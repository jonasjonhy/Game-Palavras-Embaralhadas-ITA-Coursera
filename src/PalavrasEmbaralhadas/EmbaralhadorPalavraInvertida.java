package PalavrasEmbaralhadas;

public class EmbaralhadorPalavraInvertida implements Embaralhador {

	private final int DIFICULDADE = 3;

	@Override
	public String embaralharPalavra(String palavra) {

		char[] letrasDaPalavra = palavra.toCharArray();
		StringBuffer palavraEmbaralhada = new StringBuffer();

		for (int i = letrasDaPalavra.length - 1; i >= 0; i--) {
			palavraEmbaralhada.append(letrasDaPalavra[i]);
		}

		return palavraEmbaralhada.toString();
	}

	@Override
	public int getDificuldade() {
		return DIFICULDADE;
	}

}
