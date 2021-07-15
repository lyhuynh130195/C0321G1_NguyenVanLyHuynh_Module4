package com.dictionary.repository;

import com.dictionary.model.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DictionaryRepoImpl implements DictionaryRepo {
    private static List<Dictionary> dictionaryList = new ArrayList<>();

    static {
        dictionaryList.add(new Dictionary("go", "đi"));
        dictionaryList.add(new Dictionary("home", "nhà"));
        dictionaryList.add(new Dictionary("read", "đọc"));
        dictionaryList.add(new Dictionary("book", "sách"));
        dictionaryList.add(new Dictionary("computer", "máy tính"));
        dictionaryList.add(new Dictionary("work", "làm việc"));
        dictionaryList.add(new Dictionary("speak", "nói"));
        dictionaryList.add(new Dictionary("run", "chạy"));
        dictionaryList.add(new Dictionary("stop", "dừng lại"));
        dictionaryList.add(new Dictionary("service", "dịch vụ"));
        dictionaryList.add(new Dictionary("learn", "học"));
    }

    @Override
    public String findByEnglish(String en) {
        Dictionary dictionary =
                dictionaryList.stream()
                        .filter(dictionarys -> dictionarys.getEnglish().toLowerCase().equals(en.toLowerCase()))
                        .findFirst()
                        .orElse(null);

        return dictionary == null ? "" : dictionary.getVietnamese();
    }

    @Override
    public String findByVietnamese(String vi) {
       Dictionary dictionary=
               dictionaryList.stream()
               .filter(dictionary1 -> dictionary1.getVietnamese().toLowerCase().equals(vi.toLowerCase()))
               .findFirst()
               .orElse(null);
       return dictionary==null?"":dictionary.getEnglish();
    }
}
