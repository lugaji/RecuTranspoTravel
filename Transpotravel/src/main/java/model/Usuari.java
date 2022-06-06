package model;

public class Usuari {
	
	String dni;
	String nom;
	String cognom;
	
	public Usuari(String dni, String nom, String cognom) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.cognom = cognom;
		
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	@Override
	public String toString() {
		return "Usuari [dni=" + dni + ", nom=" + nom + ", cognom=" + cognom + "]";
	}
	
}
