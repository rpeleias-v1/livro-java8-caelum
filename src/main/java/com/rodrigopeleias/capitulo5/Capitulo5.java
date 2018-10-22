package com.rodrigopeleias.capitulo5;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Capitulo5 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 300);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Comparator no Java 8
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Collections.sort(usuarios, comparator);

        // comparator com lambda
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        // sort direto com default method
        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        // métodos estáticos na interface Comparator e method reference
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        // indexação pela ordem natural
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
        palavras.sort(Comparator.naturalOrder());
        palavras.forEach(p -> System.out.println(p));

        // comparaçao de usuarios por ponto
        usuarios.sort(Comparator.comparing(Usuario::getPontos));
        palavras.forEach(p -> System.out.println(p));

        //importante - PARA COMPARAÇÃO DE TIPOS PRIMITIVOS USSAR COMPARING DE TIPOS
        // SE USAR COMPARING NORMAL - AUTOBOXING SERÁ GERADO
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
        palavras.forEach(p -> System.out.println(p));

    }
}
