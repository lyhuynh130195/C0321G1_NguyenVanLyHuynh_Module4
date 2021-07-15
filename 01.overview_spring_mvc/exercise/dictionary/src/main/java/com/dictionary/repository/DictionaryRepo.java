package com.dictionary.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepo {
    String findByEnglish(String en);

    String findByVietnamese(String vi);
}
