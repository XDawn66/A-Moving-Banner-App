/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS125-02 
Lab #: Extra-Credit Project 
Submission Date: 10pm, Thu(10/13)
Description:  This is a movingbanner app that can display a moving flag with custom content. The user can customize their banner
colors and text size. This is also develop through using javafx. It uses the combo box, Rectangle class, animation class, and other 
common use javafx data type. After the ok button is clicked, the banner will keep moving from the left to the right horizontally
until the user exit the program. Those buttons actions are created by using action handle classes. The color is controlled by the
built in color functions in the scene class and the text size is controlled by the css functions.
*********************************************************************************************/ 
package application;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.util.Duration;

public class MovingBanner extends Application
{
	private TextField input; //some local variables to hold data
	private Label content,colorchoice,textchoice,error,errortext;
	private VBox banner;
	private ComboBox<String> color,Textsize;
	private Rectangle flag;
	
	public static void main(String[]args)
	{
		launch(args); //start the app
	}
		
	@Override
	public void start(Stage primary) 
	{
		flag = new Rectangle(300,150); //creat a banner by using Rectangle class
		flag.setFill(Color.WHITE); //the default flag color
		
	   	
		Label Message = new Label("Enter your message here:");
		content = new Label();
		colorchoice = new Label("Color: ");
		textchoice = new Label("TextSize: ");
		error = new Label();
		errortext = new Label();
		input = new TextField(); 
		 
		
		Button ok = new Button("OK"); //creating an OK button
		Button exit = new Button("Exit"); //creating an Exit button
		//creating an action handle without creating a class since it is simple action
		exit.setOnAction(event->
		{
			System.exit(0); //quit the program
		});
		
	
		color = new ComboBox<>(); //creating a combo box to hold color choices
		color.getItems().addAll("Red","Yellow","Blue","Green", "Purple");
		
		Textsize = new ComboBox<>(); //creating a textsize combo box to hold text size choices
		Textsize.getItems().addAll("20pt","24pt","28pt","32pt","36pt");
		
		HBox enterbar = new HBox(10,Message,input);
		HBox selectbar = new HBox(10,colorchoice,color,textchoice,Textsize);
		HBox hitbar = new HBox(10,ok,exit);
		
		banner = new VBox(-100,flag,content); //combing the flag with the text to a one single box so that they can move together
		VBox all = new VBox(10,enterbar,selectbar,hitbar,error,errortext,banner); //creating a vbox to hold all nodes
		
		enterbar.setPadding(new Insets(10));
		selectbar.setPadding(new Insets(10)); //some adjustment to make the app looks nice
		enterbar.setAlignment(Pos.CENTER);
		selectbar.setAlignment(Pos.CENTER); //putting content into center
		hitbar.setAlignment(Pos.CENTER); 
		
		ok.setOnAction(new okHandler()); //create the handling class
		
		Scene scene = new Scene(all,500,400);
		primary.setScene(scene);
		primary.setTitle("MovingBanner");
		primary.show();
		
	}
	class okHandler implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent event) {
			
			content.setText(input.getText()); //setting the user input to the marques
			
			if(color.getValue() == null) //if nothing is chosen
			{
				error.setText("The default color will be displayed.");
			}
			else if(color.getValue().equals("Red")) //if red is chosen
			{
				flag.setFill(Color.RED); //setting the color to the flag
			}
			else if(color.getValue().equals("Yellow")) //if yellow is chosen
			{
				flag.setFill(Color.YELLOW);//setting the color to the flag
			}
			else if(color.getValue().equals("Blue")) 
			{
				flag.setFill(Color.BLUE);//setting the color to the flag
			}
			else if(color.getValue().equals("Green"))
			{
				flag.setFill(Color.GREEN);//setting the color to the flag
			}
			else if(color.getValue().equals("Purple"))
			{
				flag.setFill(Color.PURPLE);//setting the color to the flag
			}
			
			if(Textsize.getValue() == null) //if nothing is chosen
			{
				errortext.setText("The default text size will be displayed.");
			}
			else if(Textsize.getValue().equals("20pt")) //if textsize 20pt is chosen
			{
				content.setStyle("-fx-font-size:20pt;-fx-text-alignment: center;"); //setting the text to size 20pt
			}
			else if(Textsize.getValue().equals("24pt"))//if textsize 24pt is chosen
			{
				content.setStyle("-fx-font-size:24pt; -fx-text-alignment: center;"); //setting the text to size 24pt
			}
			else if(Textsize.getValue().equals("28pt")) //similar to the one above...
			{
				content.setStyle("-fx-font-size:28pt; -fx-text-alignment: center;");
			}
			else if(Textsize.getValue().equals("32pt"))
			{
				content.setStyle("-fx-font-size:32pt; -fx-text-alignment: center;");
			}
			else if(Textsize.getValue().equals("36pt"))
			{
				content.setStyle("-fx-font-size:36pt; -fx-text-alignment: center;");
			}
			
			
			
			TranslateTransition move = new TranslateTransition(new Duration(3000),banner); //the animation that moves the banner
			move.setFromX(0); //starting from (0,0)
			move.setFromY(0);
			move.setByX(600); // to (600,0)  
			move.setInterpolator(Interpolator.LINEAR); //making the looping smoother
			move.setCycleCount(Animation.INDEFINITE); //allow the banner keep moving without stop
			move.play(); //play the animation
			
		}
		
	}
}