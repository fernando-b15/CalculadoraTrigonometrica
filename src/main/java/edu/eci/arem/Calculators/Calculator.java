package edu.eci.arem.Calculators;
/**
 * Esta clase es la clase se encarga de realizar los calculos trigonmetricos
 *
 */

public class Calculator {
	/**
	 * Constructor de la calculadora
	 */
	public Calculator() {
		
	}
	/**
	 * se encarga de calcular el valor solicitando usnado el valor y la funcion dada
	 * @param funcion
	 * @param valor
	 * @return double
	 */
	public double calculate(String funcion,double valor) {
		if(funcion.equals("sin")) {
			return this.calculateSin(valor);
		}
		else if (funcion.equals("cos")) {
			return this.calculateCos(valor);
		}
		else if (funcion.equals("tan")) {
			return this.calculateTan(valor);
		}
		else {
			System.out.println("Operacion no encontrada");
			return -1;
		}
	}
	/**
	 * calcula el seno de un numero en radianes
	 * 
	 * @param valor
	 * @return double
	 */
	public double calculateSin(double valor) {
		return Math.sin(valor);
	}
	/**
	 * calcula el coseno de un numero en radianes
	 * 
	 * @param valor
	 * @return double
	 */
	public double calculateCos(double valor) {
		return Math.cos(valor);
	}
	/**
	 * calcula la tangente de un numero en radianes
	 * 
	 * @param valor
	 * @return double
	 */
	public double calculateTan(double valor) {
		return Math.tan(valor);
	}

}
