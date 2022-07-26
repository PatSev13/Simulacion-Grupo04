package Pruebas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class main {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        main main = new main();

        main.pruebaU1();
        TimeUnit.SECONDS.sleep(8);
        main.pruebaU2();
        TimeUnit.SECONDS.sleep(8);
        main.pruebaU3();
        TimeUnit.SECONDS.sleep(8);
        main.pruebaU4();

    }

    public void pruebaU1() throws InterruptedException, MalformedURLException {
        /*Se quiere visualizar la oferta académica de la Universidad Fidélitas*/

        //Se configura el ambiente en donde se quiere realizar las pruebas
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        //Se hace la configuración de algunas opciones que ofrece Sauce Labs
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "PU1");
        sauceOptions.put("name", "OfertaAcademica");
        sauceOptions.put("screenResolution", "1920x1080");
        browserOptions.setCapability("sauce:options", sauceOptions);

        //Esta parte de código corresponde a la "vinculación" o enlace con la cuenta pertinente en Sauce Labs
        URL url = new URL("https://oauth-psevillaalvarez-8ee26:07ab4f93-2982-4b7a-b839-fca2fd8d4ef4@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        //Apartir de este punto se ejecutan las pruebas deseadas
        //Variable para verificar el correcto funcionamiento de las pruebas
        String result;

        //Instrucción para entrar a la dirección indicada
        driver.get("https://ufidelitas.ac.cr/");

        TimeUnit.SECONDS.sleep(5);

        //Quitar el banner de "cookies"
        WebElement cookies = driver.findElement(By.xpath("/html/body/section/div/div[2]/a[1]"));
        cookies.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        //Se inicializan objetos para que "tomen la forma" de los elementos de la página (opción propia de Selenium)
        WebElement bach_lic = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/ul/li[1]/a"));

        bach_lic.sendKeys(Keys.ENTER);

        //Esperar
        TimeUnit.SECONDS.sleep(5);

        //Esta instrucción se utiliza para hacer "scroll" determinado número de pixeles
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(5);

        if (driver.getCurrentUrl().equals("https://ufidelitas.ac.cr/carreras/")) {
            result = "passed";
        } else {
            result = "failed";
        }

        driver.executeScript("sauce:job-result=" + result);

        driver.quit();

        /*FIN PRUEBA 1*/
    }

    public void pruebaU2() throws MalformedURLException, InterruptedException {
        /*Se quiere visualizar SOLAMENTE las ingenierías ofrecidas por la universidad*/

        //Se configura el ambiente en donde se quiere realizar las pruebas
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        //Se hace la configuración de algunas opciones que ofrece Sauce Labs
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "PU2");
        sauceOptions.put("name", "FiltroIngenierias");
        sauceOptions.put("screenResolution", "1920x1080");
        browserOptions.setCapability("sauce:options", sauceOptions);

        //Esta parte de código corresponde a la "vinculación" o enlace con la cuenta pertinente en Sauce Labs
        URL url = new URL("https://oauth-psevillaalvarez-8ee26:07ab4f93-2982-4b7a-b839-fca2fd8d4ef4@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        //Apartir de este punto se ejecutan las pruebas deseadas
        //Variable para verificar el correcto funcionamiento de las pruebas
        String result;

        //Instrucción para entrar a la dirección indicada
        driver.get("https://ufidelitas.ac.cr/");

        TimeUnit.SECONDS.sleep(5);

        //Quitar el banner de "cookies"
        WebElement cookies = driver.findElement(By.xpath("/html/body/section/div/div[2]/a[1]"));
        cookies.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        //Se inicializan objetos para que "tomen la forma" de los elementos de la página (opción propia de Selenium)
        WebElement bach_lic = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/ul/li[1]/a"));

        bach_lic.sendKeys(Keys.ENTER);

        //Esperar
        TimeUnit.SECONDS.sleep(5);

        //Esta instrucción se utiliza para hacer "scroll" determinado número de pixeles
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(5);

        WebElement filtro = driver.findElement(By.id("ingenierias"));
        filtro.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        if (driver.getCurrentUrl().equals("https://ufidelitas.ac.cr/carreras/?categoria=ingenierias")) {
            result = "passed";
        } else {
            result = "failed";
        }

        driver.executeScript("sauce:job-result=" + result);

        driver.quit();

        /*FIN PRUEBA 2*/
    }

    public void pruebaU3() throws MalformedURLException, InterruptedException {
        /*Se quiere consultar la información de la carrera de ingeniería en sistemas*/

        //Se configura el ambiente en donde se quiere realizar las pruebas
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        //Se hace la configuración de algunas opciones que ofrece Sauce Labs
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "PU3");
        sauceOptions.put("name", "IngenieriaSistemas");
        sauceOptions.put("screenResolution", "1920x1080");
        browserOptions.setCapability("sauce:options", sauceOptions);

        //Esta parte de código corresponde a la "vinculación" o enlace con la cuenta pertinente en Sauce Labs
        URL url = new URL("https://oauth-psevillaalvarez-8ee26:07ab4f93-2982-4b7a-b839-fca2fd8d4ef4@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        //Apartir de este punto se ejecutan las pruebas deseadas
        //Variable para verificar el correcto funcionamiento de las pruebas
        String result;

        //Instrucción para entrar a la dirección indicada
        driver.get("https://ufidelitas.ac.cr/");

        TimeUnit.SECONDS.sleep(5);

        //Quitar el banner de "cookies"
        WebElement cookies = driver.findElement(By.xpath("/html/body/section/div/div[2]/a[1]"));
        cookies.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        //Se inicializan objetos para que "tomen la forma" de los elementos de la página (opción propia de Selenium)
        WebElement bach_lic = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/ul/li[1]/a"));

        bach_lic.sendKeys(Keys.ENTER);

        //Esperar
        TimeUnit.SECONDS.sleep(5);

        //Esta instrucción se utiliza para hacer "scroll" determinado número de pixeles
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(5);

        WebElement filtro = driver.findElement(By.id("ingenierias"));
        filtro.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        WebElement ing_comp = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[4]/div/div/div[10]/div/div[2]/a[2]"));
        ing_comp.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(6);

        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(6);

        js.executeScript("window.scrollBy(0,-1200)");

        TimeUnit.SECONDS.sleep(6);

        if (driver.getCurrentUrl().equals("https://ufidelitas.ac.cr/carrera/bachillerato-ingenieria-sistemas-de-computacion/")) {
            result = "passed";
        } else {
            result = "failed";
        }

        driver.executeScript("sauce:job-result=" + result);

        driver.quit();

        /*FIN PRUEBA 3*/
    }

    public void pruebaU4() throws MalformedURLException, InterruptedException {
        /*Se quiere acceder a la red social de Facebook de la universidad*/

        //Se configura el ambiente en donde se quiere realizar las pruebas
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        //Se hace la configuración de algunas opciones que ofrece Sauce Labs
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "PU4");
        sauceOptions.put("name", "FacebookU");
        sauceOptions.put("screenResolution", "1920x1080");
        browserOptions.setCapability("sauce:options", sauceOptions);

        //Esta parte de código corresponde a la "vinculación" o enlace con la cuenta pertinente en Sauce Labs
        URL url = new URL("https://oauth-psevillaalvarez-8ee26:07ab4f93-2982-4b7a-b839-fca2fd8d4ef4@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        //Apartir de este punto se ejecutan las pruebas deseadas
        //Variable para verificar el correcto funcionamiento de las pruebas
        //Instrucción para entrar a la dirección indicada
        driver.get("https://ufidelitas.ac.cr/");

        TimeUnit.SECONDS.sleep(5);

        //Quitar el banner de "cookies"
        WebElement cookies = driver.findElement(By.xpath("/html/body/section/div/div[2]/a[1]"));
        cookies.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        //Se inicializan objetos para que "tomen la forma" de los elementos de la página (opción propia de Selenium)
        WebElement bach_lic = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div[2]/div/ul/li[1]/a"));

        bach_lic.sendKeys(Keys.ENTER);

        //Esperar
        TimeUnit.SECONDS.sleep(5);

        //Esta instrucción se utiliza para hacer "scroll" determinado número de pixeles
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(5);

        WebElement filtro = driver.findElement(By.id("ingenierias"));
        filtro.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        WebElement ing_comp = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[4]/div/div/div[10]/div/div[2]/a[2]"));
        ing_comp.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        js.executeScript("window.scrollBy(0,1200)");

        TimeUnit.SECONDS.sleep(6);

        js.executeScript("window.scrollBy(0,-1200)");

        TimeUnit.SECONDS.sleep(6);

        WebElement facebook = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]"));
        facebook.sendKeys(Keys.ENTER);

        TimeUnit.SECONDS.sleep(5);

        //En esta prueba se eliminará el if para mostrar qué pasa
        driver.quit();

        /*FIN PRUEBA 4*/
    }

}
