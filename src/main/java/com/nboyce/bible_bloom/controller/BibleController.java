package com.nboyce.bible_bloom.controller;

import com.nboyce.bible_bloom.BibleBook;
import com.nboyce.bible_bloom.ReadFromJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BibleController implements Initializable {
    @FXML
    Label textLabel;
    @FXML
    ChoiceBox<String> bookField, chapterField, verseField;
    List<BibleBook> books = null;

    public void searchBibleVerse(){
//        bookField.getItems().add("Genesis");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ReadFromJson readFromJson = new ReadFromJson();
        try {
            books = readFromJson.getBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(BibleBook book: books){
            bookField.getItems().add(book.getBook());
            bookField.setOnAction(this::getBook);
            chapterField.setOnAction(this::getChapter);
        }


    }
    public void getBook(ActionEvent event){
        String book = bookField.getValue();
        BibleBook selectedBook = books.stream()
                .filter(b -> b.getBook().equals(book))
                .findFirst().orElse(null);

        int chapterSize = selectedBook.getChapters().size();
//        System.out.println(selectedBook.getChapters());
        if(selectedBook != null) {
            chapterField.getItems().clear();
            for (int i = 1; i < chapterSize; i++) {
                chapterField.getItems().add(String.valueOf(i));
            }
        }
    }

    public void getChapter(ActionEvent event){
        String book = bookField.getValue();
        BibleBook selectedBook = books.stream()
                .filter(b -> b.getBook().equals(book))
                .findFirst().orElse(null);
        int chapter = Integer.parseInt(chapterField.getValue());
        System.out.println(chapter);
        int totalVerses = selectedBook.getChapters().get(chapter)-1;
        for(int i = 1; i<=totalVerses; i++){
            verseField.getItems().add(String.valueOf(i));
        }

    }

    public void getVerses(ActionEvent event){
        String verse = verseField.getValue();
        System.out.println();
    }
}
