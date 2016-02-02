package com.blabs.records.utilities.entity.behavior;

import java.util.Date;

/**
 * Entities implementing these interface have its creation and last update registered;
 * 
 * @author biasao
 */
public interface Timestampable {
	Date getCreation();
	void setCreation(Date creation);
	Date getLastUpdate();
	void setLastUpdate(Date lastUpdate);
}
