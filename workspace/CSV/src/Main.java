

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.dao.Municipios_control;
import com.apps4Society.model.Municipios;
import com.appss4Society.LoaderCSV;
import com.opencsv.CSVReader;

import java.util.ArrayList;

public class Main {

	private static ArrayList<Municipios> lista_municipios = new ArrayList<Municipios>();

	
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		
		LoaderCSV loader_muncipios = new LoaderCSV();
		
		
		
		Municipios_control n = new Municipios_control();
		lista_municipios = loader_muncipios.lerArquivosCSV("/home/osvaldoairon/Documentos/xd.csv");
		
		if(lista_municipios!=null){
			for(int i =0 ; i<lista_municipios.size();i++){
				n.addMunicipio(lista_municipios.get(i));
			}
		}
		
		
		
		
		
		
	}
	

}