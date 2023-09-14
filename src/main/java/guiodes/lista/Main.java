package guiodes.lista;

public class Main {
    public static void main(String[] args) {
        Lista<Integer> listaInteiro = new Lista<>();

        listaInteiro.adicionarFinal(9);
        listaInteiro.adicionarInicio(1);
        listaInteiro.adicionarInicio(2);
        listaInteiro.removerInicio();
        listaInteiro.adicionarInicio(3);
        listaInteiro.adicionarFinal(8);
        listaInteiro.removerFinal();
        listaInteiro.adicionarFinal(7);

        System.out.println("---- Itens ----");
        listaInteiro.forEach(integerNo ->
            System.out.println(integerNo.getValor())
        );
        System.out.println("---- Fim ----");

        System.out.println("Tamanho da lista: " + listaInteiro.tamanho);
    }
}
