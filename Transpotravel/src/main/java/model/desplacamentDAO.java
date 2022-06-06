package model;

public interface desplacamentDAO {

	boolean afegirClientADesplacament(Conbd conn, int usuari, int iddistribuciovols, int numequipatges,int places);
	
}
