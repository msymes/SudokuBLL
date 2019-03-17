package pkgEnum;

public enum ePuzzleViolation {
	DupRow, DupCol, DupRegion, InvalidValue, MissingZero;

	private ePuzzleViolation() {
	}

	public static ePuzzleViolation valueOf​(String name) {
		ePuzzleViolation valueOf = null;
		for (ePuzzleViolation violation : ePuzzleViolation.values()) {
			if (violation.toString() == name) {
				valueOf = violation;
				break;
			}
		}
		return valueOf;
	}
	/* the method for values() is given implicitly so we dont need it*/
}