package com.appss4Society;

import java.io.FileReader;
import java.io.IOException;
import com.apps4Society.model.Municipios;
import com.apps4Society.model.AtrativoTuristico;
import java.util.ArrayList;
import com.opencsv.CSVReader;


public class LoaderCSV {
	private static ArrayList<Municipios> list_mun =  new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> list_atrativos = new ArrayList<AtrativoTuristico>();
	
	public LoaderCSV(){
		//list_mun = new ArrayList<Municipios>();
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
		 * 0 = estado
		 * 1 = latitude
		 * 2 = longitude
		 * 3 = nome
		 * 4 = populacao
		 * 5 = site
		 */
		try{
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
			String[] leitorLinhas;
			
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;				
				
				list_mun.add(new Municipios(leitorLinhas[0],Double.valueOf(leitorLinhas[1]),Double.valueOf(leitorLinhas[2]),leitorLinhas[3],Integer.parseInt(leitorLinhas[4]),leitorLinhas[5]));
				
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
		 * 1 = latitude
		 * 2 = longitude
		 * 3 = comochegar
		 * 4 = infocontato;
		 * 5 = site;
		 */
		try {
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV));
			String[] leitorLinhas;
			while((leitorLinhas=leitor.readNext())!=null){
				list_atrativos.add(new AtrativoTuristico(leitorLinhas[0],Double.parseDouble(leitorLinhas[1]),Double.parseDouble(leitorLinhas[2]),leitorLinhas[3],leitorLinhas[4],leitorLinhas[5]));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista atrativos"+list_atrativos.size());
		return list_atrativos;
	}
	
	
}
