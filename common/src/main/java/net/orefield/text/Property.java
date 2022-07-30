/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a key (name) and value pair.
 * <p>
 * For example a property specifying a player's name:
 * <pre>
 * Property property = Property.of("Name", "overlapse");
 * </pre>
 *
 * @author Sparky983
 * @since 1.0.0
 */
public interface Property<Message> {

    /**
     * Returns a new property with the specified {@code propertyName} and {@code value}.
     *
     * @author Sparky983
     * @param propertyName The property name.
     * @param value The value.
     * @return The new property.
     * @param <T> The message type.
     * @throws NullPointerException if {@code propertyName} or {@code value} are {@code null}.
     * @since 1.0.0
     */
    @Contract(pure = true)
    static <T> @NotNull Property<T> of(
            final @Nls(capitalization = Title) @NotNull String propertyName,
            final @Nls @NotNull T value) {
        return new PropertyImpl<>(propertyName, value);
    }

    /**
     * Returns the property name.
     *
     * @author Sparky983
     * @return The property name.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @Nls(capitalization = Title)
    @NotNull
    String getPropertyName();

    /**
     * Returns the value.
     *
     * @author Sparky983
     * @return The value.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @Nls
    @NotNull
    Message getValue();
}
