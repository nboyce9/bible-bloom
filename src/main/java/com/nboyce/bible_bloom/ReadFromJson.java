package com.nboyce.bible_bloom;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromJson {

    public List<String> getBooks () throws IOException {
        List<String> books = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/com/nboyce/bible_bloom/json/bible_structure.json"));

        String book  = jsonNode.get("book").asText();
        System.out.println(book);
        books.add(book);
        return books;
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
