This file is part of KeY - https://key-project.org
The KeY system is protected by the GNU General Public License Version 2

Copyright (C) 2001-2011 Universitaet Karlsruhe (TH), Germany
                        Universitaet Koblenz-Landau, Germany
                        Chalmers University of Technology, Sweden
Copyright (C) 2011-2019 Karlsruhe Institute of Technology, Germany
                        Technical University Darmstadt, Germany
                        Chalmers University of Technology, Sweden

package de.uka.ilkd.key.gui.prooftree;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.*;

/**
 * @author Alexander Weigl
 * @version 1 (20.05.19)
 */
public class Style {
    private final Map<Object, Object> styles = new HashMap<>();
    private final Set<Object> sealed = new HashSet<>();

    private static class Key<T> {
        <T> Key(Class<T> clazz) {
        }
    }

    public static final Key<Color> KEY_COLOR_FOREGROUND = new Key<>(Color.class);
    public static final Key<Color> KEY_COLOR_BACKGROUND = new Key<>(Color.class);
    public static final Key<Color> KEY_COLOR_BORDER = new Key<>(Color.class);
    public static final Key<Boolean> KEY_FONT_ITALIC = new Key<>(Boolean.class);
    public static final Key<Boolean> KEY_FONT_BOLD = new Key<>(Boolean.class);
    public static final Key<Icon> KEY_ICON = new Key<>(Icon.class);
    public static final Key<String> KEY_TOOLTIP = new Key<>(String.class);
    public static final Key<String> KEY_TEXT = new Key<>(String.class);

    @Nonnull
    public <T> Style set(@Nonnull Key<T> key, @Nullable T value) {
        if (!sealed.contains(key)) {
            styles.put(key, value);
        }
        return this;
    }

    @Nonnull
    public <T> Style setAndSeal(@Nonnull Key<T> key, @Nullable T value) {
        set(key, value);
        sealed.add(key);
        return this;
    }

    public <T> boolean contains(@Nonnull Key<T> key) {
        return styles.containsKey(key);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T get(@Nonnull Key<T> key, @Nullable T defaultValue) {
        return (T) styles.getOrDefault(key, defaultValue);
    }

    @Nullable
    public <T> T get(@Nonnull Key<T> key) {
        return get(key, null);
    }

    public boolean getBoolean(Key<Boolean> key) {
        return get(key) == Boolean.TRUE;
    }
}
