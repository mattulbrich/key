package de.hentschel.visualdbc.datasource.key.model.event;

import java.util.EventObject;

import de.hentschel.visualdbc.datasource.key.model.KeyConnection;
import de.hentschel.visualdbc.datasource.key.model.KeyProof;

/**
 * An event thrown from a {@link KeyConnection}.
 * @author Martin Hentschel
 */
public class KeYConnectionEvent extends EventObject {
   /**
    * Generated UID. 
    */
   private static final long serialVersionUID = 8617858896279729196L;

   /**
    * The {@link KeyProof}.
    */
   private KeyProof proof;
   
   /**
    * Constructor.
    * @param source The {@link KeyConnection}.
    * @param proof The {@link KeyProof}.
    */
   public KeYConnectionEvent(KeyConnection source, KeyProof proof) {
      super(source);
      this.proof = proof;
   }

   /**
    * Returns the {@link KeyProof}.
    * @return The {@link KeyProof}.
    */
   public KeyProof getProof() {
      return proof;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public KeyConnection getSource() {
      return (KeyConnection)super.getSource();
   }
}