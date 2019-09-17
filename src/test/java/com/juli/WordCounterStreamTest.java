package com.juli;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterStreamTest {

    @Test
    public void givenTextFile_shouldReturnNumberOfChars(){
        Long expectedCharacters = 62L;
        ImmutableTriple statistics = WordCounterStreams.countLinesWordsChars("test.txt");
        assertEquals(expectedCharacters, statistics.right);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfWords(){
        Long expectedWords = 11L;
        ImmutableTriple statistics = WordCounterStreams.countLinesWordsChars("test.txt");
        assertEquals(expectedWords, statistics.middle);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfLines(){
        Long expectedLines = 4L;
        ImmutableTriple statistics = WordCounterStreams.countLinesWordsChars("test.txt");
        assertEquals(expectedLines, statistics.left);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfCharsV2(){
        long expectedCharacters = 62L;
        long chars = WordCounterStreams.countCharsFromTextFile("test.txt");
        assertEquals(expectedCharacters, chars);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfWordsV2(){
        long expectedWords = 11L;
        long words = WordCounterStreams.countWordsFromTextFile("test.txt");
        assertEquals(expectedWords, words);
    }

    @Test
    public void givenTextFile_shouldReturnNumberOfLinesV2(){
        long expectedLines = 4L;
        long lines = WordCounterStreams.countLinesFromTextFile("test.txt");
        assertEquals(expectedLines, lines);
    }
}
