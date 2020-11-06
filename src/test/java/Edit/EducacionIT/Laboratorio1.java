package Edit.EducacionIT;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;

// Punto 10 (ej1) y punto 2 (Ej2) - Importo libreria

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Laboratorio1 {
	// Punto 9 - Creo el metodo Lab1_E1
	@Test
	public void Lab1_E1() {
		//Punto 11 - Defino donde esta el chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Silja\\eclipse-workspace\\EducacionIT\\Drivers\\chromedriver.exe");
		
		// Punto 12 - Codifico el ChromeDriver - Instancio el driver del navegador chrome
		
		WebDriver driver= new ChromeDriver();
		
		// Punto 13 - Ingreso en la pagina Selenuum.dev (Defino la ruta de acceso) 
		
		driver.get("https://selenium.dev/");
		
		// Punto 14 - Codificar el cierre
		driver.close();
	}
	
	
	
	// EJERCICIO 2 - Creo todo para FIREFOX
	
	// Punto 1: 
	@Test
	public void Lab1_E2() {
		try {
			// Punto 3:
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Silja\\eclipse-workspace\\EducacionIT\\Drivers\\geckodriver.exe");
			
			// Punto 4
			
			WebDriver driver= new FirefoxDriver();
			
			// Punto 5 - Ingreso en la pagina Selenuum.dev (Defino la ruta de acceso) 
			
			driver.get("https://selenium.dev/");
			
			// Punto 6 - Maximizar el navegador
			 
			driver.manage().window().maximize();
			
			// Punto 7 - Codificar el cierre
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// Ejercicio 3
	@Test
	public void Lab1_E3() {
		
		//try {
			//Punto 1 - Defino donde esta el chromedriver.exe
			
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Silja\\eclipse-workspace\\EducacionIT\\Drivers\\chromedriver.exe");
			
			// Punto 2 - Codifico el ChromeDriver - Instancio el driver del navegador chrome
			
			WebDriver driver= new ChromeDriver();
			
			// Punto 3 - Ingreso en la pagina Selenuum.dev (Defino la ruta de acceso) 
			
			driver.get("https://selenium.dev/");
			
			
			// si quiero incorporar ESPERAS IMPLICITAS
			
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			
		
			
			
			// Punto 5, 6 y 7
			
			WebElement txtSearch = driver.findElement(By.id("gsc-i-id1"));
			
			txtSearch.sendKeys("Java");
			
			txtSearch.sendKeys(Keys.ENTER);
			
			// Punto 8 - Codificar el cierre
			driver.close();
		//} catch(Exception e) {
		//	System.out.println(e.getMessage());
		//}
	}
}
