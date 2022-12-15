package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @ModelAttribute("messages")
    public List<String> messages() {
//        return new Combiner("вихри враждебные веют над_нами").fullOut();
        return new Combiner("у попа была собака").fullOut();
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet() {
        return new ModelAndView("page");
    }
}
