package guiodes.lista.lib;


import java.util.Iterator;

public class IteradorPrivado<T> implements Iterator<No<T>> {

    private No<T> atual;

    public IteradorPrivado(No<T> atual) {
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
