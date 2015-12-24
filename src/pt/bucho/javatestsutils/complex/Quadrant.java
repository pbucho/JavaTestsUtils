package pt.bucho.javatestsutils.complex;

public enum Quadrant {

	FIRST, SECOND, THIRD, FOURTH, POSITIVE_REAL_AXIS, NEGATIVE_REAL_AXIS, POSITIVE_IMAGINARY_AXIS, NEGATIVE_IMAGINARY_AXIS, ORIGIN;
	
	/**
	 * Returns the numeric value of the corresponding quadrant or zero for the origin.
	 * Returns null for the axes
	 * @return the numeric value of the quadrant, zero for the origin or null for the axes 
	 */
	public Integer getValue() {
		if (this == FIRST) {
			return 1;
		}
		if (this == SECOND) {
			return 2;
		}
		if (this == THIRD) {
			return 3;
		}
		if (this == FOURTH) {
			return 4;
		}
		if (this == ORIGIN) {
			return 0;
		}
		return null;
	}
	
}
