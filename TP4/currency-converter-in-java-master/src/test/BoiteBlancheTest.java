package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import currencyConverter.Currency;
import currencyConverter.MainWindow;

import java.util.ArrayList;

class BoiteBlancheTests {

	
	ArrayList<Currency> currencies = Currency.init();
	// pour tester Currency.convert
	@Test
	void testBoiteBlanche0() {
		Double amount = 100.0;
        Double exchangeValue = 1.5;
        
        Double result = Currency.convert(amount, exchangeValue);
        Double expectedResult = 150.0;
        
        assertEquals(expectedResult, result);
    
    
	}
	//Test de MainWindow.convert
	//cas 1 de couverture des arcs du graphe de flot de contrôle 
	@Test
	void testBoiteBlanche1() {
		String currency1 = "US Dollar";
		String currency2 = "euro";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 0.0;
    
    assertEquals(expectedResult, result);
	}
	//cas 2 de couverture des arcs du graphe de flot de contrôle 
	@Test
	void testBoiteBlanche2() {
		String currency1 = "us dollar";
        String currency2 = "Euro";
        Double amount = 100.0;
        
        Double result = MainWindow.convert(currency1, currency2, currencies, amount);
        Double expectedResult = 0.0;
        
        assertEquals(expectedResult, result);
	}
	//cas 3 de couverture des arcs du graphe de flot de contrôle && couverture d'instructions .
	@Test
	void testBoiteBlanche3() {
		String currency1 = "US Dollar";
		String currency2 = "Euro";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 93.0;
    
		assertEquals(expectedResult, result);
    }
	//cas de couverture des chemins indépendants du graphe de flot de contrôle
	@Test
	void testBoiteBlanche4() {
		String currency1 = "US Dollar";
		String currency2 = "US Dollar";
		Double amount = 100.0;
    
		Double result = MainWindow.convert(currency1, currency2, currencies, amount);
		Double expectedResult = 100.0;
    
		assertEquals(expectedResult, result);
    }
	//test de Couverture des i-chemins 
	@Test
	void testBoiteBlanche5() {
		
		Double amount = 100.0;
		for(int i=0;i<currencies.size();i++) {
		Double result = MainWindow.convert(currencies.get(i).getName(), currencies.get(i).getName(), currencies, amount);
		Double expectedResult = 100.0;
    
		assertEquals(expectedResult, result);}
    }
	
	
		

}
