package com.selenium.DemoProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestAllType {
	public static final String USERNAME = "saurabdey3";
	public static final String AUTOMATE_KEY = "g4pSxhMbR9S85gQptvtB";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void tes() throws MalformedURLException {

		System.out.println("********************START--Selenium Java Code on BrowserStack**********************");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "62.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("name", "Bstack-[Java] Sample Test");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement element1 = driver.findElement(By.id("txtUsername"));
		element1.sendKeys("Admin");

		WebElement element2 = driver.findElement(By.id("txtUsername"));
		element2.sendKeys("admin123 ");
		element2.submit();

		System.out.println(driver.getTitle());
		driver.quit();
		System.out.println("********************END--Selenium Java Code on BrowserStack**********************");
		System.out.println();
		System.out.println();
		System.out.println("********************START--Rest API using Rest Assured**********************");
		
		Response resp = RestAssured.given().baseUri("http://dummy.restapiexample.com/api/v1/employees")
				.contentType("application/json").when().get();

		String myresponse = resp.getBody().asString();
		int status = resp.statusCode();
		long myTime = resp.getTime();

		System.out.println(myresponse);
		System.out.println(status);
		System.out.println(myTime);
		System.out.println("********************START--Rest API using Rest Assured**********************");

	}
}
