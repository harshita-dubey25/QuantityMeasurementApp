package com.apps;

import java.util.*;

public class QuantityMeasurementApp {
	
	// Inner class for feet measurement
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
	
	// Inner class for Inch measurement
	public static class Inches{
		public final double value;
		
		public Inches(double value) {
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
			
			Inches other = (Inches) obj;
			return (Double.compare(this.value,other.value) == 0);
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}
	
	public static void demonstrateFeetEquality() {
		Feet f1 = new Feet(1.0);
		Feet f2 = new Feet(1.0);
		System.out.println("Feet Equal: " + f1.equals(f2));
	}

	public static void demonstrateInchesEquality() {
		Inches i1 = new Inches(1.0);
		Inches i2 = new Inches(1.0);
		System.out.println("Inches Equal: " + i1.equals(i2));
	}
	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
	}
}
