package PalavrasEmbaralhadas;

import java.util.Random;

public class FabricaEmbaralhadores {

	public static Embaralhador getEmbaralhadorAleatorio() {

		Random random = new Random();
		int i = random.nextInt(2) + 1;

		if (i == 1) {
			return new EmbaralhadorPalavraInvertida();
		} else {
			return new EmbaralhadorTrocaParPorImpar();
		}
	}

}
