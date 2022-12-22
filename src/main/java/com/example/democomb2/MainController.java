package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController extends DataStreams {
    static final Set<String> words = readWordBook(new File("D:\\DBWords\\wordbook.txt"));
    WordsBookRepository repository = null;
    Combiner data = new Combiner("вихри враждебные веют над_нами", null);

    public MainController(WordsBookRepository repository) {
//        this.repository = repository;
//        System.out.println();
//        words.stream().sorted().forEach(s -> System.out.print(s + ","));
//        System.out.println();
        System.out.printf("Wordbook %s words%n", words.size());
    }

    Stream<String> getText() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("HappyNewYear.txt")) {
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            //            lines.forEach(System.out::println);
//            reader.close();
//            return lines.collect(Collectors.toList());
            return reader.lines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/random")
    @ResponseBody
    public ModelAndView randomPageGet(Model model) {
        String s = hymn[(int) (hymn.length * Math.random())].replaceAll("[_,!.—]+", " ");
//        String s = vorona[(int) (vorona.length * Math.random())].replaceAll("_"," ");
//        String s = sobaka[(int) (sobaka.length * Math.random())];
//        String s = chuchelo[(int) (chuchelo.length * Math.random())];
        System.out.println();
        System.out.println(s);
        System.out.println("---------------------------------------------");
        data = new Combiner(s, repository);
        model.addAttribute("title", "COMBINER:" + data.words.length + "/" + data.amount);
        model.addAttribute("messages", data.fullOut());
        return new ModelAndView("page");
    }

    @GetMapping("/{i}")
    @ResponseBody
    public ModelAndView startPageGet(Model model, @PathVariable int i) {
        List<String> list = // getText()
                Arrays.stream(in[i])
                .map(s -> new Combiner(s.replaceAll("[_,!.—]+", " "), repository).randomOut(0))
                .collect(Collectors.toList());
        model.addAttribute("messages", list);
        model.addAttribute("title", "START:" + list.size());
        return new ModelAndView("page");
    }
}