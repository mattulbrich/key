package de.uka.ilkd.key.pp;

import de.uka.ilkd.key.logic.SequentFormula;


/**
 * One element of a sequent as delivered by SequentPrintFilter
 */

public interface SequentPrintFilterEntry {

    /**
     * Formula to display
     */
    SequentFormula getFilteredFormula();

    /**
     * Original formula from sequent
     */
    SequentFormula getOriginalFormula();

}
