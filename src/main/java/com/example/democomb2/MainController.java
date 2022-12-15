package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    String[] sobaka = {"у_попа была собака",
            "Он ее любил",
            "Она съела кусок мяса",
            "Он ее убил",
            "И в землю закопал",
            "И надпись написал",
            "у_попа была собака",
            "Он ее любил"};

    String[] vorona = {"Шел я как-то через_мост",
            "Глядь ворона сохнет",
            "Взял ворону я за_хвост",
            "Положил ее под_мост",
            "Пусть ворона мокнет",
            "Снова шел я через_мост",
            "Глядь ворона мокнет",
            "Снова взял ее за_хвост",
            "Положил ее на_мост",
            "Пусть ворона сохнет"};

    String[] chuchelo = {"Чучело-мяучело на_трубе сидело",
            "Чучело-мяучело песенку запело",
            "Только всем от песенки этой стало тошно",
            "Потому что песенка чучела про то что",
            "Чучело мяучело на_трубе сидело"};
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
