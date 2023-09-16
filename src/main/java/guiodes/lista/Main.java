package guiodes.lista;

import guiodes.lista.lib.Lista;

public class Main {
    public static void main(String[] args) {
        Lista<Integer> listaInteiro = new Lista<>();

        listaInteiro.adicionarFinal(1);

        System.out.println("Primeiro item: " + listaInteiro.getPrimeiroItem());
        System.out.println("Ultimo item: " + listaInteiro.getUltimoItem());

        listaInteiro.adicionarFinal(2);
        System.out.println("Primeiro item: " + listaInteiro.getPrimeiroItem());
        System.out.println("Ultimo item: " + listaInteiro.getUltimoItem());

        listaInteiro.adicionarFinal(3);
        System.out.println("Primeiro item: " + listaInteiro.getPrimeiroItem());
        System.out.println("Ultimo item: " + listaInteiro.getUltimoItem());

        listaInteiro.substituirPeloIndice(2, 2);
        System.out.println("Primeiro item: " + listaInteiro.getPrimeiroItem());
        System.out.println("Ultimo item: " + listaInteiro.getUltimoItem());

        System.out.println("Indice 2 -> " + listaInteiro.obterPorIndice(2));
        System.out.println("Ocorrencias do número 2 -> " + listaInteiro.obterNumeroOcorencias(2));

//        listaInteiro.limparLista();
        System.out.println("Impares: " + listaInteiro.ocorrenciasDeNumerosImpares());
        System.out.println("---- Itens ----");
        System.out.println(listaInteiro);
        System.out.println("---- Fim ----");

        System.out.println("Tamanho da lista: " + listaInteiro.getTamanho());
    }
}
