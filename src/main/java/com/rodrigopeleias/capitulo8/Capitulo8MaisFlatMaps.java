package com.rodrigopeleias.capitulo8;

import com.rodrigopeleias.capitulo2.Usuario;

import java.util.*;

public class Capitulo8MaisFlatMaps {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Rodrigo Peleias", 150);
        Usuario user2 = new Usuario("Denise Gasques", 200);
        Usuario user3 = new Usuario("Fulano de tal", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Grupo englishSpeakers = new Grupo();
        englishSpeakers.add(user1);
        englishSpeakers.add(user2);

        Grupo spanishSpeakers = new Grupo();
        spanishSpeakers.add(user2);
        spanishSpeakers.add(user3);

        List<Grupo> grupos = Arrays.asList(englishSpeakers, spanishSpeakers);

        grupos.stream()
                .flatMap(g -> g.getUsuarios().stream())
                .distinct()
                .forEach(System.out::println);
    }
}

class Grupo {
    private Set<Usuario> usuarios = new HashSet<>();

    public void add(Usuario u) {
        usuarios.add(u);
    }

    public Set<Usuario> getUsuarios() {
        return Collections.unmodifiableSet(usuarios);
    }
}
