package com.dictionary.service;

import com.dictionary.model.Dictionary;
import com.dictionary.repository.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService{
@Autowired
    DictionaryRepo dictionaryRepo;
    @Override
    public String findVieByEng(String eng) {
        return dictionaryRepo.findByEnglish(eng);
    }

    @Override
    public String finEngByVie(String vie) {
        return dictionaryRepo.findByVietnamese(vie);
    }
}
