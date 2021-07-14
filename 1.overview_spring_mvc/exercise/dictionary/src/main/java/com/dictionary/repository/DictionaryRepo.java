package com.dictionary.repository;

public interface DictionaryRepo {
    String findByEnglish(String en);

    String findByVietnamese(String vi);
}
