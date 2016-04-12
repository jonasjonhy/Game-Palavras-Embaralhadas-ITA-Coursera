package PalavrasEmbaralhadas;

import java.util.Random;

public class FabricaMecanicaDoJogo {

	public static MecanicaDoJogo getMecanicaAleatoria() {

		Random random = new Random();
		int i = random.nextInt(2) + 1;

		if (i == 1) {
			return new MecanicaUM();
		} else {
			return new MecanicaDOIS();
		}
	}
	
}
