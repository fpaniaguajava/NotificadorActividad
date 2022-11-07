package com.fernandopaniagua.notificadoractividad;

import java.awt.TrayIcon;
import java.util.Timer;
import java.util.TimerTask;

public class NotificadorActividad extends TimerTask{

    public static void main(String[] args) {
        try {
            int delay = Integer.parseInt(args[0]);
            int period = Integer.parseInt(args[1]);
            Timer temporizador = new Timer();
            NotificadorActividad notificadorActividad = new NotificadorActividad();
            temporizador.schedule(notificadorActividad, delay, period);
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    
    @Override
    public void run() {
        try {
            Notificador.showNotification("Aviso de inactividad", "Llevas demasiado tiempo sentado", TrayIcon.MessageType.WARNING);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
}
