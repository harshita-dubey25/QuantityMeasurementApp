package com.apps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
	private static final double EPSILON = 1e-6;
	@Test
	public void testEquality_YardToYard_SameValue() {
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		Quantity yard2 = new Quantity(1.0, Unit.YARD);
		assertEquals(yard1, yard2);
	}

	@Test
	public void testEquality_YardToYard_DifferentValue() {
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		Quantity yard2 = new Quantity(2.0, Unit.YARD);
		assertNotEquals(yard1, yard2);
	}

	@Test
	public void testEquality_YardToFeet_EquivalentValue() {
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		Quantity feet3 = new Quantity(3.0, Unit.FEET);
		assertEquals(yard1, feet3);
	}

	@Test
	public void testEquality_FeetToYard_EquivalentValue() {
		Quantity feet3 = new Quantity(3.0, Unit.FEET);
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		assertEquals(feet3, yard1);
	}

	@Test
	public void testEquality_YardToInches_EquivalentValue() {
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		Quantity inch36 = new Quantity(36.0, Unit.INCHES);
		assertEquals(yard1, inch36);
	}

	@Test
	public void testEquality_InchesToYard_EquivalentValue() {
		Quantity inch36 = new Quantity(36.0, Unit.INCHES);
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		assertEquals(inch36, yard1);
	}

	@Test
	public void testEquality_YardToFeet_NonEquivalentValue() {
		Quantity yard1 = new Quantity(1.0, Unit.YARD);
		Quantity feet2 = new Quantity(2.0, Unit.FEET);
		assertNotEquals(yard1, feet2);
	}

	@Test
	public void testEquality_CentimetersToInches_EquivalentValue() {
		Quantity cm1 = new Quantity(1.0, Unit.CENTIMETERS);
		Quantity inchValue = new Quantity(0.393701, Unit.INCHES);
		assertEquals(cm1, inchValue);
	}

	@Test
	public void testEquality_CentimetersToFeet_NonEquivalentValue() {
		Quantity cm1 = new Quantity(1.0, Unit.CENTIMETERS);
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		assertNotEquals(cm1, feet1);
	}

	@Test
	public void testEquality_MultiUnit_TransitiveProperty() {
		Quantity yard = new Quantity(1.0, Unit.YARD);
		Quantity feet = new Quantity(3.0, Unit.FEET);
		Quantity inches = new Quantity(36.0, Unit.INCHES);
		assertEquals(yard, feet);
		assertEquals(feet, inches);
		assertEquals(yard, inches);
	}

	@Test
	public void testEquality_NullUnit() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> new Quantity(1.0, null)
				);
	}

	@Test
	public void testEquality_YardSameReference() {
		Quantity yard = new Quantity(2.0, Unit.YARD);
		assertEquals(yard, yard);
	}

	@Test
	public void testEquality_YardNullComparison() {
		Quantity yard = new Quantity(2.0, Unit.YARD);
		assertNotEquals(yard, null);
	}

	@Test
	public void testEquality_CentimetersSameReference() {
		Quantity cm = new Quantity(2.0, Unit.CENTIMETERS);
		assertEquals(cm, cm);
	}

	@Test
	public void testEquality_CentimetersNullComparison() {
		Quantity cm = new Quantity(2.0, Unit.CENTIMETERS);
		assertNotEquals(cm, null);
	}

	@Test
	public void testEquality_AllUnits_ComplexScenario() {
		Quantity yards = new Quantity(2.0, Unit.YARD);
		Quantity feet = new Quantity(6.0, Unit.FEET);
		Quantity inches = new Quantity(72.0, Unit.INCHES);
		assertEquals(yards, feet);
		assertEquals(feet, inches);
		assertEquals(yards, inches);
	}

	@Test
	public void testEquality_CentimetersToCentimeters_SameValue() {
		Quantity cm2a = new Quantity(2.0, Unit.CENTIMETERS);
		Quantity cm2b = new Quantity(2.0, Unit.CENTIMETERS);
		assertEquals(cm2a, cm2b);
	}

	@Test
	public void testEquality_CentimetersToCentimeters_DifferentValue() {
		Quantity cm2 = new Quantity(2.0, Unit.CENTIMETERS);
		Quantity cm3 = new Quantity(3.0, Unit.CENTIMETERS);
		assertNotEquals(cm2, cm3);
	}

	@Test
	public void testEquality_InchesToCentimeters_EquivalentValue() {
		Quantity inchValue = new Quantity(0.393701, Unit.INCHES);
		Quantity cm1 = new Quantity(1.0, Unit.CENTIMETERS);
		assertEquals(inchValue, cm1);
	}

	@Test
	public void testEquality_DifferentClass() {
		Quantity yard = new Quantity(2.0, Unit.YARD);
		assertFalse(yard.equals("2.0"));
	}

	@Test
	public void testEquality_NaN() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> new Quantity(Double.NaN, Unit.FEET)
				);
	}

	@Test
	public void testEquality_Infinity() {
		assertThrows(
				IllegalArgumentException.class,
				() -> new Quantity(Double.POSITIVE_INFINITY, Unit.CENTIMETERS)
				);
	}

	@Test
	public void testEquality_DemonstrateLengthComparisonMethod() {
		boolean result = QuantityMeasurementApp.demonstrateLengthComparison(
				1.0, Unit.YARD, 
				36.0, Unit.INCHES
				);
		assertTrue(result);
	}

	@Test
	public void testConversion_FeetToInches() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(1.0, Unit.FEET, Unit.INCHES);
		Quantity expected = new Quantity(12.0, Unit.INCHES);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_InchesToFeet() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(24.0, Unit.INCHES, Unit.FEET);
		Quantity expected = new Quantity(2.0, Unit.FEET);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_YardsToInches() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(1.0, Unit.YARD, Unit.INCHES);
		Quantity expected = new Quantity(36.0, Unit.INCHES);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_InchesToYards() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(72.0, Unit.INCHES, Unit.YARD);
		Quantity expected = new Quantity(2.0, Unit.YARD);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_CentimetersToInches() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(2.54, Unit.CENTIMETERS, Unit.INCHES);
		Quantity expected = new Quantity(1.0, Unit.INCHES);
		assertTrue(result.equals(expected));
	}

	@Test
	public void testConversion_FeetToYards() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(6.0, Unit.FEET, Unit.YARD);
		Quantity expected = new Quantity(2.0, Unit.YARD);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_RoundTrip_PreservesValue() {
		Quantity original = new Quantity(3.0, Unit.FEET);
		Quantity converted = original.convertTo(Unit.INCHES).convertTo(Unit.FEET);
		assertTrue(original.equals(converted));
	}

	@Test
	public void testConversion_ZeroValue() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(0.0, Unit.FEET, Unit.INCHES);
		Quantity expected = new Quantity(0.0, Unit.INCHES);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_NegativeValue() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(-1.0, Unit.FEET, Unit.INCHES);
		Quantity expected = new Quantity(-12.0, Unit.INCHES);
		assertEquals(expected, result);
	}

	@Test
	public void testConversion_InvalidUnit_Throws() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> QuantityMeasurementApp.demonstrateLengthConversion(1.0, null, Unit.INCHES)
				);
	}

	@Test
	public void testConversion_NaNOrInfinite_Throws() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> new Quantity(Double.NaN, Unit.FEET)
				);
		assertThrows(
				IllegalArgumentException.class, 
				() -> new Quantity(Double.POSITIVE_INFINITY,Unit.INCHES)
				);
	}

	@Test
	public void testConversion_PrecisionTolerance() {
		double result = Quantity.convert(30.48, Unit.CENTIMETERS, Unit.FEET);
		double expected = 1.0;
		assertTrue(Math.abs(result - expected) < 1e-6, "Conversion should be within precision tolerance");
	}


	@Test
	public void testConversion_SameUnit() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthConversion(5.0, Unit.FEET, Unit.FEET);
		Quantity expected = new Quantity(5.0, Unit.FEET);
		assertEquals(expected, result);
	}

	@Test
	public void testAddition_SameUnit_FeetPlusFeet() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(2.0, Unit.FEET)
				);
		assertEquals(new Quantity(3.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_SameUnit_InchPlusInch() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(6.0, Unit.INCHES),
				new Quantity(6.0, Unit.INCHES)
				);
		assertEquals(new Quantity(12.0, Unit.INCHES), result);
	}

	@Test
	public void testAddition_CrossUnit_FeetPlusInches() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES)
				);
		assertEquals(new Quantity(2.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_CrossUnit_InchPlusFeet() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(12.0, Unit.INCHES),
				new Quantity(1.0, Unit.FEET)
				);
		assertEquals(new Quantity(24.0, Unit.INCHES), result);
	}

	@Test
	public void testAddition_CrossUnit_YardPlusFeet() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.YARD),
				new Quantity(3.0, Unit.FEET)
				);
		assertEquals(new Quantity(2.0, Unit.YARD), result);
	}

	@Test
	public void testAddition_CrossUnit_CentimeterPlusInch() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(2.54, Unit.CENTIMETERS),
				new Quantity(1.0, Unit.INCHES)
				);
		assertTrue(result.equals(new Quantity(5.08, Unit.CENTIMETERS)));
	}

	@Test
	public void testAddition_Commutativity() {
		Quantity a = new Quantity(1.0, Unit.FEET);
		Quantity b = new Quantity(12.0, Unit.INCHES);
		assertEquals(a.add(b), b.add(a).convertTo(Unit.FEET));
	}

	@Test
	public void testAddition_WithZero() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(0.0, Unit.INCHES)
				);
		assertEquals(new Quantity(5.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_NegativeValues() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(-2.0, Unit.FEET)
				);
		assertEquals(new Quantity (3.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_NullSecondOperand() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> QuantityMeasurementApp.demonstrateLengthAddition(new Quantity(1.0,Unit.FEET), null)
				);
	}

	@Test
	public void testAddition_LargeValues() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1e6, Unit.FEET),
				new Quantity(1e6, Unit.FEET)
				);
		assertEquals(new Quantity(2e6, Unit.FEET), result);
	}

	@Test
	public void testAddition_SmallValues() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(0.001, Unit.FEET),
				new Quantity(0.002, Unit.FEET)
				);
		assertTrue(result.equals(new Quantity(0.003, Unit.FEET)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Feet() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES),
				Unit.FEET
				);
		assertEquals(new Quantity(2.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Inches() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES),
				Unit.INCHES
				);
		assertEquals(new Quantity(24.0, Unit.INCHES), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Yards() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(12.0, Unit.INCHES),
				Unit.YARD
				);
		assertTrue(result.equals(new Quantity(0.666667, Unit.YARD)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Centimeters() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.INCHES),
				new Quantity(1.0, Unit.INCHES),
				Unit.CENTIMETERS
				);
		assertTrue(result.equals(new Quantity(5.079998, Unit.CENTIMETERS)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(2.0, Unit.YARD),
				new Quantity(3.0, Unit.FEET),
				Unit.YARD
				);
		assertEquals(new Quantity(3.0, Unit.YARD), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(2.0, Unit.YARD),
				new Quantity(3.0, Unit.FEET),
				Unit.FEET
				);
		assertEquals(new Quantity(9.0, Unit.FEET), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Commutativity() {
		Quantity a = new Quantity(1.0, Unit.FEET);
		Quantity b = new Quantity(12.0, Unit.INCHES);
		Quantity result1 = QuantityMeasurementApp.demonstrateLengthAddition(a, b, Unit.YARD);
		Quantity result2 = QuantityMeasurementApp.demonstrateLengthAddition(b, a, Unit.YARD);
		assertTrue(result1.equals(result2));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_WithZero() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(0.0, Unit.INCHES),
				Unit.YARD
				);
		assertTrue(result.equals(new Quantity(1.666667, Unit.YARD)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_NegativeValues() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(5.0, Unit.FEET),
				new Quantity(-2.0, Unit.FEET),
				Unit.INCHES
				);
		assertEquals(new Quantity(36.0, Unit.INCHES), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
		assertThrows(
				IllegalArgumentException.class, 
				() -> QuantityMeasurementApp.demonstrateLengthAddition(
						new Quantity(1.0, Unit.FEET),
						new Quantity(12.0, Unit.INCHES),
						null
						)
				);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1000.0, Unit.FEET),
				new Quantity(500.0, Unit.FEET),
				Unit.INCHES
				);
		assertEquals(new Quantity(18000.0, Unit.INCHES), result);
	}

	@Test
	public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(12.0, Unit.INCHES),
				new Quantity(12.0, Unit.INCHES),
				Unit.YARD
				);
		assertTrue(result.equals(new Quantity(0.666667, Unit.YARD)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
		Quantity result1 = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(1.0, Unit.FEET),
				new Quantity(1.0, Unit.YARD),
				Unit.INCHES
				);
		assertTrue(new Quantity(48.0, Unit.INCHES).equals(result1));

		Quantity result2 = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(2.54, Unit.CENTIMETERS),
				new Quantity(1.0, Unit.INCHES),
				Unit.FEET
				);
		assertTrue(result2.equals(new Quantity(0.166667, Unit.FEET)));
	}

	@Test
	public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
		Quantity result = QuantityMeasurementApp.demonstrateLengthAddition(
				new Quantity(0.1, Unit.FEET),
				new Quantity(0.2, Unit.FEET),
				Unit.INCHES
				);
		assertTrue(result.equals(new Quantity(3.6, Unit.INCHES)));
	}

	@Test
	public void testEquality_VerySmallValues_WithinEpsilon() {
		Quantity a = new Quantity(1e-9, Unit.INCHES);
		Quantity b = new Quantity(1.0000005e-9, Unit.INCHES);
		assertEquals(a, b);

		Quantity c = new Quantity(1e-8, Unit.FEET);
		Quantity d = new Quantity(1.2e-7, Unit.INCHES);
		assertEquals(c, d);

		Quantity e = new Quantity(1e-9, Unit.INCHES);
		Quantity f = new Quantity(1e-9 + 2e-6, Unit.INCHES);
		assertNotEquals(e, f);
	}

	@Test
	public void testHashCode_EqualObjectsHaveSameHashCode() {
		Quantity a1 = new Quantity(5.0, Unit.FEET);
		Quantity a2 = new Quantity(5.0, Unit.FEET);
		assertEquals(a1.hashCode(), a2.hashCode());

		Quantity b1 = new Quantity(1.0, Unit.YARD);
		Quantity b2 = new Quantity(36.0, Unit.INCHES);
		assertEquals(b1, b2);           // just to confirm equality
		assertEquals(b1.hashCode(), b2.hashCode());

		Quantity c1 = new Quantity(2.54, Unit.CENTIMETERS);
		Quantity c2 = new Quantity(1.0, Unit.INCHES);
		assertEquals(c1, c2);
		assertEquals(c1.hashCode(), c2.hashCode());

		Quantity d1 = new Quantity(1.0000003, Unit.FEET);
		Quantity d2 = new Quantity(1.0, Unit.FEET);
		assertNotEquals(d1, d2);
		assertNotEquals(d1.hashCode(), d2.hashCode());
	}

	@Test
	public void testEquality_SmallDifference_OutsideTolerance() {
		Quantity a = new Quantity(1.0000003, Unit.FEET);
		Quantity b = new Quantity(1.0, Unit.FEET);
		assertNotEquals(a, b);
	}

	@Test
	public void testEquality_SmallDifference_InsideTolerance() {
		Quantity a = new Quantity(1.00000008, Unit.FEET);
		Quantity b = new Quantity(1.0, Unit.FEET);
		assertEquals(a, b);
	}

	@Test
	public void testLengthUnitEnum_FeetConstant() {
		assertEquals(
				12.0, 
				Unit.FEET.getConversionFactor(),
				EPSILON
				);
	}

	@Test
	public void testLengthUnitEnum_InchesConstant() {
		assertEquals(
				1.0,
				Unit.INCHES.getConversionFactor(),
				EPSILON
				);
	}

	@Test
	public void testLengthUnitEnum_YardsConstant() {
		assertEquals(
				36.0,
				Unit.YARD.getConversionFactor(),
				EPSILON
				);
	}

	@Test
	public void testLengthUnitEnum_CentimetersConstant() {
		assertEquals(
				1.0 / 2.54,
				Unit.CENTIMETERS.getConversionFactor(),
				EPSILON
				);
	}

	@Test
	public void testConvertToBaseUnit_FeetToInches() {
		assertEquals(
				60.0,
				Unit.FEET.convertToBaseUnit(5.0),
				EPSILON
				);
	}

	@Test
	public void testConvertToBaseUnit_InchesToInches() {
		assertEquals(
				12.0,
				Unit.INCHES.convertToBaseUnit(12.0),
				EPSILON
				);
	}

	@Test
	public void testConvertToBaseUnit_YardsToInches() {
		assertEquals(
				36.0,
				Unit.YARD.convertToBaseUnit(1.0),
				EPSILON
				);
	}

	@Test
	public void testConvertToBaseUnit_CentimetersToInches() {
		assertEquals(
				12.0,
				Unit.CENTIMETERS.convertToBaseUnit(30.48),
				EPSILON
				);
	}

	@Test
	public void testConvertFromBaseUnit_InchesToFeet() {
		assertEquals(
				1.0,
				Unit.FEET.convertFromBaseUnit(12.0),
				EPSILON
				);
	}

	@Test
	public void testConvertFromBaseUnit_InchesToInches() {
		assertEquals(
				12.0,
				Unit.INCHES.convertFromBaseUnit(12.0),
				EPSILON
				);
	}

	@Test
	public void testConvertFromBaseUnit_InchesToYards() {
		assertEquals(
				1.0,
				Unit.YARD.convertFromBaseUnit(36.0),
				EPSILON
				);
	}

	@Test
	public void testConvertFromBaseUnit_InchesToCentimeters() {
		assertEquals(
				30.48,
				Unit.CENTIMETERS.convertFromBaseUnit(12.0),
				EPSILON
				);
	}

	@Test
	public void testQuantityLengthRefactored_Equality() {
		Quantity a = new Quantity(1.0, Unit.FEET);
		Quantity b = new Quantity(12.0, Unit.INCHES);

		assertTrue(a.equals(b));
	}

	@Test
	public void testQuantityLengthRefactored_ConvertTo() {
		Quantity result = new Quantity(1.0, Unit.FEET).convertTo(Unit.INCHES);

		assertEquals(new Quantity(12.0, Unit.INCHES), result);
	}

	@Test
	public void testQuantityLengthRefactored_Add() {
		Quantity result = new Quantity(1.0, Unit.FEET)
				.add(
						new Quantity(12.0, Unit.INCHES),
						Unit.FEET
						);

		assertEquals(new Quantity(2.0, Unit.FEET), result);
	}

	@Test
	public void testQuantityLengthRefactored_AddWithTargetUnit() {
		Quantity result = new Quantity(1.0, Unit.FEET)
				.add(
						new Quantity(12.0, Unit.INCHES),
						Unit.YARD
						);

		assertEquals(new Quantity(0.666667, Unit.YARD), result);
	}

	@Test
	public void testQuantityLengthRefactored_NullUnit() {
		assertThrows(
				IllegalArgumentException.class,
				() -> new Quantity(1.0, null)
				);
	}

	@Test
	public void testQuantityLengthRefactored_InvalidValue() {
		assertThrows(
				IllegalArgumentException.class,
				() -> new Quantity(Double.NaN, Unit.FEET)
				);
	}

	@Test
	public void testBackwardCompatibility_UC1EqualityTests() {
		assertEquals(
				new Quantity(3.0, Unit.FEET),
				new Quantity(36.0, Unit.INCHES)
				);
	}

	@Test
	public void testBackwardCompatibility_UC5ConversionTests() {
		Quantity result = new Quantity(1.0,Unit.YARD)
				.convertTo(Unit.FEET);

		assertEquals(new Quantity(3.0, Unit.FEET), result);
	}

	@Test
	public void testBackwardCompatibility_UC6AdditionTests() {
		Quantity result = new Quantity(2.0,Unit.FEET)
				.add(new Quantity(24.0, Unit.INCHES));

		assertEquals(new Quantity(4.0, Unit.FEET), result);
	}

	@Test
	public void testBackwardCompatibility_UC7AdditionWithTargetUnitTests() {
		Quantity result = new Quantity(2.0, Unit.FEET)
				.add(
						new Quantity(24.0, Unit.INCHES),
						Unit.INCHES
						);

		assertEquals(new Quantity(48.0, Unit.INCHES), result);
	}

	@Test
	public void testArchitecturalScalability_MultipleCategories() {
		assertDoesNotThrow(() -> Unit.valueOf("FEET"));
	}

	@Test
	public void testRoundTripConversion_RefactoredDesign() {
		Quantity original = new Quantity(5.0, Unit.FEET);
		Quantity converted = original.convertTo(Unit.CENTIMETERS)
				.convertTo(Unit.FEET);

		assertEquals(original, converted);
	}

	@Test
	public void testUnitImmutability() {
		assertTrue(Unit.FEET instanceof Enum);
		assertTrue(Unit.INCHES instanceof Enum);
		assertTrue(Unit.YARD instanceof Enum);
		assertTrue(Unit.CENTIMETERS instanceof Enum);
	}
}