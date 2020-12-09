/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI.chill;

import java.util.ArrayList;
import java.util.List;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bupble
 */
public class MAILsender extends Thread {

    static {
        MAILsender sender = new MAILsender();
        sender.start();
    }
    static final List<MimeMessage> queue = new ArrayList<>();

    public static void queue(MimeMessage mail) {
        synchronized (queue) {
            queue.add(mail);
            queue.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        try {
                            MimeMessage mail = queue.remove(0);
                            Transport.send(mail);
                            System.out.println("the mail was send.");
                        } catch (Exception e) {
                            System.out.println("unable to send mail");
                        }
                    } else {
                        queue.wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
