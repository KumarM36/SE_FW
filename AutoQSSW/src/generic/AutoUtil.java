package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {
public static void main(String[] args) throws Exception{
	Properties p=new Properties();
	p.load(new FileInputStream("./qsp.properties"));
	String v=p.getProperty("TIME");
	System.out.println(v);
}
public static String getproperty(String path,String key){
	String v="";
	try{
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		v=p.getProperty(key);
	}
	catch (Exception e){
}
	return v;
}

public static void getphoto(WebDriver driver,String folder,String fileName)
{
	try{
		String dateTime=new Date().toString().replaceAll(":","-");
		String path=folder+fileName+dateTime+".png";
		TakesScreenshot t=(TakesScreenshot) driver;
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File destFile=new File(path);
		FileUtils.copyFile(srcFile, destFile);
	}
	catch (Exception e){	
	}
}
}