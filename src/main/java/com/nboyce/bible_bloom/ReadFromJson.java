package com.nboyce.bible_bloom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadFromJson {
    private static final String pathName = "src/main/resources/com/nboyce/bible_bloom/json/bible_structure.json";

    public static  List<BibleBook> getBooks () throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(pathName), new TypeReference<>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
