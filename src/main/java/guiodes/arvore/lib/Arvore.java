package guiodes.arvore.lib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Arvore {
    private int valor;
    private Arvore esquerda;
    private Arvore direita;
    public Arvore(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Arvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Arvore esquerda) {
        this.esquerda = esquerda;
    }
    public Arvore getDireita() {
        return direita;
    }
    public void setDireita(Arvore direita) {
        this.direita = direita;
    }
    public void inserirArvore(Arvore arvore) {
        if (this.esquerda == null) {
            this.esquerda = arvore;
        } else if (this.esquerda.getValor() > arvore.getValor()) {
            this.direita = this.esquerda;
            this.esquerda = arvore;
        } else if (this.direita == null) {
            this.direita = arvore;
        } else if (this.direita.getValor() < arvore.getValor()) {
            this.direita = arvore;
        }
    }
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
