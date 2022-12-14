/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS125-02 
Lab #: Extra-Credit Project 
Submission Date: 10pm, Thu(10/13)
Description:  This is a driver class to call the RecursiveMultipy program. It can simply launch the 
javafx program through the launch program.
*********************************************************************************************/ 
package application;
import javafx.application.Application;


public class Appdriver
{
	 public static void main(String[] args)
	  {
		  Application.launch(RecursiveMultiply.class, args); //launching the app
	  }
}