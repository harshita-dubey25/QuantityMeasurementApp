package com.apps;

public class Quantity {
	private double value;
	private Unit unit;
	
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
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Quantity that = (Quantity) obj;

		return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
	}
	
	public static void main(String[] args) {
		Quantity length1 = new Quantity(1.0, Unit.FEET);
		Quantity length2 = new Quantity(12.0, Unit.INCHES);
		System.out.println("Are lengths equal? " + length1.equals(length2)); // true
	}
}
