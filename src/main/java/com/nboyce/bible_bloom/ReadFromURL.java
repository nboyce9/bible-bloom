package com.nboyce.bible_bloom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL {
    public static void main(String[] args) {
        try {
            String version = "en-asv";
            String book = "genesis".toLowerCase();
            String chapter = "1";
            String verse = null;

            URL url;
            String baseURL = "https://cdn.jsdelivr.net/gh/wldeh/bible-api/bibles/" + version + "/books/" + book + "/chapters/" + chapter;

            // Create a URL object for diff cases vs/no vs
            if(verse != null){
                url = new URL(baseURL +"/verses/" + verse + ".json");
            }
            else{
                url = new URL(baseURL + ".json");
            }
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
            Data wrapper = mapper.readValue(jsonBuilder.toString(), Data.class);
            Book bookWrapper = mapper.readValue(jsonBuilder.toString(), Book.class);


            if(url.toString().contains("/verses/")) {

                    System.out.println(bookWrapper.getBook() + " " + bookWrapper.getChapter() + ":" + bookWrapper.getVerse() + " - " + bookWrapper.getText());
            }else{
                // Loop through the verses
                for (Book data : wrapper.data) {
                    System.out.println(data.getBook() + " " + data.getChapter() + ":" + data.getVerse() + " - " + data.getText());}
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions (e.g., MalformedURLException or IOException)
        }
    }
}


