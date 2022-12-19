package projeto_threads;

public class Relogio extends Thread {
     public int hora = 0;
     public int minuto = 0;
     public int segundo = 0;

     @Override
     public void run() {
          while (!Thread.currentThread().isInterrupted()){
               segundo++;

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
                    Thread.sleep(1000);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     }

     public void ajustarHora(int hora, int minuto, int segundo){
         this.hora = hora;
         this.minuto = minuto;
         this.segundo = segundo;
     }

     @Override
     public String toString() {
          return hora + ":" + minuto + ":" + segundo;
     }

}