/*******************************************************************************
 * Copyright (c) 2011 Martin Hentschel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Martin Hentschel - initial API and implementation
 *******************************************************************************/

package org.key_project.key4eclipse.util.test.suite.swtbot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.key_project.key4eclipse.util.test.testcase.swtbot.SWTBotKeYUtilTest;
import org.key_project.key4eclipse.util.test.testcase.swtbot.SWTBotLoggerTest;

/**
 * Run all contained JUnit 4 test cases that requires SWT Bot.
 * @author Martin Hentschel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SWTBotKeYUtilTest.class,
    SWTBotLoggerTest.class
})
public class SWTBotAllUtilTests {
}