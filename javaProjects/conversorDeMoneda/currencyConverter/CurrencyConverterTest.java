package currencyConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    private static final double USD_AMOUNT = 100.0;
    private static final double DELTA = 0.001;

    private static final int OPTION_EUR = 1;
    private static final int OPTION_GBP = 2;
    private static final int OPTION_INR = 3;
    private static final int OPTION_INVALID = 4;

    @Test
    void testConvertCurrencyToEUR() {
        double expectedAmount = USD_AMOUNT * CurrencyConverter.getUSDToEUR();
        assertEquals(expectedAmount, CurrencyConverter.convertCurrency(USD_AMOUNT, OPTION_EUR), DELTA);
    }

    @Test
    void testConvertCurrencyToGBP() {
        double expectedAmount = USD_AMOUNT * CurrencyConverter.getUSDToGBP();
        assertEquals(expectedAmount, CurrencyConverter.convertCurrency(USD_AMOUNT, OPTION_GBP), DELTA);
    }

    @Test
    void testConvertCurrencyToINR() {
        double expectedAmount = USD_AMOUNT * CurrencyConverter.getUSDToINR();
        assertEquals(expectedAmount, CurrencyConverter.convertCurrency(USD_AMOUNT, OPTION_INR), DELTA);
    }

    @Test
    void testConvertCurrencyInvalidChoice() {
        assertEquals(-1, CurrencyConverter.convertCurrency(USD_AMOUNT, OPTION_INVALID), DELTA);
    }
}