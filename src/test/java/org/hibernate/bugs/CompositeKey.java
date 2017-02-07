package org.hibernate.bugs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private int keyOne;

	@Column
	private int keyTwo;

	public int getKeyOne() {
		return keyOne;
	}

	public void setKeyOne(int keyOne) {
		this.keyOne = keyOne;
	}

	public int getKeyTwo() {
		return keyTwo;
	}

	public void setKeyTwo(int keyTwo) {
		this.keyTwo = keyTwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + keyOne;
		result = prime * result + keyTwo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		if (keyOne != other.keyOne)
			return false;
		if (keyTwo != other.keyTwo)
			return false;
		return true;
	}
	
	
}
