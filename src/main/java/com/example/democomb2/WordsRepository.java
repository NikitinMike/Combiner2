package com.example.democomb2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRepository extends CrudRepository<WordsEntity, Long> {
    List<WordsEntity> findAllByWord(String word);
}