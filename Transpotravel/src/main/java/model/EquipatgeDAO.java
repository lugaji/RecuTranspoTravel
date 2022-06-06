package model;

import java.util.ArrayList;
import java.util.List;


public interface EquipatgeDAO {
	
	equipatge cercarEquipatge(Conbd conn,int id);
	
	boolean afegirEquipatgeADesplacament(Conbd conn,int usuari,String origen,String desti, int pes, String punt, int iddistribuciovol);
	
	public ArrayList<equipatge> cercarEquipatgePerUsuari(Conbd conn, int idUsuari, int idVol);
	
}
