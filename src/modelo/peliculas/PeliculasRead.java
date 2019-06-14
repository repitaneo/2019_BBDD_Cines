package modelo.peliculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.CineBean;
import controlador.PeliculaBean;
import util.BDConect;

public class PeliculasRead {

	
	
	
	
	
	
	public void getPeliculas(CineBean cine) {
		
		
		Connection conexion = BDConect.getConexion(); 
       	PreparedStatement stmt;
       	
       	
		try {
			
			String sql= "select * " + 
						"from salas s, peliculas p " + 
						"where s.idcines = "+cine.getIdCine()+" and s.idpeliculas=p.idpeliculas";
			
			stmt = conexion.prepareStatement(sql);
	       	ResultSet rs = stmt.executeQuery();
	       	while (rs.next()) {
	       		
	       		PeliculaBean peli = new PeliculaBean();
	       		peli.setIdPelicula(rs.getInt("idpeliculas"));
	       		peli.setIdSala(rs.getInt("idsalas"));
	       		peli.setTitulo(rs.getString("titulo"));
	       		peli.setDirector(rs.getString("director"));
	       		peli.setAnio(rs.getString("anio"));

	       		cine.addPelicula(peli);
	       	} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

	}
}
