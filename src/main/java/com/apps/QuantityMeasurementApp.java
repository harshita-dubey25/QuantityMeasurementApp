package com.apps;

import java.util.*;

public class QuantityMeasurementApp {
	
	// Static method to demonstrate Weight equality
		public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
		    return weight1.equals(weight2);
		}
		
		// Static method to demonstrate weight comparison using values and units
		public static boolean demonstrateWeightComparison(double value1, WeightUnit unit1,
		                                                  double value2, WeightUnit unit2) {
		    Weight w1 = new Weight(value1, unit1);
		    Weight w2 = new Weight(value2, unit2);
		    boolean result = w1.equals(w2);
		    System.out.println(w1 + " == " + w2 + " ? " + result);
		    return result;
		}
		
		// Static method to demonstrate conversion using raw values
		public static Weight demonstrateWeightConversion(double value, WeightUnit fromUnit,
		                                                  			   WeightUnit toUnit) {
		    Weight source = new Weight(value, fromUnit);
		    Weight converted = source.convertTo(toUnit);
		    System.out.println(source + " -> " + converted);
		    return converted;
		}

		// Static method to demonstrate conversion using existing Weight object
		public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
		    Weight converted = weight.convertTo(toUnit);
		    System.out.println(weight + " -> " + converted);
		    return converted;
		}
		
		// Static method to demonstrate addition of two Weight objects
		public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {
		    Weight sum = weight1.add(weight2);
		    System.out.println(weight1 + " + " + weight2 + " = " + sum);
		    return sum;
		}
		
		// Static method to demonstrate addition with target unit
		public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2, WeightUnit targetUnit) {
		    Weight sum = weight1.add(weight2, targetUnit);
		    System.out.println(weight1 + " + " + weight2 + " in " + targetUnit + " = " + sum);
		    return sum;
		}
		
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
		
		demonstrateWeightComparison(1.0, WeightUnit.KILOGRAM, 1000.0, WeightUnit.GRAM);
		demonstrateWeightComparison(2.204624, WeightUnit.POUND, 1.0, WeightUnit.KILOGRAM);
		demonstrateWeightComparison(453.592, WeightUnit.GRAM, 1.0, WeightUnit.POUND);
		demonstrateWeightComparison(1.0, WeightUnit.KILOGRAM, 1.0, WeightUnit.KILOGRAM);
		demonstrateWeightComparison(2.0, WeightUnit.POUND, 2.0, WeightUnit.POUND);
		demonstrateWeightComparison(500.0, WeightUnit.GRAM, 0.5, WeightUnit.KILOGRAM);
		
		demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
		demonstrateWeightConversion(2.0, WeightUnit.POUND, WeightUnit.KILOGRAM);
		demonstrateWeightConversion(500.0, WeightUnit.GRAM, WeightUnit.POUND);
		demonstrateWeightConversion(0.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
		
		demonstrateWeightConversion(
	        new Weight(-1.0, WeightUnit.KILOGRAM),
	        WeightUnit.GRAM
        );

		demonstrateWeightAddition(
	        new Weight(1.0, WeightUnit.KILOGRAM),
	        new Weight(2.0, WeightUnit.KILOGRAM)
        );
		
		demonstrateWeightAddition(
	        new Weight(1.0, WeightUnit.KILOGRAM),
	        new Weight(1000.0, WeightUnit.GRAM)
        );

		demonstrateWeightAddition(
	        new Weight(500.0, WeightUnit.GRAM),
	        new Weight(0.5, WeightUnit.KILOGRAM)
        );

		demonstrateWeightAddition(
	        new Weight(1.0, WeightUnit.KILOGRAM),
	        new Weight(1000.0, WeightUnit.GRAM),
	        WeightUnit.GRAM
        );

		demonstrateWeightAddition(
	        new Weight(1.0, WeightUnit.POUND),
	        new Weight(453.592, WeightUnit.GRAM),
	        WeightUnit.POUND
        );
		
		demonstrateWeightAddition(
	        new Weight(2.0, WeightUnit.KILOGRAM),
	        new Weight(4.0, WeightUnit.POUND),
	        WeightUnit.KILOGRAM
        );
		
		System.out.println("Weight vs Length equality: " +
		    new Weight(1.0, WeightUnit.KILOGRAM)
		    .equals(new Quantity(1.0, Unit.FEET))
		);
		
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
