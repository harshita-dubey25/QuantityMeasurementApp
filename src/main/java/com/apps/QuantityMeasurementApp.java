package com.apps;

import java.util.*;

public class QuantityMeasurementApp {
	
	// Static method to demonstrate Length equality
		public static boolean demonstrateLengthEquality(Quantity l1, Quantity l2) {
			return l1.equals(l2);
		}

		// Static method to demonstrate Feet equality
		public static void demonstrateFeetEquality() {
			Quantity feet1 = new Quantity(1.0, Unit.FEET);
			Quantity feet2 = new Quantity(1.0, Unit.FEET);
			System.out.println("Feet equality: " + demonstrateLengthEquality(feet1, feet2));
		}

		// Static method to demonstrate Inches equality
		public static void demonstrateInchesEquality() {
			Quantity inch1 = new Quantity(1.0, Unit.INCHES);
			Quantity inch2 = new Quantity(1.0, Unit.INCHES);
			System.out.println("Inches equality: " + demonstrateLengthEquality(inch1, inch2));
		}

		// Static method to demonstrate Feet and Inches comparison
		public static void demonstrateFeetInchesComparison() {
			Quantity feet1 = new Quantity(1.0, Unit.FEET);
			Quantity inch12 = new Quantity(12.0, Unit.INCHES);
			System.out.println("Feet vs Inches equality: " + demonstrateLengthEquality(feet1, inch12));
		}

		// Main method
		public static void main(String[] args) {
			demonstrateFeetEquality();
			demonstrateInchesEquality();
			demonstrateFeetInchesComparison();
		}
}
