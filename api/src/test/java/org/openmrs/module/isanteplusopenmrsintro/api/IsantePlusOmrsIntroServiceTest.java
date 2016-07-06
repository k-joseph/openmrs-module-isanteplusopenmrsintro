/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.isanteplusopenmrsintro.api;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * Tests {@link ${${module-name-no-spaces}Service}}.
 */
public class IsantePlusOmrsIntroServiceTest extends BaseModuleContextSensitiveTest {

	@Test
	public void shouldSetupContext() {
		assertNotNull(Context.getService(IsantePlusOmrsIntroService.class));
	}

	@Test
	public void testGetPatientWeights() {
		System.out.println(Context.getService(IsantePlusOmrsIntroService.class)
				.getPatientWeights(Context.getPatientService().getPatient(1)));
	}
}
