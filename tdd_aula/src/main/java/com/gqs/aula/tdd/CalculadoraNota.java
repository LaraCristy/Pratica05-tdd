package com.gqs.aula.tdd;

/**
 * Calculadora de notas dos alunos.
 */
public class CalculadoraNota {

    public double calcularNotaFinal(double nota1, double nota2, double nota3) {
        return nota1 + nota2 + nota3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= 70;
    }
}