package PalavrasEmbaralhadas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {

		System.out.println(
				"BEM VINDO AO PALAVRAS EMBARALHADAS, VAMOS VER SE VOCÊ É BOM EM DESCOBRIR AS PALAVRAS CORRETAS");

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
				System.out.println("Tente acertar, a palavra é... " + "'" + palavraEmbaralhada + "'");
				System.out.print("digite a palavra corretamente: ");
				String palavraDoUsuario = scan.nextLine();

				if (mecanica.isAcertou(palavra, palavraDoUsuario)) {
					System.out.println("Parabéns você acertou, você tem " + mecanica.getPontos() + " pontos");
				} else {

					while (mecanica.tentarNovamente()) {
						System.out.println("Tente novamente, a palavra é... " + "'" + palavraEmbaralhada + "'");
						System.out.print("digite a palavra corretamente: ");
						String palavraDoUser = scan.nextLine();
						if (mecanica.isAcertou(palavra, palavraDoUser)) {
							System.out.println("Parabéns você acertou, você tem " + mecanica.getPontos() + " pontos");
							break;
						}
					}
					if (!mecanica.tentarNovamente()) {
						System.out.println("XIIII, você errou");
					}

				}

			} else {
				System.out.println("O jogo acabou, parabéns, você fez " + mecanica.getPontos() + " pontos");
				System.exit(0);
			}
		}

		System.out.println(
				"XIIIII, você errou mais de " + mecanica.getQuantidadeMaximaDeErros() + " vezes, Fim de Jogo :( ");

	}

}