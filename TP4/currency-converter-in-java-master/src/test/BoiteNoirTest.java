package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

class BoiteNoirTest {
	
	ArrayList<Currency> currencies = Currency.init();
	
	// Tests sur Partition du domaine des entrées en classes d’équivalence
	
	// MainWindow.convert
	
	@Test
	void testAppartenenatIntervalleMW() {
		String currency1 = "US Dollar";
        String currency2 = "Euro";
        Double amount = 100.0;
        
        Double result = MainWindow.convert(currency1, currency2, currencies, amount);
        Double expectedResult = 93.0;
        
        assertEquals(expectedResult, result);
	}
	
	@Test
	void testSuperieurIntervalleMW() {
		String currency1 = "USD";
        String currency2 = "EUR";
        Double amount = 2000000.0;
        
        Double result = MainWindow.convert(currency1, currency2, currencies, amount);
        Double expectedResult = 465.0;
        
        assertEquals(expectedResult, result);
	}
	
	@Test
	void testinferieurIntervalleMW() {
		String currency1 = "USD";
        String currency2 = "EUR";
        Double amount = -500.0;
        
        Double result = MainWindow.convert(currency1, currency2, currencies, amount);
        Double expectedResult = 465.0;
        
        assertEquals(expectedResult, result);
	}
	
	// Currency.convert
	
	@Test
	void testAppartenenatIntervalleCurr() {
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        
        Double result = Currency.convert(amount, exchangeValue);
        Double expectedResult = 150.0;
        
        assertEquals(expectedResult, result);
	}
	
	@Test
	void testsuperieurIntervalleCurr() {
        Double amount = 200000.0;
        Double exchangeValue = 1.5;
        
        Double result = Currency.convert(amount, exchangeValue);
        Double expectedResult = 0.0;
        
        assertEquals(expectedResult, result);
	}
	
	@Test
	void testinferieurIntervalleCurr() {
        Double amount = -100.0;
        Double exchangeValue = 1.5;
        
        Double result = Currency.convert(amount, exchangeValue);
        Double expectedResult = 0.0;
        
        assertEquals(expectedResult, result);
	}
	
	// Tests sur l'Analyse des valeurs frontières
	
	// Currency.convert
	
	@Test
	void testAppartenenatIntervalleCurrfrontiere() {
		Double amount = 0.0;
	    Double exchangeValue = 1.5;
	    
	    Double result = Currency.convert(amount, exchangeValue);
	    Double expectedResult = 0.0;
	        
	    assertEquals(expectedResult, result);
	 }
		
	@Test
	void testAppartenenatIntervalleCurrfrontiere2() {
	    Double amount = 1000000.0;
	    Double exchangeValue = 1.5;
	        
	    Double result = Currency.convert(amount, exchangeValue);
	    Double expectedResult = 1500000.0;
	        
	    assertEquals(expectedResult, result);
	}
		
	@Test
	void testsuperieurIntervalleCurrfrontiere() {
	    Double amount = 100001.0;
	    Double exchangeValue = 1.5;
	        
	    Double result = Currency.convert(amount, exchangeValue);
	    Double expectedResult = 0.0;
	        
	    assertEquals(expectedResult, result);
	}
		
	@Test
	void testinferieurIntervalleCurrfrontiere() {
	    Double amount = -1.0;
	    Double exchangeValue = 1.5;
	        
	    Double result = Currency.convert(amount, exchangeValue);
	    Double expectedResult = 0.0;
	        
	    assertEquals(expectedResult, result);
	}
	
	
	
	

}
