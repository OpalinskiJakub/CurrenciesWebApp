package opalinski.jakub.currencieswebapp.Services;

import opalinski.jakub.currencieswebapp.PojoClasses.Rate;
import opalinski.jakub.currencieswebapp.PojoClasses.Root;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionServiceTest {

    @Test
    void PLNtoGBPFirstTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(2);
        assertEquals(currencyConversionService.PLNtoGBP(1.2),2.4);
    }
    @Test
    void PLNtoGBPSecondTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(10);
        assertEquals(currencyConversionService.PLNtoGBP(1.2),12);
    }
    @Test
    void PLNtoGBPThirdTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(1.32);
        assertEquals(currencyConversionService.PLNtoGBP(1.2),1.58);
    }
}