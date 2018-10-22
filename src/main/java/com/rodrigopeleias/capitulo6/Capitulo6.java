package com.rodrigopeleias.capitulo6;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.nullsLast;

public class Capitulo6 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 300);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        usuarios.forEach(u -> u.tornaModerador());

        //tornando todos os usuários moderadoes com method reference
        usuarios.forEach(Usuario::tornaModerador);

        // ordenação de usuários de forma fluente
        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));


        // composição de comparators com default method thenComparing
        usuarios.sort(comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome));
        usuarios.sort(comparing(Usuario::getNome)
                .thenComparingInt(Usuario::getPontos));

        usuarios.sort(nullsLast(comparing(Usuario::getNome)));

        usuarios.sort(comparing(Usuario::getNome).reversed());

        // method reference com Runnable
        Usuario rodrigo = new Usuario("Rodrigo Peleias", 150);
        Runnable bloco = rodrigo::tornaModerador;
        bloco.run();
    }
}
