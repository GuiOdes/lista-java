package guiodes.lista.lib;

import java.math.BigDecimal;
import java.util.function.Function;

public class FuncoesSoma<T> {
    Lista<T> lista;

    public FuncoesSoma(Lista<T> lista) {
        this.lista = lista;
    }

    public Number somaDe(Function<T, Number> seletor) {
        if (seletor == null) throw new  IllegalArgumentException("Seletor não pode ser nulo!");
        return switch (lista.getTipo().getSimpleName()) {
            case "BigDecimal" -> somaBigDecimal(
                    seletor
                        .andThen(Number::doubleValue)
                        .andThen(BigDecimal::valueOf)
            );
            case "Integer" -> somaInteiro(seletor.andThen(Number::intValue));
            case "Double" -> somaDouble(seletor.andThen(Number::doubleValue));
            case "Long" -> somaLong(seletor.andThen(Number::longValue));
            default -> throw new IllegalArgumentException("Tipo de dado não suportado!");
        };
    }

    private BigDecimal somaBigDecimal(Function<T, BigDecimal> seletor) {
        BigDecimal soma = BigDecimal.ZERO;

        for (T item : lista) {
            soma = soma.add(seletor.apply(item));
        }

        return soma;
    }

    private Integer somaInteiro(Function<T, Integer> seletor) {
        Integer soma = 0;

        for (T item : lista) {
            soma += seletor.apply(item);
        }

        return soma;
    }

    private Long somaLong(Function<T, Long> seletor) {
        Long soma = 0L;

        for (T item : lista) {
            soma += seletor.apply(item);
        }

        return soma;
    }

    private Double somaDouble(Function<T, Double> seletor) {
        Double soma = 0.0;

        for (T item : lista) {
            soma += seletor.apply(item);
        }

        return soma;
    }
}
