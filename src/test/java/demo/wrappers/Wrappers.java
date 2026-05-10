package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
     public static void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void radioButton(ChromeDriver driver, String radioButtonText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + radioButtonText + "')]") );
            element.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void checkBox(ChromeDriver driver, String checkBoxText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + checkBoxText + "')]") );
            element.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   
    public static void dropDownClickByLoop(List<WebElement> elements, String dropdownText){
        try{
            for(WebElement element:elements){
                if(element.getText().equals(dropdownText)){
                    element.click();
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void clickOnElement(ChromeDriver driver, WebElement element){
         try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
         }catch(Exception e){
            e.printStackTrace();
         }
    }

    public static String getdateSevenDaysAgo(int days){
        LocalDate currenDate = LocalDate.now();
        LocalDate dateMinus7Days = currenDate.minusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = dateMinus7Days.format(formatter);
        return formattedDate;
    }

    public static String getEpochTimeString(){
        long epoch = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epoch);
        return epochTimeString;
    }

    public static boolean handleAlert(ChromeDriver driver){
    try{
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return true;
    }catch(Exception e){
        return false;
    }
    }
}
