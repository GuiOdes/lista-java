package guiodes.lista.lib;

import java.util.Iterator;

public class Lista<T> implements Iterable<No<T>> {
    private int tamanho = 0;
    private No<T> primeiroItem;
    private No<T> ultimoItem;

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getPrimeiroItem() {
        return primeiroItem;
    }

    public No<T> getUltimoItem() {
        return ultimoItem;
    }

    public Lista() {
    }

    @Override
    public Iterator<No<T>> iterator() {
        return new Iterador<>(primeiroItem);
    }

    public void adicionarInicio(T elemento) {
        if (this.primeiroItem != null) {
            this.forEach((no) -> {
                no.setIndice(no.getIndice() + 1);
            });
        }

        this.primeiroItem = new No<>(elemento, primeiroItem, null, 0);

        if (this.tamanho == 0)
            this.ultimoItem = this.primeiroItem;
        crescer();
    }

    public void adicionarFinal(T elemento) {
        if (this.tamanho == 0) {
            adicionarInicio(elemento);
            return;
        }

        crescer();

        this.forEach(no -> {
            if (no.getProximo() == null) {
                No<T> novoUltimoItem = new No<>(elemento, null, no, this.tamanho - 1);
                no.setProximo(novoUltimoItem);
                this.ultimoItem = novoUltimoItem;
            }
        });
    }

    public void removerInicio() {
        this.primeiroItem = this.primeiroItem.getProximo();

        this.forEach((no) -> no.setIndice(no.getIndice() - 1));

        reduzir();
    }

    public void removerFinal() {
        No<T> antigoUltimo = this.ultimoItem;
        this.ultimoItem = antigoUltimo.getAnterior();
        this.ultimoItem.setProximo(antigoUltimo.getProximo());
        reduzir();
    }

    public void substituirPeloIndice(int indice, T novoElemento) {
        if (indice >= this.tamanho || indice < 0)
            throw new IllegalArgumentException("Índice inválido para item da lista");

        if (indice == 0) {
            adicionarInicio(novoElemento);
            return;
        };

        No<T> noASerSubstituido = this.primeiroItem;

        while (noASerSubstituido.getIndice() != indice) {
            noASerSubstituido = noASerSubstituido.getProximo();
        }

        No<T> novoNo = new No<>(novoElemento, noASerSubstituido, noASerSubstituido.getAnterior(), indice);

        noASerSubstituido.getAnterior().setProximo(novoNo);
        noASerSubstituido.setAnterior(novoNo);

        No<T> noAtual = noASerSubstituido;
        while (noAtual.getIndice() <= this.tamanho-1) {
            noAtual.setIndice(noAtual.getIndice()+1);

            if (!noAtual.existeProximo()) {
                this.ultimoItem = noAtual;
                break;
            }
            noAtual = noAtual.getProximo();
        }

        crescer();
    }

    public T obterPorIndice(int indice) {
        if (indice < 0 || indice > tamanho-1)
            throw new IllegalArgumentException("Indice fora dos limites da lista!");

        No<T> noAtual = this.primeiroItem;

        while (noAtual.getIndice() != indice) {
            noAtual = noAtual.getProximo();
        }

        return noAtual.getValor();
    }

    public int obterNumeroOcorencias(T valor) {
        No<T> noAtual = this.primeiroItem;
        int contador = 0;

        while (noAtual.getIndice() <= this.tamanho-1) {
            if (noAtual.getValor() == valor) contador++;

            if (!noAtual.existeProximo()) break;
            noAtual = noAtual.getProximo();
        }

        return contador;
    }

    public int ocorrenciasDeNumerosImpares() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("Lista vazia!");
        }

        No<T> noAtual = this.primeiroItem;

        if (!(noAtual.getValor() instanceof Integer)) {
            throw new IllegalArgumentException("A lista deve ser de inteiros!");
        }

        int contador = 0;
        while (noAtual.getIndice() <= this.tamanho-1) {
            if ((int) noAtual.getValor() % 2 != 0) contador++;

            if (!noAtual.existeProximo()) break;
            noAtual = noAtual.getProximo();
        }

        return contador;
    }

    public void limparLista() {
        int antigoTamanho = this.tamanho;
        for (int i = 0; i <= antigoTamanho-1; i++) {
            removerInicio();
        }

        System.gc();
    }

    void crescer() {
        this.tamanho++;
    }

    void reduzir() {
        this.tamanho--;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        this.forEach(no -> {
            result
                .append("[")
                .append(no.getIndice())
                .append("] -> ")
                .append(no.getValor());

            if (no.getIndice() != this.tamanho - 1) result.append("\n");
        });

        return result.toString();
    }
}