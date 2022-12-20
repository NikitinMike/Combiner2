package com.example.democomb2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController extends DataStreams {

    final WordsRepository repository;

    public MainController(WordsRepository repository) {
        this.repository = repository;
    }

    Combiner data = new Combiner("вихри враждебные веют над_нами");

    String[] words; // слова
    int[] parts; // какой части речи принадлежит

//    @ModelAttribute("title")
//    public String title() {
//        return "COMBINER:" + data.words.length + "/" + data.amount;
//    }

//    @ModelAttribute("messages")
//    public List<String> messages() {
//        return data.fullOut();
//    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView startPageGet(Model model) {
//        String s = vorona[(int) (vorona.length * Math.random())];
//        String s = sobaka[(int) (sobaka.length * Math.random())];
        String s = chuchelo[(int) (chuchelo.length * Math.random())];
        System.out.println("----------------------------------");
        System.out.println(s);
        data = new Combiner(s);
        model.addAttribute("title","COMBINER:" + data.words.length + "/" + data.amount);
        for (WordsEntity word : getWords(data.getWords())) System.out.println(word);
        model.addAttribute("messages", data.fullOut());
        return new ModelAndView("page");
    }

    private List<WordsEntity> getWords(String[] words) {
//        return Arrays.stream(words).flatMap(word -> repository.findAllByWord(word).stream()).collect(Collectors.toList());
        List<WordsEntity> wordsEntityList = new ArrayList<>();
        for (String word : words) {
            String [] subWords = word.split("_");
            if(subWords.length>1) wordsEntityList.addAll(getWords(subWords));
            else wordsEntityList.addAll(repository.findAllByWord(word));
        }
        return wordsEntityList;
    }
}