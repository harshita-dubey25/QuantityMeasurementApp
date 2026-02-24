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

	public double convertToBaseUnit(double value) {
		double result = value * conversionFactor;
		return Math.round(result * 1_000_000.0) / 1_000_000.0;
	}

	public double convertFromBaseUnit(double baseValue) {
		double result = baseValue / conversionFactor;
		return Math.round(result * 1_000_000.0) / 1_000_000.0;
	}
}
