/****************************************************************************************** 
Name: Zhenyu Jiang 
Course: CS125-02 
Lab #: Extra-Credit Project 
Submission Date: 10pm, Thu(10/13)
Description:  This is an exception class inherited from the Exception class to handle user's negative input 
*********************************************************************************************/ 
package application;

public class NegativeIntegerException extends Exception
{	
	public NegativeIntegerException()
	{
		super("Please enter non-negative numbers.");//it will output the message to notifying user they enter the negative number
	}

}