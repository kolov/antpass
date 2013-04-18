package com.akolov.antpass;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.input.DefaultInputHandler;
import org.apache.tools.ant.input.InputRequest;

import java.util.concurrent.CountDownLatch;

public class PasswordInputHandler extends DefaultInputHandler {

    public void handleInput(InputRequest request) throws BuildException {

        CountDownLatch latch = new CountDownLatch(1);
        try {
            final InputDialog dialog = new InputDialog(request.getPrompt(), latch);
            final Thread thread = new Thread(new Runnable() {
                public void run() {
                    dialog.setVisible(true);
                }
            });
            thread.start();
            latch.await();
            dialog.setVisible(false);
            thread.stop();
            final String pw = new String(dialog.getPassword());
            request.setInput(pw);
        } catch (Exception e) {
            super.handleInput(request);
        }
    }



}
