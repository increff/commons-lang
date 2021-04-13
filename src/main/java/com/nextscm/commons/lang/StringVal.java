package com.nextscm.commons.lang;

public class StringVal {

	private String s;

	public StringVal(String value) {
		this.s = value;
	}

	public String value() {
		return s;
	}

	@Override
	public int hashCode() {
		return s.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || !(o instanceof StringVal)) {
			return false;
		}
		StringVal cc = (StringVal) o;
		return s.equals(cc.value());
	}
}
