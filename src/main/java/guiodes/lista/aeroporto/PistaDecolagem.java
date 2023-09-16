package guiodes.lista.aeroporto;

import guiodes.lista.lib.Lista;

public class PistaDecolagem {
    private Lista<Aviao> listaEspera;

    public PistaDecolagem(Lista<Aviao> listaEspera) {
        this.listaEspera = listaEspera;
    }

    void contarAvioesNaFila() {
        System.out.println("Aviões em espera na fila: " + listaEspera.getTamanho());
    }

    void listarAvioesEmEspera() {
        System.out.println("----- LISTA DE ESPERA -----");
        System.out.println(listaEspera.toString());
        System.out.println("---------- FIM ----------");
    }

    void adicionarAviaoFilaEspera(Aviao aviao) {
        listaEspera.adicionarFinal(aviao);
    }

    void autorizarDecolagem() {
        Aviao aviao = listaEspera.getPrimeiroItem();
        aviao.setStatus(StatusAviao.VOO_AUTORIZADO);
        System.out.println("Decolagem autorizada para avião -> " + aviao.getNome());
        listaEspera.removerInicio();
    }

    void informacoesPrimeiroAviaoDaFila() {
        System.out.println("Primeiro avião da fila: " + listaEspera.getPrimeiroItem().toString());
    }
}
