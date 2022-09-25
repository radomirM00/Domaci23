import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Base {
    private static WebDriver driver;
    public Base (String url){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeRegistrationModal(String element){
        WebElement xBtn = driver.findElement(By.className(element));
        xBtn.click();
    }
    public static void selectLink(String path){
        WebElement selection = driver.findElement(By.xpath(path));
        selection.click();
    }

    public static void scrollAndSelectLink(String path){
        WebElement link = driver.findElement(By.xpath(path));
        Actions actions = new Actions(driver);
        actions.moveToElement(link);
        link.click();

    }

    public static List<WebElement> links(String path){
        List<WebElement> list = driver.findElements(By.xpath(path));
        return list;
    }

    public static WebElement filterLinks(List<WebElement> links,String href) {

        WebElement link = null;
        for (WebElement we : links) {
            if (we.getAttribute("href").equals(href)) {
                link = we;
            }
        }
        return link;
    }

    public static void printCategoryTitles(){
        WebElement categoriesWrapper = driver.findElement(By.id("realCategoriesHolder"));
        List<WebElement> categoryTitles = categoriesWrapper.findElements(By.className("categoryTitle"));
        for (WebElement we:categoryTitles){
            System.out.println(we.findElement(By.tagName("span")).getText());
        }
    }

    public static void closeDriver(){
        driver.close();
    }

}
