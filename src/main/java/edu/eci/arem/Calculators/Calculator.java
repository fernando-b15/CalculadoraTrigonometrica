package edu.eci.arem.Calculators;

public class Calculator {

	public Calculator() {
		
	}
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
	public double calculateSin(double valor) {
		return Math.sin(valor);
	}
	public double calculateCos(double valor) {
		return Math.cos(valor);
	}
	public double calculateTan(double valor) {
		return Math.tan(valor);
	}

}
