package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class puntRecollidaDAOImpl implements puntRecollidaDAO {

	@Override
	public puntRecollida cercaPuntRecollida(Conbd conn, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void eliminarPR(Conbd conn,String idPR) {
    	
		
    	String sql = "DELETE FROM `transpotravelrecu`.`puntsrecollida` WHERE (`IDPuntsRecollida` = "+idPR+");";
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();
    		
    		
    		
    	}catch (Exception e) {
    		
    		
    		System.out.println("ERROR - Punts Recollida - eliminar PR " + e);
    		
    	}
	}

	public static void cercarPRs(Conbd conn,List<puntRecollida> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM transpotravelrecu.puntsrecollida;";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int IDPuntsRecollida = rs.getInt("IDPuntsRecollida");
				int IDLocalitzacio = rs.getInt("IDLocalitzacio");
				String NomPR = rs.getString("Nom");
				String DescripcioPR = rs.getString("Descripcio");
				
				puntRecollida afegir = new puntRecollida(IDPuntsRecollida, IDLocalitzacio,NomPR,DescripcioPR);

				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el Cercar Punts de Recollida: " + e);
			
		}
				
	}
	
	@Override
	public boolean create(Conbd conn, puntRecollida punt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Conbd conn, int id, puntRecollida punt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Conbd conn, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void ComboBoxPuntRecollida(Conbd conn,List<String> punts) {
		
		String sql2 = "SELECT localitzacio.ciutat,puntrecollida.adreca FROM transpotravel.puntrecollida  INNER JOIN localitzacio \r\n" + 
				"ON puntrecollida.idLocalitzacio = localitzacio.idLocalitzacio;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String ciutat = rs.getString("localitzacio.ciutat");
				String iddestins = rs.getString("puntrecollida.adreca");
				String resultatFinal = ciutat + " - " + iddestins;
				punts.add(resultatFinal);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR en el Combobox puntsRecollida");
			
		}

		
	}
	
	@Override
	public int cercarPuntRecollidaInsertatPelClient(Conbd conn, String nomPunt) {
		int puntrecollidatrobat=1;
		String Parts[]=nomPunt.trim().split("-");
		String sql = "";
		
		if (Parts.length == 2) {
			sql = "select idPunt from puntrecollida where adreca = '"+Parts[1].trim()+"';";
		}

		else {
			sql = "select idPunt from puntrecollida where adreca = '"+Parts[0]+"';";
		}
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				puntrecollidatrobat = rs.getInt("idPunt");
			
			}
		}catch (Exception e) {
    		
    		System.out.println("ERROR - En la busqueda del punt de recollida");
    		
    	}
		
		return puntrecollidatrobat;
	
	}

}
