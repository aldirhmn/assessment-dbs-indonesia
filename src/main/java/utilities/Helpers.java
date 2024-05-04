package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Helpers {

    private static WebDriver driver;
    private static Properties properties;
    private static String folderName;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }

    public static WebElement waitForElementVisible(By object, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(object));
    }

    public static boolean isElementPresent(By object){
        try {
            driver.findElement(object);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    static{
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/config.properties")){
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed To Read Config Properties");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    static {
        String basePath = System.getProperty("user.dir");
        SimpleDateFormat folderFormatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-SSS");
        folderName = folderFormatter.format(new Date());
        String directoryPath = basePath + File.separator + "screenshots" + File.separator + folderName;
        File directory = new File(directoryPath);
        if (!directory.exists()){
            directory.mkdirs();
        }
    }

    public static void takeScreenshot(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-SSS");
        String fileFormatter = formatter.format(new Date());
        String basePath = System.getProperty("user.dir");
        String directoryPath = basePath + File.separator + "screenshots" + File.separator + folderName;

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = directoryPath + File.separator + "screenshots_" + fileFormatter + ".png";

        try {
            Files.copy(screenshotFile.toPath(), Path.of(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
