package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.classes.Component;
import javafx.scene.control.Hyperlink;

public class ComponentResultController {

	@FXML
	private VBox box;
		
	@FXML
	private ImageView componentImage;

	@FXML
	private Label categoryLbl;

	@FXML
	private Label nameLbl;

	@FXML
    private Label spec1Lbl;

    @FXML
	private Label spec2Lbl;

	@FXML
	private Label spec3Lbl;

	@FXML
	private Label priceLbl;

	@FXML 
	private Hyperlink link;
	
	//Set the data of the box to display the detail of result component
	public void setData(Component c) {
		Image image = new Image(getClass().getResourceAsStream(c.getImgSrc()));
		componentImage.setImage(image);
		
		categoryLbl.setText(c.getCategory());
		nameLbl.setText(c.getName());
		spec1Lbl.setText(c.getSpec1());
		spec2Lbl.setText(c.getSpec2());
		spec3Lbl.setText(c.getSpec3());
		priceLbl.setText(c.getPrice());
		link.setText("Buy");
		link.setId(c.getLink());
		
	}
	
	//Open the link to the online shop of the component
	public void openLink(ActionEvent event) throws URISyntaxException, IOException {
		Desktop.getDesktop().browse(new URI(link.getId()));
	}

}
