package Pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import Paginas.PaginaInicio;
import Paginas.PaginaLogin;
import Utilidades.DatosExcel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


public class Test_Laboratorio4_E2 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest ="http://automationpractice.com/index.php";
	
	@BeforeSuite
	
	public void setUp() {
		// Defino donde esta el chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Codifico el ChromeDriver - Instancio el driver del navegador chrome
		
		 driver = new ChromeDriver();
		 driver.get (urlTest);
	}
	
	@Test (dataProvider="Datos Crear Cuenta Invalida")
  public void crearCuentaInvalida(String EmailAdress, String Password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ClickOnSingIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.ffllLoginForm(EmailAdress, Password);
		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
	  
  }
	
	@AfterSuite
	public void cierre () {
		driver.close();
	}
	
	@DataProvider (name= "Datos Crear Cuenta Invalida")
	public Object[][] obtenerDatosExcel() throws Exception {
				
		return DatosExcel.leerExcel("..\\EducacionIT\\Datos\\datos Lab4_E2.xlsx", "Sheet1");
	}
}