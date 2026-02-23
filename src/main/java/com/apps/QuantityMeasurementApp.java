package com.apps;

import java.util.*;

public class QuantityMeasurementApp {
	public static class Feet{
		public final double value;
		
		public Feet(double value) {
			this.value = value;
		}
		
		public double getValue() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this ==  obj) {
				return true;
			}
			
			if(obj == null || getClass() != obj.getClass()) {
				return false;
			}
			
			Feet other = (Feet) obj;
			return (Double.compare(this.value,other.value) == 0);
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstValue = sc.nextInt();
		int secondValue = sc.nextInt();
		Feet f1 = new Feet(firstValue);
		Feet f2 = new Feet(secondValue);
		
		System.out.println("Is Equals: "+ f1.equals(f2));
	}
}
