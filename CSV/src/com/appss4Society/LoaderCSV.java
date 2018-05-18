package com.appss4Society;

import java.io.FileReader;
import java.io.IOException;
import com.apps4Society.model.Municipios;
import com.apps4Society.model.AtrativoTuristico;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.apps4Society.model.Praia;

public class LoaderCSV {
	private static ArrayList<Municipios> list_mun =  new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> list_atrativos = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praias = new ArrayList<Praia>();
	
	public LoaderCSV(){
		//list_mun = new ArrayList<Municipios>();
	}
	/*
	 * Problemas a serem resolvidos qualquer valor diferente do indice especificado , tera seu valor no banco trocado
	 * se forem dos mesmos tipos
	 * ele pega sempre a primeira linha de cada coluna, impossibilitando do usuario criar algum "nome referencia"
	 * na primeira linha do arquivo
	 */
	
	
	public ArrayList<Praia> lerArquivosCSV_Praia(String caminhoCSV){
		/*
		 * Indices
		 * nome = 0
		 * comochegar= 1
		 * descricao = 2
		 * infoContato = 3
		 * latitude = 4
		 * longitude =5
		 * perigotubarao =6
		 * propriabanho = 7
		 * tipoOrla=8
		 */
		try{
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
			String[] leitorLinhas;
			
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;				
				
				list_praias.add(new Praia(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],leitorLinhas[3],Double.parseDouble(leitorLinhas[4]),Double.parseDouble(leitorLinhas[5]),leitorLinhas[6],leitorLinhas[7],leitorLinhas[8]));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista praia"+list_praias.size());
		return list_praias;
	}
	public ArrayList<Municipios> lerArquivosCSV_Municipio(String caminhoCSV) throws IOException{
		/*
		 * Cria um objeto do tipo leitorCsv que carregar um arquivo do tipo csv;
		 * é necessario passar um caminho do arquivo para que ele carregue;
		 * foi criado um array de string que percorre a cada iteraçcao do leitor
		 * cada campo é separado por virgula, desse modo ele retorna os dados da coluna 0
		 */
		
		/*
		 * Indices Para Municipios
		 * 0= cep
		 * 1 = areaTerritorial
		 * 2 = estado
		 * 3 = latitude
		 * 4 = longitude
		 * 5 = nome
		 * 6 = populacao
		 * 7 = site
		 */
		try{
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
			String[] leitorLinhas;
			
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;				
				list_mun.add(new Municipios(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],Double.valueOf(leitorLinhas[3]),Double.valueOf(leitorLinhas[4]),leitorLinhas[5],Integer.parseInt(leitorLinhas[6]),leitorLinhas[7]));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista"+list_mun.size());
		return list_mun;
	}
	
	public ArrayList<AtrativoTuristico> lerArquivosCSV_AtrativoTuristico(String caminhoCSV){
		/*
		 * Indices para AtrativoTuristicos
		 * 
		 * 0 = nome
		 * 1 = comoChegar
		 * 2 = descricao
		 * 3 = info_contato
		 * 4 = latitude
		 * 5 = longitude;
		 * 6 = site;
		 */
		try {
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
			String[] leitorLinhas;
			while((leitorLinhas=leitor.readNext())!=null){
				list_atrativos.add(new AtrativoTuristico(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],leitorLinhas[3],Double.parseDouble(leitorLinhas[4]),Double.parseDouble(leitorLinhas[5]),leitorLinhas[6]));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista atrativos"+list_atrativos.size());
		return list_atrativos;
	}
	
	
}
