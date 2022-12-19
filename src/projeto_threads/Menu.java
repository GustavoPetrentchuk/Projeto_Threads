package projeto_threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Thread{
     private int opcao = 0;
     private int i;
     Scanner scanner = new Scanner(System.in);
     Relogio r1 = new Relogio();
     List<Cronometro> lCronometros = new ArrayList<>();
     List<Alarme> lAlarmes = new ArrayList<>();
     Cronometro c1;
     Alarme a1;
     private int h, m, s;

     @Override
     public void run() {
          r1.start();
          while(true){
               System.out.println("\n===================\n");
               System.out.println("1- Mostrar Relogio\n2- Ajustar Relogio\n3- Definir Alarme\n" +
                       "4- Iniciar novo Cronometro\n5- Parar Cronometro\n6- Resumir cronometro\n7- Zerar Cronometro" +
                       "\n8- Mostrar Cronometro\n9- Listar alarmes\nOpcao: ");
               opcao = scanner.nextInt();
               switch (opcao){
                    case 1:
                         System.out.println("=====Relogio===== \n" + r1 + "\n=====Relogio=====");
                         break;
                    case 2:
                         System.out.println("Digite a hora: ");
                         h = scanner.nextInt();
                         System.out.println("Digite os minutos: ");
                         m = scanner.nextInt();
                         System.out.println("Digite os segundo: ");
                         s = scanner.nextInt();
                         r1.ajustarHora(h, m, s);
                         break;
                    case 3:
                         System.out.println("Digite a hora: ");
                         h = scanner.nextInt();
                         System.out.println("Digite os minutos: ");
                         m = scanner.nextInt();
                         a1 = new Alarme(r1, h, m, lAlarmes);
                         lAlarmes.add(a1);
                         a1.start();
                         break;
                    case 4:
                         c1 = new Cronometro();
                         lCronometros.add(c1);
                         c1.start();
                         break;
                    case 5:
                         System.out.println("Existem " + lCronometros.size() + " Cronometros\n Qual dejesa parar? ");
                         i = scanner.nextInt();
                         System.out.println(lCronometros.get(i));
                         lCronometros.get(i).pararCronometro();
                         break;
                    case 6:
                         System.out.println("Existem " + lCronometros.size() + " Cronometros\n Qual dejesa resumir? ");
                         i = scanner.nextInt();
                         lCronometros.get(i).resumir();
                         break;
                    case 7:
                         System.out.println("Existem " + lCronometros.size() + " Cronometros\n Qual dejesa zerar? ");
                         i = scanner.nextInt();
                         lCronometros.get(i).zerarCronometro();
                         break;
                    case 8:
                         System.out.println("Lista de Cronometros ☺");
                         lCronometros.forEach(cronometro -> System.out.println(cronometro));
                         break;
                    case 9:
                         System.out.println("Lista de Alarmes ☺");
                         lAlarmes.forEach(alarme -> System.out.println(alarme));
                         break;
               }
               try {
                    Thread.sleep(1000);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     }
}
