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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hentschel.visualdbc.dbcmodel.provider;

import de.hentschel.visualdbc.dbcmodel.util.DbcmodelAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DbcmodelItemProviderAdapterFactory extends DbcmodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
   /**
    * This keeps track of the root adapter factory that delegates to this adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ComposedAdapterFactory parentAdapterFactory;

   /**
    * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected IChangeNotifier changeNotifier = new ChangeNotifier();

   /**
    * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected Collection<Object> supportedTypes = new ArrayList<Object>();

   /**
    * This constructs an instance.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public DbcmodelItemProviderAdapterFactory() {
      supportedTypes.add(IEditingDomainItemProvider.class);
      supportedTypes.add(IStructuredItemContentProvider.class);
      supportedTypes.add(ITreeItemContentProvider.class);
      supportedTypes.add(IItemLabelProvider.class);
      supportedTypes.add(IItemPropertySource.class);
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcModel} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcModelItemProvider dbcModelItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcModel}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcModelAdapter() {
      if (dbcModelItemProvider == null) {
         dbcModelItemProvider = new DbcModelItemProvider(this);
      }

      return dbcModelItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcPackage} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcPackageItemProvider dbcPackageItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcPackage}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcPackageAdapter() {
      if (dbcPackageItemProvider == null) {
         dbcPackageItemProvider = new DbcPackageItemProvider(this);
      }

      return dbcPackageItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcClass} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcClassItemProvider dbcClassItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcClass}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcClassAdapter() {
      if (dbcClassItemProvider == null) {
         dbcClassItemProvider = new DbcClassItemProvider(this);
      }

      return dbcClassItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcMethod} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcMethodItemProvider dbcMethodItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcMethod}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcMethodAdapter() {
      if (dbcMethodItemProvider == null) {
         dbcMethodItemProvider = new DbcMethodItemProvider(this);
      }

      return dbcMethodItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcInvariant} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcInvariantItemProvider dbcInvariantItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcInvariant}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcInvariantAdapter() {
      if (dbcInvariantItemProvider == null) {
         dbcInvariantItemProvider = new DbcInvariantItemProvider(this);
      }

      return dbcInvariantItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcProof} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcProofItemProvider dbcProofItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcProof}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcProofAdapter() {
      if (dbcProofItemProvider == null) {
         dbcProofItemProvider = new DbcProofItemProvider(this);
      }

      return dbcProofItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcConstructor} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcConstructorItemProvider dbcConstructorItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcConstructor}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcConstructorAdapter() {
      if (dbcConstructorItemProvider == null) {
         dbcConstructorItemProvider = new DbcConstructorItemProvider(this);
      }

      return dbcConstructorItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcProofReference} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcProofReferenceItemProvider dbcProofReferenceItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcProofReference}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcProofReferenceAdapter() {
      if (dbcProofReferenceItemProvider == null) {
         dbcProofReferenceItemProvider = new DbcProofReferenceItemProvider(this);
      }

      return dbcProofReferenceItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcAttribute} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcAttributeItemProvider dbcAttributeItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcAttribute}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcAttributeAdapter() {
      if (dbcAttributeItemProvider == null) {
         dbcAttributeItemProvider = new DbcAttributeItemProvider(this);
      }

      return dbcAttributeItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcInterface} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcInterfaceItemProvider dbcInterfaceItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcInterface}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcInterfaceAdapter() {
      if (dbcInterfaceItemProvider == null) {
         dbcInterfaceItemProvider = new DbcInterfaceItemProvider(this);
      }

      return dbcInterfaceItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcEnum} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcEnumItemProvider dbcEnumItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcEnum}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcEnumAdapter() {
      if (dbcEnumItemProvider == null) {
         dbcEnumItemProvider = new DbcEnumItemProvider(this);
      }

      return dbcEnumItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcEnumLiteral} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcEnumLiteralItemProvider dbcEnumLiteralItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcEnumLiteral}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcEnumLiteralAdapter() {
      if (dbcEnumLiteralItemProvider == null) {
         dbcEnumLiteralItemProvider = new DbcEnumLiteralItemProvider(this);
      }

      return dbcEnumLiteralItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcOperationContract} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcOperationContractItemProvider dbcOperationContractItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcOperationContract}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcOperationContractAdapter() {
      if (dbcOperationContractItemProvider == null) {
         dbcOperationContractItemProvider = new DbcOperationContractItemProvider(this);
      }

      return dbcOperationContractItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcProperty} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcPropertyItemProvider dbcPropertyItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcProperty}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcPropertyAdapter() {
      if (dbcPropertyItemProvider == null) {
         dbcPropertyItemProvider = new DbcPropertyItemProvider(this);
      }

      return dbcPropertyItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link de.hentschel.visualdbc.dbcmodel.DbcProofObligation} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DbcProofObligationItemProvider dbcProofObligationItemProvider;

   /**
    * This creates an adapter for a {@link de.hentschel.visualdbc.dbcmodel.DbcProofObligation}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createDbcProofObligationAdapter() {
      if (dbcProofObligationItemProvider == null) {
         dbcProofObligationItemProvider = new DbcProofObligationItemProvider(this);
      }

      return dbcProofObligationItemProvider;
   }

   /**
    * This returns the root adapter factory that contains this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ComposeableAdapterFactory getRootAdapterFactory() {
      return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
   }

   /**
    * This sets the composed adapter factory that contains this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
      this.parentAdapterFactory = parentAdapterFactory;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean isFactoryForType(Object type) {
      return supportedTypes.contains(type) || super.isFactoryForType(type);
   }

   /**
    * This implementation substitutes the factory itself as the key for the adapter.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter adapt(Notifier notifier, Object type) {
      return super.adapt(notifier, this);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object adapt(Object object, Object type) {
      if (isFactoryForType(type)) {
         Object adapter = super.adapt(object, type);
         if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
            return adapter;
         }
      }

      return null;
   }

   /**
    * This adds a listener.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void addListener(INotifyChangedListener notifyChangedListener) {
      changeNotifier.addListener(notifyChangedListener);
   }

   /**
    * This removes a listener.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void removeListener(INotifyChangedListener notifyChangedListener) {
      changeNotifier.removeListener(notifyChangedListener);
   }

   /**
    * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void fireNotifyChanged(Notification notification) {
      changeNotifier.fireNotifyChanged(notification);

      if (parentAdapterFactory != null) {
         parentAdapterFactory.fireNotifyChanged(notification);
      }
   }

   /**
    * This disposes all of the item providers created by this factory. 
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void dispose() {
      if (dbcModelItemProvider != null) dbcModelItemProvider.dispose();
      if (dbcPackageItemProvider != null) dbcPackageItemProvider.dispose();
      if (dbcClassItemProvider != null) dbcClassItemProvider.dispose();
      if (dbcMethodItemProvider != null) dbcMethodItemProvider.dispose();
      if (dbcInvariantItemProvider != null) dbcInvariantItemProvider.dispose();
      if (dbcProofItemProvider != null) dbcProofItemProvider.dispose();
      if (dbcConstructorItemProvider != null) dbcConstructorItemProvider.dispose();
      if (dbcProofReferenceItemProvider != null) dbcProofReferenceItemProvider.dispose();
      if (dbcAttributeItemProvider != null) dbcAttributeItemProvider.dispose();
      if (dbcInterfaceItemProvider != null) dbcInterfaceItemProvider.dispose();
      if (dbcEnumItemProvider != null) dbcEnumItemProvider.dispose();
      if (dbcEnumLiteralItemProvider != null) dbcEnumLiteralItemProvider.dispose();
      if (dbcOperationContractItemProvider != null) dbcOperationContractItemProvider.dispose();
      if (dbcPropertyItemProvider != null) dbcPropertyItemProvider.dispose();
      if (dbcProofObligationItemProvider != null) dbcProofObligationItemProvider.dispose();
   }

}