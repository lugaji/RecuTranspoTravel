package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




public interface volsDAO {

	
	/*public static void ActualitzarEstatVol(Conbd conn,int volActualitzar,String EstatNou) {
	}*/
	public static void ComboBoxOrigen(Conbd conn,List<String> origens) {
	}
	public static void ComboBoxDesti(Conbd conn, List<String> destins) {
	}
	/*public static void ComboBoxEstats(Conbd conn,List<String> Estats) {
	}*/
	public static void cercarVols(Conbd conn,List<vols> llista2) {
		
		
	}
	//public static void ComboBoxVols(Conbd conn,List<String> ciutats) {}
	public static void insertarVol(Conbd conn,int idorigen,int iddesti,int preu,LocalDateTime horaSortida,LocalDateTime horaArribada,int oferta,int IdPuntRecollida,String Descripcio) {
	}
	public static void eliminarVol(Conbd conn,String idvol) {	
	}

	/*public static void ObtenirVolsSeleccionats(Conbd conn,int idDesti,int idOrigen,List<vols> llistaVolsFiltrats) {
	}*/
	/*public static String ObtenirCiutat(Conbd conn,String ciutat,int ID) {
		return ciutat;
	}*/
	
	/*public static int ObtenirID_Puntrecollida(Conbd conn,String PuntRecollida,int IDPuntRecollida) {
		return IDPuntRecollida;
	}*/
	/*public static String ObtenirID_Estat(Conbd conn,String Estat) {
		return Estat;
	}*/
	/*public static int ObtenirID_Localitzacio(Conbd conn,String ciutat,int ID) {
		return ID;
	}*/

	vols cercarVolClient(Conbd conn, int id);
	
	//public ArrayList<String> cercarTotsVolsClient(Conbd conn, int id);
	
}
