package opalinski.jakub.currencieswebapp.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import opalinski.jakub.currencieswebapp.PojoClasses.Rate;
import opalinski.jakub.currencieswebapp.PojoClasses.Root;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

@Component
public class ActualExchangeRateService {

    public double getActualExchangeRate() throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(responseStream, Root.class);
        Rate rate = root.getRates().get(0);
        return rate.getMid();
    }

}
