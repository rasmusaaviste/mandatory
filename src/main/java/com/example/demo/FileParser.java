package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class FileParser implements FileParserInterface {

   void parseFile() throws IOException {
        String content = readFile("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\artiklikogumik.txt");

        List<String> words = splitWords(content);
        List<String> lowerCaseWords = wordsToLowerCase(words);

        Map<String, Integer> wordCount = new HashMap<String, Integer>();

        for (String word : lowerCaseWords) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count==null) ? 1 : count+1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + "\n");
        }

       countWordsLongerThan(words, 20L);
   }

    @Override
    public String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get
                ("C:\\Users\\aavis\\Desktop\\demo\\demo\\src\\main\\java\\com\\example\\demo\\artiklikogumik.txt")
        ));
    }

    @Override
    public List<String> splitWords(String text) {
        return Arrays.asList(text.split(" "));
    }

    @Override
    public List<String> wordsToLowerCase(List<String> arrayOfWords) {
        List<String> lowerCaseWords = new ArrayList<>();
        for (String word : arrayOfWords) {
            lowerCaseWords.add(word.toLowerCase());
        }
        return lowerCaseWords;
    }

    @Override
    public Long countWordsLongerThan(List<String> words, Long wordLength) {
        long count = 0L;

        for (String word : words) {
            if (word.length() > wordLength) {
                count++;
            }
        }

        System.out.print("Pikem kui " + wordLength + " tähemärki oli " + count + " sõna!");
        return count;
    }
}
