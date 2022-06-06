package Transpotravel.Transpotravel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Conbd;
import model.vols;
import model.volsDAOImpl;
import model.equipatge;

public class registreController implements Initializable{

    @FXML
    private TextField Cognom1Usuari;

    @FXML
    private TextField CorreuUsuari;

    @FXML
    private Button Enrere;

    @FXML
    private Button EnviarDadesRegistre;

    @FXML
    private PasswordField contrasenyaUsuari;
    
    @FXML
    private ImageView imgVol;
    
    @FXML
    private Label missatgeRegistre;

    @FXML
    private TextField nomUsuari;
    
    @FXML
    private TextField dniUsuari;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	File fileRegistre = new File(".\\src\\main\\resources\\Transpotravel\\Transpotravel\\Imatges\\viatgeDef.jpg");
        Image imageRegistre = new Image(fileRegistre.toURI().toString());
        imgVol.setImage(imageRegistre);
    	
    }
    
    @FXML
    private void pantallaLogin() throws IOException {
        App.setRoot("Login");
    }
    
    public void registreUsuari() {
    	
    	if(!dniUsuari.getText().isBlank() && !nomUsuari.getText().isBlank() && !Cognom1Usuari.getText().isBlank() && !CorreuUsuari.getText().isBlank() && !contrasenyaUsuari.getText().isBlank()) {
    		
    		Conbd conn = new Conbd();
        	Connection connectDB = conn.getConexio();
        	
        	String dni = dniUsuari.getText();
        	String nom = nomUsuari.getText();
        	String cognoms = Cognom1Usuari.getText();
        	String correu = CorreuUsuari.getText();
        	String contrasenya = contrasenyaUsuari.getText();
        	
        	String sql = "Insert into transpotravelrecu.usuaris(DNI,Nom,Cognom,Contrasenya,Correu) values ('"+dni+"','"+nom+"','"+cognoms+"','"+contrasenya+"','"+correu+"');";
        	
        	
        	try {
        		
        		Statement st = connectDB.createStatement();
        		st.executeUpdate(sql);
        		
        		missatgeRegistre.setText("L'usuari s'ha registrat correctament!");
        		
        	}catch (Exception e) {
        		
        		e.printStackTrace();
        		e.getCause();
        		
        	}
    		
    	}else {
    							//No quitar este espacio.
    		missatgeRegistre.setText("       Has d'emplenar tots els camps!"); 
        	
    	}
    	
    	
    }

}
