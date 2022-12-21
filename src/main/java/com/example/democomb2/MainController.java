package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController extends DataStreams {

    final WordsBookRepository repository;

    public MainController(WordsBookRepository repository) {
        this.repository = repository;
    }

    Combiner data = new Combiner("вихри враждебные веют над_нами", null);

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet(Model model) {
        String s = hymn[(int) (hymn.length * Math.random())].replaceAll("[_,!.—]+"," ");
//        String s = vorona[(int) (vorona.length * Math.random())].replaceAll("_"," ");
//        String s = sobaka[(int) (sobaka.length * Math.random())];
//        String s = chuchelo[(int) (chuchelo.length * Math.random())];
        System.out.println("----------------------------------");
        System.out.println(s);
        data = new Combiner(s,repository);
        model.addAttribute("title","COMBINER:" + data.words.length + "/" + data.amount);
        model.addAttribute("messages", data.fullOut());
        return new ModelAndView("page");
    }
}