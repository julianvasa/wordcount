package com.juli;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.io.*;
import java.util.stream.Stream;

/**
 * Read a file from /opt/tmp/example.txt and count the lines, words and
 * characters and print the results A "word" is everything that is separated by
 * a white-space, e.g. " one, two 123 four " is 4 words. Punctuation characters
 * like "." and "," are treated as white space. Whitespace and newlines are no
 * characters.
 * <p>
 * Write the code as if it were production code!
 * <p>
 * Java version: JDK 8
 */
public class WordCounterSimple {


    static ImmutableTriple countLinesWordsChars(String filePath) {
        int lines = 0;
        int words = 0;
        int characters = 0;
        InputStream in = getInputStream(filePath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] wordsInCurrentLine = line.replace(".", " ").replace(",", " ").split(" ");
                if (wordsInCurrentLine.length > 0) {
                    for (String s : wordsInCurrentLine) {
                        if (!s.isEmpty()) words++;
                    }
                }
                lines++;
                for (String currentWordInCurrentLine : wordsInCurrentLine) {
                    char[] charsInWordsInCurrentLine = currentWordInCurrentLine.toCharArray();
                    characters += charsInWordsInCurrentLine.length;
                }
            }
            System.out.println("lines: " + lines);
            System.out.println("words: " + words);
            System.out.println("characters: " + characters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImmutableTriple(lines, words, characters);
    }

    static int countCharsFromTextFile(String filePath) {
        int characters = 0;
        InputStream in = getInputStream(filePath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] wordsInCurrentLine = line.replace(".", " ").replace(",", " ").split(" ");
                for (String currentWordInCurrentLine : wordsInCurrentLine) {
                    char[] charsInWordsInCurrentLine = currentWordInCurrentLine.toCharArray();
                    characters += charsInWordsInCurrentLine.length;
                }
            }
            System.out.println("characters: " + characters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    static int countWordsFromTextFile(String filePath) {
        int words = 0;
        InputStream in = getInputStream(filePath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] wordsInCurrentLine = line.replace(".", " ").replace(",", " ").split(" ");
                if (wordsInCurrentLine.length > 0) {
                    for (String s : wordsInCurrentLine) {
                        if (!s.isEmpty()) words++;
                    }
                }

            }
            System.out.println("words: " + words);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    static int countLinesFromTextFile(String filePath) {
        int lines = 0;
        InputStream in = getInputStream(filePath);

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] wordsInCurrentLine = line.replace(".", " ").replace(",", " ").split(" ");
                lines++;
            }
            System.out.println("lines: " + lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static InputStream getInputStream(String filePath) {
        InputStream in = WordCounterSimple.class.getClassLoader().getResourceAsStream("example.txt");
        if (!filePath.isEmpty()) in = WordCounterSimple.class.getClassLoader().getResourceAsStream(filePath);
        return in;
    }

    public static void main(String[] args) {
        countLinesWordsChars("");
    }
}


