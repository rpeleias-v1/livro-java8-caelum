package com.rodrigopeleias.capitulo4;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Capitulo4 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 300);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // exemplo do uso do default method andThen() da interface Consumer
        Consumer<Usuario> mostraMensagens = u -> System.out.println("Antes de imprimir os nomes");

        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        usuarios.forEach(mostraMensagens.andThen(imprimeNome));

        // uso de predicates dentro do default method removeIf
        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 160;
            }
        };

        List<Usuario> usuariosMutaveis = new ArrayList<>();
        usuariosMutaveis.add(user1);
        usuariosMutaveis.add(user2);
        usuariosMutaveis.add(user3);

        usuariosMutaveis.removeIf(predicado);

        // predicado com lambda
        usuariosMutaveis.removeIf(u -> u.getPontos() > 160);
        usuariosMutaveis.forEach(u -> System.out.println(u.getNome()));

    }
}
