

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.dao.AtrativoTuristico_control;
import com.apps4Society.dao.Municipios_control;
import com.apps4Society.dao.Praia_control;
import com.apps4Society.model.AtrativoTuristico;
import com.apps4Society.model.Municipios;
import com.apps4Society.model.Praia;
import com.appss4Society.LoaderCSV;
import com.opencsv.CSVReader;

import java.util.ArrayList;

public class Main {

	private static ArrayList<Municipios> lista_municipios = new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> lista_Atrativo = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praia = new ArrayList<Praia>();

	
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		
		//l.teste();
		
		Municipios_control l = new Municipios_control();

		
		/*
		 * INitir;
		 */
		//carregarPraias();
		carregarAtrativosTuristicos();
		//carregarMunicipios();
	}
	
	
	public static void carregarPraias() throws SQLException{
		LoaderCSV loader_praia = new LoaderCSV();
		
		Praia_control praia = new Praia_control();
		
		list_praia = loader_praia.lerArquivosCSV_Praia("/home/osvaldoairon/Documentos/Praias.csv");
		
		if(list_praia != null){
			for(int i = 0 ; i < list_praia.size();i++){
				praia.addPraia(list_praia.get(i));
			}
		}
	}
	public static void carregarAtrativosTuristicos() throws SQLException{
		LoaderCSV loader_atrativo = new LoaderCSV();

		AtrativoTuristico_control a = new AtrativoTuristico_control();
		lista_Atrativo = loader_atrativo.lerArquivosCSV_AtrativoTuristico("/home/osvaldoairon/Documentos/atrativoTuristico.csv");
		if(lista_Atrativo!=null){
			for(int i = 0 ; i <lista_Atrativo.size();i++){
				a.addAtratativoTuristico(lista_Atrativo.get(i));
			}
		}
		
	}
	
	public static void carregarMunicipios() throws IOException, ClassNotFoundException, SQLException{
		LoaderCSV loader_muncipios = new LoaderCSV();
		Municipios_control n = new Municipios_control();
		
		lista_municipios = loader_muncipios.lerArquivosCSV_Municipio("/home/osvaldoairon/Documentos/xd.csv");
		
		if(lista_municipios!=null){
			for(int i =0 ; i<lista_municipios.size();i++){
				n.addMunicipio(lista_municipios.get(i));
			}
		}
	}
	

}
