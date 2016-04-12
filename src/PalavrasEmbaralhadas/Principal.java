package PalavrasEmbaralhadas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {

		System.out.println(
				"BEM VINDO AO PALAVRAS EMBARALHADAS, VAMOS VER SE VOC� � BOM EM DESCOBRIR AS PALAVRAS CORRETAS");

		Scanner scan = new Scanner(System.in);

		MecanicaDoJogo mecanica = FabricaMecanicaDoJogo.getMecanicaAleatoria();

		BancoDePalavras bancoDePalavras = new BancoDePalavras();

		while (!mecanica.isAcabou()) {

			String palavra = bancoDePalavras.getPalavrasDoArquivo();
			/*
			 * se a palavra gerada for null, significa que terminou todas as
			 * palavras do arquivo e o jogo acabou
			 */
			if (palavra != null) {
				String palavraEmbaralhada = mecanica.novaPalavraEmbaralhada(palavra);
				System.out.println("Tente acertar, a palavra �... " + "'" + palavraEmbaralhada + "'");
				System.out.print("digite a palavra corretamente: ");
				String palavraDoUsuario = scan.nextLine();

				if (mecanica.isAcertou(palavra, palavraDoUsuario)) {
					System.out.println("Parab�ns voc� acertou, voc� tem " + mecanica.getPontos() + " pontos");
				} else {

					while (mecanica.tentarNovamente()) {
						System.out.println("Tente novamente, a palavra �... " + "'" + palavraEmbaralhada + "'");
						System.out.print("digite a palavra corretamente: ");
						String palavraDoUser = scan.nextLine();
						if (mecanica.isAcertou(palavra, palavraDoUser)) {
							System.out.println("Parab�ns voc� acertou, voc� tem " + mecanica.getPontos() + " pontos");
							break;
						}
					}
					if (!mecanica.tentarNovamente()) {
						System.out.println("XIIII, voc� errou");
					}

				}

			} else {
				System.out.println("O jogo acabou, parab�ns, voc� fez " + mecanica.getPontos() + " pontos");
				System.exit(0);
			}
		}

		System.out.println(
				"XIIIII, voc� errou mais de " + mecanica.getQuantidadeMaximaDeErros() + " vezes, Fim de Jogo :( ");

	}

}