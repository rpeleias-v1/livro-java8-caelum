package com.rodrigopeleias.capitulo8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Capitulo8Files {

    public static void main(String[] args) throws IOException {
        Stream<Stream<String>> streamStream = Files.list(Paths.get("./src/main/java/com/rodrigopeleias/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .map(p -> lines(p));

        //achatamento com flatMap - único stream
        Stream<String> flattedStream = Files.list(Paths.get("./src/main/java/com/rodrigopeleias/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .flatMap(p -> lines(p));
    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
