This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.properties;


import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractProperties implements Properties {

    private final Map<Property<?>, Set<PropertyListener>> listenerMap =
        new IdentityHashMap<Property<?>, Set<PropertyListener>>();

    private final Set<PropertyListener> globalListeners =
        new HashSet<Properties.PropertyListener>();

    @Override
    public void addPropertyListener(Property<?> property, PropertyListener listener) {
        if (property == null) {
            globalListeners.add(listener);
        } else {
            Set<PropertyListener> list = listenerMap.get(property);
            if (list == null) {
                list = new HashSet<PropertyListener>();
                listenerMap.put(property, list);
            }
            list.add(listener);
        }
    }

    @Override
    public void removePropertyListener(Property<?> property, PropertyListener listener) {
        if (property == null) {
            globalListeners.remove(listener);
        } else {
            Set<PropertyListener> list = listenerMap.get(property);
            if (list != null) {
                list.remove(listener);
            }
        }
    }

    @Override
    public void removePropertyListener(PropertyListener listener) {
        globalListeners.remove(listener);
        for (Set<PropertyListener> list : listenerMap.values()) {
            list.remove(listener);
        }
    }

    protected <T> void firePropertyChange(Property<T> property, T oldValue, T newValue) {
        if (oldValue == null || !oldValue.equals(newValue)) {
            Set<PropertyListener> list = listenerMap.get(property);
            if (list != null) {
                for (PropertyListener listener : list) {
                    listener.propertyChanged(property, oldValue, newValue);
                }
            }
            for (PropertyListener listener : globalListeners) {
                listener.propertyChanged(property, oldValue, newValue);
            }
        }
    }


    @Override
    public abstract Properties clone();
}
