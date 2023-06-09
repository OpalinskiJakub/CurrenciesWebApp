package opalinski.jakub.currencieswebapp.Services;

import opalinski.jakub.currencieswebapp.Exceptions.BadDataException;
import opalinski.jakub.currencieswebapp.PojoClasses.CurrencyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DecimalFormat;

@Component
public class CurrencyConversionService {

    private static final String PATTERN = "#.##";

    private static final String PLN = "PLN";

    private static final String GBP = "GBP";

    private static ActualExchangeRateService actualExchangeRateService;

    private static double actualExchangeRate;

    @Autowired
    public CurrencyConversionService(ActualExchangeRateService actualExchangeRateService) throws IOException {
        actualExchangeRate = actualExchangeRateService.getActualExchangeRate();
    }

    public CurrencyConversionService(double actualExchangeRateForTests) {
        actualExchangeRate = actualExchangeRateForTests;
    }


    public CurrencyData chooseDestination(CurrencyData currencyData) throws IOException, BadDataException {
        if (Double.parseDouble(currencyData.getAmount()) < 0) {
            throw new BadDataException("Negative number");
        }
        if (currencyData.getType().equals(PLN)) {
            double toDouble = Double.parseDouble(currencyData.getAmount());
            double result = CurrencyConversionService.PLNtoGBP(toDouble);
            CurrencyData newCurrencyData = new CurrencyData(Double.toString(result), GBP);
            return newCurrencyData;
        } else if (currencyData.getType().equals(GBP)) {
            double toDouble = Double.parseDouble(currencyData.getAmount());
            double result = CurrencyConversionService.GBPtoPLN(toDouble);
            CurrencyData newCurrencyData = new CurrencyData(Double.toString(result), PLN);
            return newCurrencyData;
        }
        return null;
    }

    public static double GBPtoPLN(double value) throws IOException {
        DecimalFormat change = new DecimalFormat(PATTERN);
        double result = value * actualExchangeRate;
        return Double.parseDouble(change.format(result));
    }

    public static double PLNtoGBP(double value) throws IOException {
        DecimalFormat change = new DecimalFormat(PATTERN);
        double result = value / actualExchangeRate;
        return Double.parseDouble(change.format(result));
    }

    public double getActualExchangeRate() {
        DecimalFormat change = new DecimalFormat(PATTERN);
        double result = actualExchangeRate;
        return result;
    }
}
