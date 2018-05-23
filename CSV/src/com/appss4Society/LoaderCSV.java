package com.appss4Society;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.apps4Society.model.Municipios;
import com.apps4Society.model.AtrativoTuristico;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.apps4Society.model.Praia;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	public void teste() throws IllegalStateException, IOException{
		/*
		 * Esse codigo no FIleReader permite que as primeiras linhas do arquivos nao sejam lidas
		 * dessa forma facilitando a compreensando do usuario para inserir os dados respectivos;
		 * 
		 * 
		 * CSVReader reader = new CSVReader(new FileReader("/home/osvaldoairon/Documentos/xd.csv"),',', '\t',1);
		 String[] linhas;
		 while((linhas=reader.readNext())!=null){
			 System.out.println(linhas[2]);
			
		 }
	}
		 */
		
		
	
	}
	
	
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
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;				
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[6].isEmpty() || leitorLinhas[7].isEmpty() || leitorLinhas[8].isEmpty()){
					System.out.print("Preencha os dados corretamente");
				}else{
					list_praias.add(new Praia(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],leitorLinhas[3],Double.parseDouble(leitorLinhas[4]),Double.parseDouble(leitorLinhas[5]),leitorLinhas[6],leitorLinhas[7],leitorLinhas[8]));
					
				}
				
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
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;
				
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[5].isEmpty() || leitorLinhas[7].isEmpty()){
					System.out.println("Preencha os dados corretamente/1");	
				}
				else{
					list_mun.add(new Municipios(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],Double.parseDouble(leitorLinhas[3]),Double.parseDouble(leitorLinhas[4]),leitorLinhas[5],Integer.parseInt(leitorLinhas[6]),leitorLinhas[7]))
					;
					
					/*
					 * Cria um txt com os dados que foram inseridos no banco;
					 */
					salvaLogs_municipios(list_mun , caminhoCSV);
				}
				
				
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
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			while((leitorLinhas=leitor.readNext())!=null){
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[3].isEmpty() || leitorLinhas[6].isEmpty()){
					System.out.println("Preencha os dados corretamente/1");	
				}else{
					list_atrativos.add(new AtrativoTuristico(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],leitorLinhas[3],Double.parseDouble(leitorLinhas[4]),Double.parseDouble(leitorLinhas[5]),leitorLinhas[6]));
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista atrativos"+list_atrativos.size());
		return list_atrativos;
	}
	
	
	public void salvaLogs_municipios(ArrayList<Municipios> list , String caminhoCSV){
		
		try {
			// File file = new
			
			File file = new File("/home/osvaldoairon/Documentos/Municipios_LOG.txt"); // quebra de linha \r\n
			String dados_muncipio = "";
			String conteudo;
			if(file!=null){
				System.out.println("Arquivo criado");
			}

			FileWriter arq = new FileWriter(file);
			arq.write("--------------- Relatório de Municipios Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < list.size(); i++) {

				dados_muncipio = "Área Territórial: " + list.get(i).getAreaTerritorial() + "\r\n" + "CEP: " + list.get(i).getCep()
						+ "\r\n" + "Estado: " + list.get(i).getEstado() + "\r\n" + "Latitude: " + list.get(i).getLatitude()
						+ "\r\n" + "Longitude: " + list.get(i).getLongitude() + "\r\n" + "Nome: " + list.get(i).getNome() + "\r\n" + "População: " + list.get(i).getPopulacao()
						+ "\r\n" + "Site: " + list.get(i).getSite() + "\r\n" + "----------------------------------------------------------------------------------------------------------------" + "\r\n";
				
				arq.write("\r\n");
				conteudo = dados_muncipio;
				conteudo += "\r\n";

				arq.write(conteudo);

			}
			arq.write("------------------------------------------------------------------------------");
			arq.write("\r\n");
			arq.write("Armazenados com sucesso!");
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
}
	}
	
}
