package guiodes.lista.funcionarioEmpresa;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger cont = new AtomicInteger(1);
        empresa.getListaFuncionarios().forEach(funcionario -> {
            System.out.println(cont.getAndIncrement());
            System.out.println("Nome: " + funcionario.getNome()); // Resolver a necessidade de usar o getValor()
            System.out.println("Idade: " + funcionario.getIdade());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("-----------------");
        });
        System.out.println("--- Fim da lista ---");

        System.out.println("Soma de todos os salários: " + empresa.getListaFuncionarios().somaDe(Funcionario::getSalario));
    }
}
