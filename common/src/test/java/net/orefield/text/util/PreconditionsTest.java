/*
 * Copyright 2022 OreField - All Rights Reserved
 */

package net.orefield.text.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("ConstantConditions")
class PreconditionsTest {

    @Test
    void checkArgument_Succeeds_WhenArgumentIsValid() {
        final int n = 100;

        assertDoesNotThrow(() -> Preconditions.checkArgument(n < 1000));
        assertDoesNotThrow(() -> Preconditions.checkArgument(n > 0));
        assertDoesNotThrow(() -> Preconditions.checkArgument(n < 1000,
                "[n] must be less than 1000"));
        assertDoesNotThrow(() -> Preconditions.checkArgument(n > 0,
                "[n] must be positive"));
    }

    @Test
    void checkArgument_Fails_WhenArgumentNotValid() {
        final int n = 0;

        assertThrows(IllegalArgumentException.class,
                () -> Preconditions.checkArgument(n < 0));
        assertThrows(IllegalArgumentException.class,
                () -> Preconditions.checkArgument(n > 0));

        final Throwable negativeThrown = assertThrows(IllegalArgumentException.class,
                () -> Preconditions.checkArgument(n < 0, "[n] must be negative"));
        assertEquals("[n] must be negative", negativeThrown.getMessage());

        final Throwable positiveThrown = assertThrows(IllegalArgumentException.class,
                () -> Preconditions.checkArgument(n > 0, "[n] must be positive"));
        assertEquals("[n] must be positive", positiveThrown.getMessage());
    }

    @Test
    void checkNotNull_ReturnsArgument_WhenArgumentIsNotNull() {
        final Object object = new Object();

        assertSame(object, Preconditions.checkNotNull(object));
        assertSame(object, Preconditions.checkNotNull(object, "object"));
    }

    @Test
    void checkNotNull_Fails_WhenArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> Preconditions.checkNotNull(null));
        assertThrows(NullPointerException.class, () -> Preconditions.checkNotNull(null, "object"));
    }
}
