package guiodes.lista;

import java.util.Iterator;

public class Lista<T> implements Iterable<No<T>> {
    int tamanho = 0;
    No<T> primeiroItem;
    No<T> ultimoItem;

    public Lista() {
    }

    @Override
    public Iterator<No<T>> iterator() {
        return new Iterador<>(primeiroItem);
    }

    void adicionarInicio(T elemento) {
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

    void adicionarFinal(T elemento) {
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

    void removerInicio() {
        this.primeiroItem = this.primeiroItem.getProximo();

        this.forEach((no) -> no.setIndice(no.getIndice() - 1));

        reduzir();
    }

    void removerFinal() {
        No<T> antigoUltimo = this.ultimoItem;
        this.ultimoItem = antigoUltimo.getAnterior();
        this.ultimoItem.setProximo(antigoUltimo.getProximo());
        reduzir();
    }

    void substituirPeloIndice(int indice, T novoElemento) {

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