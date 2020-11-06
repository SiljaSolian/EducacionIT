package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaInicio {
	// ubicar el elemento Sing In
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement TestSingIn;
	
	
	// Ubicar el titulo de la pagina
	@FindBy(xpath="//title[contains(text(),'My Store')]")
	WebElement Title;
	
	
	// Constructor- Inicializa la espera con unos 20 segundos de espera
	public PaginaInicio(WebDriver driver) {
	PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}

	// Hacerle click al boton Sing In
    public void ClickOnSingIn () {
	TestSingIn.click();
}
}