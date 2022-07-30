/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Informational/System message categories.
 *
 * @author Sparky983
 * @since 1.0.0
 */
public interface Category {

    /**
     * The category for chat related messages (e.g. changing chat channels).
     *
     * @since 1.0.0
     */
    @NotNull Category CHAT = of("CHAT", "CHAT");

    /**
     * The category for moderation messages.
     *
     * @since 1.0.0
     */
    @NotNull Category PUNISH = of("PUNISH", "PUNISH");

    /**
     * The category for messages related to discord and discord linking.
     *
     * @since 1.0.0
     */
    @NotNull Category DISCORD = of("DISCORD", "DISCORD");

    /**
     * The category for staff messages (e.g. staff login/out).
     *
     * @since 1.0.0
     */
    @NotNull Category STAFF = of("STAFF", "STAFF");

    /**
     * The category for messages related to the network (e.g. proxy restart messages).
     *
     * @since 1.0.0
     */
    @NotNull Category NETWORK = of("NETWORK", "NETWORK");

    /**
     * The category for general OreField messages.
     *
     * @since 1.0.0
     */
    @NotNull Category OREFIELD = of("OREFIELD", "OREFIELD");

    /**
     * Returns a new category with the specified {@code name} and {@code userFriendlyName}.
     *
     * @author Sparky983
     * @param name The name.
     * @param friendlyName The user-friendly name. This is used for {@link #toString()}.
     * @throws NullPointerException if {@code name} or {@code userFriendlyName} are {@code null}.
     * @return The new category.
     * @since 1.0.0
     */
    @Contract(value = "_, _ -> new", pure = true)
    static @NotNull Category of(final @NonNls @NotNull String name,
            final @Nls(capitalization = Title) @NotNull String friendlyName) {
        return new CategoryImpl(name, friendlyName);
    }

    /**
     * A computer-readable name of the category.
     * <p>
     * This should be as unique as possible.
     * <p>
     * If this category is in a constant field, this should return the name of that field.
     *
     * @author Sparky983
     * @return The name.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @NonNls
    @NotNull
    String getName();

    /**
     * A human-readable name of the category.
     *
     * @author Sparky983
     * @return The category name.
     * @since 1.0.0
     */
    @Contract(pure = true)
    @Nls(capitalization = Title)
    @NotNull
    String toString();
}
