package com.bridgelabz.test;

import com.bridgelabz.base.Base;
import com.bridgelabz.pages.DashBoard;
import org.testng.annotations.Test;

import java.awt.*;

public class MakeMyTripTest extends Base {
    @Test(priority = 1)
    public void getFromCity() throws InterruptedException, AWTException {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setSelectFromCity();
    }
    @Test(priority = 2)
    public void getToCity() throws InterruptedException, AWTException {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setToCity();
    }
    @Test(priority = 3)
    public void getDepartDate() throws InterruptedException {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setDepartDate();
    }
    @Test(priority = 4)
    public void getReturnDate() throws InterruptedException {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setReturnDate();
    }
    @Test(priority = 5)
    public void get_flights() {
        DashBoard dashBoard = new DashBoard();
        dashBoard.search_for_flights();
    }
}
