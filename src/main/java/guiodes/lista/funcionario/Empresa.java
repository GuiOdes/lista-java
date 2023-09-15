package guiodes.lista.funcionario;

import guiodes.lista.lib.Lista;

public class Empresa {
    private String nome;
    private int quantidadeFuncionarios = 0;
    private Lista<Funcionario> listaFuncionarios = new Lista<>();

    public Empresa(String nome) {
        this.nome = nome;
    }

    void adicionarFuncionario(Funcionario funcionario) {
        listaFuncionarios.adicionarInicio(funcionario);
        this.quantidadeFuncionarios++;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public Lista<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
