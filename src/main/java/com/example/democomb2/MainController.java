package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController extends DataStreams {

    final
    WordsRepository repository;

    public MainController(WordsRepository repository) {
        this.repository = repository;
    }

    Combiner data = new Combiner("вихри враждебные веют над_нами");

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
        return new ModelAndView("page");
    }
}
