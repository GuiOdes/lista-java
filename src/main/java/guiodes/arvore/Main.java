package guiodes.arvore;

import guiodes.arvore.lib.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(1);
        Arvore arvore2 = new Arvore(2);
        Arvore arvore3 = new Arvore(3);
        Arvore arvore4 = new Arvore(4);
        Arvore arvore5 = new Arvore(-1);
        Arvore arvore6 = new Arvore(7);
        Arvore arvore7 = new Arvore(5);

        arvore.inserirArvore(arvore2);
        arvore.inserirArvore(arvore5);
        arvore.inserirArvore(arvore4);
        arvore.inserirArvore(arvore3);
        arvore4.inserirArvore(arvore6);
        arvore4.inserirArvore(arvore7);
        System.out.println(arvore);
    }
}
