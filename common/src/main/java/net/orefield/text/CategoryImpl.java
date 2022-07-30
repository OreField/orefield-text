/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import net.orefield.text.util.Preconditions;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

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
}
