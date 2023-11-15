package by.itacademy.bakumenko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSiteTest {
    @Test
    public void testOnliner() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        String enterButtonLocator = "//*[@id=\"userbar\"]/div[1]/div/div/div[1]";
        By enterButtonBy = By.xpath(enterButtonLocator);
        Thread.sleep(4000);
        WebElement enterButtonWebElement = driver.findElement(enterButtonBy);
        enterButtonWebElement.click();
        String enterTitleOauthFormLocator = "//*[@id=\"auth-container\"]/div/div[2]/div/div[1]";
        By enterTitleOauthFormBy = By.xpath(enterTitleOauthFormLocator);
        WebElement enterTitleOauthFormWebElement = driver.findElement(enterTitleOauthFormBy);
        String actual = enterTitleOauthFormWebElement.getText();
        String expected = "Вход";
        Assertions.assertEquals(expected, actual);
        driver.close();
    }

    @Test
    public void testJavaRash() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://javarush.com/");
        String enterButtonLocator = "//*[@id=\"button_menu_start_learning_unauthorized_user\"]";
        By enterButtonBy = By.xpath(enterButtonLocator);
        WebElement enterButtonWebElement = driver.findElement(enterButtonBy);
        enterButtonWebElement.click();
        String enterTitleOauthFormLocator = "//*[@id=\"id_button_jr_welcome_start_learning_1\"]";
        By enterTitleOauthFormBy = By.xpath(enterTitleOauthFormLocator);
        WebElement enterTitleOauthFormWebElement = driver.findElement(enterTitleOauthFormBy);
        String actual = enterTitleOauthFormWebElement.getText();
        String expected = "НАЧАТЬ";
        Assertions.assertEquals(expected, actual);
        driver.close();
    }

    @Test
    public void testOnlinerLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        String enterButtonLocator = "//*[@id=\"userbar\"]/div[1]/div/div/div[1]";
        By enterButtonBy = By.xpath(enterButtonLocator);
        Thread.sleep(4000);
        WebElement enterButtonWebElement = driver.findElement(enterButtonBy);
        enterButtonWebElement.click();

        String buttonEnter = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button";
        By buttonEnterBy = By.xpath(buttonEnter);
        WebElement buttonEnterWebElement = driver.findElement(buttonEnterBy);
        buttonEnterWebElement.click();

        String errorMassageLogin = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
        By errorMassageLoginBy = By.xpath(errorMassageLogin);
        WebElement errorMassageLoginWebElement = driver.findElement(errorMassageLoginBy);
        String actualErrorMassageLogin = errorMassageLoginWebElement.getText();
        String expectedErrorMassageLogin = "Укажите ник или e-mail";
        Assertions.assertEquals(expectedErrorMassageLogin, actualErrorMassageLogin);

        String errorMassagePassword = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";
        By errorMassagePasswordBy = By.xpath(errorMassagePassword);
        WebElement errorMassagePasswordWebElement = driver.findElement(errorMassagePasswordBy);
        String actualErrorMassagePassword = errorMassagePasswordWebElement.getText();
        String expectedErrorMassagePassword = "Укажите пароль";
        Assertions.assertEquals(expectedErrorMassagePassword, actualErrorMassagePassword);
        driver.close();

    }

    @Test
    public void testDev() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://devby.io");
        String enterButtonLocator = "/html/body/div[2]/header/div[1]/div[3]/a";
        WebElement enterButton = driver.findElement(By.xpath(enterButtonLocator));
        enterButton.click();

        String inputTextLoginLocator = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input";
        Thread.sleep(4000);
        WebElement inputTextLoginElement = driver.findElement(By.xpath(inputTextLoginLocator));
        inputTextLoginElement.sendKeys("webgetd");

        String inputTextPasswordLocator = "//*[@id=\"root\"]/div/div/div/div/div/div/form/ul/li[2]/div/input";

        Thread.sleep(4000);
        WebElement inputTextPasswordElement = driver.findElement(By.xpath(inputTextPasswordLocator));
        inputTextPasswordElement.sendKeys("321");

        String enterButtonFormLocator = "//*[@id=\"root\"]/div/div/div/div/div/div/form/ul/li[2]/div/input";
        WebElement enterButtonFormElement = driver.findElement(By.xpath(enterButtonFormLocator));
        enterButtonFormElement.click();

        String textErrorLoginPasswordLocator = "//*[@id=\"root\"]/div/div/div/div/div/div/form/span";
        WebElement textErrorLoginPasswordElement = driver.findElement(By.xpath(textErrorLoginPasswordLocator));

        String actual = textErrorLoginPasswordElement.getText();
        String expected = "Неверный логин или пароль.";
        Assertions.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void TestDevBy2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://devby.io/");

        OnlinerPage onlinerPage = new OnlinerPage();
        WebElement enterButton = driver.findElement(By.xpath(onlinerPage.buttonEnterLocator));
        enterButton.click();

        Thread.sleep(4000);
        WebElement inputLogin = driver.findElement(By.xpath(onlinerPage.inputLoginLocator));
        inputLogin.sendKeys("test");

        WebElement inputPassword = driver.findElement(By.xpath(onlinerPage.inputPasswordLocator));
        WebElement buttonEnter = driver.findElement(By.xpath(onlinerPage.buttonEnterLocator));
        buttonEnter.click();

        Thread.sleep(4000);
        WebElement errorMassage = driver.findElement(By.xpath(onlinerPage.errorMassageLocator));
        Assertions.assertEquals("Неверный логин или пароль.", errorMassage.getText());
        driver.close();
    }

    @Test
    public void TestAvBy() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://av.by/");
        AvPage avPage = new AvPage();

        WebElement buttonEnter = driver.findElement(By.xpath(avPage.buttonEnterLocator));
        buttonEnter.click();

        Thread.sleep(2000);
        WebElement buttonLoginOption = driver.findElement(By.xpath(avPage.buttonLoginOptionLocator));
        buttonLoginOption.click();

        WebElement inputEmail = driver.findElement(By.xpath(avPage.inputEmailLocator));
        inputEmail.sendKeys("test@test");

        WebElement inputPassword = driver.findElement(By.xpath(avPage.inputPasswordLocator));
        inputPassword.sendKeys("test");

        Thread.sleep(2000);
        WebElement buttonSubmit = driver.findElement(By.xpath(avPage.buttonSubmitLocator));
        buttonSubmit.click();

        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath((avPage.errorMessageLocator)));
        String actualErrorMessage = errorMessage.getText();
        Assertions.assertEquals("Слишком часто вводится неверный пароль. Повторите попытку позже", actualErrorMessage);
        driver.close();
    }
}
