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
            final @NotNull T value) {
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
    @NotNull
    Message getValue();
}
