package guiodes.lista.funcionario;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Funcionario guilherme = new Funcionario("Guilherme", 22, new BigDecimal(25000));
        Funcionario marcelo = new Funcionario("Marcelo", 25, new BigDecimal(500));
        Funcionario julio = new Funcionario("Julio", 18, new BigDecimal(12000));
        Empresa empresa = new Empresa("IF Goiano");

        empresa.adicionarFuncionario(guilherme);
        empresa.adicionarFuncionario(marcelo);
        empresa.adicionarFuncionario(julio);

        System.out.println("Nome da empresa: " + empresa.getNome());
        System.out.println("Quantidade de funcionarios: " + empresa.getQuantidadeFuncionarios());
        System.out.println("--- Funcionários ---");
        empresa.getListaFuncionarios().forEach(funcionario -> {
            System.out.println(funcionario.getIndice()+1);
            System.out.println("Nome: " + funcionario.getValor().getNome()); // Resolver a necessidade de usar o getValor()
            System.out.println("Idade: " + funcionario.getValor().getIdade());
            System.out.println("Salário: " + funcionario.getValor().getSalario());
            System.out.println("-----------------");
        });
        System.out.println("--- Fim da lista ---");
    }
}
