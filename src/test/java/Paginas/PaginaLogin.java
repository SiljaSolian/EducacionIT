package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class PaginaLogin {
	// Encontrar el elemento para completar el email
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement Email;
	
	
	//Encontrar el boton de crear
	@FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")
	WebElement BtnCreate;
	
	// Agrego el elemento adicional Authentication que es el titulo del login. Nos sirve para mas aelante
	
	@FindBy(xpath="//h1[contains(text(),'Authentication')]")
	WebElement title;
	
	// agrego busqueda de otros elementos para el ejercicio 4.1, para Añready Existed
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
	WebElement BtnSignIn;
	
	// Constructor- Inicializa la espera con unos 20 segundos de espera
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	
	// Agregarle el email al casillero 
	public void ffllEmailAdress (String EmailAdress) {
		Email.sendKeys(EmailAdress);
		}
	
    // Hacerle click al boton crear
	public void ClickOnBtnCreate () {
		BtnCreate.click();
		}

    // Creamos el metodo get Text Title From para que, habiendo creado el elemento titulo, nos devuelva el nombre del titulo (Authentication)
	public String getTextTitleForm() {
		return title.getText();
	}
	
	// Ejercicio 4.1 - -creamos un metodo para enviar texto a Already Registred (envio email y pw)
	public void ffllLoginForm(String EmailAdress, String Password) {
		txtEmail.sendKeys(EmailAdress);
		txtPassword.sendKeys(Password);
		BtnSignIn.click();
	
		}
	
}

