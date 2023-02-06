package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.classes.PC;

public class PCResultController {

	@FXML
    private HBox box;
	
	@FXML
	private AnchorPane resultPane;

    @FXML
    private ImageView pcImage;

    @FXML
    private Label nameLbl;

    @FXML
    private Label cpuLbl;

    @FXML
    private Label ramLbl;

    @FXML
    private Label graphicsLbl;

    @FXML
    private Label storageLbl;

    @FXML
    private Label priceLbl;

	@FXML 
	private Label numberLbl;
	
	@FXML
	private Hyperlink link;

	//Set the data of the box to display the detail of result PC
    public void setData(PC pc, int number) {
    	Image image = new Image(getClass().getResourceAsStream(pc.getImgSrc()));
    	pcImage.setImage(image);
    	
    	nameLbl.setText(pc.getName());
    	cpuLbl.setText(pc.getCpu());
    	ramLbl.setText(pc.getRam());
    	graphicsLbl.setText(pc.getGraphics());
    	storageLbl.setText(pc.getStorage());
    	priceLbl.setText(pc.getPrice());
    	numberLbl.setText(Integer.toString(number));
    	link.setId(pc.getLink());
    }
    
    //Open the link to the online shop of the component
  	public void openLink(ActionEvent event) throws URISyntaxException, IOException {
  		Desktop.getDesktop().browse(new URI(link.getId()));
  	}
}
