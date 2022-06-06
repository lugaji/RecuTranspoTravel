package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EquipatgeDAOImpl implements EquipatgeDAO {
	
	@Override
	public equipatge cercarEquipatge(Conbd conn, int id) {
		
		equipatge equipatgeClient = null;
		
		String sql = "select equipatge.idEquipatge, equipatge.pes, equipatge.dni, A.ciutat, B.ciutat, estat.descripcio, puntrecollida.adreca " + 
				"from equipatge " + 
				"inner join estat on equipatge.idEstat = estat.idEstat " + 
				"inner join localitzacio as A on equipatge.idOrigen = A.idLocalitzacio " + 
				"inner join localitzacio as B on equipatge.idDesti = B.idLocalitzacio " +
				"inner join puntrecollida on equipatge.idPunt = puntrecollida.idPunt " + 
				"where idEquipatge=" + id + ";";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String puntRecollida = rs.getString("adreca");
				int idEquipatge = rs.getInt("idEquipatge");
				int pes = rs.getInt("pes");
				String dni = rs.getString("dni");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				String estat = rs.getString("descripcio");
				
				equipatgeClient = new equipatge(idEquipatge, pes,dni,origen,desti,estat,puntRecollida);
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR AL CERCAR EQUIPATGE: " + e);
			
		}
		
		
				
		return equipatgeClient;
	}
	
	@Override
	public ArrayList<equipatge> cercarEquipatgePerUsuari(Conbd conn, int idUsuari, int idVol) {
		
		ArrayList<equipatge> equipatgesClient = new ArrayList<equipatge>();
		
		String sql = "select equipatge.idEquipatge, equipatge.pes, equipatge.adrecaPerz, puntrecollida.adreca " + 
				"from equipatge " + 
				"inner join puntrecollida on equipatge.idPunt = puntrecollida.idPunt " + 
				"where dni = " + idUsuari + " and idDistrivuciovol = " + idVol + ";";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String puntRecollida = rs.getString("adreca");
				int idEquipatge = rs.getInt("idEquipatge");
				int pes = rs.getInt("pes");
				String puntRecollidaPerz = rs.getString("adrecaPerz");
				
				if (puntRecollidaPerz == null) {
					equipatgesClient.add(new equipatge(idEquipatge, pes,null,null,null,null,puntRecollida));
				}
				
				else {
					equipatgesClient.add(new equipatge(idEquipatge, pes,null,null,null,null,puntRecollidaPerz));
				}
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR AL CERCAR EQUIPATGE: " + e);
			
		}
		
		return equipatgesClient;

	}
	
	@Override
	public boolean afegirEquipatgeADesplacament(Conbd conn,int usuari,String origen,String desti, int pes, String punt, int iddistribuciovol) {	
		
		puntRecollidaDAO daoPR = new puntRecollidaDAOImpl();
		int puntFinal = daoPR.cercarPuntRecollidaInsertatPelClient(conn, punt);
		
		if (puntFinal == 1) {
			String sql = "insert into equipatge(dni,idDesti,idOrigen,pes,idEstat,idPunt,idDistrivuciovol,adrecaPerz) "
					+ "values ("+usuari+","+origen+","+desti+","+pes+","+1+","+puntFinal+","+iddistribuciovol+",'"+punt+"');";
	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		return true;
	    		
	    	}catch (Exception e) {
	    		
	    		return false;
	    		
	    	}
	    	
		}
		
		else {
			String sql = "insert into equipatge(dni,idDesti,idOrigen,pes,idEstat,idPunt,idDistrivuciovol,adrecaPerz) "
					+ "values ("+usuari+","+origen+","+desti+","+pes+","+1+","+puntFinal+","+iddistribuciovol+","+null+");";
	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		return true;
	    		
	    	}catch (Exception e) {
	    		
	    		return false;
	    		
	    	}
	    	
		}
    	
	}
	
}
