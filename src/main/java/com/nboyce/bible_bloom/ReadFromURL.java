package com.nboyce.bible_bloom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;

public class ReadFromURL {
    public static void main(String[] args) {
        try {
            String version ="en-asv";
            String book = "genesis".toLowerCase();
            int chapter = 1;
            int verse = 3;
            // Create a URL object
            URL url = new URL("https://cdn.jsdelivr.net/gh/wldeh/bible-api/bibles/" +version+"/books/"+book+"/chapters/"+chapter+".json");

            // Open a stream to the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Print each line from the URL
                System.out.println(line);
            }

            reader.close(); // Close the stream
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions (e.g., MalformedURLException or IOException)
        }
    }
}

