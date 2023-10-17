package com.app.Junit.Lesson4project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LessonProject1 {


	// Create your own annotation and use
	// Add displayname annotation
	// repeat the test case 3 times
	// Make it a parmeterized test using csvsource

	WebDriver driver;

	@BeforeAll
	public void StartBrowser()
	{
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
	}

	@ParameterizedTest(name = "CSV source {arguments}")

	@CsvSource({"Admin , Admin@456"})

	//@RepeatedTest(2)
	@DisplayName("Facebook Login")
	public void testMethod(String Username, String Password) {
		driver.findElement(By.cssSelector("input#email")).clear();
		driver.findElement(By.cssSelector("input#email")).sendKeys(Username);

		driver.findElement(By.cssSelector("input[name='pass']")).clear();
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys(Password);
	}


	@AfterAll
	public void closebrowser()
	{
		driver.close();
	}

}