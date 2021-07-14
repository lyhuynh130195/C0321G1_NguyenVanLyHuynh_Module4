package com.dictionary.service;

import org.springframework.stereotype.Service;

@Service
public interface DictionaryService {
    String findVieByEng(String eng);

    String finEngByVie(String vie);
}
