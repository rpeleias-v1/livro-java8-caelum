package com.rodrigopeleias.capitulo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


class Mostrador implements Consumer<Usuario> {
    public void accept(Usuario usuario) {
        System.out.println(usuario.getNome());
    }
}

public class Capitulo2 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 300);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        for (Usuario usuario: usuarios) {
            System.out.println(usuario.getNome());
        }

        // java 8 - passando Consumer para forEach
        usuarios.forEach(new Mostrador());

        // uso direto do Lambda
        usuarios.forEach(u -> System.out.println(u.getNome()));
        usuarios.forEach(u -> u.tornaModerador());
    }
}
