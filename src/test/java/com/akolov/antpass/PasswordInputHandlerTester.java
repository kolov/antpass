package com.akolov.antpass;

import com.akolov.antpass.PasswordInputHandler;
import org.apache.tools.ant.input.InputRequest;


public class PasswordInputHandlerTester {
    public static void main(String[] args) {

        PasswordInputHandler pid = new PasswordInputHandler();
        System.out.println("Begin");
        InputRequest input = new InputRequest("Your password, please");
        pid.handleInput(input);
        System.out.println("Password:" + input.getInput());
    }
}
