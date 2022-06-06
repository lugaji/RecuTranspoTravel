package model;

public interface puntRecollidaDAO {
	
	puntRecollida cercaPuntRecollida(Conbd conn,int id);
	boolean create(Conbd conn,puntRecollida punt);
	boolean update(Conbd conn,int id,puntRecollida punt);
	boolean delete(Conbd conn,int id);
	
	int cercarPuntRecollidaInsertatPelClient(Conbd conn,String nomPunt);

}
