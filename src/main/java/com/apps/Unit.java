package com.apps;

public enum Unit {
	 FEET(12.0),
	 INCHES(1.0);
	 
	 private final double conversionFactor;
	 
	 Unit(double conversionFactor){
		 this.conversionFactor = conversionFactor;
	 }
	 
	 public double getConversionFactor() {
		 return conversionFactor;
	 }
}
