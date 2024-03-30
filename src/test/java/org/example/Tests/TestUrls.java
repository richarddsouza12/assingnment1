package org.example.Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class TestUrls {

    public static int LIMIT = 10;

    @Test
    public void TestUrlsInFacebookPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriver driver = new ChromeDriver( chromeOptions );
        driver.get("https://www.flipkart.com");

        List<WebElement> listAWebElement =  driver.findElements( By.tagName("a") );
        System.out.println( "Total <a href> links found : " +  listAWebElement.size() );
        listAWebElement = listAWebElement.subList( 0 , LIMIT ); /** limit the processing of all links for simplicity */


        System.out.println( "Printing first " + LIMIT + " elements of <a> using foreach loop :" );
        for( WebElement aWebElement : listAWebElement ) {
            System.out.println( aWebElement.getAttribute("href") );
        }


        System.out.println( "Printing first " + LIMIT + " elements of <a> using streams with lambda expression" );
        listAWebElement.stream().forEach( ( element  ) -> {
            System.out.println( element.getAttribute("href") );
        } );


        System.out.println( "Printing first "  + LIMIT + " elements of <a> using parallel streams with lambda expression" );
        listAWebElement.parallelStream().forEach( ( element ) -> {
            System.out.println( element.getAttribute("href") );
        } );

    }


}
