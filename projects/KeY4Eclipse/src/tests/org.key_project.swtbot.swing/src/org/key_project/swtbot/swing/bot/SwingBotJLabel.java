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

package org.key_project.swtbot.swing.bot;

import java.awt.Component;

import javax.swing.JLabel;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;

/**
 * <p>
 * This represents a {@link JLabel} {@link Component}.
 * </p>
 * <p>
 * The class structure (attributes, methods, visibilities, ...) is oriented
 * on the implementation of {@link SWTBotLabel}.
 * </p>
 * @author Martin Hentschel
 */
public class SwingBotJLabel extends AbstractSwingBotComponent<JLabel> {
   /**
    * Constructs an instance of this object with the given {@link JLabel}.
    * @param component The given {@link JLabel}.
    * @throws WidgetNotFoundException Is thrown when the given {@link Component} is {@code null}.
    */
   public SwingBotJLabel(JLabel component) throws WidgetNotFoundException {
      super(component);
   }
   
   /**
    * Returns the shown text.
    * @return The shown text.
    */
   public String getText() {
       return component.getText();
   }
}