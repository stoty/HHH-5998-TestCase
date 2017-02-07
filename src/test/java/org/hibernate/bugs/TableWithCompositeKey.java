package org.hibernate.bugs;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TableWithCompositeKey {

	@EmbeddedId
	private CompositeKey id;

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}
	
	
}
