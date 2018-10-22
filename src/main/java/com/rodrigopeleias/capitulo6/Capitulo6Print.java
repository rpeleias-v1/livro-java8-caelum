package com.rodrigopeleias.capitulo6;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Capitulo6Print {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 300);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //print de todos usuários da lista
        usuarios.forEach(System.out::println);

        // methos reference para a criaçAo de usuário (atribuído a interface Supplier)
        Supplier<Usuario> criadorDeUsuarios = Usuario::new;
        Usuario usuario = criadorDeUsuarios.get();

        BiFunction<String, Integer, Usuario> criadorDeUsuariosComParametros = Usuario::new;
        Usuario rodrigo = criadorDeUsuariosComParametros.apply("Rodrigo Peleias", 50);
        Usuario denise = criadorDeUsuariosComParametros.apply("Denise Gasques", 100);

        List<Usuario> casal = Arrays.asList(rodrigo, denise);

        casal.forEach(System.out::println);

    }

}
