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
	
	// Private helper method to compare two Lengths
		private boolean compare(Quantity that) {
			double thisValue = this.convertToBaseUnit();
			double thatValue = that.convertToBaseUnit();
			return Math.abs(thisValue - thatValue) < EPSILON;
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
		return compare(that);
	}
	
	@Override
	public String toString() {
		return String.format("%.2f %s", value, unit);
	}

	// Convert this length to the specified target unit
	public Quantity convertTo(Unit targetUnit) {
		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}
		double baseValue = this.convertToBaseUnit();
		double convertedValue = baseValue / targetUnit.getConversionFactor();

		convertedValue = Math.round(convertedValue * 100.0) / 100.0;
		return new Quantity(convertedValue, targetUnit);
	}
	
	public static double convert(double value, Unit source, Unit target) {
	    if (source == null || target == null) {
	        throw new IllegalArgumentException("Units cannot be null");
	    }
	    if (!Double.isFinite(value)) {
	        throw new IllegalArgumentException("Value must be a finite number");
	    }

	    double baseValue = value * source.getConversionFactor();
	    double convertedValue = baseValue / target.getConversionFactor();
	    return Math.round(convertedValue * 100.0) / 100.0;
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
		
		
		System.out.println("Convert 3 Feet to Inches: " + length1.convertTo(Unit.INCHES));
		System.out.println("Convert 2 Yards to Inches: " + length3.convertTo(Unit.INCHES));
		System.out.println("Convert 30.48 cm to Feet: " + new Quantity(30.48, Unit.CENTIMETERS).convertTo(Unit.FEET));
		System.out.println("Convert 72 Inches to Yards: " + new Quantity(72.0, Unit.INCHES).convertTo(Unit.YARD));
		System.out.println("Convert 0 Feet to Inches: " + new Quantity(0.0, Unit.FEET).convertTo(Unit.INCHES));
		System.out.println("Convert -1 Foot to Inches: " + new Quantity(-1.0, Unit.FEET).convertTo(Unit.INCHES));
	}
}
