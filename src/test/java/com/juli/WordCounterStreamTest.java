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
}
