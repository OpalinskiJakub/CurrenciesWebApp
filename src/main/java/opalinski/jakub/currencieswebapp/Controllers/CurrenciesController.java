package opalinski.jakub.currencieswebapp.Controllers;


import opalinski.jakub.currencieswebapp.Services.ActualExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DecimalFormat;

@RestController
public class CurrenciesController {

    private final ActualExchangeRateService actualExchangeRateService;

    @Autowired
    public CurrenciesController(ActualExchangeRateService actualExchangeRateService){
        this.actualExchangeRateService=actualExchangeRateService;
    }

    @GetMapping("/GBPRate")
    public String getActualRate() throws IOException {
        DecimalFormat change = new DecimalFormat("#.##");
        String result = change.format(actualExchangeRateService.getActualExchangeRate());
        return result;
    }
}
