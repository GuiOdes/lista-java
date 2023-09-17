package guiodes.lista.lib;

import java.math.BigDecimal;
import java.util.function.Function;

public class FuncoesSoma<T> {
    Lista<T> lista;

    public FuncoesSoma(Lista<T> lista) {
        this.lista = lista;
    }

    public BigDecimal somaBigDecimal(Function<T, BigDecimal> seletor) {
        BigDecimal soma = BigDecimal.ZERO;

        for (T item : lista) {
            soma = soma.add(seletor.apply(item));
        }

        return soma;
    }

    public Integer somaInteiro(Function<T, Integer> seletor) {
        Integer soma = 0;

        for (T item : lista) {
            soma += seletor.apply(item);
        }

        return soma;
    }

    public Double somaDouble(Function<T, Double> seletor) {
        Double soma = 0.0;

        for (T item : lista) {
            soma += seletor.apply(item);
        }

        return soma;
    }
}
