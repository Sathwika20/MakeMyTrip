package com.bridgelabz;

import com.bridgelabz.base.Base;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTPHandling extends Base {
    public static final String ACCOUNT_SID = "ACd6b25191e0b0f12a03ae877c51369abf";
    public static final String AUTH_TOKEN = "c3275d4ed391db750d5608e5afb77bb2";

    @FindBy(xpath = "//div[@class = 'makeFlex column flexOne whiteText latoBold']")
    public static WebElement newAccount;

    @FindBy(xpath = "//p[@class = 'makeFlex hrtlCenter flagCountryCode']")
    public static WebElement countryCode;

    @FindBy(xpath = "//input[@id = 'username']")
    public static WebElement mobileNumber;

    @FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[1]/div/div/div/div/div[3]")
    public static WebElement unitedStates;

    @FindBy(xpath = "//button[@class = 'capText font16']")
    public static WebElement clickOnContinue;

    @FindBy(xpath = "//input[@id = 'otp']")
    public static WebElement OTP;

    @FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")
    public static WebElement login;


    public OTPHandling(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String readOTP() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(newAccount).click().build().perform();
//        Thread.sleep(2000);
        mobileNumber.sendKeys("5082837648");
        Thread.sleep(2000);
        countryCode.click();
        Thread.sleep(2000);
        unitedStates.click();
        Thread.sleep(2000);
        clickOnContinue.click();
        Thread.sleep(2000);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String smsBody = getMessage();
        System.out.println(smsBody);
        String[] oTPNumber = smsBody.split("[^\\d]+");
        OTP.sendKeys(oTPNumber);
        Thread.sleep(2000);
        login.click();
        String otp = oTPNumber[1];
        System.out.println(otp);
        return otp;
    }

    public static String getMessage() {
            return getMessages().filter(message -> message.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                    .filter(message -> message.getTo().equals("+15082837648")).map(Message::getBody).findFirst()
                    .orElseThrow(IllegalStateException::new);
        }

        public static Stream<Message> getMessages() {
            ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
            return StreamSupport.stream(messages.spliterator(), false);
        }

   }







