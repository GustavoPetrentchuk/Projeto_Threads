package projeto_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alarme extends Thread{
     Relogio r2;
     private int hora;
     private int minuto;
     private boolean interrupted;
     List<Alarme> lAlarmes;

     public Alarme(Relogio r2, int hora, int minuto, List<Alarme> lAlarmes) {
          this.interrupted = false;
          this.r2 = r2;
          this.hora = hora;
          this.minuto = minuto;
          this.lAlarmes = lAlarmes;

     }

     @Override
     public void run(){
         while (!interrupted){
              try {
                   notificar();
                   Thread.sleep(1000);
              } catch (InterruptedException e) {
                   e.printStackTrace();
              }
         }
     }

     public void notificar(){
          if (this.hora == r2.hora && this.minuto == r2.minuto && r2.segundo == 0) {
               System.out.println("Alarme de " + r2.hora + ":" + r2.minuto + " disparado!" );
               this.interrupted = true;
               lAlarmes.remove(this);
          }
     }

     @Override
     public String toString() {
          return hora + ":" + minuto;
     }
}