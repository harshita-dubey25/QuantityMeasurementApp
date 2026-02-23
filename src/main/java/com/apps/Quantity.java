package com.apps;

public class Quantity {
	private double value;
	private Unit unit;
	private static final double EPSILON =  1e-3;
	
	public Quantity(double value, Unit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("value must be a finite number");
		}
		
		this.value = value;
		this.unit = unit;
	}
	
	private double convertToBaseUnit() {
		return value * unit.getConversionFactor();
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Quantity that = (Quantity) o;
		double thisValue = this.convertToBaseUnit();
		double thatValue = that.convertToBaseUnit();
		return Math.abs(thisValue - thatValue) < EPSILON;
	}
	
	@Override
	public int hashCode() {
	    long normalized =
	        Math.round(convertToBaseUnit() / EPSILON);
	    return Long.hashCode(normalized);
	}
	
	public static void main(String[] args) {
		Quantity length1 = new Quantity(1.0, Unit.FEET);
		Quantity length2 = new Quantity(12.0, Unit.INCHES);
		System.out.println("Are lengths equal? " + length1.equals(length2)); // true
		
		Quantity length3 = new Quantity(1.0, Unit.YARD);
		Quantity length4 = new Quantity(36.0, Unit.INCHES);
		System.out.println("Are lengths equal? " + length3.equals(length4)); // true
		
		Quantity length5 = new Quantity(100.0, Unit.CENTIMETERS);
		Quantity length6 = new Quantity(39.3701, Unit.INCHES);
		System.out.println("Are lengths equal? " + length5.equals(length6)); // true
	}
}
