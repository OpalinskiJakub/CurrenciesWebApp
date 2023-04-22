package opalinski.jakub.currencieswebapp.PojoClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyData {
    private String amount;
    private String type;
}
