package com.nboyce.bible_bloom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class ReadFromURL {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a bible book: ");
            String version = "en-kjv";
            String book = scanner.nextLine().toLowerCase();
            Console console = System.console();
            ReadFromJson readFromJson = new ReadFromJson();
            readFromJson.getBooks();

            String chapter = console.readLine("Enter a chapter: ");
            String verse = console.readLine("Enter a verse: ");

            URL url = getUrl(version, book, chapter, verse);
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
                System.out.println(book + " " + chapter + ":" + bookWrapper.getVerse() + " - " + bookWrapper.getText());
            }else{
                Data wrapper = mapper.readValue(jsonBuilder.toString(), Data.class);
                // Loop through the verses
                for (Book data : wrapper.data) {
                    System.out.println(data.getBook() + " " + data.getChapter() + ":" + data.getVerse() + " - " + data.getText());}
            }

        } catch (IOException e) {
            // Handle exceptions (IOException)
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static URL getUrl(String version, String book, String chapter, String verse) throws MalformedURLException, URISyntaxException {
        URL url;
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


