package opalinski.jakub.currencieswebapp.PojoClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Root {
    private String table;
    private String currency;
    private String code;
    private ArrayList<Rate> rates;

}