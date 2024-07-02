This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.util.properties;

import java.util.Arrays;

public class ArrayProperties extends AbstractProperties {

    private Object[] data = null;

    public ArrayProperties() {
    }

    public ArrayProperties(int initialSize) {
        data = new Object[initialSize];
    }

    public ArrayProperties(ArrayProperties original) {
        data = new Object[original.size()];
        data = Arrays.copyOf(data, data.length);
    }

    @Override
    public <T> void put(Property<T> property, T value) {
        T oldValue = get(property);
        // double check typing
        property.getType().cast(value);
        // ensure capacity;
        ensurePresent(property.getNumber());
        // store it in the object
        data[property.getNumber()] = value;
        firePropertyChange(property, oldValue, value);
    }

    private void ensurePresent(int number) {
        int size = number + 1;
        if (data == null) {
            data = new Object[size];
        } else if (data.length < size) {
            data = Arrays.copyOf(data, size);
        }
    }

    @Override
    public <T> T get(Property<T> property) {
        if (data == null || property.getNumber() >= data.length) {
            return null;
        } else {
            return property.getType().cast(data[property.getNumber()]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public <T> void remove(Property<T> property) {
        if (data == null || property.getNumber() >= data.length) {
            // do nothing
        } else {
            T oldValue = get(property);
            data[property.getNumber()] = null;
            firePropertyChange(property, oldValue, null);
        }
    }

    @Override
    public Properties clone() {
        return new ArrayProperties(this);
    }


    @Override
    public int size() {
        return data.length;
    }
}
