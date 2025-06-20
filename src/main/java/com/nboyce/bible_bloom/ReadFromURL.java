package com.nboyce.bible_bloom;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class ReadFromURL {

    public static String passage(String book, String chapter, String verse){
        try{
            URL url = getUrl(book, chapter, verse);
            // Open a stream to the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
                System.out.println(line);
            }
            reader.close();

            ObjectMapper mapper = new ObjectMapper();

            if(url.toString().contains("/verses/")) {
                Book bookWrapper = mapper.readValue(jsonBuilder.toString(), Book.class);
                return book + " " + chapter + ":" + bookWrapper.getVerse() + " - " + bookWrapper.getText();
            }else{
                Data wrapper = mapper.readValue(jsonBuilder.toString(), Data.class);
                // Loop through the verses
                for (Book data : wrapper.data) {
                    return data.getBook() + " " + data.getChapter() + ":" + data.getVerse() + " - " + data.getText();
                }
            }

        } catch (IOException e) {
            // Handle exceptions (IOException)
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static URL getUrl(String book, String chapter, String verse) throws MalformedURLException, URISyntaxException {
        URL url;
        String version = "en-kjv";
        String baseURL = "https://cdn.jsdelivr.net/gh/wldeh/bible-api/bibles/" + version + "/books/" + book + "/chapters/" + chapter;

        // Create a different URL object for verse or no verse
        if(verse != null){
            url = new URI(baseURL +"/verses/" + verse + ".json").toURL();
        }
        else{
            url = new URI(baseURL + ".json").toURL();
        }
        return url;
    }
}


