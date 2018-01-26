package com.kookoon.multicountdown;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MultiCountdownGUI {
    private JPanel pnlMain;
    private JButton btnAddCountdown;
    private JButton btnPlay;
    private JButton btnSettings;
    private JLabel lblTime;
    private JButton btnRemove;
    private Countdown countdown;
    private int count;

    public static void main(String args[]) {
        new MultiCountdownGUI().start();
    }

    private void start() {
        countdown = new Countdown(new Timer(0, 0, 0));
        JFrame frame = new JFrame("Multi Countdown");
        Image addIcon = null;
        Image playIcon = null;
        Image settingsIcon = null;
        Image removeIcon = null;
        try {
            addIcon = ImageIO.read(getClass().getResource("assets/add.png"));
            btnAddCountdown.setIcon(new ImageIcon(addIcon));

            playIcon = ImageIO.read(getClass().getResource("assets/play.png"));
            btnPlay.setIcon(new ImageIcon(playIcon));

            settingsIcon = ImageIO.read(getClass().getResource("assets/settings.png"));
            btnSettings.setIcon(new ImageIcon(settingsIcon));

            removeIcon = ImageIO.read(getClass().getResource("assets/remove.png"));
            btnRemove.setIcon(new ImageIcon(removeIcon));

            setupBtnSettingsActionListener();

            btnPlay.addActionListener(e -> {
                countdown.start();
                javax.swing.Timer timer = new javax.swing.Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long millisLeft = countdown.getMillisLeft();
                        Time time = Utilities.fromMillisToTime(millisLeft);
                        String timerString = String.format("%02d:%02d:%02d.%03d", time.hours, time.minutes, time.seconds, time.millis);
                        System.out.println("Millis: " + millisLeft);
                        System.out.println("TimerString: " + timerString);
                        lblTime.setText(timerString);
                        if (countdown.isElapsed())  {
                            ((javax.swing.Timer)e.getSource()).stop();
                            countdown.playSound();
                        }
                    }
                });
                timer.setDelay(1000 / 60);
                timer.setRepeats(true);
                timer.start();
            });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(pnlMain);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setupBtnSettingsActionListener() {
        btnSettings.addActionListener(e -> {
            SettingsDialog dialog = new SettingsDialog();
            dialog.pack();
            dialog.setVisible(true);
            if (dialog.setted) {
                long millis = dialog.millis;
                String timerString = String.format("%02d:%02d:%02d", dialog.hours, dialog.minutes, dialog.seconds);
                System.out.println("Millis: " + millis);
                System.out.println("TimerString: " + timerString);
                lblTime.setText(timerString);
                countdown.set(dialog.hours, dialog.minutes, dialog.seconds);

            }
        });
    }
}
