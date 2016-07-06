/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.isanteplusopenmrsintro.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.isanteplusopenmrsintro.api.IsantePlusOmrsIntroService;
import org.openmrs.module.isanteplusopenmrsintro.api.db.IsantePlusOmrsIntroDAO;

/**
 * It is a default implementation of {@link IsantePlusOmrsIntroService}.
 */
public class IsantePlusOmrsIntroServiceImpl extends BaseOpenmrsService implements IsantePlusOmrsIntroService {

	protected final Log log = LogFactory.getLog(this.getClass());

	private IsantePlusOmrsIntroDAO dao;

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(IsantePlusOmrsIntroDAO dao) {
		this.dao = dao;
	}

	/**
	 * @return the dao
	 */
	public IsantePlusOmrsIntroDAO getDao() {
		return dao;
	}

	@Override
	public List<Double> getPatientWeights(Patient patient) {
		// weight concept 5089
		List<Double> weightValues = new ArrayList<Double>();
		Integer weightConceptId = StringUtils
				.isNotBlank(Context.getAdministrationService().getGlobalProperty("concept.weight"))
						? Integer.parseInt(Context.getAdministrationService().getGlobalProperty("concept.weight"))
						: 5089;
		Concept weight = Context.getConceptService().getConcept(weightConceptId);

		for (Obs obs : Context.getObsService().getObservations(patient, weight, false)) {
			if (obs != null) {
				weightValues.add(obs.getValueNumeric());
			}
		}
		return weightValues;
	}
}