package com.hh.test.rest_api.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceI implements TestService {

    @Override public String getSymbolsFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Character, Integer> entry : entryList) {
            if (!first) {
                builder.append(", ");
            }
            String formattedEntry = "|%s|: %d".formatted(entry.getKey(), entry.getValue());
            builder.append(formattedEntry);
            first = false;
        }
        return builder.toString();
    }
}
