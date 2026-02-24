package com.apps;

import java.util.*;

public class QuantityMeasurementApp {

	// Static method to demonstrate Length equality
	public static boolean demonstrateLengthEquality(Quantity l1, Quantity l2) {
		return l1.equals(l2);
	}

	public static boolean demonstrateLengthComparison(double value1, Unit unit1, 
			double value2, Unit unit2) {
		Quantity l1 = new Quantity(value1, unit1);
		Quantity l2 = new Quantity(value2, unit2);
		boolean result = l1.equals(l2);
		System.out.println("Are lengths equal? " + result);
		return result;
	}

	public static Quantity demonstrateLengthConversion(double value, Unit fromUnit, Unit toUnit) { 
		Quantity source = new Quantity(value, fromUnit); 
		Quantity converted = source.convertTo(toUnit); 
		System.out.println(source + " -> " + converted); 
		return converted; 
	}

	public static Quantity demonstrateLengthConversion(Quantity length, Unit toUnit) { 
		Quantity converted = length.convertTo(toUnit); 
		System.out.println(length + " -> " + converted); 
		return converted; 
	}

	// Static method to demonstrate addition of two Length objects
	public static Quantity demonstrateLengthAddition(Quantity length1, Quantity length2) {
		Quantity sum = length1.add(length2); // use Length.add() from UC6
		System.out.println(length1 + " + " + length2 + " = " + sum);
		return sum;
	}

	// Static method to demonstrate addition of two Length objects into target unit
	public static Quantity demonstrateLengthAddition(Quantity length1, Quantity length2, Unit targetUnit) {
		Quantity sum = length1.add(length2, targetUnit);
		System.out.println(length1 + " + " + length2 + " in " + targetUnit + " = " + sum);
		return sum;
	}
	// Main method	
	public static void main(String[] args) {
		demonstrateLengthComparison(1.0, Unit.FEET, 12.0, Unit.INCHES);
		demonstrateLengthComparison(1.0, Unit.YARD, 36.0, Unit.INCHES);
		demonstrateLengthComparison(100.0, Unit.CENTIMETERS, 39.3701,Unit.INCHES);
		demonstrateLengthComparison(3.0,Unit.FEET, 1.0, Unit.YARD);
		demonstrateLengthComparison(30.48, Unit.CENTIMETERS, 1.0,Unit.FEET);

		demonstrateLengthConversion(1.0, Unit.FEET, Unit.INCHES); 
		demonstrateLengthConversion(3.0, Unit.YARD, Unit.FEET); 
		demonstrateLengthConversion(36.0, Unit.INCHES, Unit.YARD); 
		demonstrateLengthConversion(30.48, Unit.CENTIMETERS, Unit.FEET); 

		demonstrateLengthConversion(new Quantity(-1.0, Unit.FEET), Unit.INCHES);

		demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES)
				);

		demonstrateLengthAddition(
				new Quantity(12.0, Unit.INCHES),
				new Quantity(1.0, Unit.FEET)
				);

		demonstrateLengthAddition(
				new Quantity(1.0, Unit.YARD),
				new Quantity(3.0, Unit.FEET)
				);

		demonstrateLengthAddition(
				new Quantity(2.54, Unit.CENTIMETERS),
				new Quantity(1.0, Unit.INCHES)
				);

		demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(0.0, Unit.INCHES)
				);

		demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(-2.0, Unit.FEET)
				);
		demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES),
				Unit.FEET
				);

		demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),                                  
				new Quantity(12.0, Unit.INCHES),
				Unit.INCHES
				);

		demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES),
				Unit.YARD
				);

		demonstrateLengthAddition(
				new Quantity(1.0, Unit.YARD),
				new Quantity(3.0, Unit.FEET),
				Unit.YARD
				); 

		demonstrateLengthAddition(
				new Quantity(36.0, Unit.INCHES),
				new Quantity(1.0, Unit.YARD),
				Unit.FEET
				);

		demonstrateLengthAddition(
				new Quantity(2.54, Unit.CENTIMETERS),
				new Quantity(1.0, Unit.INCHES),
				Unit.CENTIMETERS
				);

		demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(0.0, Unit.INCHES),
				Unit.YARD
				);

		demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(-2.0, Unit.FEET),
				Unit.INCHES
				);
	}
}
