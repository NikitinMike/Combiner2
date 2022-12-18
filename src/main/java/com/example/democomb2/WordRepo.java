package com.example.democomb2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends CrudRepository<Word, Long> {
    Word findByWordLike(String word);
}