package PalavrasEmbaralhadas;

public interface MecanicaDoJogo {

	public boolean isAcabou();

	public boolean isAcertou(String palavra, String palavraDoUsuario);
	
	public boolean tentarNovamente();

	public String novaPalavraEmbaralhada(String palavra);

	public void computarPontos(String palavra);

	public int getPontos();
	
	public int getQuantidadeMaximaDeErros();
}
