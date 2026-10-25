package com.gqs.aula.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes da classe CalculadoraNota.
 */
public class CalculadoraNotaTest {

    private static final double NOTA_APROVACAO = 70;
    private static final double NOTA_REPROVACAO = 69;

    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20, 20, 30);
        assertEquals(NOTA_APROVACAO, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(NOTA_APROVACAO));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(NOTA_REPROVACAO));
    }
    @Test
    void deveRejeitarA1MaiorQue30() {
    CalculadoraNota calc = new CalculadoraNota();
    assertThrows(IllegalArgumentException.class,
    () -> calc.calcularNotaFinal(35, 20, 30));
    }
    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals("APROVADO", calc.situacao(80, 90));
    }
    @Test
    void deveReprovarComNotaBaixa() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals("REPROVADO POR NOTA", calc.situacao(60, 90));
}

   @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals("REPROVADO POR FALTA", calc.situacao(95, 74));
}

    @Test
    void deveAprovarComFrequenciaExatamente75() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals("APROVADO", calc.situacao(70, 75));
    }
    @Test
    void devePermitirAIComSomaA2A3Suficiente() {
    CalculadoraNota calc = new CalculadoraNota();
    assertTrue(calc.podeFazerAI(10, 20, 30, 80));
    }
    @Test
    void devePermitirAIComSomaExatamente40() {
    CalculadoraNota calc = new CalculadoraNota();
    assertTrue(calc.podeFazerAI(10, 5, 30, 80));
    }
    @Test
    void deveNegarAIParaAlunoAprovado() {
    CalculadoraNota calc = new CalculadoraNota();
    assertFalse(calc.podeFazerAI(25, 25, 30, 80));
    }

    @Test
    void deveNegarAIPorFrequenciaBaixa() {
    CalculadoraNota calc = new CalculadoraNota();
    assertFalse(calc.podeFazerAI(10, 20, 30, 70));
    }   

    @Test
    void deveNegarAISemSomaMinima() {
    CalculadoraNota calc = new CalculadoraNota();
    assertFalse(calc.podeFazerAI(5, 5, 30, 80));
    }
    @Test
    void deveSubstituirA1PelaAI() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals(75, calc.aplicarAI(10, 20, 30, 25));
}

    @Test
    void deveSubstituirA2PelaAI() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals(75, calc.aplicarAI(20, 10, 30, 25));
}

    @Test
    void naoDeveSubstituirQuandoAIEhMenor() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals(75, calc.aplicarAI(20, 25, 30, 15));
}

    @Test
    void deveRejeitarAINotaInvalida() {
    CalculadoraNota calc = new CalculadoraNota();
    assertThrows(IllegalArgumentException.class,
        () -> calc.aplicarAI(10, 20, 30, 35));
    }
    @Test
    void devePriorizarReprovacaoPorFalta() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals("REPROVADO POR FALTA", calc.situacao(50, 60));
}
@Test
void deveAprovarComNotaMaiorQue70() {
    CalculadoraNota calc = new CalculadoraNota();
    assertTrue(calc.estaAprovadoPorNota(85));
}

@Test
void deveReprovarComNotaMuitoBaixa() {
    CalculadoraNota calc = new CalculadoraNota();
    assertFalse(calc.estaAprovadoPorNota(40));
}

@Test
void deveAceitarNotasZeradas() {
    CalculadoraNota calc = new CalculadoraNota();
    assertEquals(0, calc.calcularNotaFinal(0, 0, 0));
}
}
