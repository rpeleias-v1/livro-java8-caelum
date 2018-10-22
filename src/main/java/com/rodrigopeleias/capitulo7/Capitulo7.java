package com.rodrigopeleias.capitulo7;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo7 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Stream<Usuario> stream = usuarios.stream();
        stream.filter(u -> u.getPontos() > 100);

        usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .forEach(System.out::println);

        usuarios.stream()
                .filter(Usuario::isModerador);

        // para retornar o resultado de um stream em uma nova lista - usamos os Collectors
        List<Usuario> usuariosModeradores = usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .collect(Collectors.toList());
        usuariosModeradores.forEach(System.out::println);

        //listando apenas os ponto dos usuários com Map
        List<Integer> pontosUsuarios = usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .map(Usuario::getPontos)
                .collect(Collectors.toList());
        pontosUsuarios.forEach(System.out::println);

        //também existem stream para tipos numéricos para evitar autoboxing
        IntStream intStream = usuarios.stream()
                .mapToInt(Usuario::getPontos);

        // intStream e semelhantes facilitam operaçoes aritméticas
        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();

        //Optional
        OptionalDouble average = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average();
        double pontuacaoOptional = average.orElse(0.0);
        double pontuacaoComExcecao = average.orElseThrow(IllegalArgumentException::new);

        usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .ifPresent(valor -> System.out.println(valor));
    }
}
