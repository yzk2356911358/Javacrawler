package com.shwl.navigation;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClicker{

public AutoClicker(){
    try {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(6000);
        Thread.interrupted();
    } catch (AWTException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    while(true){
        new AutoClicker();
    }
}

}