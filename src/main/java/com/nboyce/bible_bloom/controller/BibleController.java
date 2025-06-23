package com.nboyce.bible_bloom.controller;

import com.nboyce.bible_bloom.BibleBook;
import com.nboyce.bible_bloom.Book;
import com.nboyce.bible_bloom.ReadFromJson;
import com.nboyce.bible_bloom.ReadFromURL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BibleController implements Initializable {
    @FXML
    ChoiceBox<String> bookField, chapterField, verseField;
    List<BibleBook> books = null;
    @FXML
    Text text;
    @FXML
    Label bookName, chapterNumber;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            books = ReadFromJson.getBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assert books != null;
        for(BibleBook book: books){
            bookField.getItems().add(book.getBook());
            bookField.setOnAction(this::getBook);
            chapterField.setOnAction(this::getChapter);
        }
        verseField.setOnAction(this::getVerses);


    }
    public void getBook(ActionEvent event){
        String book = bookField.getValue();
        BibleBook selectedBook = books.stream()
                .filter(b -> b.getBook().equals(book))
                .findFirst().orElse(null);

        assert selectedBook != null;
        bookName.setText(book);
        int chapterSize = selectedBook.getChapters().size();

        chapterField.getItems().clear();
        for (int i = 1; i <= chapterSize; i++) {
            chapterField.getItems().add(String.valueOf(i));
        }
    }

    public void getChapter(ActionEvent event){
        String book = bookField.getValue();
        BibleBook selectedBook = books.stream()
                .filter(b -> b.getBook().equals(book))
                .findFirst().orElse(null);
        assert selectedBook != null;
        int chapter = Integer.parseInt(chapterField.getValue());
        verseField.getItems().clear();
        int totalVerses = selectedBook.getChapters().get(chapter-1);
        for(int i = 1; i < totalVerses; i++){
            verseField.getItems().add(String.valueOf(i));
        }
        searchBibleChapter(event);
    }

    public void getVerses(ActionEvent event){
        String verse = verseField.getValue();
        searchBibleVerse(event);
    }

    public void searchBibleVerse(ActionEvent e){
        String book = bookField.getValue().toLowerCase();
        String chapter = chapterField.getValue();
        String verse = verseField.getValue();
        text.setText(String.valueOf(ReadFromURL.passage(book, chapter, verse)));

   }
    public void searchBibleChapter(ActionEvent e){
        String book = bookField.getValue().toLowerCase();
        String chapter = chapterField.getValue();
        chapterNumber.setText(chapter);
        text.setText(String.valueOf(ReadFromURL.passage(book, chapter, null)));

    }
    public void journal(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nboyce/bible_bloom/view/journal.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void favourite(ActionEvent event){
        List<Book> favouritePassages = new ArrayList<>();
        String book = bookField.getValue().toLowerCase();
        String chapter = chapterField.getValue();
//        String verse = verseField.getValue();
//        if(verse.equals(null))
        Book favouriteBook = new Book(book, Integer.parseInt(chapter));
        favouritePassages.add(favouriteBook);
        System.out.println(favouritePassages);
    }
}
