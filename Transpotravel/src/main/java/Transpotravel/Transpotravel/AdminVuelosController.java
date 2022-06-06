package Transpotravel.Transpotravel;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Conbd;
import model.vols;
import model.volsDAOImpl;
import model.equipatge;

public class AdminVuelosController implements Initializable{

	
    @FXML
    private TableColumn<vols, String> ColumnIdVol;
    
    @FXML
    private TableColumn<vols, String> Columnorigen;
    
    @FXML
    private TableColumn<vols, String> Columndesti;
    
    @FXML
    private TableColumn<vols, Integer> ColumnMaxPas;
    
    @FXML
    private TableColumn<vols, Integer> ColumnMaxPes;
    
    @FXML
    private TableColumn<vols, LocalDateTime> Columndatasortida;
    
    @FXML
    private TableColumn<vols, LocalDateTime> Columndataarribada;  

    @FXML
    private TableColumn<vols, Integer> Columnpreu;
    
    @FXML
    private Button btnActualitzar;

    @FXML
    private TextField TextDisplayIDvol;
    
    @FXML
    private Tab butotabEliminarVol;

    @FXML
    private Button ButoonBorrar;

    @FXML
    private Button buttonCrearVol;
    
    @FXML
    private ComboBox<String> combobosorigen;

    @FXML
    private ComboBox<String> comboboxdesti;

    @FXML
    private DatePicker inputdatarribada;

    @FXML
    private DatePicker inputdatasortida;

    @FXML
    private TextField inputpes;
    
    @FXML
    private TextField inputpreu;
    
    @FXML
    private TextField inputID;
    
    @FXML
    private TextField inputpas;
    
    @FXML
    private TextField inputidborrar;

    @FXML
    private TextField inputtimearribada;

    @FXML
    private TextField inputtimesort;
    
    
    @FXML
    private TableView<vols> volsComprats;
    
    
    @FXML
    void OnClickActualitzar(ActionEvent event) {
    	
    	
    	ObservableList <vols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
	    	
	   
		volsDAOImpl.cercarVols(conexio, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<vols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<vols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<vols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<vols,Integer>("preu"));
		
    }
    
    
    @FXML
    void OnClickInsertarVol(ActionEvent event) {
    	
    	ID = Integer.parseInt(inputID.getText());
    	Pes = Integer.parseInt(inputpes.getText());
    	Pas = Integer.parseInt(inputpas.getText());
    	Preu=Integer.parseInt(inputpreu.getText());
		
    	dataEnt=inputdatarribada.getValue();
		
		dataSort=inputdatasortida.getValue();
		
		String partsarribada[]=inputtimearribada.getText().split(":");
		String partssortida[]=inputtimesort.getText().split(":");
		
		DataentCompleta=dataEnt.atTime(Integer.parseInt(partsarribada[0]), Integer.parseInt(partsarribada[1]));
		
		DataSortCompleta=dataSort.atTime(Integer.parseInt(partssortida[0]), Integer.parseInt(partssortida[1]));
		System.out.println(DataSortCompleta);
		Desc=inputpes.getText();

		
    	int IDOrigen=0;
    	int IDDesti=0;
    	LocalDateTime Arribada=DataentCompleta;
    	LocalDateTime Sortida=DataSortCompleta;
    	//
    	
    	
    	
    	IDOrigen=volsDAOImpl.ObtenirID_Localitzacio(conexio, ID_VueloSeleccionat1,IDOrigen);
    	IDDesti=volsDAOImpl.ObtenirID_Localitzacio(conexio, ID_VueloSeleccionat2,IDDesti);
    	
    	System.out.println(Arribada);
    	
    	volsDAOImpl.insertarVol(conexio, ID,IDOrigen, IDDesti, Pas, Pes,Sortida, Arribada,Preu);

    }
    
    
    @FXML
    void OnClickBorrarVol(ActionEvent event) {    	
    	volsDAOImpl.eliminarVol(conexio, inputidborrar.getText());
    	
    	
    	
    	ObservableList <vols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
    	
		volsDAOImpl.cercarVols(conexio, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<vols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<vols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<vols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<vols,Integer>("preu"));
    }
    
    
    @FXML
    void OnClickRefrescarTaula(ActionEvent event) {    	
    	    	
    	ObservableList <vols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
    	
		volsDAOImpl.cercarVols(conexio, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<vols,String>("iddistribuciovols"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<vols,String>("iddesti"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<vols,String>("idorigen"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaArribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("horaSortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<vols,Integer>("preu"));
    }
    
   
    
 	private Conbd conexio;
	int EstatIDVolSeleccionat=0;
    String EstatNouSeleccionat=" ";
 	String ID_VueloSeleccionat1="";
 	String ID_VueloSeleccionat2="";
 	int Preu,Pes,Pas,ID;
    LocalDate dataEnt;
    LocalDate dataSort;
    LocalDateTime DataentCompleta;
    LocalDateTime DataSortCompleta;
    String Desc="";
 	String ID_PuntRecollida="";
	int Oferta=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	conexio = new Conbd();	

    	ObservableList <String> Estats;
    	Estats = FXCollections.observableArrayList();
    	
    	//IDComboboxEstats.setItems(Estats);
    	
    	
    	ObservableList <String> paisos_origen;
    	paisos_origen = FXCollections.observableArrayList();
    	volsDAOImpl.ComboBoxOrigen(conexio, paisos_origen);
    	combobosorigen.setItems(paisos_origen);
    	
    	ObservableList <String> paisos_destins;
    	paisos_destins = FXCollections.observableArrayList();
    	volsDAOImpl.ComboBoxOrigen(conexio, paisos_destins);
    	comboboxdesti.setItems(paisos_destins);
    	
    	ObservableList <String> punts_recollida;
    	punts_recollida = FXCollections.observableArrayList();
    
    	

    	
    	
    	ObservableList <vols>llistaVols;
	    llistaVols=FXCollections.observableArrayList();
	    	
	   
		volsDAOImpl.cercarVols(conexio, llistaVols);    
		volsComprats.setItems(llistaVols);
		ColumnIdVol.setCellValueFactory(new PropertyValueFactory<vols,String>("IDVols"));
		Columnorigen.setCellValueFactory(new PropertyValueFactory<vols,String>("Origen"));
		Columndesti.setCellValueFactory(new PropertyValueFactory<vols,String>("Desti"));
		ColumnMaxPas.setCellValueFactory(new PropertyValueFactory<vols,Integer>("MaxPassatgers"));
		ColumnMaxPes.setCellValueFactory(new PropertyValueFactory<vols,Integer>("MaxPes"));
		Columndataarribada.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("Arribada"));
		Columndatasortida.setCellValueFactory(new PropertyValueFactory<vols,LocalDateTime>("Sortida"));
		Columnpreu.setCellValueFactory(new PropertyValueFactory<vols,Integer>("Preu"));
    
		
		//ObservableList <vols>llistaVolsEstats;
		//llistaVolsEstats=FXCollections.observableArrayList();
	    	
	   
		//volsDAOImpl.cercarVols(conexio, llistaVolsEstats);    
		//TaulaEstatsVolsEstats.setItems(llistaVolsEstats);
    
    
    
		comboboxdesti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_VueloSeleccionat1=valorSeleccionat;
      				}
    		}
    	});
		
		combobosorigen.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					ID_VueloSeleccionat2=valorSeleccionat;
    				}
    		}
    	});
		
		
		/*IDComboboxEstats.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> valorActual, String valorAnterior, String valorSeleccionat) {
    				if(valorSeleccionat!=null) {
    					EstatNouSeleccionat=valorSeleccionat;
    				}
    		}
    	});*/
		
    }
    
}
