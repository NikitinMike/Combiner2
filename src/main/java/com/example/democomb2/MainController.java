package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController extends DataStreams {

    final WordsRepository repository;

    public MainController(WordsRepository repository) {
        this.repository = repository;
    }

    Combiner data = new Combiner("вихри враждебные веют над_нами");

//    String[] words; // слова
//    int[] parts; // какой части речи принадлежит

    @ModelAttribute("title")
    public String title() {
        return "COMBINER:" + data.words.length + "/" + data.amount;
    }

    @ModelAttribute("messages")
    public List<String> messages() {
        return data.fullOut();
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet() {
        String s = vorona[(int) (vorona.length * Math.random())];
        data = new Combiner(s);
        System.out.println(s);
        for (WordsEntity word : getWords(data.getWords())) System.out.println(word);
        return new ModelAndView("page");
    }

    private List<WordsEntity> getWords(String[] words) {
        return Arrays.stream(words).flatMap(word -> repository.findAllByWord(word).stream()).collect(Collectors.toList());
    }
}
