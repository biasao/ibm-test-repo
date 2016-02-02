package com.blabs.records.utilities.entity.behavior.impl;

import java.util.Date;

import com.blabs.records.utilities.entity.behavior.Identifiable;
import com.blabs.records.utilities.entity.behavior.Timestampable;

public abstract class AbstractSimpleCRUDEntity<PK> implements Timestampable, Identifiable<PK> {
	
	public abstract PK getId();
	
	public abstract Date getCreation();
	
	public abstract void setCreation(Date creation);	
	
	public abstract Date getLastUpdate();	
	
	public abstract void setLastUpdate(Date lastUpdate);

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSimpleCRUDEntity other = (AbstractSimpleCRUDEntity) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
