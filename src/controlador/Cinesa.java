package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import modelo.cines.CinesRead;
import modelo.peliculas.PeliculasRead;

public class Cinesa {

	private ArrayList<CineBean> listaCines;
	
	
	
	/**
	 * 
	 * 
	 */
	public Cinesa() {
		
		// cargo los datos
		CinesRead cinesData = new CinesRead();
		listaCines = cinesData.getCines();

		/*
		// Recorro los cines y cargo sus datos
		PeliculasData peliculaData = new PeliculasData();
		for (CineBean unCine : listaCines) {
			 
			
			peliculaData.getPeliculas(unCine); 
		}
		*/
	}
	
	
	
	





	@Override
	public String toString() {
		return "Cinesa [listaCines=" + listaCines + "]";
	}









	public Enumeration<CineBean> getCines() {
		
		
		return Collections.enumeration(listaCines);
	}









	public CineBean getCine(int numero) {
		
		int i=0;
		boolean encontrado = false;
		
		while((i<listaCines.size())&&(!encontrado)) {
			
			if(listaCines.get(i).getIdCine()==numero) {
				
				encontrado = true;
			}
			else i++;
		}
		
		if(encontrado == true) {
		
			return listaCines.get(i);
		}	
		else return null;
	}
	
	
	
	
	
	
	
}
