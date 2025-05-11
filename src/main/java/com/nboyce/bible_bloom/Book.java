package com.nboyce.bible_bloom;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private String version;
    private String book;
    private int chapter;
    private int verse;
    private String text;

    public Book(){}

    public Book(String version, String book, int chapter, int verse, String text) {
        this.version = version;
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.text = text;
    }
}
