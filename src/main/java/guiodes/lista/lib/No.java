package guiodes.lista.lib;

public class No<T> {

    private T valor;
    private No<T> proximo;
    private No<T> anterior;
    private int indice;

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    public No(T valor, No<T> proximo, No<T> anterior, int indice) {
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
        this.indice = indice;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
    public boolean existeProximo() {
        return this.proximo != null;
    }
}
