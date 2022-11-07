package com.fernandopaniagua.notificadoractividad;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class Notificador {
    public static void showNotification(String caption, String text, MessageType messageType) 
            throws Exception {
        if (SystemTray.isSupported()) {
            displayTray(caption, text, messageType);
        } else {
            System.err.println("System tray not supported!");
            throw new Exception("Las notificaciones no están soportadas por el sistema");
        }
    }
    private static void displayTray(String caption, String text, MessageType messageType) 
            throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");

        TrayIcon trayIcon = new TrayIcon(image, "Mensaje");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Mensaje");
        tray.add(trayIcon);
        trayIcon.displayMessage(caption, text, messageType);
    }
}
