package com.rodrigopeleias.capitulo3;

@FunctionalInterface
interface Validador<T> {
    boolean valida(T t);
}