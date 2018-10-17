/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romano1;

/**
 *
 * @author JHPAT
 */import java.util.Scanner;
public class Romano1 {
   static final String INSTRUCCIONES = "Introduzca un decimal menor a 9999 o un número romano válido:";
   static final String ERROR = "El numero introducido es incorrecto";
   public static int millares = 0, centenas = 0, decenas = 0, unidades = 0;
   public static String [][] romanos={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
         {"","X","XX","XXX","XL","L","LX","LXX","LXX","XC"},
         {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
         {"","M","MM","MMM","Mv","v","vM","vMM","vMMM","Mx"}};
   private static Scanner scan;
    
   public static void main(String[] args) {
      System.out.println(INSTRUCCIONES);
      scan = new Scanner(System.in);
      String numero = scan.nextLine();
      Romano1.convertir(numero);
   }
    
   private static void convertir(String numero) {
      try{ //intenta convertir arabigo a romano
         Romano1.obtenerNotDesarrollada(Integer.valueOf(numero));
         System.out.println(Romano1.obtenerRomano());
      }catch (NumberFormatException e){
         try{ //intenta convertir romano a arabigo
            System.out.println(Romano1.obtenerArabigo(numero.trim()));
         }
         catch(Exception e1){
            System.out.println(ERROR);
         }
      }
      catch(Exception e){
         System.out.println(ERROR);
      }
       
   }
    
   public static void obtenerNotDesarrollada(int numero) {
      millares = (int)numero / 1000;
      centenas = (int)numero % 1000 / 100;
      decenas = (int)numero % 1000 % 100 / 10;
      unidades = (int)numero % 1000 % 100 % 10;
   }
    
   public static String obtenerRomano(){
      return romanos[3][millares]+""+
            romanos[2][centenas]+""+
            romanos[1][decenas]+""+
            romanos[0][unidades]+"";
   }
 
   private static String obtenerArabigo(String numero) {
      int size = numero.length();
      String arabigo = "";
      for (int i = 3; i>-1; i--){
         for(int j = size; j>-1; j--){
            int valor = -1;
            valor = escanear(numero.substring(0,j),i);
            if (valor > -1){
               arabigo = arabigo + valor;
               numero = numero.substring(j,size);
               size = numero.length();
               break;
            }
         }
      }
      return arabigo;
   }
 
   private static int escanear(String cadena, int orden) {
      for (int j = 9; j>-1; j-- ){
         if(romanos[orden][j].equals(cadena)){
            return j;
         }
      }
      return -1;
   }
 
}
