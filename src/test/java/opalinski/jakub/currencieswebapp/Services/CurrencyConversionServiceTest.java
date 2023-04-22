package opalinski.jakub.currencieswebapp.Services;

import opalinski.jakub.currencieswebapp.Exceptions.BadDataException;
import opalinski.jakub.currencieswebapp.PojoClasses.CurrencyData;
import opalinski.jakub.currencieswebapp.PojoClasses.Rate;
import opalinski.jakub.currencieswebapp.PojoClasses.Root;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionServiceTest {

    @Test
    void PLNtoGBPFirstTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(2);
        assertEquals(CurrencyConversionService.PLNtoGBP(10), 5);
    }

    @Test
    void PLNtoGBPSecondTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(11);
        assertEquals(CurrencyConversionService.PLNtoGBP(100), 9.09);
    }

    @Test
    void PLNtoGBPThirdTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(1.32);
        assertEquals(CurrencyConversionService.PLNtoGBP(1.2), 0.91);
    }

    @Test
    void GBPToPLNFirstTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(2);
        assertEquals(CurrencyConversionService.GBPtoPLN(1.2), 2.4);
    }

    @Test
    void GBPToPLNSecondTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(10);
        assertEquals(CurrencyConversionService.GBPtoPLN(1.2), 12);
    }

    @Test
    void GBPToPLNThirdTest() throws IOException {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(1.32);
        assertEquals(CurrencyConversionService.GBPtoPLN(1.2), 1.58);
    }

    @Test
    void chooseDestination(){
        CurrencyConversionService currencyConversionService = new CurrencyConversionService(1.32);
        assertThrows(BadDataException.class, () -> currencyConversionService.chooseDestination(new CurrencyData("-1","PLN")));
    }
}