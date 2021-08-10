package com.bridgelabz.pages;

import com.bridgelabz.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DashBoard extends Base {
    //div[@class = 'listingCard ' ]
    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement roundTrip;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/label")
    WebElement fromCity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
    WebElement selectFromCity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/label/span")
    WebElement toCity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input")
    WebElement selectToCity;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]")
    WebElement departure;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")
    WebElement clickOnNext;

    @FindBy(xpath = "//a[@class = 'primaryBtn font24 latoBold widgetSearchBtn '] ")
    WebElement search;

    public DashBoard(){
        PageFactory.initElements(driver,this);
    }
    public void setSelectFromCity() throws AWTException, InterruptedException {
        Thread.sleep(2000);
        roundTrip.click();
        Thread.sleep(1000);
        fromCity.click();
        Thread.sleep(1000);
        Robot robot = new Robot();
        selectFromCity.sendKeys("Mumbai");
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("From City : Mumbai");
    }
    public void setToCity() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        toCity.click();
        Thread.sleep(1000);
        Robot robot = new Robot();
        selectToCity.sendKeys("Bengaluru");
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("To City: Bengaluru");
    }
    public void setDepartDate() throws InterruptedException {
        departure.click();
        String selectDate = "08/04/2021";
        Date d = new Date(selectDate);

        //formatting the date into the required format
        SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
        String date = dt.format(d);
        System.out.println(date);
        //splitting the date by expression "/"
        String[] split = date.split("/");
        System.out.println(split[0] + " " + split[1] + " " + split[2]);
        String month = split[0] + " " + split[2];
        System.out.println(month);
        Thread.sleep(2000);
        while (true) {
            try {
                driver.findElement(By.xpath("//div[text() = '" + month + "']")).isDisplayed();
                clickOnNext.click();
                Thread.sleep(3000);
            } catch (Exception e) {
               driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[4]/div/p")).click();
               Thread.sleep(2000);
               break;
            }
        }
    }
    public void setReturnDate() throws InterruptedException {
//        returnDate.click();
        String selectDate = "08/11/2021";
        Date d = new Date(selectDate);

        //formatting the date into the required format
        SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
        String date = dt.format(d);
        System.out.println(date);
        //splitting the date by expression "/"
        String[] split = date.split("/");
        System.out.println(split[0] + " " + split[1] + " " + split[2]);
        String month = split[0] + " " + split[2];
        System.out.println(month);
        Thread.sleep(2000);
        while (true) {
            try {
                driver.findElement(By.xpath("//div[text() = '" + month + "']")).isDisplayed();
                clickOnNext.click();
                Thread.sleep(3000);
            } catch (Exception e) {
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[4]/div/p")).click();
                Thread.sleep(2000);
                break;
            }
        }

    }
    public void search_for_flights(){
        search.click();
    }
}



