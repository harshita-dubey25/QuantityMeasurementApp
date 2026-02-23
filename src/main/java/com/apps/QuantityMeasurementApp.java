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

		// Main method
		public static void main(String[] args) {
			demonstrateLengthComparison(1.0, Unit.FEET, 12.0, Unit.INCHES);
			demonstrateLengthComparison(1.0, Unit.YARD, 36.0, Unit.INCHES);
			demonstrateLengthComparison(100.0, Unit.CENTIMETERS, 39.3701,Unit.INCHES);
			demonstrateLengthComparison(3.0,Unit.FEET, 1.0, Unit.YARD);
			demonstrateLengthComparison(30.48, Unit.CENTIMETERS, 1.0,Unit.FEET);
		}
}
