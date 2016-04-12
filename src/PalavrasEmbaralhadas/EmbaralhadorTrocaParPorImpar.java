package PalavrasEmbaralhadas;

public class EmbaralhadorTrocaParPorImpar implements Embaralhador {

	private final int DIFICULDADE = 5;
	
	@Override
	public String embaralharPalavra(String palavra) {

		char[] letrasDaPalavra = palavra.toCharArray();

		for (int i = 0; i < letrasDaPalavra.length; i++) {
			if (i < letrasDaPalavra.length - 1) {
				if (i % 2 == 0) {
					char atual = letrasDaPalavra[i];
					letrasDaPalavra[i] = letrasDaPalavra[i + 1];
					letrasDaPalavra[i + 1] = atual;
				}
			}
		}

		String palavraEmbaralhada = new String(letrasDaPalavra);
		return palavraEmbaralhada;
	}

	@Override
	public int getDificuldade() {
		return DIFICULDADE;
	}

	
}
