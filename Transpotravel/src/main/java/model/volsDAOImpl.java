package model;
import java.sql.ResultSet;       
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;

//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import java.time.LocalDateTime;


public class volsDAOImpl implements volsDAO{

	//static String sql = "SELECT * FROM distribuciovols;";

	
	/*public static void ComboBoxPuntsRecollida(Conbd conn,List<String> puntsrecollida) {
		String sql2 = "Select adreca from puntrecollida;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				String nompuntrecollida = rs.getString("adreca");
				
				puntsrecollida.add(nompuntrecollida);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Punts de Recollida");
			
		}
	}*/
	
	public static void ComboBoxVols(Conbd conn,List<String> ciutats) {
		String sql2 = "Select Nom from localitzacions;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String NomCiutat = rs.getString("Nom");
				
				ciutats.add(NomCiutat);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Totes les Ciutats");
			
		}
	}
		
	public static void ComboBoxDesti(Conbd conn,List<String> destins) {
		
		String sql2 = "SELECT Nom FROM transpotravelrecu.localitzacions;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String iddestins = rs.getString("localitzacions.Nom");
				
				destins.add(iddestins);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox desti");
			
		}

		
	}
	
	
	/*public static void ActualitzarEstatVol(Conbd conn,int volActualitzar,String EstatNou) {
		
		String sql2 = "update distribuciovols set estat='"+EstatNou+"' where IDVols="+volActualitzar+";";
    	PreparedStatement pst = null;

		try {
			
			pst = conn.getConexio().prepareStatement(sql2);
    		pst.execute();
			
					
		}catch(Exception e) {

			System.out.println("ERROR En l'actualitzacio de l'estat del vol");
			
		}
	}*/
	
	
	public static void ComboBoxOrigen(Conbd conn,List<String> origens) {
		String sql2 = "SELECT Nom FROM transpotravelrecu.localitzacions;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String idorigens = rs.getString("localitzacions.Nom");
				
				origens.add(idorigens);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox origen");
			
		}

		
	}
	
	
	/*public static void ComboBoxEstats(Conbd conn,List<String> Estats) {
		String sql2 = "select descripcio from estat;";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String estat = rs.getString("descripcio");
				
				Estats.add(estat);			
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En el Combobox Estats");
			
		}

		
	}*/
	
	/*public static void cercarVolsOferta(Conbd conn,int idorigenEntrat,int iddestiEntrat,List<distribuciovols> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM distribuciovols where idorigen = '" + idorigenEntrat + "' and iddesti='"+iddestiEntrat+"';";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int IDVols = rs.getInt("IDVols");
				int idorigen = rs.getInt("idorigen");
				int iddesti = rs.getInt("iddesti");
				int preu = rs.getInt("preu");
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				int oferta = rs.getInt("oferta");
				int idpuntrecollida=rs.getInt("idpuntrecollida");
				Image image = new Image(rs.getString("imatge"));
		        ImageView iv1 = new ImageView();
		        iv1.setImage(image);
		        
				distribuciovols afegir = new distribuciovols(IDVols, idorigen, iddesti, preu,horaArribada,horaSortida,oferta,idpuntrecollida,iv1);
				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el cercarvols");
			
		}
				
	}*/
	

	public static void cercarVols(Conbd conn,List<vols> llista2) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM vols;";
				
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int IDVols = rs.getInt("IDVols");
				int idorigen = rs.getInt("Origen");
				int iddesti = rs.getInt("Desti");
				int MaxPas = rs.getInt("MaxPassatgers");
				int MaxPes = rs.getInt("MaxPes");
				LocalDateTime horaSortida = rs.getObject("Sortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("Arribada", LocalDateTime.class);
				int preu = rs.getInt("preu");
				
				vols afegir = new vols(IDVols, idorigen,iddesti,preu,MaxPas,MaxPes,horaArribada,horaSortida);

				llista2.add(afegir);			
				
			}
					
		}catch(Exception e) {
			
			System.out.println("ERROR En el Cercar vols oferta: " + e);
			
		}
				
	}

	
	/*public ArrayList<String> cercarTotsVolsClient(Conbd conn, int id) {
		
		ArrayList<String> stringRetorn = new ArrayList<String>();
		
		String sql = "select distribuciovols.IDVols, distribuciovols.preu,distribuciovols.horaSortida,distribuciovols.horaArribada,A.ciutat,B.ciutat,numequipatges,numplaces from desplacament " + 
				"inner join distribuciovols on desplacament.IDVols=distribuciovols.IDVols " + 
				"inner join localitzacio as A on distribuciovols.idorigen=A.idLocalitzacio " + 
				"inner join localitzacio as B on distribuciovols.iddesti=B.idLocalitzacio " + 
				"where desplacament.dni='" + id + "';";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
						
			while(rs.next()) {
				
				String idPunt = rs.getString("IDVols");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
				int preu = rs.getInt("preu");
				int equipatges = rs.getInt("numequipatges");
				int places = rs.getInt("numplaces");
								
				stringRetorn.add(i, idPunt + "---" + origen + "---" + desti + "---" + horaSortida + "---" + horaArribada + "---"
						+ preu + "---" + equipatges + "---" + places);
				
			}
			
		}catch(Exception e) {
			System.out.println("ERROR AL CERCAR ELS VOLS COMPRATS: " + e);	
		}
		
		return stringRetorn;
		
	}*/
	
	/*@Override
	public vols cercarVolClient(Conbd conn, int id) {
		
		vols distribuciovolsClient = null;
		
		String sql = "select distribuciovols.IDVols,A.ciutat, B.ciutat, estat.descripcio, " + 
				"distribuciovols.preu, distribuciovols.horaSortida, distribuciovols.horaArribada " +
				"from distribuciovols " + 
				"inner join estat on distribuciovols.estat = estat.idEstat " + 
				"inner join localitzacio as A on distribuciovols.idorigen = A.idLocalitzacio " + 
				"inner join localitzacio as B on distribuciovols.iddesti = B.idLocalitzacio " + 
				"where IDVols = " + id + ";";
								
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				String idPunt = rs.getString("IDVols");
				String origen = rs.getString("A.ciutat");
				String desti = rs.getString("B.ciutat");
				String estat = rs.getString("descripcio");	
				int preu = rs.getInt("preu");
				LocalDateTime horaSortida = rs.getObject("horaSortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("horaArribada", LocalDateTime.class);
								
				distribuciovolsClient = new vols(Integer.parseInt(idPunt), origen, desti, preu, horaArribada, horaSortida, 0, 0, " ", null,estat,0,0);
			}
			
		}catch(Exception e) {
			System.out.println("ERROR AL CERCAR VOL: " + e);	
		}
		
		return distribuciovolsClient;
		
		}*/
	
	
	public static void eliminarVol(Conbd conn,String idvol) {
    	
    	String sql = "delete from vols where IDVols="+idvol+";";
    	PreparedStatement pst = null;
  
   	
    	try {
    		
    		pst = conn.getConexio().prepareStatement(sql);
    		pst.execute();
    		
    		
    		
    	}catch (Exception e) {
    		
    		System.out.println("ERROR - distribuciovols controller - eliminar vol" + e);
    		
    	}
	}
	
	public static void insertarVol(Conbd conn,int IDVol, int idorigen,int iddesti,int MaxPass,int MaxPes,LocalDateTime horaSortida,LocalDateTime horaArribada,int preu) {
    	
		String sql = "insert into transpotravelrecu.vols(IDVols,Origen,Desti,MaxPassatgers,MaxPes,Sortida,Arribada,Preu) values "
				+ "("+IDVol+","
						+ ""+idorigen+","
								+ ""+iddesti+","
										+ ""+MaxPass+","
												+ "'"+MaxPes+"','"
														+ ""+horaSortida+"',"
																+ ""+horaArribada+","
																		+ ""+preu+");";
	    	PreparedStatement pst = null;
	    	
	    	try {
	    		
	    		//System.out.println("Sortida: "+horaSortida+" Arribada: "+horaArribada);
	    		
	    		pst = conn.getConexio().prepareStatement(sql);
	    		pst.execute();
	    		
	    		
	    		
	    	}catch (Exception e) {
	    		
	    		System.out.println("ERROR - distribuciovols controller - insertar vol" + e);
	    		
	    	}
	}
    	
	/*public static int ObtenirID_Puntrecollida(Conbd conn,String PuntRecollida,int IDPuntRecollida) {
		String sql2 = "select idPunt from puntrecollida where adreca='"+PuntRecollida+"';";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id_Puntrecollida = rs.getInt("idPunt");
				IDPuntRecollida=id_Puntrecollida;
				
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En otenur idpuntrecollida");
			
		}
		return IDPuntRecollida;
	}*/
	
	/*public static String ObtenirID_Estat(Conbd conn,String Estat) {
		String sql2 = "select idEstat from estat where descripcio='"+Estat+"';";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idEstat_Obtingut = rs.getInt("idEstat");
				Estat=String.valueOf(idEstat_Obtingut);
				//Despues s'ha de fer un parseint quan es passi a la consult pq la id es un int
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En obtenir la id del estat");
			
		}
		return Estat;
	}*/
	
	
	
	public static void ObtenirVolsSeleccionats(Conbd conn,int idDesti,int idOrigen,List<vols> llistaVolsFiltrats) {
		String sql2 = "select * from distribuciovols where idorigen="+idOrigen+" and iddesti="+idDesti+";";
		
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int IDVols = rs.getInt("IDVols");
				int idorigen = rs.getInt("Origen");
				int iddesti = rs.getInt("Desti");
				int MaxPas = rs.getInt("MaxPassatgers");
				int MaxPes = rs.getInt("MaxPes");
				LocalDateTime horaSortida = rs.getObject("Sortida", LocalDateTime.class);
				LocalDateTime horaArribada = rs.getObject("Arribada", LocalDateTime.class);
				int preu = rs.getInt("preu");
			
				vols afegir = new vols(IDVols, idorigen,iddesti,preu,MaxPas,MaxPes,horaArribada,horaSortida);
				llistaVolsFiltrats.add(afegir);
			
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En Seleccionar els vols filtrats");
			
		}
	}
	
	public static int ObtenirID_Localitzacio(Conbd conn,String ciutat,int ID) {
		String sql2 = "SELECT IDLocalitzacions FROM transpotravelrecu.localitzacions where Nom ='"+ciutat+"';";
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idlocalitzacio = rs.getInt("IDLocalitzacions");
				ID=idlocalitzacio;
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En l'obtencio de la id de localitzacio");
			
		}
		return ID;
	}
	
	
	
	/*public static String ObtenirCiutat(Conbd conn,String ciutat,int ID) {
		String sql2 = "select ciutat from localitzacio where idLocalitzacio="+ID+";";
		try {
			
			PreparedStatement ps = conn.getConexio().prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String CiutatObtenida=rs.getString("ciutat");
				ciutat=CiutatObtenida;
			}
					
		}catch(Exception e) {

			System.out.println("ERROR En l'obtencio la ciutat");
			
		}
		return ciutat;
	}*/
}
