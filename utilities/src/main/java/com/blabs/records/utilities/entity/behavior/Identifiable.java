package com.blabs.records.utilities.entity.behavior;

/**
 * Entities implementing these interface are identified by an id attribute.
 * 
 * @author biasao
 */
public interface Identifiable<T> {
	T getId();
}
