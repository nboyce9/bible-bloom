package com.nboyce.bible_bloom;

import java.util.List;

public class BibleBook {
    String book;
    List<Integer> chapters;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public List<Integer> getChapters() {
        return chapters;
    }

    public void setChapters(List<Integer> chapters) {
        this.chapters = chapters;
    }
}
