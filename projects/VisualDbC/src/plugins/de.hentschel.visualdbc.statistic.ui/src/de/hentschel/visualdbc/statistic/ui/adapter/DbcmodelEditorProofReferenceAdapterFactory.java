package de.hentschel.visualdbc.statistic.ui.adapter;

import java.util.List;

import org.eclipse.ui.IEditorPart;

import de.hentschel.visualdbc.dbcmodel.presentation.DbcmodelEditor;
import de.hentschel.visualdbc.statistic.ui.control.IProofReferenceProvider;
import de.hentschel.visualdbc.statistic.ui.util.StatisticUtil;
import de.hentschel.visualdbc.statistic.ui.view.DbcProofReferencesViewPart;
import de.hentschel.visualdbc.statistic.ui.view.IProofReferencesViewPart;

/**
 * Converts a given {@link DbcmodelEditor} into an {@link IProofReferencesViewPart}.
 * @author Martin Hentschel
 */
public class DbcmodelEditorProofReferenceAdapterFactory extends AbstractProofReferenceAdapterFactory {
   /**
    * {@inheritDoc}
    */
   @SuppressWarnings("rawtypes")
   @Override
   public Object getAdapter(Object adaptableObject, Class adapterType) {
      if (adaptableObject instanceof IEditorPart) {
         final DbcmodelEditor editor = adaptableObject instanceof DbcmodelEditor ? (DbcmodelEditor)adaptableObject : null;
         IProofReferenceProvider provider = new IProofReferenceProvider() {
            @Override
            public List<?> extractElementsToShow(List<?> elements) {
               return elements;
            }

            @Override
            public void select(List<?> toSelect) {
               StatisticUtil.select(editor, toSelect);
            }
         };
         return new DbcProofReferencesViewPart((IEditorPart)adaptableObject, provider);
      }
      else {
         return null;
      }
   }
}