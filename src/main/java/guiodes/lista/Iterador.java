package guiodes.lista;


import java.util.Iterator;
import java.util.LinkedList;

public class Iterador<T> implements Iterator<No<T>> {

    private No<T> atual;

    public Iterador(No<T> atual) {
        this.atual = atual;
    }

    @Override
    public boolean hasNext() {
        return this.atual != null;
    }

    @Override
    public No<T> next() {
        No<T> atual = this.atual;
        this.atual = this.atual.getProximo();
        return atual;
    }
}
