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

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openmrs.Concept;
import org.openmrs.ConceptNumeric;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.ConceptService;
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
	public JSONArray getPatientWeights(Patient patient) {
		// weight concept 5089
		JSONArray weightsJson = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Integer weightConceptId = StringUtils
				.isNotBlank(Context.getAdministrationService().getGlobalProperty("concept.weight"))
						? Integer.parseInt(Context.getAdministrationService().getGlobalProperty("concept.weight"))
						: 5089;
		Concept weight = Context.getConceptService().getConcept(weightConceptId);

		for (Obs obs : Context.getObsService().getObservations(patient, weight, false)) {
			if (obs != null) {
				JSONObject json = new JSONObject();

				json.put("weight", obs.getValueNumeric());
				json.put("date", obs.getDateChanged() == null ? sdf.format(obs.getDateCreated())
						: sdf.format(obs.getDateChanged()));
				weightsJson.put(json);
			}
		}
		return weightsJson;
	}
	@Override
	public Double getPatientHeights(Patient patient) {
		
		ConceptService cs = Context.getConceptService();
		Obs latestHeight = null;
		Integer heightConceptId = StringUtils
				.isNotBlank(Context.getAdministrationService().getGlobalProperty("concept.height"))
						? Integer.parseInt(Context.getAdministrationService().getGlobalProperty("concept.height"))
						: 5090;
		Concept height = Context.getConceptService().getConcept(heightConceptId);
		
		for (Obs obs : Context.getObsService().getObservations(patient,height, false)) {
			if (obs != null) {
				ConceptNumeric heightConcept = null;
				heightConcept = cs.getConceptNumeric(cs.getConcept(Integer.valueOf(heightConceptId))
					        .getConceptId());
				
				if (obs.getConcept().equals(heightConcept)
				        && (latestHeight == null || obs.getObsDatetime().compareTo(
				            latestHeight.getObsDatetime()) > 0)) {
					latestHeight = obs;
				}
				
				}
			}
		Double heightValues = latestHeight.getValueNumeric();
		return heightValues;
	}
}
