package co.com.sofka.app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BasicCalculator {

    public static final Logger logger = LoggerFactory.getLogger (BasicCalculator.class);

    public Long suma(Long number1, Long number2){
        logger.info( "Sumando {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long resta(Long number1, Long number2){
        logger.info( "Restando {} - {}", number1, number2 );
        return number1 - number2;
    }

    public Long multiplicacion(Long number1, Long number2){
        logger.info( "Multiplicando {} * {}", number1, number2 );
        return number1 * number2;
    }

    public Long division(Long number1, Long number2){
        if(number2 == 0){
            throw new ArithmeticException("No se puede dividir sobre 0");
        }
        logger.info( "Dividiendo {} / {}", number1, number2 );
        return number1 / number2;
    }

}
