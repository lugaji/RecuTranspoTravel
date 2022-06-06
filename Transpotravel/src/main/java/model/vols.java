package model;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

import java.util.ArrayList;

import javafx.scene.image.ImageView;


//import javafx.scene.image.ImageView;

public class vols {

		int IDVols;
		int Origen;
		int Desti;
		int maxPas;
		int maxPes;
		String sortida;
		String arribada;
		int preu;
		
		
		
		public vols(int iDVols, int origen, int desti, int maxPas, int maxPes, String sortida, String arribada,
				int preu) {
			super();
			IDVols = iDVols;
			Origen = origen;
			Desti = desti;
			this.maxPas = maxPas;
			this.maxPes = maxPes;
			this.sortida = sortida;
			this.arribada = arribada;
			this.preu = preu;
		}
		
		public int getIDVols() {
			return IDVols;
		}
		public void setIDVols(int iDVols) {
			IDVols = iDVols;
		}
		public int getOrigen() {
			return Origen;
		}
		public void setOrigen(int origen) {
			Origen = origen;
		}
		public int getDesti() {
			return Desti;
		}
		public void setDesti(int desti) {
			Desti = desti;
		}
		public int getMaxPas() {
			return maxPas;
		}
		public void setMaxPas(int maxPas) {
			this.maxPas = maxPas;
		}
		public int getMaxPes() {
			return maxPes;
		}
		public void setMaxPes(int maxPes) {
			this.maxPes = maxPes;
		}
		public String getSortida() {
			return sortida;
		}
		public void setSortida(String sortida) {
			this.sortida = sortida;
		}
		public String getArribada() {
			return arribada;
		}
		public void setArribada(String arribada) {
			this.arribada = arribada;
		}
		public int getPreu() {
			return preu;
		}
		public void setPreu(int preu) {
			this.preu = preu;
		}

		@Override
		public String toString() {
			return "vols [IDVols=" + IDVols + ", Origen=" + Origen + ", Desti=" + Desti + ", maxPas=" + maxPas
					+ ", maxPes=" + maxPes + ", sortida=" + sortida + ", arribada=" + arribada + ", preu=" + preu + "]";
		}

}
