package DriverPackage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class RecButton extends StackPane{ 
	
	
	public RecButton(String title,Color colorBackground,int width,int height){
			setRectangle(title,width,height,colorBackground);
			setMoves();
			setOpacity(0.8);
		}
	
	
	private void setMoves(){
		setOnMouseEntered(e ->{
			setOpacity(.8);
			
		});
		setOnMouseExited(e ->{
					setOpacity(1);
			
		});
		setOnMousePressed(e ->{
			setScaleX(.95);
			setScaleY(.95);
			
		});
		setOnMouseReleased(e ->{
			setScaleX(1);
			setScaleY(1);
		});
	}
	
	
	private void setRectangle(String title, int width,int height, Color colorBackground){
		Rectangle rect = new Rectangle(width, height);
		rect.setFill(colorBackground);
		getChildren().add(rect);
		Label titleLabel =new Label(title);
		titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
		getChildren().add(titleLabel);

		
	}
	
	
	}
	

