package opalinski.jakub.currencieswebapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DecimalFormat;

@Component
public class CurrencyConversionService {


    private ActualExchangeRateService actualExchangeRateService;

    private double actualExchangeRate;

    @Autowired
    public CurrencyConversionService(ActualExchangeRateService actualExchangeRateService) throws IOException {
        this.actualExchangeRate=actualExchangeRateService.getActualExchangeRate();
    }

    public CurrencyConversionService(double actualExchangeRateForTests) {
        this.actualExchangeRate=actualExchangeRateForTests;
    }



    public double PLNtoGBP(double value) throws IOException {
        DecimalFormat change = new DecimalFormat("#.##");
        double result = value*this.actualExchangeRate;
        return Double.parseDouble(change.format(result));
    }

    public double GBPtoPLN(double value) throws IOException {
        DecimalFormat change = new DecimalFormat("#.##");
        double result = value/this.actualExchangeRate;
        return Double.parseDouble(change.format(result));
    }

    public double getActualExchangeRate(){
        DecimalFormat change = new DecimalFormat("#.##");
        double result = this.actualExchangeRate;
        return result;
    }
}
