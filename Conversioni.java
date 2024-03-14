package it.edu.iisgubbio.matematica;

import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Conversioni extends Application {
	TextField cNumero = new TextField();
	TextField cBase = new TextField();
	TextField cBinario = new TextField();
	Button bCalcola = new Button("calcola");
	Button bContrario = new Button("contrario");
	Label eRisultato = new Label();
	
	Hashtable<Integer, String> my_dizionario = new Hashtable<Integer,String>();
		
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eNumero = new Label("Numero:");
		Label eBase = new Label("Base:");
		Label eNumeroConvertito = new Label("numero convertito:");
		
		my_dizionario.put(10,"A");
		my_dizionario.put(11,"B");
		my_dizionario.put(12,"C");
		my_dizionario.put(13,"D");
		my_dizionario.put(14,"E");
		my_dizionario.put(15,"F");
		
		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(cBinario, 1, 0);
		griglia.add(eBase, 0, 1);
		griglia.add(cBase, 1, 1);
		griglia.add(bCalcola, 0, 2, 2, 1);
		griglia.add(bContrario, 0, 2, 2, 5);
		griglia.add(eNumeroConvertito, 0, 3);
		griglia.add(eRisultato, 1, 3);

		bCalcola.setOnAction(e -> converti());
		bContrario.setOnAction(e -> contrario());


		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Conversioni");
		finestra.setScene(scena);
		finestra.show();

	}
	String daVettoreATesto(int[] numeriStampare) {
		String stampa="";
		for(int i = 0;i<numeriStampare.length;i++) {
			stampa+=numeriStampare[i] + " ";
		}
		return stampa;
	}
	public void converti() {
		int numero = Integer.parseInt(cNumero.getText());
		int resto=0;
		int base = Integer.parseInt(cBase.getText());
		String binario[]= new String[10];
		String restoStr="";
		String stampa="";
		for (int i=0;binario.length<i;i++) {
			binario[i]="0";
			
		}
			resto=numero%base;
		for (int i=binario.length-1; numero!=0; i--) {
			resto=numero%base;
			if(resto>=10){
				String resto2 = Integer.toString(resto);
				restoStr=my_dizionario.get(resto2);
				stampa=restoStr+stampa;
				binario[i]=restoStr;
			
			}else {
				restoStr=resto+"";
				binario[i]=restoStr;
			}
			numero=numero/base;

		}
		for (int i=0;i<binario.length-1; i++) {
			stampa=stampa+binario[i];
			
		}
		eRisultato.setText(stampa);
	}
	public void contrario() {

	}
	public static void main(String[] args) {
		launch(args);
	}
}
