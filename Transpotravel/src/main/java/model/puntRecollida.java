package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class puntRecollida {

	private int IDPuntsRecollida;
	private int IDLocalitzacio;
	private String NomPR;
	private String DescripcioPR;
	
	public puntRecollida(int iDPuntsRecollida, int iDLocalitzacio, String nomPR, String descripcioPR) {
		super();
		IDPuntsRecollida = iDPuntsRecollida;
		IDLocalitzacio = iDLocalitzacio;
		NomPR = nomPR;
		DescripcioPR = descripcioPR;
	}
	
	public int getIDPuntsRecollida() {
		return IDPuntsRecollida;
	}
	
	public void setIDPuntsRecollida(int iDPuntsRecollida) {
		IDPuntsRecollida = iDPuntsRecollida;
	}
	public int getIDLocalitzacio() {
		return IDLocalitzacio;
	}
	public void setIDLocalitzacio(int iDLocalitzacio) {
		IDLocalitzacio = iDLocalitzacio;
	}
	public String getNomPR() {
		return NomPR;
	}
	public void setNomPR(String nomPR) {
		NomPR = nomPR;
	}
	public String getDescripcioPR() {
		return DescripcioPR;
	}
	public void setDescripcioPR(String descripcioPR) {
		DescripcioPR = descripcioPR;
	}

	@Override
	public String toString() {
		return "puntRecollida [IDPuntsRecollida=" + IDPuntsRecollida + ", IDLocalitzacio=" + IDLocalitzacio + ", NomPR="
				+ NomPR + ", DescripcioPR=" + DescripcioPR + "]";
	}
	
	
}
