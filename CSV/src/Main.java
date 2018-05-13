

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;


public class Main {
	

	
	public static void main(String[] args) throws IOException{
		
		
		lerArquivosCSV("/home/osvaldoairon/Documentos/clientes.csv");
		
	}
	
	public static void lerArquivosCSV(String caminhoCSV) throws IOException{
		/*
		 * Cria um objeto do tipo leitorCsv que carregar um arquivo do tipo csv;
		 * é necessario passar um caminho do arquivo para que ele carregue;
		 * foi criado um array de string que percorre a cada iteraçcao do leitor
		 * cada campo é separado por virgula, desse modo ele retorna os dados da coluna 0
		 */
		CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
		String[] leitorLinhas;
		while((leitorLinhas=leitor.readNext()) != null){
			System.out.println(leitorLinhas[0]);
		}
		
	}

}
