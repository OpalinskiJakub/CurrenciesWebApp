package opalinski.jakub.currencieswebapp.Connection;


import com.fasterxml.jackson.databind.ObjectMapper;
import opalinski.jakub.currencieswebapp.Exceptions.BadDataException;
import opalinski.jakub.currencieswebapp.PojoClasses.CurrencyData;
import opalinski.jakub.currencieswebapp.Services.CurrencyConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private final CurrencyConversionService currencyConversionService;

    public SocketHandler(CurrencyConversionService currencyConversionService){
        this.currencyConversionService=currencyConversionService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, BadDataException {

        ObjectMapper mapper = new ObjectMapper();
        CurrencyData currencyData = mapper.readValue(message.getPayload(), CurrencyData.class);
        CurrencyData newCurrencyData = currencyConversionService.chooseDestination(currencyData);
        String newCurrencyDataInJson = mapper.writeValueAsString(newCurrencyData);
        session.sendMessage(new TextMessage(newCurrencyDataInJson));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage(Double.toString(currencyConversionService.getActualExchangeRate())));
    }
}
