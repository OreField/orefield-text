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
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation of {@link Category}.
 *
 * @author Sparky983
 */
class CategoryImpl implements Category {

    private final String name;
    private final String friendlyName;

    /**
     * Constructs a new {@code CategoryImpl} with the specified {@code name} and
     * {@code friendlyName}.
     *
     * @author Sparky983
     * @param name The name.
     * @param friendlyName The friendly name.
     * @throws NullPointerException if {@code name} or {@code friendlyName} are {@code null}.
     */
    @Contract(pure = true)
    CategoryImpl(final @NonNls @NotNull String name,
            final @Nls(capitalization = Title) @NotNull String friendlyName) {
        this.name = Preconditions.checkNotNull(name, "name");
        this.friendlyName = Preconditions.checkNotNull(friendlyName, "friendlyName");
    }

    public @NonNls @NotNull String getName() {
        return name;
    }

    public @Nls(capitalization = Title) @NotNull String toString() {
        return friendlyName;
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryImpl)) return false;

        CategoryImpl category = (CategoryImpl) o;

        if (!name.equals(category.name)) return false;
        return friendlyName.equals(category.friendlyName);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + friendlyName.hashCode();
        return result;
    }
}
