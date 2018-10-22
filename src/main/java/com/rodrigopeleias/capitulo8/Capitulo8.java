package com.rodrigopeleias.capitulo8;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Capitulo8 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        List<Usuario> usuariosOrdenadosPorNome = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
//        usuariosOrdenadosPorNome.forEach(System.out::println);

        //busca do primeiro usuário da lista - stream lazy
        Optional<Usuario> usuarioEncontrado = usuariosOrdenadosPorNome.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .findAny();

        usuariosOrdenadosPorNome.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Usuario::getNome))
                .findAny();

        //operaçoes de redução
        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();

        //us de reduce, para acumulo de ponts
        int totalReduced = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, Integer::sum);

        //trabalhando com iterators
        Iterator<Usuario> iterator = usuarios.stream().iterator();

        usuarios.stream().iterator()
                .forEachRemaining(System.out::println);

        //testando se algum usuário da lista é moderador
        boolean hasModerator = usuarios.stream()
                .anyMatch(Usuario::isModerador);

        Random random = new Random(0);
        List<Integer> randomCollectedInts = IntStream
                .generate(() -> random.nextInt())
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        randomCollectedInts.forEach(System.out::println);

        IntStream.generate(new Fibonacci())
                .limit(10)
                .forEach(System.out::println);
    }
}

class Fibonacci implements IntSupplier {

    private int anterior = 0;
    private int proximo = 1;

    @Override
    public int getAsInt() {
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return anterior;
    }
}
