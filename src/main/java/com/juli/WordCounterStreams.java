package com.juli;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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
public class WordCounterStreams {


    public static ImmutableTriple countLinesWordsChars(String filePath) {
        Long lines = 0L;
        Long words = 0L;
        Long characters = 0L;
        if (filePath.isEmpty()) filePath = "example.txt";
        Path path = Paths.get(WordCounterStreams.class.getClassLoader().getResource(filePath).getPath());

        try {
            words = Files.lines(path)
                .flatMap(str->Stream.of(str.split("[ ,.]")))
                .filter(s->s.length()>0).count();

            lines = Files.lines(path).count();

            final Map<Character, Integer> countCharacters = Files.lines(path).
                flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt)).
                filter(Character::isLetter).
                map(Character::toLowerCase).
                collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);

            characters = countCharacters.values().stream().mapToLong(t-> t).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("lines: " + lines);
        System.out.println("words: " + words);
        System.out.println("characters: " + characters);

        return new ImmutableTriple(lines, words, characters);
    }

    public static void main(String[] args) {
        countLinesWordsChars("");
    }
}


