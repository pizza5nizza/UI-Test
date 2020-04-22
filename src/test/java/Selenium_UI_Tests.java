import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Selenium_UI_Tests {

    @Test
    public void testYouTubeVideoTitle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pizza5nizza\\Java\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        // Данный селектор находит картинку-превью первого видео (уже не актуальный, но рабочий)
        // WebElement videoImagePreview = driver.findElement(By.cssSelector("ytd-rich-item-renderer:nth-child(1) #img[width=\"9999\"]"));

        // Первый селектор находит название у первого по счёту видео, записывает его в переменную и печатает на консоль, потом кликает на него
        WebElement videoTitlePreview = driver.findElement(By.cssSelector("#contents ytd-rich-item-renderer:nth-child(1) #video-title"));
        String firstTitle = videoTitlePreview.getText();
        System.out.println(firstTitle);
        videoTitlePreview.click();

        // Отправляем все потоки программы в "сон" на 5 секунд, чтобы успела загрузиться страница выбраного видео
        Thread.sleep(5000);

        // Второй селектор находит название у открывшейся страницы с видео, записывает в переменную и печатает на консоль
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement videoTitle = driver.findElement(By.cssSelector("#container h1 yt-formatted-string"));
        String secondTitle = videoTitle.getText();
        System.out.println(secondTitle);

        // Сравниваем первоначальное и конечное названия видео для удачного прохождения теста
        assertEquals(firstTitle, secondTitle);

        driver.quit();
    }
}