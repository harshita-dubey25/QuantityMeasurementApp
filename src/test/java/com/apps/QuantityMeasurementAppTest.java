package com.apps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

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
}