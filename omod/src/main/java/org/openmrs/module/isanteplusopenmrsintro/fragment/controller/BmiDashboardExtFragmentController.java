package org.openmrs.module.isanteplusopenmrsintro.fragment.controller;

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
		//JSONArray bmi = Context.getService(IsantePlusOmrsIntroService.class).getPatientWeights(patient);
		
		/*String[] bmiLabels = new String[bmi.length()];
		Double[] bmiValues = new Double[bmi.length()];
		Double[] weightsValues = new Double[bmi.length()];
		Double[] heightsValues = new Double[bmi.length()];
		for (int i = 0; i < bmi.length(); i++) {
			    weightsValues[i] = bmi.getJSONObject(i).getDouble("weight");
				heightsValues[i] = bmi.getJSONObject(i).getDouble("height");
				bmiValues[i] = weightsValues[i] / ((heightsValues[i]/100) * (heightsValues[i]/100));
				bmiLabels[i] = bmi.getJSONObject(i).getString("date");
			
		}*/
		JSONArray heights = Context.getService(IsantePlusOmrsIntroService.class).getPatientHeights(patient);
		JSONArray weights = Context.getService(IsantePlusOmrsIntroService.class).getPatientWeights(patient);
		Double[] weightsValues = new Double[weights.length()];
		Double[] heightsValues = new Double[heights.length()];
		//String[] weightsLabels = new String[weights.length()];
		//String[] heightsLabels = new String[heights.length()];
		String[] bmiLabels = null;
		Double[] bmiValues = null;
		for (int i = 0; i < weights.length(); i++) {
			if(heights.getJSONObject(i).getString("date")==weights.getJSONObject(i).getString("date"))
			{
			    weightsValues[i] = weights.getJSONObject(i).getDouble("weight");
				heightsValues[i] = heights.getJSONObject(i).getDouble("height");
				bmiValues[i] = weightsValues[i] / ((heightsValues[i]/100) * (heightsValues[i]/100));
				bmiLabels[i] = heights.getJSONObject(i).getString("date");
			}
		
		}
		
		model.addAttribute("bmiLabels", bmiLabels);
		model.addAttribute("bmiValues", bmiValues);
	}
	
	
}
