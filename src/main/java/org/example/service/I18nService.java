package org.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class I18nService {
    private final Map<String, String> phraseMap = new HashMap<>() {{
        put("ru#hello", "привет, меня зовут 1448");
        put("en#hello", "hello, my name is Bot1448");
        put("ru#press-any-key", "нажмите любую кнопку");
        put("en#press-any-key", "press any-key");
        put("ru#askFind", "что хотите сделать?");
        put("en#askFind", "what do you want to do?");
        put("ru#id", "айди");
        put("en#id", "id");
        put("ru#name", "имя");
        put("en#name", "name");
        put("ru#mail", "мыло");
        put("en#mail", "mail");
        put("ru#age", "возраст");
        put("en#age", "age");
        put("ru#isman", "пол");
        put("en#isman", "isman");
    }};


    private final LanguageService languageService;

    public I18nService(LanguageService languageService) {
        this.languageService = languageService;
    }

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Map<String, Object> params) {
        var language = languageService.getCurrentLanguage();
        var key = language + "#" + code;
        var phrase = phraseMap.get(key);
        if (params != null)
            phrase = handlePlaceholders(phrase, params);
        return phrase;
    }

    private String handlePlaceholders(String phrase, Map<String, Object> params) {
        for (var e : params.entrySet())
            phrase = phrase.replace("%" + e.getKey() + "%", e.getValue().toString());
        return phrase;
    }
}
