/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS125-02 
Lab #: Extra-Credit Project 
Submission Date: 10pm, Thu(10/13)
Description:  This is a javafx program that calculate the multiplication for the user by reading inputs. 
The program will accept two positive integer, and it will keep asking the user to enter the valid number if they try 
to input something like string or negative number. This program uses a basic recursion function call multi, it will
adding a single number many times to achieve a similar process. The data validation is done by using exception
handling classes, and it also use the eventhandler to activate calculation, clear, and exit functionalities.
*********************************************************************************************/ 
package application;
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class RecursiveMultiply extends Application
{
	private Label firstnum,secondnum,result,error; //some local variables to hold information
	private TextField input1,input2;
	private int base, num, total;
	
	public int multi(int base, int num)
	{
		if(num == 1) //the base case
		{
			return base;
		}
		else
		{
			return base+multi(base,num-1);
		}
	}
	/*
	public static void main(String[]args)
	{
		launch(args); //start the app
	}*/
	@Override
	public void start(Stage primary) 
	{
		
		Label intro = new Label("Please enter two int to get value");
		firstnum = new Label("Num 1:");
		secondnum = new Label("Num 2:");
		result = new Label();  
		error = new Label();
			
		Button submit = new Button("Submit"); //creating 3 bottons for different functionailties
		submit.setOnAction(new submitHandler()); //it will start calculate all the data after this Button is clicked
		Button clear = new Button("Clear");
		clear.setOnAction(new clearHandler());//it will start clear all the data after this Button is clicked
		Button exit = new Button("Exit");
		exit.setOnAction(new exitHandler());//it will exit the app after this Button is clicked
		
		input1 = new TextField(); //a textfield to get the first number from the user
		input2 = new TextField(); //a textfield to get the second number from the user
		
		HBox introbar = new HBox(intro); //setting up a HBox to hold the intro and the input area
		HBox inputbar1 = new HBox(30,firstnum,input1);
		HBox inputbar2 = new HBox(30,secondnum,input2);
		HBox functionbar = new HBox(10,submit,clear,exit); //create a bar for buttons
		HBox errorbar = new HBox(error);
		HBox resultbar = new HBox(result); //create a bar for displaying results
		
		inputbar1.setPadding(new Insets(15)); //formating the app to make it look more organize
		inputbar2.setPadding(new Insets(15));
		functionbar.setAlignment(Pos.CENTER);
		errorbar.setAlignment(Pos.CENTER);
		
		
		VBox all = new VBox(10,introbar,inputbar1,inputbar2,functionbar,errorbar,resultbar); //putting all the node together as one app
	
		Scene scene = new Scene(all,300,250); //creating a scene with size of 300 by 250
		primary.setScene(scene);
		primary.setTitle("RecursiveMultiply App");
		primary.show();	
	}
	
	class submitHandler implements EventHandler<ActionEvent> //an action handler class for the submit button
	{

		@Override
		public void handle(ActionEvent event) {
			
			try //try if the following code can run
			{
				base = Integer.parseInt(input1.getText()); //turning user input to integers
				num = Integer.parseInt(input2.getText());
				if(base<0 || num < 0)
				{
					throw new NegativeIntegerException(); //if the user input a negative number
				}
				total = multi(base,num); //calling the recursion class to done the calculation
				error.setText("");//there is no error, so the error label is staying empty
			}
			
			catch(NegativeIntegerException e) //custom exception class to handle negative input
			{
				error.setText(e.getMessage());
				total = 0;
				result.setText(""); //setting everything to empty
				input1.setText("");
				input2.setText("");
			}
			catch(NumberFormatException e) //exception class to handle string input
			{
				error.setText("Please input numbers!");
				total = 0;
				result.setText(""); //setting everything to empty
				input1.setText("");
				input2.setText("");
			}
			
			result.setText("Total: " + total); //displaying the result
		}
		
	}
	
	 class clearHandler implements EventHandler<ActionEvent>
	 {

		@Override
		public void handle(ActionEvent event) {
			result.setText("");//empty the textfield and all the data  
			input1.setText("");//empty the textfield and all the data  
			input2.setText("");//empty the textfield and all the data  	
			error.setText("");
		}
		 
	 }
	 
	 class exitHandler implements EventHandler<ActionEvent>
	 {

		@Override
		public void handle(ActionEvent event) {
			System.exit(0); //quit the program
		}
		 
	 }
}