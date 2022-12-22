package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Set;

@Controller
public class MainController extends DataStreams {

    final WordsBookRepository repository;
//        new File(Objects.requireNonNull(ClassLoader.getResource("fileTest.txt")).getFile());
    static final Set<String> words = readWordBook(new File("D:\\DBWords\\wordbook.txt"));
    Combiner data = new Combiner("вихри враждебные веют над_нами", null);

    public MainController(WordsBookRepository repository) {
        this.repository = repository;
//        System.out.println();
//        words.stream().sorted().forEach(s -> System.out.print(s + ","));
//        System.out.println();
        System.out.printf("Wordbook %s words%n",words.size());
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet(Model model) {
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
}