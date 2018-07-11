package com.apps4Society.view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.apps4Society.dao.AtrativoTuristico_control;
import com.apps4Society.dao.Municipios_control;
import com.apps4Society.dao.Praia_control;
import com.apps4Society.model.AtrativoTuristico;
import com.apps4Society.model.Municipios;
import com.apps4Society.model.Praia;
import com.appss4Society.LoaderCSV;

/**
*
* @author osvaldoairon
*/
public class InterfaceBuscaCSV implements ActionListener{
	
	private static ArrayList<Municipios> lista_municipios = new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> lista_Atrativo = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praia = new ArrayList<Praia>();
	private static String caminho;
	
	private static JButton localizararq;
	private static JTextField dir;
	
	public InterfaceBuscaCSV(){
		FlowLayout layout = new FlowLayout();
		dir = new JTextField();
		dir.setBounds(10, 300, 500, 30);
		dir.setVisible(true);
		
		localizararq = new JButton("Localizar Arquivo CSV");
		localizararq.setBounds(525, 300, 200, 30);
		localizararq.setVisible(true);
		localizararq.addActionListener(this);
	
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(730,400);
		painel.add(dir);
		painel.add(localizararq);
		painel.setVisible(true);
		
		JFrame janela = new JFrame("APPS4Society");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(730, 400);
		janela.setVisible(true);


	}
	
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == localizararq){
				 JFileChooser arquivocsv = new JFileChooser(); 
				 arquivocsv.setFileSelectionMode(JFileChooser.FILES_ONLY);
		          int i= arquivocsv.showSaveDialog(null);
		        if (i==1){
		            dir.setText("");
		        } else {
		            File arquivo = arquivocsv.getSelectedFile();
		            dir.setText(arquivo.getPath());
		
		            caminho = arquivo.toString();
		           System.out.println(arquivo.toString());
		           String[] verific = caminho.split("/");
		           
		           
		           try {
					verificaTipo(verific);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		          
		           
		        }
				
			}
		}
		
		public void verificaTipo(String[] p) throws SQLException, ClassNotFoundException, IOException{
			
			/*
			 * verifica o caminho do arquivo especificado, checa palavra por palavra do caminho até ser compativel com o nome
			 * do CSV especifico
			 * ex: /home/osvaldoairon/Documentos/praias.csv
			 *  ValidaPraia é igual a home?, osvaldoairon? ,Documentos?, praias.csv?
			 *  se sim ele carrega os metodos do CSV. 
			 */
			
			
			String validaPraia = "praias.csv";
			String validaMunicipio ="municipios.csv";
			String validaAtrativo = "atrativoTuristico.csv";
			boolean inter=false;
			for(int i = 0 ; i < p.length;i++){
				if(p[i].equals(validaPraia)){
					carregarPraias(caminho);
					inter = false;
				}else if(p[i].equals(validaMunicipio)){
					carregarMunicipios(caminho);
					inter = false;
				}else if(p[i].equals(validaAtrativo)){
					carregarAtrativosTuristicos(caminho);
					inter =false;
				}else{
					inter=true;
				}
			}
			if(inter){
				dir.setText("CSV válido nao encontrado!");
				JOptionPane.showMessageDialog(null, "Porfavor coloque um arquivo com os requisitos necessários");
			}
		}
		
		public static void carregarPraias(String patch) throws SQLException{
			
			/*
			 * 	Tem como parametro o caminho do arquivo csv especificado.
			 * carrega a classe LoaderCSV que vai pegar os dados do CSV
			 * em seguida guarda a lista de objetos "Praias" no banco de dados chamando a classe praiaControl
			 */
			
			LoaderCSV loader_praia = new LoaderCSV();
			
			Praia_control praia = new Praia_control();
			
			list_praia = loader_praia.lerArquivosCSV_Praia(patch);
			
			if(list_praia != null){
				for(int i = 0 ; i < list_praia.size();i++){
					praia.addPraia(list_praia.get(i));
				}
				JOptionPane.showMessageDialog(null, "Dados do tipo Praias foram inseridos");
			}
		}
		public static void carregarAtrativosTuristicos(String patch) throws SQLException{
			LoaderCSV loader_atrativo = new LoaderCSV();

			AtrativoTuristico_control a = new AtrativoTuristico_control();
			
			lista_Atrativo = loader_atrativo.lerArquivosCSV_AtrativoTuristico(patch);
			if(lista_Atrativo!=null){
				for(int i = 0 ; i <lista_Atrativo.size();i++){
					a.addAtratativoTuristico(lista_Atrativo.get(i));
				}
			}
			JOptionPane.showMessageDialog(null, "Dados do tipo AtrativoTuristico foram inseridos");
			
		}
		
		public static void carregarMunicipios(String patch) throws IOException, ClassNotFoundException, SQLException{
			LoaderCSV loader_muncipios = new LoaderCSV();
			Municipios_control n = new Municipios_control();
			
			lista_municipios = loader_muncipios.lerArquivosCSV_Municipio(patch);
			
			if(lista_municipios!=null){
				for(int i =0 ; i<lista_municipios.size();i++){
					n.addMunicipio(lista_municipios.get(i));
				}
			}
			JOptionPane.showMessageDialog(null, "Dados do tipo Municipios foram inseridos");
		}
	}

	

