package com.example.demo;

import java.io.IOException;
import java.util.List;

interface FileParserInterface {
    String readFile(String path) throws IOException;
    List<String> splitWords(String text);
    List<String> wordsToLowerCase(List<String> arrayOfWords);
    Long countWordsLongerThan(List<String> words, Long wordLength);
}
