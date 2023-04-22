package opalinski.jakub.currencieswebapp.PojoClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;

}