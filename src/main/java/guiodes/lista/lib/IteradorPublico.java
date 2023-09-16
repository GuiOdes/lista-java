package guiodes.lista.lib;

import java.util.Iterator;
import java.util.NoSuchElementException;

class IteradorPublico<T> implements Iterator<T> {
    private int indice = 0;
    private final Lista<T> listaElementos;

    public IteradorPublico(Lista<T> listaElementos) {
        this.listaElementos = listaElementos;
    }

    @Override
    public boolean hasNext() {
        return indice < listaElementos.getTamanho();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T elemento = listaElementos.obterPorIndice(indice);
        indice++;
        return elemento;
    }
}
