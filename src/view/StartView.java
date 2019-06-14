package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import controlador.CineBean;
import controlador.Cinesa;

public class StartView {

	private Cinesa cines;
	
	private InputStreamReader isr = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader (isr);
	
	
	public StartView(Cinesa cines) {
		
		this.cines = cines;
	}
	
	
	
	public void go() throws NumberFormatException, IOException {
		
		
		
		int numero = 1000;
		
		while(numero!=0) {
			
			System.out.println("\n\n\n\nMenu");
			System.out.println("_____________________");
			System.out.println("1) Modificar Cine");
			System.out.println("2) Lista de Cines");
			System.out.println("\n");
			System.out.println("0) SALIR");
			numero = Integer.parseInt (br.readLine());
			
			switch(numero) {
			
				case 1: modificarCine(); break;
				case 2: listarCines(); break;
			}
		}
	}
	
	
	
	
	
	private void listarCines() {
		// TODO Auto-generated method stub
		
		Enumeration<CineBean> listado =  cines.getCines();
		while(listado.hasMoreElements()) {
			
			CineBean unCine = listado.nextElement();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
	}



	private void modificarCine() throws NumberFormatException, IOException {
		
		// recorro la lista de cines imprimiendo lo que hay		
		Enumeration<CineBean> listado =  cines.getCines();
		while(listado.hasMoreElements()) {
			
			CineBean unCine = listado.nextElement();
			System.out.println("["+unCine.getIdCine()+"] "+unCine.getNombre());
		}
		
		// solicito un ID
		System.out.println("Seleccione el ID del cine que quiere modificar");
		int numero = Integer.parseInt (br.readLine());
		
		// recojo el cine se lo paso a la parte de la view que lo modifica
		CineBean unCine = cines.getCine(numero);
		ModificarCineView.modificarCine(unCine);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
