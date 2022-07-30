/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text.adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.orefield.text.Category;
import net.orefield.text.Property;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class AdventureTextsTest {

    @Test
    void adventureText_Loads() {
        assertNotNull(AdventureTexts.adventureText());
    }

    @Test
    void title_ReturnsTitle() {
        final Component serverTitle = AdventureTexts.title("SERVER");
        final Component staffCategoryTitle = AdventureTexts.title(Category.STAFF);

        assertEquals(
                Component.empty()
                        .append(
                                Component.text("SERVER")
                                        .color(AdventureText.ACCENT)
                                        .decorate(TextDecoration.BOLD)
                        ),
                serverTitle
        );
        assertEquals(
                Component.empty()
                        .append(
                                Component.text("STAFF")
                                        .color(AdventureText.ACCENT)
                                        .decorate(TextDecoration.BOLD)
                        ),
                staffCategoryTitle
        );
    }

    @Test
    void orefield_ReturnsOrefieldTitle() {
        final Component orefield = AdventureTexts.orefield();

        assertEquals(
                Component.empty()
                        .append(
                                Component.text("OREFIELD")
                                        .color(AdventureText.ACCENT)
                                        .decorate(TextDecoration.BOLD)
                        ),
                orefield
        );
    }

    @Test
    void information_ReturnsInformation() {
        final Component information = AdventureTexts.information(Category.CHAT,
                Component.text("Hello, world!"));

        assertEquals(
                Component.empty()
                        .append(
                                Component.text("CHAT ")
                                        .color(AdventureText.MAIN)
                                        .decorate(TextDecoration.BOLD)
                        )
                        .append(AdventureText.SEPARATOR_COMPONENT)
                        .append(Component.text("Hello, world!")),
                information
        );
    }

    @Test
    void error_ReturnsError() {
        final Component error = AdventureTexts.error(Component.text("Player not found."));

        assertEquals(
                AdventureText.ERROR_COMPONENT
                        .append(Component.text("Player not found.")),
                error
        );
    }

    @Test
    void warning_ReturnsWarning() {
        final Component warning = AdventureTexts.warning(
                Component.text("Unable to teleport 2/10 players."));

        assertEquals(
                AdventureText.WARNING_COMPONENT
                        .append(Component.text("Unable to teleport 2/10 players.")),
                warning
        );
    }

    @Test
    void callToAction_ReturnsCallToAction() {
        final Component callToAction = AdventureTexts.callToAction(Component.text("CLICK HERE"));

        assertEquals(
                Component.text("CLICK HERE")
                        .style(AdventureText.CALL_TO_ACTION_STYLE),
                callToAction
        );
    }

    @Test
    void property_ReturnsProperty() {
        final Component nameProperty = AdventureTexts.property(
                Property.of("Name", Component.text("overlapse")));
        final Component serverProperty = AdventureTexts.property("Server", Component.text("hub-1"));

        assertEquals(
                Component.empty()
                        .append(Component.text("Name: ").color(AdventureText.GRAY))
                        .append(Component.text("overlapse")),
                nameProperty
        );
        assertEquals(
                Component.empty()
                        .append(Component.text("Server: ").color(AdventureText.GRAY))
                        .append(Component.text("hub-1")),
                serverProperty
        );
    }

    @Test
    void propertyGroup_ReturnsPropertyGroup() {
        final List<Component> propertyGroup = AdventureTexts.propertyGroup(
                "SERVER",
                Arrays.asList(
                        Property.of("TPS", Component.text("20")),
                        Property.of("Players", Component.text("53/100"))
                )
        );

        assertEquals(
                Arrays.asList(
                        Component.text("SERVER")
                                .color(AdventureText.ACCENT)
                                .decorate(TextDecoration.BOLD),
                        AdventureText.INDENT_COMPONENT
                                .append(
                                        Component.empty()
                                                .append(Component.text("TPS: ")
                                                        .color(AdventureText.GRAY))
                                                .append(Component.text("20"))
                                ),
                        AdventureText.INDENT_COMPONENT
                                .append(
                                        Component.empty()
                                                .append(Component.text("Players: ")
                                                        .color(AdventureText.GRAY))
                                                .append(Component.text("53/100"))
                                )
                ),
                propertyGroup
        );
    }
}
