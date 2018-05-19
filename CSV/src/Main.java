

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
import com.apps4Society.view.InterfaceBuscaCSV;
import com.appss4Society.LoaderCSV;
import com.opencsv.CSVReader;

import java.util.ArrayList;

public class Main {


	
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		
		new InterfaceBuscaCSV();
		//l.teste();
		
		//Municipios_control l = new Municipios_control();

		
		/*
		 * INitir;
		 */
		//carregarPraias();
		//carregarAtrativosTuristicos();
		//carregarMunicipios();
	}
	
	
	

}
