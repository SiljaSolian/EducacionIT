package Edit.EducacionIT;

// Aqui van todos los imports

import org.testng.annotations.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Laboratorio2 {
		// aqui van todos los metodos ( y todos empiezan con el @test)
	
		@Test
		public void Lab2_E1() {
			//Punto 4 - Defino donde esta el chromedriver.exe
			
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Silja\\eclipse-workspace\\EducacionIT\\Drivers\\chromedriver.exe");
			
			// Punto 4 - Codifico el ChromeDriver - Instancio el driver del navegador chrome
			
			WebDriver driver= new ChromeDriver();
			
			// Punto 5 - Ingreso en la pagina facebook.com (Defino la ruta de acceso) 
			
			driver.get("https://facebook.com/");
			
			 		
			
			// PUNTO 6 - Esperas
			
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
			
			txtNombre.sendKeys("Silja");
			
			
			// Una vez que hacemos los cambios en el Wait (para que quede la version nueva(ver en teorico pag 19))y le agregamos la duration, podemos utilizarlo en el codigo tambien, Por ejemplo para completar el nombre, podemos usar;
			
			//WebElement txtNombre = myWaitVar.until(ExpectedConditions. elementToBeClickable(By.name("firstname")));
			//txtNombre.sendKeys("Silja");
			
			// completamos el campo Apellido . Como selector elijo name.
			
            WebElement txtApellido = driver.findElement(By.name("lastname"));
			
			txtApellido.sendKeys("Solian");
			
			
			// completamos el campo numero de celular o email.Como selector elijo Css
			
			
			
			WebElement txtCelularEmail = driver.findElement(By.name("reg_email__"));
			txtCelularEmail.sendKeys("silsolian@gmail.com");
			
			
			// Campo oculto confirmar email. Ponerle una espera primero. 
			
			myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_email_confirmation__")));
			
	        WebElement txtConfirmaEmail = driver.findElement(By.name("reg_email_confirmation__"));
			
			txtConfirmaEmail.sendKeys("silsolian@gmail.com");
			
			
			
			// completamos el campo Contraseña nueva. Como selector elijo la ID (porque no parce que fuera a variar)
			
			WebElement txtContraseña = driver.findElement(By.id("password_step_input"));
			
			txtContraseña.sendKeys("12hgtdutjvlhkjñu");
			
					
			// En la lista desplegable fecha de nacimiento, seleccionamos dia ( por xpath) 
			
			WebElement selDia = driver.findElement(By.xpath("//select[@id='day']"));
			
			Select dia = new Select(selDia); 
			
			dia.selectByVisibleText("23");
			
			
			// para elegir las opciones, se recomienda siempre elegirlas por el valor visible!! ( en el codigo, son los valores en negro). 
				
			// En la lista desplegable fecha de nacimiento, seleccionamos mes ( por id). Pero en este caso, para evitar errores por diferencias en el lenguaje
			// se recomienda utilizar en vez del valor visible, utilizarlo por Valor ( Se ven de color azul. Aqui por ej en vez de Sept, va a ser 9). 
			
			
			WebElement selMes = driver.findElement(By.id("month")); 
			
			Select mes = new Select(selMes); 
			
			mes.selectByValue("9");
			
			
			// En la lista desplegable fecha de nacimiento, seleccionamos año ( por id). 
			
	        WebElement selAño = driver.findElement(By.id("year")); 
			
			Select año = new Select(selAño); 
			
			año.selectByValue("1989");
			
			
			
			// Tildamos la opcion de Sexo preferida. Ponerle una espera primero. 
			
			WebElement selSexo = myWaitVar.until(ExpectedConditions. elementToBeClickable(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/span[1]/span[1]/label[1]"))));
			selSexo.click();
			
			
			// Hacemos click en el boton Registrarse
			WebElement btnRegistrarse = driver.findElement(By.name("websubmit"));
			
			btnRegistrarse.click();
		
							
			
		}
	

}
