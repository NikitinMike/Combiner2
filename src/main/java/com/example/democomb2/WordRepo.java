package com.example.democomb2;

import org.springframework.data.repository.CrudRepository;

//@Repository
public interface WordRepo extends CrudRepository<Word, Long> {
    Word findByWordLike(String word);
}