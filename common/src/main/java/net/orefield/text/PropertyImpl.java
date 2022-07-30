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
 */
class PropertyImpl<Message> implements Property<Message> {

    private final String propertyName;
    private final Message value;

    /**
     * Constructs a new {@code PropertyImpl} with the specified {@code propertyName} and
     * {@code value}.
     *
     * @author Sparky983
     * @param propertyName The property name.
     * @param value The value.
     * @throws NullPointerException if {@code propertyName} or {@code value} are {@code null}.
     */
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
