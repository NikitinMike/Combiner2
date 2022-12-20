package com.example.democomb2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends CrudRepository<WordsEntity, Long> {
    WordsEntity findByWord(String word);
}