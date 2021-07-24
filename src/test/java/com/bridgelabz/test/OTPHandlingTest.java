package com.bridgelabz.test;

import com.bridgelabz.OTPHandling;
import com.bridgelabz.base.Base;
import org.testng.annotations.Test;

public class OTPHandlingTest extends Base {
    @Test
    public static void readOTP() throws InterruptedException {
        OTPHandling otpHandling = new OTPHandling(driver);
        otpHandling.readOTP();
    }
}
