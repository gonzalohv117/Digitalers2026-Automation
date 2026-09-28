package snippet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ejercicios {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBusquedaGoogle() {
        driver.get("https://www.google.com");

        WebElement barraBusqueda = driver.findElement(By.name("q"));
        barraBusqueda.sendKeys("Selenium WebDriver");
        barraBusqueda.sendKeys(Keys.ENTER);

        String tituloActual = driver.getTitle();
        Assert.assertTrue(tituloActual.contains("Selenium"), "El título no contiene la palabra buscada.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}