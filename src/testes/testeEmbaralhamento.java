package testes;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import PalavrasEmbaralhadas.EmbaralhadorPalavraInvertida;
import PalavrasEmbaralhadas.EmbaralhadorTrocaParPorImpar;

public class testeEmbaralhamento {

	private static EmbaralhadorTrocaParPorImpar embaralhadorParPorImpar;
	private static EmbaralhadorPalavraInvertida embaralhadorPalavraInvertida;

	@BeforeClass
	public static void inicializarEmbaralhador() {
		embaralhadorParPorImpar = new EmbaralhadorTrocaParPorImpar();
		embaralhadorPalavraInvertida = new EmbaralhadorPalavraInvertida();
	}

	@Test
	public void testPalavraInvertida() {
		assertEquals("ECAFLA", embaralhadorPalavraInvertida.embaralharPalavra("ALFACE"));

	}

	@Test
	public void testPalavraParPorImpar() {
		assertEquals("LAAFEC", embaralhadorParPorImpar.embaralharPalavra("ALFACE"));

	}

}
