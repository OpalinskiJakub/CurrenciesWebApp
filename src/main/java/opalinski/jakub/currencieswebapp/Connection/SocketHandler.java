package opalinski.jakub.currencieswebapp.Connection;


import opalinski.jakub.currencieswebapp.Services.CurrencyConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private CurrencyConversionService currencyConversionService;

    public SocketHandler(CurrencyConversionService currencyConversionService){
        this.currencyConversionService=currencyConversionService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {

        String currency = message.getPayload().substring(0,3);
        String amount = message.getPayload().substring(3);
        if(currency.equals("PLN")){
            double toDouble = Double.parseDouble(amount);
            double result = currencyConversionService.PLNtoGBP(toDouble);
            session.sendMessage(new TextMessage(Double.toString(result)));
        }else if(currency.equals("GBP")){
            double toDouble = Double.parseDouble(amount);
            double result = currencyConversionService.GBPtoPLN(toDouble);
            session.sendMessage(new TextMessage(Double.toString(result)));
        }


    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage(Double.toString(currencyConversionService.getActualExchangeRate())));
    }
}
