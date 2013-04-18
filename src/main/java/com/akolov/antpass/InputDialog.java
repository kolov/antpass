package com.akolov.antpass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;


public class InputDialog extends JFrame {

    private JPasswordField passwordField;
    private char[] password;
    CountDownLatch latch;
    String title;

    public InputDialog(String title, CountDownLatch latch) {
        this.latch = latch;
        this.title = title;
        initUI();
    }


    public final void initUI() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        final InputDialog dialog = this;
        JButton quitButton = new JButton("OK");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                password = passwordField.getPassword();
                latch.countDown();
                dialog.dispose();
            }
        });


        // password
        passwordField = new JPasswordField(20);


        panel.add(passwordField);
        panel.add(quitButton);
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    public char[] getPassword() {
        return password;
    }

}

