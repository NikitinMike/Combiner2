package com.example.democomb2;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController extends DataStreams {

    Combiner data = new Combiner("вихри враждебные веют над_нами");

    @Autowired
    WordRepo wordRepo;

    @ModelAttribute("title")
    public String title() {
        return "COMBINER:" + data.words.length + "/" + data.amount;
    }

    @ModelAttribute("messages")
    public List<String> messages() {
        return data.fullOut();
    }

    @Autowired
    ConfigurableApplicationContext context;

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet() {
        WordRepo wordRepo= context.getBean(WordRepo.class);
//        System.out.println(wordRepo.findByWordLike("а"));
        String s = vorona[(int) (vorona.length * Math.random())];
        data = new Combiner(s);
        return new ModelAndView("page");
    }
}
