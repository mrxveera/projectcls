package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

  public static WebDriver driver;
	
  public static Robot r;
	
  public static WebDriver chromeBowser() {
	 WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
	return driver;
     
	}
	
  public static  WebDriver firefox() {
		 WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		return driver;

	}
	
  public static   WebDriver edge() {
		 WebDriverManager.edgedriver().setup();
		 WebDriver driver =new EdgeDriver();
		return driver;
		
      }
	
  public static   WebDriver  OperaDriver() {
		 WebDriverManager.operadriver().setup();
		 return driver=new OperaDriver();
	}
	
  public static void urlLaunch(String url) {
		driver.get(url); 
        driver.manage().window().maximize();
	}
	
  public static void implicitlyWait(int a) {
		driver.manage().timeouts().implicitlyWait(a,TimeUnit.SECONDS);

	}
	
  public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value); 
	}
  
  public static void click(WebElement e) {
	 e.click();

}

  public static void quit() {
	 driver.quit();

}
  
  public static void close() {
	 driver.close();

}

  public static void forword() {
	 driver.navigate().forward();

}
  
  public static void backWord() {
	 driver.navigate().back();

}
  
  public static void refresh() {
	 driver.navigate().refresh();
}
 
  public static void navigateTo(String url) {
	 driver.navigate().to(url);

}
  
  public static String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;

}
  
  public static String getTitle() {
	 String title = driver.getTitle();
	return title;

}
  
 public static void clear(WebElement e) {
	 e.clear();

}
  
 public static String  getAttribute(WebElement e) {
	 
	 String attribute = e.getAttribute("value");
	return attribute;
	 

}

  public static String getCssValue(WebElement e,String value) {
	 String cssValue = e.getCssValue(value);
	return cssValue;
}
  
  public static String getText(WebElement e) {
	 String text = e.getText();
	return text;
}
  
  public static Dimension getSize(WebElement e) {
	 Dimension size = e.getSize();
	return size;

}
  
  public static   boolean isDisplayed(WebElement e) {
	 boolean displayed = e.isDisplayed();
	return displayed;
}
  
  public static boolean isEnabled(WebElement e) {
	 boolean enabled = e.isEnabled();
	return enabled;

}
  
  public static boolean isSelected(WebElement e) {
	 boolean selected = e.isSelected();
	return selected;

}
  
  
  public static void keyPress(int KeyEvent) throws AWTException {
	   r=new Robot();
	  r.keyPress(KeyEvent);

}
  public static void keyRelease(int value) {
	 r.keyRelease(value);

}
  public static String ReadExcel(String filename,String sheet,int row,int c) throws IOException {
	  File f=new File("C:\\Users\\Veera\\eclipse-workspace\\PracticeMaven\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream st =new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);                    
		Cell cell = r.getCell(c);
		int Type = cell.getCellType(); 
		String value =null;
		if(Type==1) {
			value = cell.getStringCellValue();
		}
		
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-YYYY");
			value = sd.format(dateCellValue);
		}
		else{
		double numericCellValue = cell.getNumericCellValue();
			long num=(long)numericCellValue;
			value=String.valueOf(num);
			
		}
		
		}
		return value;
  }
  
}
		
		
		
		
		
		
		
		
		



  
  
  

