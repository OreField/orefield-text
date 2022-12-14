/*
 * Copyright (c) 2022 OreField
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.orefield.text;

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
     * The indent for properties inside a {@link #propertyGroup(String, Collection)}  propertyGroup}.
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
    @NotNull
    Message title(final @Nls(capitalization = Title) @NotNull String title);

    /**
     * Creates a title for the specified {@code category}.
     * <p>
     * The same as calling {@code Text.title(category.toString())}.
     * @author Sparky983
     * @param category The category.
     * @return The title.
     * @throws NullPointerException if {@code category} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
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
    @NotNull
    Message information(final @NotNull Category category,
            final @NotNull Message message);

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
    @NotNull
    Message error(final @NotNull Message message);

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
    @NotNull
    Message warning(final @NotNull Message message);

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
    @NotNull
    Message callToAction(final @NotNull Message message);

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
    @NotNull
    Message property(final @NotNull Property<? extends Message> property);

    /**
     * Returns a new property message of a property with the specified {@code propertyName} and
     * {@code message}.
     * <p>
     * The same as calling
     * <p>
     * The same as calling {@code Text.property(Property.of(propertyName, message))}.
     *
     * @author Sparky983
     * @param propertyName The property name.
     * @param value The property value.
     * @return The property message.
     * @throws NullPointerException if {@code propertyName} or {@code value} are {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    Message property(final @Nls(capitalization = Title) @NotNull String propertyName,
            final @NotNull Message value);


    /**
     * Returns a new property group message with the specified {@code groupName} and
     * {@code properties}.
     *
     * @author Sparky983
     * @param propertyGroupName The group name.
     * @param properties The properties.
     * @return The property group.
     * @since 1.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    @Unmodifiable
    List<@NotNull Message> propertyGroup(
            final @Nls(capitalization = Title) @NotNull String propertyGroupName,
            final @NotNull Collection<@NotNull Property<? extends Message>> properties);
}
