package guiodes.lista.lib;

import java.util.Iterator;
import java.util.function.Function;

public class Lista<T> implements Iterable<T> {
    private int tamanho = 0;
    private No<T> primeiroItem;
    private No<T> ultimoItem;
    private final FuncoesSoma<T> funcoesSoma = new FuncoesSoma<>(this);

    public int getTamanho() {
        return tamanho;
    }

    public T getPrimeiroItem() {
        return primeiroItem.getValor();
    }

    public T getUltimoItem() {
        return ultimoItem.getValor();
    }

    public Lista() {
    }

    @Override
    public Iterator<T> iterator() { // Utilizado para funções externas, pois retorna diretamente os valores dos nós
        return new IteradorPublico<>(this);
    }

    public Iterator<No<T>> iteratorPrivado() { // Utilizado para funções internas, pois retorna os nós nas repetições
        return new IteradorPrivado<>(primeiroItem);
    }

    public Class<?> getTipo() {
        return this.primeiroItem.getValor().getClass();
    }

    public Number somaDe(Function<T, Number> seletor) {
        return funcoesSoma.somaDe(seletor);
    }

    public void adicionarInicio(T elemento) {
        if (this.primeiroItem != null) {
            iteratorPrivado().forEachRemaining(no -> {
                no.setIndice(no.getIndice() + 1);
            });
        }

        this.primeiroItem = new No<>(elemento, primeiroItem, null, 0);

        if (this.tamanho == 0)
            this.ultimoItem = this.primeiroItem;
        crescer();
    }

    public void adicionarVariosInicio(Lista<T> elementos) {
        elementos.forEach(this::adicionarInicio);
    }

    public void adicionarFinal(T elemento) {
        if (this.tamanho == 0) {
            adicionarInicio(elemento);
            return;
        }

        crescer();

        iteratorPrivado().forEachRemaining(no -> {
            if (no.getProximo() == null) {
                No<T> novoUltimoItem = new No<>(elemento, null, no, this.tamanho - 1);
                no.setProximo(novoUltimoItem);
                this.ultimoItem = novoUltimoItem;
            }
        });
    }

    public void adicionarVariosFinal(Lista<T> elementos) {
        elementos.forEach(this::adicionarFinal);
    }

    public void removerInicio() {
        this.primeiroItem = this.primeiroItem.getProximo();

        iteratorPrivado().forEachRemaining((no) -> no.setIndice(no.getIndice() - 1));

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
        }
        ;

        No<T> noASerSubstituido = this.primeiroItem;

        while (noASerSubstituido.getIndice() != indice) {
            noASerSubstituido = noASerSubstituido.getProximo();
        }

        No<T> novoNo = new No<>(novoElemento, noASerSubstituido, noASerSubstituido.getAnterior(), indice);

        noASerSubstituido.getAnterior().setProximo(novoNo);
        noASerSubstituido.setAnterior(novoNo);

        No<T> noAtual = noASerSubstituido;
        while (noAtual.getIndice() <= this.tamanho - 1) {
            noAtual.setIndice(noAtual.getIndice() + 1);

            if (!noAtual.existeProximo()) {
                this.ultimoItem = noAtual;
                break;
            }
            noAtual = noAtual.getProximo();
        }

        crescer();
    }

    public T obterPorIndice(int indice) {
        if (indice < 0 || indice > tamanho - 1)
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

        while (noAtual.getIndice() <= this.tamanho - 1) {
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
        while (noAtual.getIndice() <= this.tamanho - 1) {
            if ((int) noAtual.getValor() % 2 != 0) contador++;

            if (!noAtual.existeProximo()) break;
            noAtual = noAtual.getProximo();
        }

        return contador;
    }

    public void limparLista() {
        int antigoTamanho = this.tamanho;
        for (int i = 0; i <= antigoTamanho - 1; i++) {
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

        iteratorPrivado().forEachRemaining(no -> {
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