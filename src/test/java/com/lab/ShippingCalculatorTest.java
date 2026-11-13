package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ShippingCalculatorTest {

    private final ShippingCalculator calc = new ShippingCalculator();

    @Test
    void expressFee() {
        assertEquals(30000.0, calc.calculate(2, "EXPRESS"), 0.0001);
    }

    @Test
    void standardFee() {
        assertEquals(6000.0, calc.calculate(2, "STANDARD"), 0.0001);
    }

    @Test
    void zeroWeightThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(0, "STANDARD"));
    }

    @Test
    void unknownTypeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(1, "FAST"));
    }

    @Test
    void nullTypeThrowsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(1, null));
    }
}