import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Atv1 {

    @Test
    public void teste() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(300, 1000));
        driver.get("https://google.com.br");
        Assertions.assertEquals("Google", driver.getTitle());
        driver.quit();
    }

    @Test
    public void automacao(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automacaocombatista.herokuapp.com/treinamento/home");
        Assertions.assertEquals("Bem vindo ao Site de Automação do Batista.",
                driver.findElement(By.cssSelector(".tamanhodivupl .orange-text.center")).getText());

        driver.findElement(By.cssSelector("li[class='bold']:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
        driver.findElement(By.cssSelector("a[href='/users/new']")).click();

        driver.findElement(By.id("user_name")).sendKeys("José");
        driver.findElement(By.id("user_lastname")).sendKeys("Weverton");
        driver.findElement(By.id("user_email")).sendKeys("wevertoncaldas62@gmail.com");
        driver.findElement(By.id("user_address")).sendKeys("Cajazeiras");

        driver.findElement(By.id("user_university")).sendKeys("Faculdade Catolica da Paraiba");
        driver.findElement(By.id("user_profile")).sendKeys("Estudante");

        driver.findElement(By.id("user_gender")).sendKeys("Masculino");
        driver.findElement(By.id("user_age")).sendKeys("20");

        driver.findElement(By.cssSelector("[type='submit']")).click();
        Assertions.assertEquals("Usuário Criado com sucesso", driver.findElement(By.id("notice")).getText());

        driver.findElement(By.cssSelector("a[href='/users']")).click();
        Assertions.assertEquals("Lista de Usuários!!", driver.findElement(By.cssSelector(".tamanhodiv2 .center")).getText());

        driver.findElement(By.cssSelector("a[href='/users/new']")).click();
        driver.quit();
    }
}
