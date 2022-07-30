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

package net.orefield.text.adventure;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.orefield.text.Category;
import net.orefield.text.Property;
import net.orefield.text.Text;
import net.orefield.text.util.Preconditions;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of {@link Text} for {@link net.kyori.adventure.Adventure}.
 *
 * @author Sparky983
 * @see AdventureTexts
 * @since 1.0.0
 */
public class AdventureText implements Text<Component> {

    /**
     * The main color.
     *
     * @since 1.0.0
     */
    public static final TextColor MAIN = NamedTextColor.GOLD;

    /**
     * The accent color.
     *
     * @since 1.0.0
     */
    public static final TextColor ACCENT = NamedTextColor.YELLOW;

    /**
     * A gray color.
     *
     * @since 1.0.0
     */
    public static final TextColor GRAY = NamedTextColor.GRAY;

    /**
     * A dark gray color.
     *
     * @since 1.0.0
     */
    public static final TextColor DARK_GRAY = NamedTextColor.DARK_GRAY;

    /**
     * The call to action color.
     *
     * @see #callToAction(Component)
     * @since 1.0.0
     */
    public static final TextColor CALL_TO_ACTION = TextColor.color(0xFA342D);

    /**
     * The error color.
     *
     * @see #error(Component)
     * @since 1.0.0
     */
    public static final TextColor ERROR = TextColor.color(0xFF5E6E);

    /**
     * The warning color.
     *
     * @see #warning(Component)
     * @since 1.0.0
     */
    public static final TextColor WARNING = TextColor.color(0xEBD94D);

    /**
     * Cached component version of {@link #SEPARATOR}.
     *
     * @see #SEPARATOR
     */
    @VisibleForTesting
    static final Component SEPARATOR_COMPONENT = Component.text(SEPARATOR + ' ', DARK_GRAY);

    /**
     * Cached component version of {@link #INDENT}.
     *
     * @see #INDENT
     */
    @VisibleForTesting
    static final Component INDENT_COMPONENT = Component.text(INDENT);

    /**
     * Cached error component.
     *
     * @see #error(Component)
     */
    @VisibleForTesting
    static final Component ERROR_COMPONENT = Component.text("Error: ", ERROR);

    /**
     * Cached warning component.
     *
     * @see #warning(Component)
     */
    @VisibleForTesting
    static final Component WARNING_COMPONENT = Component.text("Warning: ", WARNING);

    /**
     * Cached call to action style.
     *
     * @see #callToAction(Component)
     */
    @VisibleForTesting
    static final Style CALL_TO_ACTION_STYLE = Style.style(
            CALL_TO_ACTION,
            TextDecoration.BOLD);

    private final Component orefieldTitle = title("OREFIELD");

    @Override
    public @NotNull Component title(final @Nls(capitalization = Title) @NotNull String title) {
        Preconditions.checkNotNull(title, "title");

        return Component.empty()
                .append(Component.text(title, ACCENT, TextDecoration.BOLD));
    }

    @Override
    public @NotNull Component title(final @NotNull Category category) {
        Preconditions.checkNotNull(category, "category");

        return title(category.toString());
    }

    @Override
    public @NotNull Component orefield() {
        return orefieldTitle;
    }

    @Override
    public @NotNull Component information(final @NotNull Category category,
            final @NotNull Component message) {
        Preconditions.checkNotNull(category, "category");
        Preconditions.checkNotNull(message, "message");

        return Component.text()
                .append(
                        Component.text(
                                category.getName() + ' ',
                                MAIN,
                                TextDecoration.BOLD
                        )
                )
                .append(SEPARATOR_COMPONENT)
                .append(message)
                .build();
    }

    @Override
    public @NotNull Component error(
            final @NotNull Component message) {
        Preconditions.checkNotNull(message, "message");

        return ERROR_COMPONENT.append(message);
    }

    @Override
    public @NotNull Component warning(
            final @NotNull Component message) {
        Preconditions.checkNotNull(message, "message");

        return WARNING_COMPONENT.append(message);
    }

    @Override
    public @NotNull Component callToAction(final @NotNull Component message) {
        Preconditions.checkNotNull(message, "message");
        return message.style(CALL_TO_ACTION_STYLE);
    }

    @Override
    public @NotNull Component property(final @NotNull Property<? extends Component> property) {
        Preconditions.checkNotNull(property, "property");

        return Component.text()
                .append(Component.text(property.getPropertyName() + ": ", GRAY))
                .append(property.getValue())
                .build();
    }

    @Override
    public @NotNull Component property(
            final @Nls(capitalization = Title) @NotNull String propertyName,
            final @NotNull Component value) {
        return property(Property.of(propertyName, value));
    }

    @Override
    public @NotNull List<@NotNull Component> propertyGroup(
            final @Nls(capitalization = Title) @NotNull String propertyGroupName,
            final @NotNull Collection<@NotNull Property<? extends Component>> properties) {
        Preconditions.checkNotNull(propertyGroupName, "propertyGroupName");
        Preconditions.checkNotNull(properties, "properties");

        Component[] components = new Component[properties.size() + 1];

        components[0] = Component.text(
                propertyGroupName,
                ACCENT,
                TextDecoration.BOLD
        );

        int i = 1;
        for (final Property<? extends Component> property : properties) {
            Preconditions.checkNotNull(property, "properties[" + i + "]");
            components[i] = INDENT_COMPONENT.append(property(property));
            i++;
        }

        return Collections.unmodifiableList(Arrays.asList(components));
    }
}
