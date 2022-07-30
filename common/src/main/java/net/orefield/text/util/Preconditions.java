/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Utility class for checking preconditions with consistent errors.
 *
 * @author Sparky983
 * @since 1.0.0
 */
public final class Preconditions {

    /**
     * Checks that the provided argument is valid.
     *
     * @author Sparky983
     * @param isValid Whether the parameter is valid.
     * @throws IllegalArgumentException if {@code isValid} is {@code false}.
     * @since 1.0.0
     */
    @Contract(value = "false -> fail", pure = true)
    public static void checkArgument(final boolean isValid) {
        checkArgument(isValid, null);
    }

    /**
     * Checks that the provided argument is valid.
     *
     * @author Sparky983
     * @param isValid Whether the parameter is valid. 
     * @param message The error message.
     * @throws IllegalArgumentException if {@code isValid} is {@code false}.
     * @since 1.0.0
     */
    @Contract(value = "false, _ -> fail", pure = true)
    public static void checkArgument(final boolean isValid,
            final @NonNls @Nullable String message) {
        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that the provided argument is not {@code null}. 
     *
     * @author Sparky983
     * @param t The argument. 
     * @return The argument if it is not {@code null}. 
     * @param <T> The type of the argument. 
     * @throws NullPointerException if {@code t} is {@code null}.
     * @see #checkNotNull(Object, String)
     * @since 1.0.0
     */
    @Contract(value = "null -> fail; !null -> param1", pure = true)
    public static <T> @NotNull T checkNotNull(final @Nullable T t) {
        return checkNotNull(t, null);
    }

    /**
     * Checks that the provided argument is not {@code null}.
     *
     * @author Sparky983
     * @param t The argument.
     * @return The argument if it is not {@code null}.
     * @param <T> The type of the argument.
     * @param parameterName The parameter name of the argument that is being checked. This may be
     *                      used to construct an error message.
     * @throws NullPointerException if {@code t} is {@code null}.
     * @see #checkNotNull(Object)
     * @since 1.0.0
     */
    @Contract(value = "null, _ -> fail; !null, _ -> param1", pure = true)
    public static <T> @NotNull T checkNotNull(final @Nullable T t,
            final @NonNls @Nullable String parameterName) {
        if (t == null) {
            throw new NullPointerException("[" + parameterName + "] cannot be null");
        }
        return t;
    }
}
