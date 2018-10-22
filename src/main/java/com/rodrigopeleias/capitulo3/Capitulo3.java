package com.rodrigopeleias.capitulo3;

public class Capitulo3 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();

        // instanciacao de thread como uma functional interface
        new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                System.out.println(i);
            }
        }).start();

        Validador<String> validadorCEP = new Validador<String>() {
            @Override
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        // validador com lambda
        Validador<String> validadorCEPLambda = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        Runnable o = () -> System.out.println("O que sou eu? Que lambda?");
        System.out.println(o);
        System.out.println(o.getClass());
    }
}
