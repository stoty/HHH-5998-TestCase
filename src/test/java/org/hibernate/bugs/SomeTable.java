package org.hibernate.bugs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SomeTable {
	
	@Id
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
