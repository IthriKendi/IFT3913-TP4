package test;

public package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import currencyConverter.Currency;
import currencyConverter.MainWindow;

import java.util.ArrayList;

class BoiteBlancheTests {

	ArrayList<Currency> currencies = Currency.init();
	@Test
	void testBoiteBlanche1() {
		String currency1 = "US Dollar";
		String currency2 = "euro";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 0.0;
    
    assertEquals(expectedResult, result);
	}
	@Test
	void testBoiteBlanche2() {
		String currency1 = "us dollar";
        String currency2 = "Euro";
        Double amount = 100.0;
        
        Double result = MainWindow.convert(currency1, currency2, currencies, amount);
        Double expectedResult = 0.0;
        
        assertEquals(expectedResult, result);
	}
	@Test
	
	void testBoiteBlanche3() {
		String currency1 = "US Dollar";
		String currency2 = "Euro";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 93.0;
    
		assertEquals(expectedResult, result);
    }
	@Test
	void testBoiteBlanche4() {
		String currency1 = "US Dollar";
		String currency2 = "US Dollar";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 100.0;
    
		assertEquals(expectedResult, result);
    }
	
	

    
}
