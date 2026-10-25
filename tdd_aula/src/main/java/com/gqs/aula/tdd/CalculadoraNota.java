package com.gqs.aula.tdd;

/**
 * Calculadora de notas dos alunos.
 */
public class CalculadoraNota {

    public static final double FREQUENCIA_MINIMA = 75;
   
    /** Nota mínima para aprovação. */
    public static final double NOTA_MINIMA_APROVACAO = 70;

    /** Nota máxima para A1 e A2. */
    public static final double NOTA_MAXIMA_A1_A2 = 30;

    /** Nota máxima para A3. */
    public static final double NOTA_MAXIMA_A3 = 40;

    /** Situação de aprovação. */
public static final String SITUACAO_APROVADO = "APROVADO";

/** Reprovação por frequência insuficiente. */
public static final String SITUACAO_REPROVADO_FALTA = "REPROVADO POR FALTA";

/** Reprovação por nota insuficiente. */
public static final String SITUACAO_REPROVADO_NOTA = "REPROVADO POR NOTA";

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, NOTA_MAXIMA_A1_A2, "A1");
        validarNota(a2, NOTA_MAXIMA_A1_A2, "A2");
        validarNota(a3, NOTA_MAXIMA_A3, "A3");

        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }
   public String situacao(double notaFinal, double frequencia) {
    if (frequencia < FREQUENCIA_MINIMA) {
        return SITUACAO_REPROVADO_FALTA;
    }

    if (!estaAprovadoPorNota(notaFinal)) {
        return SITUACAO_REPROVADO_NOTA;
    }

    return SITUACAO_APROVADO;
}

public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
    double notaFinal = calcularNotaFinal(a1, a2, a3);

    boolean reprovadoPorNota = !estaAprovadoPorNota(notaFinal);
    boolean frequenciaSuficiente = frequencia >= FREQUENCIA_MINIMA;
    boolean somaSuficiente = (a1 + a3 >= 40 || a2 + a3 >= 40);

    return reprovadoPorNota && frequenciaSuficiente && somaSuficiente;
}
public double aplicarAI(double a1, double a2, double a3, double notaAI) {
    if (notaAI < 0 || notaAI > NOTA_MAXIMA_A1_A2) {
        throw new IllegalArgumentException("A nota da AI deve estar entre 0 e 30");
    }

    double menorNota = Math.min(a1, a2);

    if (notaAI <= menorNota) {
        return calcularNotaFinal(a1, a2, a3);
    }

    if (a1 <= a2) {
        a1 = notaAI;
    } else {
        a2 = notaAI;
    }

    return calcularNotaFinal(a1, a2, a3);
}
}