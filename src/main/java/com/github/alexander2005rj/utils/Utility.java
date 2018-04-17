package com.github.alexander2005rj.utils;

public class Utility {
	
	
	public static int sortearNumeroMenorQue( int valor ) {
		int number =  (int) ( Math.random()  * valor );
						
		return (number == 0) ? 1 : number;
	}
	
	
	public static int sortearIndexMenorQue( int index ) {
		return (int) ( Math.random()  * index );
	}
	
}
