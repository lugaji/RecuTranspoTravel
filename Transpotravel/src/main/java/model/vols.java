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
		int preu;
		int maxPas;
		int maxPes;
		LocalDateTime Arribada;
		LocalDateTime Sortida;


		public vols(int iDVols, int origen, int desti, int preu, int maxPas, int maxPes, LocalDateTime horaArribada,
				LocalDateTime horaSortida) {
			super();
			IDVols = iDVols;
			Origen = origen;
			Desti = desti;
			this.preu = preu;
			this.maxPas = maxPas;
			this.maxPes = maxPes;
			this.Arribada = horaArribada;
			this.Sortida = horaSortida;
		}


		public int getEquipatges() {
			return maxPes;
		}


		public void setEquipatges(int equipatges) {
			this.maxPes = equipatges;
		}

		public int getPlaces() {
			return maxPas;
		}


		public void setPlaces(int places) {
			this.maxPas = places;
		}
			

		public int getIddistribuciovols() {
			return IDVols;
		}		




		public void setIddistribuciovols(int iddistribuciovols) {
			this.IDVols = iddistribuciovols;
		}


		public int getIdorigen() {
			return Origen;
		}


		public void setIdorigen(int idorigen) {
			this.Origen = idorigen;
		}


		public int getIddesti() {
			return Desti;
		}


		public void setIddesti(int iddesti) {
			this.Desti = iddesti;
		}


		public int getPreu() {
			return preu;
		}


		public void setPreu(int preu) {
			this.preu = preu;
		}


		public LocalDateTime getHoraArribada() {
			return Arribada;
		}


		public void setHoraArribada(LocalDateTime horaArribada) {
			this.Arribada = horaArribada;
		}


		public LocalDateTime getHoraSortida() {
			return Sortida;
		}


		public void setHoraSortida(LocalDateTime horaSortida) {
			this.Sortida = horaSortida;
		}


		@Override
		public String toString() {
			return "vols [IDVols=" + IDVols + ", Origen=" + Origen + ", Desti=" + Desti + ", preu=" + preu + ", maxPas="
					+ maxPas + ", maxPes=" + maxPes + ", horaArribada=" + Arribada + ", horaSortida=" + Sortida
					+ "]";
		}
	

}
