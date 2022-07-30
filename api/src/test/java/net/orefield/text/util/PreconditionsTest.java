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

package net.orefield.text.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
