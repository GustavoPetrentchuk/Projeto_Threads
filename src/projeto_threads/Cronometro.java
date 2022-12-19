/**
@see https://stackoverflow.com/questions/16758346/how-pause-and-then-resume-a-thread
*/

package projeto_threads;

import java.util.ArrayList;
import java.util.List;

public class Cronometro extends Thread {

     private int hora = 0;
     private int minuto = 0;
     private int segundo = 0;
     private int milisegundo = 0;

     private boolean rodando = true;
     private boolean parado = false;
     private final Object pause = new Object();

     @Override
     public void run() {
          System.out.println("Cronometro iniciado");
          while (rodando){

               synchronized (pause){
                    if (!rodando) {
                         break;
                    }
                    if (parado){
                         try {
                              pause.wait();
                         }catch (InterruptedException ex){
                              break;
                         }
                    }
               }

               milisegundo++;

               if (milisegundo == 1000){
                    segundo++;
                    milisegundo = 0;
               }
               if (segundo == 60){
                    minuto ++;
                    segundo = 0;
               }
               if(minuto == 60){
                    hora++;
                    minuto = 0;
               }
               if (hora == 25){
                    hora = 0;
               }

               try {
                    Thread.sleep(1);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     }


     public void pararCronometro(){
          parado = true;
     }

     public void resumir(){
          synchronized (pause){
               parado = false;
               pause.notifyAll();
          }

     }

     public void zerarCronometro(){
          milisegundo = 0;
          segundo = 0;
          minuto = 0;
          hora = 0;
     }

     @Override
     public String toString() {

          return hora + ":" + minuto + ":" + segundo + ":" + milisegundo;
     }
}
