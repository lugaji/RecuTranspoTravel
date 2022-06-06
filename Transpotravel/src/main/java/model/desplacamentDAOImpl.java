package model;

import java.sql.PreparedStatement;

public class desplacamentDAOImpl implements desplacamentDAO {

	@Override
	public boolean afegirClientADesplacament(Conbd conn, int usuari, int iddistribuciovols, int numequipatges,int places) {
		String sql = "insert into desplacament(dni,iddistribuciovols,numequipatges,numplaces) values ("+usuari+","+iddistribuciovols+","+numequipatges+","+places+")";
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
