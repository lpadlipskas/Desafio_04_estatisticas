package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1.
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> max = numeros.stream().max(Integer::compare);
        max.ifPresent(System.out::println);

        // 2.
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> lista1 = palavras.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(lista1);

        // 3.
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        String string1 = nomes.stream()
                .collect(Collectors.joining(","));
        System.out.println(string1);

        // 4.
        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int somaQuadrados = numeros2.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0,Integer::sum);
        System.out.println(somaQuadrados);

        // 5.
        Map<Boolean, List<Integer>> parImpar = numeros2.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Pares: " + parImpar.get(true));
        System.out.println("Ímpares: " + parImpar.get(false));

        // 6.
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        Map<String, List<Produto>> produtosCategorias = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
        System.out.println(produtosCategorias);

        // 7.
        Map<String, Long> contagemProdutos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        System.out.println(contagemProdutos);

        // 8.
        Map<String, Optional<Produto>> maisCaro = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));
        System.out.println(maisCaro);

        // 9.
        Map<String, Double> totalPrecosCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)));
        System.out.println(totalPrecosCategoria);

    }
}