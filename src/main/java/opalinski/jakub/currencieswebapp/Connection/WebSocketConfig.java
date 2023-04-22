package opalinski.jakub.currencieswebapp.Connection;

import opalinski.jakub.currencieswebapp.Services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    CurrencyConversionService currencyConversionService;

    @Autowired
    public WebSocketConfig(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }


    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketHandler(currencyConversionService), "/app");
    }

}
