package main;
import java.io.*;

import observer.BarChart;
import observer.Limite;
import observer.LineaEstado;
import observer.PieChart;
import observer.Saltador;
import observer.SaveResults;
import poll.*;
import ui.Interviewer;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

//		poll.añadir(new Limite(new PieChart(), 3));
//		poll.añadir(new Saltador(new BarChart(), 3));
		poll.añadir(new Saltador(new Limite(new SaveResults(),2),2));
		poll.añadir(new LineaEstado());
		
		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
		
		
	}
}

