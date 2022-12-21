package com.example.democomb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoComb2Application {


    static void readWorkBook() {
//        File file = new File(Objects.requireNonNull(ClassLoader.getResource("fileTest.txt")).getFile());
        File fileIn = new File("D:\\DBWords\\wordbook.txt");
        try (BufferedReader reader = Files.newBufferedReader(fileIn.toPath())) {
            long l = 0;
            long ll = 0;
            long ls = 0;
            long w = 0;
            Set<String> wordSet = new HashSet<>();
            do {
                String line = reader.readLine();
                l += line.length();
                String[] lines = line.split("#");
                String[] words = lines[1].split("[#,]");
//                Arrays.stream(words).forEach(System.out::print);
//                System.out.println(String.join(",", words));
                w += words.length;

                List<String> list = Arrays.asList(words);
                ll += list.size();

                Set<String> set = new HashSet<>(list);
                ls += set.size();
                wordSet.addAll(set);
//                    System.out.println(word);
            } while (reader.ready());

//            System.out.println();
//            wordSet.stream().sorted().forEach(s -> System.out.print(s + ","));
//            System.out.println();

            System.out.println(l);
            System.out.println(w);
            System.out.println(ll);
            System.out.println(ls);
            System.out.println(wordSet.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        readWorkBook();
        SpringApplication.run(DemoComb2Application.class, args);
    }

}
