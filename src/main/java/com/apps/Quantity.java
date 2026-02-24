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

	// Add two lengths, result in unit of first operand
	public Quantity add(Quantity thatLength) {
		if (thatLength == null) {
			throw new IllegalArgumentException("Operand cannot be null");
		}
		double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
		double sumInTargetUnit = convertFromBaseToTargetUnit(sumInBase, this.unit);
		return new Quantity(sumInTargetUnit, this.unit);
	}
	
	public Quantity add(Quantity other, Unit targetUnit) {
	    if (other == null) {
	        throw new IllegalArgumentException("Operand cannot be null");
	    }
	    if (targetUnit == null) {
	        throw new IllegalArgumentException("Target unit cannot be null");
	    }
	    if(!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
	    	throw new IllegalArgumentException("Values must be a finite number");
	    }
 	    return addAndConvert(other, targetUnit);
	}
	
	private Quantity addAndConvert(Quantity other, Unit targetUnit) {
	    double sumInBase = this.convertToBaseUnit() + other.convertToBaseUnit();
	    double sumInTargetUnit = convertFromBaseToTargetUnit(sumInBase, targetUnit);
	    return new Quantity(sumInTargetUnit, targetUnit);
	}
	
	// Helper: convert from base unit (inches) to target unit
	private double convertFromBaseToTargetUnit(double lengthInInches, Unit targetUnit) {
		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}
		double convertedValue = lengthInInches / targetUnit.getConversionFactor();
		return Math.round(convertedValue * 1000000.0) / 1000000.0;
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

		System.out.println("Add 1 Foot + 12 Inches = " + length1.add(length2));
		System.out.println("Add 12 Inches + 1 Foot = " + length2.add(length1));
		System.out.println("Add 1 Yard + 3 Feet = " + length3.add(new Quantity(3.0, Unit.FEET)));
		System.out.println("Add 36 Inches + 1 Yard = " + length4.add(length3));
		System.out.println("Add 2.54 cm + 1 Inch = " + new Quantity(2.54, Unit.CENTIMETERS).add(new Quantity(1.0, Unit.INCHES))); 
		System.out.println("Add 5 Feet + 0 Inches = " + new Quantity(5.0, Unit.FEET).add(new Quantity(0.0, Unit.INCHES)));
		System.out.println("Add 5 Feet + (-2 Feet) = " + new Quantity(5.0, Unit.FEET).add(new Quantity(-2.0, Unit.FEET)));
		System.out.println("Add Large Values: " + new Quantity(1e6, Unit.FEET).add(new Quantity(1e6, Unit.FEET)));
		System.out.println("Add Small Values: " + new Quantity(0.001, Unit.FEET).add(new Quantity(0.002, Unit.FEET)));
		
		Quantity result = new Quantity(1.0, Unit.FEET).add(new Quantity(12.0, Unit.INCHES), Unit.FEET);
	    System.out.println("Add (1.0 FEET, 12.0 INCHES, FEET) = " + result);

	    result = new Quantity(1.0, Unit.FEET).add(new Quantity(12.0, Unit.INCHES), Unit.INCHES);
	    System.out.println("Add (1.0 FEET, 12.0 INCHES, INCHES) = " + result);

	    result = new Quantity(1.0, Unit.FEET).add(new Quantity(12.0, Unit.INCHES), Unit.YARD);
	    System.out.println("Add (1.0 FEET, 12.0 INCHES, YARDS) = " + result);

	    result = new Quantity(1.0, Unit.YARD).add(new Quantity(3.0, Unit.FEET), Unit.YARD);
	    System.out.println("Add (1.0 YARDS, 3.0 FEET, YARDS) = " + result);

	    result = new Quantity(36.0, Unit.INCHES).add(new Quantity(1.0, Unit.YARD), Unit.FEET);
	    System.out.println("Add (36.0 INCHES, 1.0 YARDS, FEET) = " + result);

	    result = new Quantity(2.54, Unit.CENTIMETERS).add(new Quantity(1.0, Unit.INCHES), Unit.CENTIMETERS);
	    System.out.println("Add (2.54 CM, 1.0 INCH, CM) = " + result);

	    result = new Quantity(5.0, Unit.FEET).add(new Quantity(0.0, Unit.INCHES), Unit.YARD);
	    System.out.println("Add (5.0 FEET, 0.0 INCHES, YARDS) = " + result);

	    result = new Quantity(5.0, Unit.FEET).add(new Quantity(-2.0, Unit.FEET), Unit.INCHES);
	    System.out.println("Add (5.0 FEET, -2.0 FEET, INCHES) = " + result);
	}

}
