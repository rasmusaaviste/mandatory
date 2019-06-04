package com.example.demo;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TextAnalyticsTest {

    @Test
    public void read_my_fileTest1() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail1.txt");
        textAnalytics.read_my_file();
    }

    @Test
    public void read_my_fileTest2() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail2.txt");
        textAnalytics.read_my_file();
    }

    @Test
    public void split_words_into_piecesTest1() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail1.txt");
        List<String> arrayOfStrings = Arrays.asList(textAnalytics.array_of_words);
        assertTrue(arrayOfStrings.size() > 0);
    }

    @Test
    public void split_words_into_piecesTest2() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail1.txt");
        String[] arrayOfStrings = textAnalytics.array_of_words;

        long spacesCount = 0L;
        for (String string : arrayOfStrings) {
            if (string.contains(" ")) {
                spacesCount++;
            }
        }

        assertEquals(0, spacesCount);
    }

    @Test
    public void turn_words_to_lowercaseTest1() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail1.txt");

        String[] arrayOfStrings = textAnalytics.array_of_words;
        List<String> lowerCaseWords = new ArrayList<>();
        boolean upperCasePresent = false;

        for (String string : arrayOfStrings) {
            lowerCaseWords.add(string.toLowerCase());
        }

        for (String lowerCaseString : lowerCaseWords) {
            for (int i = 0; i < lowerCaseString.length(); i++) {
                if (Character.isUpperCase(lowerCaseString.charAt(i))) {
                    upperCasePresent = true;
                }
            }
        }

        assertFalse(upperCasePresent);
    }

    @Test
    public void turn_words_to_lowercaseTest2() {
        TextAnalytics textAnalytics = new TextAnalytics("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\testifail1.txt");

        String[] arrayOfStrings = textAnalytics.array_of_words;
        List<String> lowerCaseWords = new ArrayList<>();

        for (String string : arrayOfStrings) {
            lowerCaseWords.add(string.toLowerCase());
        }

        List<String> sortedWords = new ArrayList<>(Arrays.asList(arrayOfStrings));

        Collections.sort(sortedWords);
        Collections.sort(lowerCaseWords);

        assertEquals(sortedWords, lowerCaseWords);
    }
}
