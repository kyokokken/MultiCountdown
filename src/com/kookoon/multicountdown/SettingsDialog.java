package com.kookoon.multicountdown;

import javax.swing.*;
import java.awt.event.*;

public class SettingsDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spnHours;
    private JSpinner spnMinutes;
    private JSpinner spnSeconds;
    long millis;
    boolean setted;
    int hours;
    int minutes;
    int seconds;

    public SettingsDialog() {
        setted = false;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() {
        this.hours = (int) spnHours.getValue();
        this.minutes = (int) spnMinutes.getValue();
        this.seconds = (int) spnSeconds.getValue();
        this.millis = (hours * 60 * 60
                + minutes * 60
                + seconds) * 1000;
        setted = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        SettingsDialog dialog = new SettingsDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // setup spinners
        SpinnerModel modelHours = new SpinnerNumberModel(0, 0, 99, 1);
        SpinnerModel modelMinutes = new SpinnerNumberModel(0, 0,
                59, 1);
        SpinnerModel modelSeconds = new SpinnerNumberModel(0, 0,
                59, 1);
        spnSeconds = new JSpinner(modelSeconds);
        spnMinutes = new JSpinner(modelMinutes);
        spnHours = new JSpinner(modelHours);

        // TODO: place custom component creation code here
    }
}
