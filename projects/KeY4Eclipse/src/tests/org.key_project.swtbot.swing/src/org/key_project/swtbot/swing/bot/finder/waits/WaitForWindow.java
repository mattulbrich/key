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

package org.key_project.swtbot.swing.bot.finder.waits;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.waits.WaitForObjectCondition;
import org.hamcrest.Matcher;

/**
 * <p>
 * An {@link ICondition} that waits for a {@link Window}.
 * </p>
 * <p>
 * The class structure (attributes, methods, visibilities, ...) is oriented
 * on the implementation of {@link org.eclipse.swtbot.swt.finder.waits.WaitForShell}.
 * </p>
 * @author Martin Hentschel
 */
public class WaitForWindow<T extends Window> extends WaitForObjectCondition<T> {
   /**
    * Constructor.
    * @param matcher The matchers to use.
    */
   WaitForWindow(Matcher<T> matcher) {
      super(matcher);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getFailureMessage() {
      return "Could not find Window matching: " + matcher;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   @SuppressWarnings("unchecked")
   protected List<T> findMatches() {
      Window[] windows = Window.getWindows();
      ArrayList<T> matchingFrames = new ArrayList<T>();
      for (Window window : windows) {
         if (matcher.matches(window)) {
            matchingFrames.add((T)window);
         }
      }
      return matchingFrames;
   }
}