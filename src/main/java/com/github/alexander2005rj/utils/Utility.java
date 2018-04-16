package com.github.alexander2005rj.utils;

public class Utility {
	
	
	public static int sortearNumeroMenorQue(int valor) {
		int number = ( (int) Math.random() * valor );
		
		if ( number == 0 ) number++;
		
		return number;
	}
	
	
}
