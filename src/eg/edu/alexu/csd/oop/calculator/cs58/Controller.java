package eg.edu.alexu.csd.oop.calculator.cs58;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

	Calculator cal = new Calculator();
	String Text = "";
	@FXML
	Label input = new Label("Enter");
	@FXML
	Label Result = new Label("The Result");
	@FXML
	Button save = new Button("SAVE");
	@FXML
	Button load = new Button("LOAD");
	@FXML
	Button enter = new Button("Enter");
	@FXML
	Button current = new Button("Current");
	@FXML
	Button previous = new Button("Previous");
	@FXML
	Button Next = new Button("Next");
	@FXML
	Button one = new Button("1");
	@FXML
	Button two = new Button("2");
	@FXML
	Button three = new Button("3");
	@FXML
	Button four = new Button("4");
	@FXML
	Button five = new Button("5");
	@FXML
	Button six = new Button("6");
	@FXML
	Button seven = new Button("7");
	@FXML
	Button eight = new Button("8");
	@FXML
	Button nine = new Button("9");
	@FXML
	Button zero = new Button("0");
	@FXML
	Button dot = new Button(".");
	@FXML
	Button equal = new Button("=");
	@FXML
	Button plus = new Button("+");
	@FXML
	Button sub = new Button("-");
	@FXML
	Button mul = new Button("*");
	@FXML
	Button div = new Button("/");
	@FXML
	Button back = new Button("Back");

	public void GetText(ActionEvent event) {
		if(((Button)event.getSource()).getText().equals("Enter") ) {
			cal.input(input.getText());
			Text="";
		}
		else if(((Button)event.getSource()).getText().equals("=")) {
			int flag=0;
			String s= input.getText();
			for(int i=0;i<cal.List.size();i++) {
				if(cal.List.get(i).equals(s)) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				cal.input(input.getText());
			}
			Result.setText(cal.getResult());
			Text="";
		}
		else if(((Button)event.getSource()).getText().equals("Back")) {
			Text = Text.substring(0, Text.length()-1);
			input.setText(Text);
		}
		else if(((Button)event.getSource()).getText().equals("Current") ) {
			input.setText(cal.current());
		}
		else if(((Button)event.getSource()).getText().equals("Previous")) {
			input.setText(cal.prev());
		}
		else if(((Button)event.getSource()).getText().equals("Next")) {
			input.setText(cal.next());
		}
		else if(((Button)event.getSource()).getText().equals("SAVE")) {
			cal.save();
		}
		else if(((Button)event.getSource()).getText().equals("LOAD")) {
			cal.load();
		}
		else if(((Button)event.getSource()).getText() != "SAVE" && ((Button)event.getSource()).getText() != "LOAD"
				&& ((Button)event.getSource()).getText() != "Enter" && ((Button)event.getSource()).getText() != "Current"
				&& ((Button)event.getSource()).getText() != "Previous"
				&& ((Button)event.getSource()).getText() != "Next" && 
				((Button)event.getSource()).getText() != "="
				&& ((Button)event.getSource()).getText() != "Back") {
		 Text+= ((Button)event.getSource()).getText();
		input.setText(Text);
		}
	}
	
}
