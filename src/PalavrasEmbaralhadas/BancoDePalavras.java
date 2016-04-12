package PalavrasEmbaralhadas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BancoDePalavras {

	private RandomAccessFile arquivo;
	private String palavraGerada;

	public BancoDePalavras() throws FileNotFoundException {
		
		arquivo = new RandomAccessFile("C:/Users/jonatas/workspaceCoursera/Projeto-Final-OrientacaoAObjetos-Coursera-ITA/palavras.txt", "r");
		
	}

	public String getPalavrasDoArquivo() throws IOException {

		this.palavraGerada = arquivo.readLine();

		return palavraGerada;
	}


	
	
	

}
