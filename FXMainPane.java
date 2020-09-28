

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	  Button hello, howdy, chinese, russian, clear, exit;
	   Label feedback; // label
	   TextField textField;
	//  declare two HBoxes
	   HBox hbox1;
	   HBox hbox2;
	   VBox vbox;
	   
	//student Task #4:
	//  declare an instance of DataManager
	   DataManager dm;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		hello = new Button("Hello");
		howdy = new Button("Hodwy");
		chinese = new Button("Chinese");
		russian = new Button("Здравствуйте");
		clear = new Button("Clear");
		exit = new Button("Exit");
		feedback = new Label("Feedback");
		textField = new TextField();
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dm = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(hello, new Insets(10));
		HBox.setMargin(howdy, new Insets(10));
		HBox.setMargin(chinese, new Insets(10));
		HBox.setMargin(clear, new Insets(10));
		HBox.setMargin(exit, new Insets(10));
		HBox.setMargin(russian, new Insets(10));
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox2.getChildren().addAll(feedback, textField);
		//  add the buttons to the other HBox
		hbox1.getChildren().addAll(hello, howdy, chinese, russian, clear, exit);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
		 hello.setOnAction(new ButtonHandler());
	     howdy.setOnAction(new ButtonHandler());
	     chinese.setOnAction(new ButtonHandler());
	     clear.setOnAction(new ButtonHandler());
	     exit.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent e) {
		       if (e.getTarget()==hello) {
		           textField.setText(dm.getHello());
		       }
		       else if (e.getTarget()==howdy) {
		           textField.setText(dm.getHowdy());
		       }
		       else if (e.getTarget()==chinese) {
		           textField.setText(dm.getChinese());
		       }
		       else if (e.getTarget()==russian) {
		    	   textField.setText(dm.getRussian());
		       }
		       else if (e.getTarget()==clear) {
		           textField.setText("");
		       }
		       else if (e.getTarget()==exit) {
		           Platform.exit();
		           System.exit(0);
		       }
		}
	}
	
}
	
