package Pruebas;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
// Debo ponerle el nombre tal cual es el nombre del archivo que creamos! con las mayusc incluidas
import Paginas.PaginaInicio;
import Paginas.PaginaLogin;

public class Laboratorio3_E2 {

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
	
	// PRUEBA 1 - Ir a la pag inicio hacer click en sing in y en la pag que aparece(login) verificar que el titulo sea el que tiene que ser (authentication)
	
	@Test
	public void IrRegistroLogin() {
	    // Instancio el objeto Pagina de inicio (es decir que puedo acceder a esa pag, hacer click, etc)
		PaginaInicio inicio = new PaginaInicio(driver);
		
		// Hago click en boton Sing In
		inicio.ClickOnSingIn();
		
		// Instanciar el objeto Pagina Login
		PaginaLogin login = new PaginaLogin(driver);
		
		// Verificar con AssertEquals que el texto que esta en el titulo de la pagina de Login, coincida con el esperado (Authentication)
		
		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
	}
	
	// Prueba 2 - Ir a la pag login completar el email hacer click en boton crear, ver que el titulo siga siendo authentication y hacer print de pantalla y guardarla. 
	// codificar metodo crear cuenta invalida con anotacion @Test que instancie un objeto de la clase PaginaLogin
	@Test
	public void crearCuentaInvalida() throws IOException {
        PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ClickOnSingIn();
		
		//ir a la pagina Login
		PaginaLogin login = new PaginaLogin(driver);
		
		// completar el email en el espacio para tal fin, y hacerle click al boton crear
		login.ffllEmailAdress("micorreo@gmail.com");
		login.ClickOnBtnCreate();
		
		// ejecutar metodo fetTextTitleFrom y asignarlo a la variable
		String tituloActual = login.getTextTitleForm();
		// Verificar que el texto coincida con el esperado
		Assert.assertEquals(tituloActual, "AUTHENTICATION");
		
		// Poner una espera
		
		WebDriverWait myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_firstname']")));
		
		// tomar screenshot de la ultima pantalla creando un objeto del tipo file con el nombre "screen" 
		File screen=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// guardar el print en la ruta EducacionIT/Evidencias/
		FileUtils.copyFile(screen, new File("..\\EducacionIT\\Evidencias\\Test1.png"));
		
		
	// SABER!! si quiero correr todo en TestNG y que me traiga todos los resultados en html y todo eso, debo 
	//ir a la carpeta testng.xml y asegurarme que dentro de las clases, este Laboratorio3_E2 (que es el titulo de estas pruebas)
	}
	
	
	
}
