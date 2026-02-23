package com.apps;

public enum Unit {
	 FEET(12.0),
	 INCHES(1.0),
	 YARD(36.0),
	 CENTIMETERS(0.393701);
	 
	 private final double conversionFactor;
	 
	 Unit(double conversionFactor){
		 this.conversionFactor = conversionFactor;
	 }
	 
	 public double getConversionFactor() {
		 return conversionFactor;
	 }
}
