package com.dvalpha.core.utils;

import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstUsuario;

import javax.servlet.ServletContextEvent;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
 
public class Tarea extends TimerTask implements ServletContextListener {
    private Timer timer;
    
    
    
    public void contextInitialized(ServletContextEvent evt) {
        // Iniciamos el timer
        timer = new Timer();
        timer.schedule(this, 0,  10*60*1000);  // 10*60*1000 Ejemplo: Cada 10 minutos
    }
 
    public void contextDestroyed(ServletContextEvent evt) {
        timer.cancel();
    }
    
    public void run() {
    	int hora=    LocalDateTime.now().getHour();
    	int minuto = LocalDateTime.now().getMinute();
    	
    	
    	
    		System.out.println("lista ");
    	
    }    
}
