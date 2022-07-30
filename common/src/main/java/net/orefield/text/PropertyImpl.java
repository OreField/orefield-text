/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import net.orefield.text.util.Preconditions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Implementation of {@link Property}.
 *
 * @author Sparky983
 * @param <Message> The message type.
 * @since 1.0.0
 */
class PropertyImpl<Message> implements Property<Message> {

    private final String propertyName;
    private final Message value;

    @Contract(pure = true)
    PropertyImpl(final @Nls(capitalization = Title) @NotNull String propertyName,
                 final @NotNull Message value) {
        this.propertyName = Preconditions.checkNotNull(propertyName, "propertyName");
        this.value = Preconditions.checkNotNull(value, "value");
    }

    @Override
    public @Nls(capitalization = Title) @NotNull String getPropertyName() {

        return propertyName;
    }

    @Override
    public @Nls @NotNull Message getValue() {

        return value;
    }
}
