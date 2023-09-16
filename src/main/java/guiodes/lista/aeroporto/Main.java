package guiodes.lista.aeroporto;

import guiodes.lista.lib.Lista;

public class Main {
    public static void main(String[] args) {
        Aviao aviao1 = new Aviao("Airbus", 1);
        Aviao aviao2 = new Aviao("Boeing", 2);
        Aviao aviao3 = new Aviao("Teco Teco", 3);
        Aviao aviao4 = new Aviao("Jatinho do L", 4);

        Lista<Aviao> listaAvioes = new Lista<>();
        listaAvioes.adicionarFinal(aviao1);
        listaAvioes.adicionarFinal(aviao2);
        listaAvioes.adicionarFinal(aviao3);
        listaAvioes.adicionarFinal(aviao4);

        PistaDecolagem pistaDecolagem = new PistaDecolagem(listaAvioes);

        pistaDecolagem.contarAvioesNaFila();
        pistaDecolagem.autorizarDecolagem();
        pistaDecolagem.autorizarDecolagem();
        pistaDecolagem.adicionarAviaoFilaEspera(aviao1);
        pistaDecolagem.listarAvioesEmEspera();
        pistaDecolagem.informacoesPrimeiroAviaoDaFila();
    }
}
