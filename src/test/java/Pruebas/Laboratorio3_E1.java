package Pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Laboratorio3_E1 {
	// para que WebDriver sea una funcion global, debe ir antes de before Suite
	WebDriver driver;
	
	// tambien podemos poner la pagina inicial como un string:
	String Url = "https://www.facebook.com/";
	
	
	@BeforeSuite
	
	public void setUp() {
		// Defino donde esta el chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Silja\\eclipse-workspace\\EducacionIT\\Drivers\\chromedriver.exe");
		
		// Codifico el ChromeDriver - Instancio el driver del navegador chrome
		
		 driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void irUrl() {
	driver.get(Url);
	}
	
	
	@BeforeClass
	public void maxventana() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	}
	
	@Test
	public void registroUsuario() {
		
		// Ingreso en la pagina facebook.com (Defino la ruta de acceso) 
		
		driver.get("https://facebook.com/");
					
					 		
					
		// Esperas
					
		WebDriverWait myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("u_0_2")));
								
					
		// 	Hacemos click en crear cuenta nueva. Como selector uso cssSelector
				
		WebElement btnCrear = driver.findElement(By.cssSelector("#u_0_2"));
					
		btnCrear.click();
					
		// recomendacion!! cuando codee debo ponerle alguna referencia para darme cuenta a que estoy apuntando. Por ej
		// btn= boton
		// txtNombre= algo para completar
		// selMes= seleccionar el mes.
		// imgLogo= para la imagen del logo
					
					
		// completamos el campo Nombre. Como selector elijo Name (aunque no salga en Chropath). ponerle una espera primero. 
					
		myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
		WebElement txtNombre = driver.findElement(By.name("firstname"));
					
		txtNombre.sendKeys("Silviaa");
					
					
		// Una vez que hacemos los cambios en el Wait (para que quede la version nueva(ver en teorico pag 19))y le agregamos la duration, podemos utilizarlo en el codigo tambien, Por ejemplo para completar el nombre, podemos usar;
					
		//WebElement txtNombre = myWaitVar.until(ExpectedConditions. elementToBeClickable(By.name("firstname")));
		//txtNombre.sendKeys("Silja");
					
		// completamos el campo Apellido . Como selector elijo name.
					
		WebElement txtApellido = driver.findElement(By.name("lastname"));
					
		txtApellido.sendKeys("can");
					
					
		// completamos el campo numero de celular o email.Como selector elijo Css
					
					
					
		WebElement txtCelularEmail = driver.findElement(By.name("reg_email__"));
		txtCelularEmail.sendKeys("silcan@gmail.com");
					
					
		// Campo oculto confirmar email. Ponerle una espera primero. 
					
		myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_email_confirmation__")));
					
		WebElement txtConfirmaEmail = driver.findElement(By.name("reg_email_confirmation__"));
					
		txtConfirmaEmail.sendKeys("silcan@gmail.com");
					
					
					
		// completamos el campo Contraseña nueva. Como selector elijo la ID (porque no parce que fuera a variar)
					
		WebElement txtContraseña = driver.findElement(By.id("password_step_input"));
					
		txtContraseña.sendKeys("12hg1231utjvlhkjñu");
					
							
		// En la lista desplegable fecha de nacimiento, seleccionamos dia ( por xpath) 
					
		WebElement selDia = driver.findElement(By.xpath("//select[@id='day']"));
					
		Select dia = new Select(selDia); 
					
		dia.selectByVisibleText("29");
					
		
		// para elegir las opciones, se recomienda siempre elegirlas por el valor visible!! ( en el codigo, son los valores en negro). 
						
		// En la lista desplegable fecha de nacimiento, seleccionamos mes ( por id). Pero en este caso, para evitar errores por diferencias en el lenguaje
		// se recomienda utilizar en vez del valor visible, utilizarlo por Valor ( Se ven de color azul. Aqui por ej en vez de Sept, va a ser 9). 
					
					
		WebElement selMes = driver.findElement(By.id("month")); 
					
		Select mes = new Select(selMes); 
					
		mes.selectByValue("9");
					
					
		// En la lista desplegable fecha de nacimiento, seleccionamos año ( por id). 
					
		WebElement selAño = driver.findElement(By.id("year")); 
					
		Select año = new Select(selAño); 
					
		año.selectByValue("1967");
					
					
					
		// Tildamos la opcion de Sexo preferida. Ponerle una espera primero. 
					
		WebElement selSexo = myWaitVar.until(ExpectedConditions. elementToBeClickable(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[1]/label[1]"))));
		selSexo.click();
					
					
		// Hacemos click en el boton Registrarse
		WebElement btnRegistrarse = driver.findElement(By.name("websubmit"));
					
		btnRegistrarse.click();
		
		
		// utilizo una verificacion Assert. Compara la pagina actual donde estoy (getcurrenturl) con la pagina inicial 
		
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals(driver.getCurrentUrl(),Url);
		
		// otra forma de validar es comparando un titulo, con su cssSelector por ej. para ver si estan en la misma pag
		// Assert.assertNotEquals(driver.findElement(By.cssSelector("body.UIPage_LoggedOut._-kb._605a.b_c3pyn-ahh.chrome.webkit.win.x1.Locale_es_LA.cores-gte4._19_u.hasAXNavMenubar:nth-child(2) div._li:nth-child(2) div.uiContextualLayerParent:nth-child(3) div.fb_content.clearfix:nth-child(1) div._4-u5._30ny div.mvl.ptm.uiInterstitial.uiInterstitialLarge.uiBoxWhite:nth-child(3) div.uiHeader.uiHeaderBottomBorder.mhl.mts.uiHeaderPage.interstitialHeader div.clearfix.uiHeaderTop div:nth-child(2) > h2.uiHeaderTitle")), "Ingresa el código de seguridad");
	}	
		
	@AfterClass 
	
	public void finPrueba() {
		System.out.println("Fin Prueba");
	}
	
	@AfterTest
	
	public void CerrarNavegador() {
	
		driver.close();
		
			
	}
	
    @AfterSuite
	
	public void finSuite() {
		System.out.println("Fin Suite");
	}
	
	}
