package com.juli;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterSimpleTest {

    @Test
    public void givenTextFile_shouldReturnNumberOfChars(){
        int expectedCharacters = 62;
        ImmutableTriple statistics = WordCounterSimple.countLinesWordsChars("test.txt");
        assertEquals(expectedCharacters, statistics.right);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfCharsV2(){
        int expectedCharacters = 62;
        int chars = WordCounterSimple.countCharsFromTextFile("test.txt");
        assertEquals(expectedCharacters, chars);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfWords(){
        int expectedWords = 11;
        ImmutableTriple statistics = WordCounterSimple.countLinesWordsChars("test.txt");
        assertEquals(expectedWords, statistics.middle);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfWordsV2(){
        int expectedWords = 11;
        int words = WordCounterSimple.countWordsFromTextFile("test.txt");
        assertEquals(expectedWords, words);
    }


    @Test
    public void givenTextFile_shouldReturnNumberOfLines(){
        int expectedLines = 4;
        ImmutableTriple statistics = WordCounterSimple.countLinesWordsChars("test.txt");
        assertEquals(expectedLines, statistics.left);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfLinesV2(){
        int expectedLines = 4;
        int lines = WordCounterSimple.countLinesFromTextFile("test.txt");
        assertEquals(expectedLines, lines);
    }
}
