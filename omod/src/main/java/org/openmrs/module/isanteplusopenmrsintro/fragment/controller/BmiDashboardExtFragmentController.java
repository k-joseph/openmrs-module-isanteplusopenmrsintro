package org.openmrs.module.isanteplusopenmrsintro.fragment.controller;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.isanteplusopenmrsintro.api.IsantePlusOmrsIntroService;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class BmiDashboardExtFragmentController {
	protected final Log log = LogFactory.getLog(getClass());

	public void controller(FragmentModel model, @FragmentParam("patientId") Patient patient) {
		DecimalFormat df = new DecimalFormat("###.#" ); 
		
		Double heights = Context.getService(IsantePlusOmrsIntroService.class).getPatientHeights(patient);
		JSONArray weights = Context.getService(IsantePlusOmrsIntroService.class).getPatientWeights(patient);
		Double[] weightsValues = new Double[weights.length()];
		String[] bmiLabels = new String[weights.length()];
		Double[] bmiValues = new Double[weights.length()];
		for (int i = 0; i < weights.length(); i++) {
			weightsValues[i] = weights.getJSONObject(i).getDouble("weight");
			    bmiValues[i] = Double.parseDouble(df.format(weightsValues[i] / ((heights/100) * (heights/100))));
				bmiLabels[i] = weights.getJSONObject(i).getString("date");
			
		
		}
		
		model.addAttribute("bmiLabels", bmiLabels);
		model.addAttribute("bmiValues",  bmiValues);
	}
	
	
}
