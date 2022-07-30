/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text.adventure;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import net.kyori.adventure.text.Component;
import net.orefield.text.Category;
import net.orefield.text.Property;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collection;
import java.util.List;

/**
 * A class for static access to {@link AdventureText}.
 *
 * @author Sparky983
 * @since 1.0.0
 */
public final class AdventureTexts {

    private final static AdventureText INSTANCE = new AdventureText();

    /**
     * Returns the singleton {@link AdventureText} instance.
     *
     * @author Sparky983
     * @return The instance.
     * @since 1.0.0
     */
    @Contract(pure = true)
    public static @NotNull AdventureText adventureText() {
        return INSTANCE;
    }

    // Documentation copied from net.orefield.text.Text

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
    public static @NotNull Component title(
            final @Nls(capitalization = Title) @NotNull String title) {
        return adventureText().title(title);
    }

    /**
     * Creates a title for the specified {@code category}.
     * <p>
     * The same as calling {@code Text.title(category.toString())}.
     *
     * @author Sparky983
     * @param category The category.
     * @return The title.
     * @throws NullPointerException if {@code category} is {@code null}.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Component title(final @NotNull Category category) {
        return adventureText().title(category);
    }

    /**
     * Returns the OreField title.
     *
     * @author Sparky983
     * @return The orefield message.
     * @since 1.0.0
     */
    @Contract(pure = true)
    public static @NotNull Component orefield() {
        return adventureText().orefield();
    }

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
    public static @NotNull Component information(final @NotNull Category category,
            final @NotNull Component message) {
        return adventureText().information(category, message);
    }

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
    public static @NotNull Component error(final @NotNull Component message) {
        return adventureText().error(message);
    }

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
    public static @NotNull Component warning(final @NotNull Component message) {
        return adventureText().warning(message);
    }

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
    public static @NotNull Component callToAction(final @NotNull Component message) {
        return adventureText().callToAction(message);
    }

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
    public static @NotNull Component property(
            final @NotNull Property<? extends Component> property) {
        return adventureText().property(property);
    }

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
    public static @NotNull Component property(final @NotNull String propertyName,
            final @NotNull Component value) {
        return adventureText().property(propertyName, value);
    }

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
    public static @Unmodifiable @NotNull List<@Nls @NotNull Component> propertyGroup(
            final @Nls(capitalization = Title) @NotNull String propertyGroupName,
            final @NotNull Collection<@NotNull Property<? extends @NotNull Component>> properties) {
        return adventureText().propertyGroup(propertyGroupName, properties);
    }
}
