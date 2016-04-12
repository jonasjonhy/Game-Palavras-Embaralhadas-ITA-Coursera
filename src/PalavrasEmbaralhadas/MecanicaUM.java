package PalavrasEmbaralhadas;

public class MecanicaUM implements MecanicaDoJogo {

	private int pontos;
	private int qtdErros;
	private int qtdTentativas;
	private final int MAXIXODETENTATIVASPERMITIDAS = 3;
	private final int MAXIXODEERROSPERMITIDOS = 2;
	private Embaralhador embaralhador;

	public MecanicaUM() {
		this.embaralhador = FabricaEmbaralhadores.getEmbaralhadorAleatorio();
	}

	@Override
	public boolean isAcabou() {
		if (qtdErros > MAXIXODEERROSPERMITIDOS) {
			return true;
		}
		return false;
	}

	/*
	 * na logica dessa primeira mec�nica eu s� vou computar erros caso o ele n�o
	 * possa tentar acertar novamente, diferentemente da l�gica da mecanica dois
	 * que s� permite uma �nica tentativa por palavra e em caso de erro j�
	 * computa os erros
	 */
	@Override
	public boolean isAcertou(String palavra, String palavraDoUsuario) {
		if (palavra.equalsIgnoreCase(palavraDoUsuario)) {
			this.computarPontos(palavraDoUsuario);
			this.qtdTentativas = 0;
			return true;
		}
		if (tentarNovamente()) {
			qtdTentativas++;
			return false;
		}
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
		if (qtdTentativas == MAXIXODETENTATIVASPERMITIDAS) {
			qtdErros++;
			qtdTentativas = 0;
			return false;
		}
		return true;

	}

}
