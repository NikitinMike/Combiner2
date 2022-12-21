package com.example.democomb2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsBookRepository extends CrudRepository<WordsBookEntity, Long> {
    List<WordsBookEntity> findAllByWord(String word);
}