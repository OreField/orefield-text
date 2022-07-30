/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text;
import static org.jetbrains.annotations.Nls.Capitalization.Sentence;
import static org.jetbrains.annotations.Nls.Capitalization.Title;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collection;
import java.util.List;

/**
 * A factory for creating messages compliant with OreField's design system and standards.
 *
 * @author Sparky983
 * @param <Message> The type of the message.
 * @since 1.0.0
 */
public interface Text<Message> {

    /**
     * The separator used to separate the category and message of an
     * {@link #information(Category, Object) information} message.
     *
     * @since 1.0.0
     */
    @Nls char SEPARATOR = '\u2192';

    /**
     * The indent for properties inside a {@link #propertyGroup(String, Iterable) propertyGroup}.
     *
     * @since 1.0.0
     */
    @Nls String INDENT = "  ";

    /**
     * Returns a new title.
     *
     * @author Sparky983
     * @param title The title.
     * @return The title.
     * @throws NullPointerException if {@code title} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls(capitalization = Title)
    @NotNull
    Message title(final @Nls @NotNull String title);

    /**
     * Creates a title for the specified {@code category}.
     *
     * @implNote The same as calling {@code Text.title(category.toString())}.
     * @author Sparky983
     * @param category The category.
     * @return The title.
     * @throws NullPointerException if {@code category} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls(capitalization = Title)
    @NotNull
    Message title(final @NotNull Category category);

    /**
     * Returns the OreField title.
     *
     * @author Sparky983
     * @return The orefield message.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @Nls(capitalization = Title)
    @NotNull
    Message orefield();

    /**
     * Returns a new informational/system message.
     *
     * @author Sparky983
     * @param category The category.
     * @param message The message.
     * @throws NullPointerException if {@code category} or {@code message} are {@code null}.
     * @return A usable informational message containing the {@code message}.
     * @since 1.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    @Nls
    @NotNull
    Message information(final @NotNull Category category,
                        final @Nls(capitalization = Sentence) @NotNull Message message);

    /**
     * Return a new error message.
     *
     * @author Sparky983
     * @param message The error message.
     * @return The error message.
     * @throws NullPointerException if {@code message} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls
    @NotNull
    Message error(final @Nls(capitalization = Sentence) @NotNull Message message);

    /**
     * Returns a new warning message.
     *
     * @author Sparky983
     * @param message The warning message.
     * @return The warning message.
     * @throws NullPointerException if {@code message} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls
    @NotNull
    Message warning(final @Nls(capitalization = Sentence) @NotNull Message message);

    /**
     * Returns a new call to action message.
     *
     * @author Sparky983
     * @param message The call to action.
     * @return The call to action
     * @throws NullPointerException if {@code message} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls
    @NotNull
    Message callToAction(final @Nls @NotNull Message message);

    /**
     * Returns a new property message.
     *
     * @author Sparky983
     * @param property The property.
     * @return The property message.
     * @throws NullPointerException if {@code property} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    @Nls
    @NotNull
    Message property(final @NotNull Property<? extends Message> property);

    /**
     * Returns a new property message of a property with the specified {@code propertyName} and
     * {@code message}.
     * <p>
     * The same as calling
     *
     * @implNote The same as calling {@code Text.property(Property.of(propertyName, message))}.
     * @author Sparky983
     * @param propertyName The property name.
     * @param value The property value.
     * @return The property message.
     * @throws NullPointerException if {@code propertyName} or {@code value} are {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    @Nls
    @NotNull
    Message property(final @Nls(capitalization = Title) @NotNull String propertyName,
                     final @Nls @NotNull Message value);


    @Contract(value = "_, _ -> new", pure = true)
    @Nls
    @NotNull
    @Unmodifiable
    List<Message> propertyGroup(
            final @Nls(capitalization = Title) @NotNull String propertyGroupName,
            final @NotNull Collection<@NotNull Property<? extends Message>> properties);
}
