package com.nboyce.bible_bloom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromJson {

    public List<BibleBook> getBooks () throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("src/main/resources/com/nboyce/bible_bloom/json/bible_structure.json"), new TypeReference<>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Integer> getChapters(String book){
        Integer[] chapters ={};
        return List.of(chapters);
    }

    public List<Integer> getVerses(String book, Integer chapter){
        Integer[] verses ={};
        return List.of(verses);
    }

}
