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

import net.orefield.text.util.Preconditions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    public @NotNull Message getValue() {
        return value;
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyImpl)) return false;

        PropertyImpl<?> property = (PropertyImpl<?>) o;

        if (!propertyName.equals(property.propertyName)) return false;
        return value.equals(property.value);
    }

    @Override
    public int hashCode() {
        int result = propertyName.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public @NotNull String toString() {
        return "PropertyImpl(" +
            "propertyName='" + propertyName + "'" +
            ", value=" + value +
            ')';
    }
}
