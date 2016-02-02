package com.blabs.records.utilities.entity.behavior;

/**
 * Entities implementing these interface are activated or deleted logically. The entity data is kept, and its state
 * is only controlled by @boolean active attribute. 
 * 
 * @author biasao
 */
public interface Activable {
	Boolean isActive();
	Boolean setActive();
}
