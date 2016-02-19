package changeassistant.peers;

import java.io.Serializable;

public class SourceCodeRange implements Serializable, Comparable {

	public static SourceCodeRange DefaultRange = new SourceCodeRange(0, 0);

	private static final long serialVersionUID = 1L;
	public int startPosition;
	public int length;

	public static SourceCodeRange getDefaultScr() {
		return new SourceCodeRange(0, 0);
	}

	public SourceCodeRange(SourceCodeRange scr) {
		this.startPosition = scr.startPosition;
		this.length = scr.length;
	}

	public SourceCodeRange(int startPosition, int length) {
		this.startPosition = startPosition;
		this.length = length;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof SourceCodeRange))
			return false;
		SourceCodeRange other = (SourceCodeRange) obj;
		if (this.startPosition != other.startPosition)
			return false;
		if (this.length != other.length)
			return false;
		return true;
	}

	public int hashCode() {
		return this.startPosition * 1000 + this.length;
	}

	public boolean isInside(SourceCodeRange other) {
		return startPosition >= other.startPosition
				&& startPosition + length <= other.startPosition + other.length;
	}

	public String toString() {
		return "start position = " + this.startPosition + "  length = "
				+ this.length;
	}

	/**
	 * This method does not handle the containment relations between two objects
	 */
	@Override
	public int compareTo(Object obj) {
		SourceCodeRange other = (SourceCodeRange) obj;
		if (this.startPosition < other.startPosition
				&& this.startPosition + this.length < other.startPosition
						+ other.length)
			return -1;
		if (this.startPosition > other.startPosition
				&& this.startPosition + this.length > other.startPosition
						+ other.length)
			return 1;
		return 0;
	}
}
