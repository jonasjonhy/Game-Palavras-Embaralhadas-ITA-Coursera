package PalavrasEmbaralhadas;

public class MecanicaDOIS implements MecanicaDoJogo {

	private int pontos;
	private int qtdErros;
	private final int MAXIXODEERROSPERMITIDOS = 6;
	private Embaralhador embaralhador;
	
	public MecanicaDOIS() {
		this.embaralhador = FabricaEmbaralhadores.getEmbaralhadorAleatorio();
	}
	
	@Override
	public boolean isAcabou() {
		if(qtdErros > MAXIXODEERROSPERMITIDOS){
			return true;
		}
		return false;
	}

	@Override
	public boolean isAcertou(String palavra, String palavraDoUsuario) {
		if(palavra.equalsIgnoreCase(palavraDoUsuario)){
			this.computarPontos(palavraDoUsuario);
			return true;
		}
		qtdErros++;
		return false;
	}

	@Override
	public String novaPalavraEmbaralhada(String palavra) {
		return this.embaralhador.embaralharPalavra(palavra);
	}

	@Override
	public void computarPontos(String palavra) {
		this.pontos += embaralhador.getDificuldade() * palavra.length();
	}

	@Override
	public int getPontos() {
		return pontos;
	}

	@Override
	public int getQuantidadeMaximaDeErros() {
		return MAXIXODEERROSPERMITIDOS;
	}

	@Override
	public boolean tentarNovamente() {
		return false;
	}

}
