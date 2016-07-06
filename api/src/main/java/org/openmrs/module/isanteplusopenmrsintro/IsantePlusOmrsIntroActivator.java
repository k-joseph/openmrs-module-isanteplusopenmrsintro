/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.isanteplusopenmrsintro;


import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.ModuleActivator;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class IsantePlusOmrsIntroActivator implements ModuleActivator {
	
	protected Log log = LogFactory.getLog(getClass());
		
	/**
	 * @see ModuleActivator${symbol_pound}willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing iSantePlus OpenMRS Introduction Module");
	}
	
	/**
	 * @see ModuleActivator${symbol_pound}contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("iSantePlus OpenMRS Introduction Module refreshed");
	}
	
	/**
	 * @see ModuleActivator${symbol_pound}willStart()
	 */
	public void willStart() {
		log.info("Starting iSantePlus OpenMRS Introduction Module");
	}
	
	/**
	 * @see ModuleActivator${symbol_pound}started()
	 */
	public void started() {
		log.info("iSantePlus OpenMRS Introduction Module started");
	}
	
	/**
	 * @see ModuleActivator${symbol_pound}willStop()
	 */
	public void willStop() {
		log.info("Stopping iSantePlus OpenMRS Introduction Module");
	}
	
	/**
	 * @see ModuleActivator${symbol_pound}stopped()
	 */
	public void stopped() {
		log.info("iSantePlus OpenMRS Introduction Module stopped");
	}
		
}
