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
        this.primeiroItem = new No<>(elemento, primeiroItem, null);
        crescer();
    }

    void removerInicio() {
        this.primeiroItem = this.primeiroItem.getProximo();
        reduzir();
    }

    void removerFinal() {
        No<T> antigoUltimo = this.ultimoItem;
        this.ultimoItem = antigoUltimo.getAnterior();
        this.ultimoItem.setProximo(antigoUltimo.getProximo());
        reduzir();
    }

    void adicionarFinal(T elemento) {
        if (this.tamanho == 0) {
            adicionarInicio(elemento);
            return;
        }

        this.forEach(no -> {
            if (no.getProximo() == null) {
                No<T> novoUltimoItem = new No<>(elemento, null, no);
                no.setProximo(novoUltimoItem);
                this.ultimoItem = novoUltimoItem;
            }
        });
        crescer();
    }

    void crescer() {
        this.tamanho++;
    }

    void reduzir() {
        this.tamanho--;
    }
}