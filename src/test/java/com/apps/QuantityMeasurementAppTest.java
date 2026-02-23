package com.apps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

	@Test
	public void testEquality_FeetToFeet_SameValue() {
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		Quantity feet2 = new Quantity(1.0, Unit.FEET);
		assertEquals(feet1, feet2);
	}

	@Test
	public void testEquality_InchToInch_SameValue() {
		Quantity inch1 = new Quantity(1.0, Unit.INCHES);
		Quantity inch2 = new Quantity(1.0, Unit.INCHES);
		assertEquals(inch1, inch2);
	}

	@Test
	public void testEquality_InchToFeet_EquivalentValue() {
		Quantity inch12 = new Quantity(12.0, Unit.INCHES);
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		assertEquals(inch12, feet1);
	}

	@Test
	public void testEquality_FeetToFeet_DifferentValue() {
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		Quantity feet2 = new Quantity(2.0, Unit.FEET);
		assertNotEquals(feet1, feet2);
	}

	@Test
	public void testEquality_InchToInch_DifferentValue() {
		Quantity inch1 = new Quantity(1.0, Unit.INCHES);
		Quantity inch2 = new Quantity(2.0, Unit.INCHES);
		assertNotEquals(inch1, inch2);
	}

	@Test
	public void testEquality_SameReference() {
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		assertEquals(feet1, feet1);
	}

	@Test
	public void testEquality_NullComparison() {
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		assertNotEquals(feet1, null);
	}

	@Test
	public void testEquality_InvalidUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Quantity(1.0, null);
		});
	}

	@Test
	public void testEquality_NullUnit() {
		Quantity feet1 = new Quantity(1.0, Unit.FEET);
		Quantity invalid = null;
		assertNotEquals(feet1, invalid);
	}

	@Test
	public void testEquality_DifferentClass() {
		Quantity l1 = new Quantity(1.0, Unit.FEET);
		assertFalse(l1.equals("1.0"));
	}

	@Test
	public void testEquality_NaN() {
		assertThrows(IllegalArgumentException.class, () -> new Quantity(Double.NaN, Unit.FEET));
	}

	@Test
	public void testEquality_Infinity() {
		assertThrows(IllegalArgumentException.class,
				() -> new Quantity(Double.POSITIVE_INFINITY, Unit.INCHES));
	}
}