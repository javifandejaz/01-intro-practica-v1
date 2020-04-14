package ejercicio1_1;

import java.util.Scanner;

public class Ejercicio1_1 {

    public static void main(String [] args){

        int [] numeros = new int[10];

        Scanner ingresoDatos = new Scanner(System.in);

        for(int i=0; i<numeros.length;i++){
            System.out.println("ingresa un numero entero por favor: ");
            numeros[i]=ingresoDatos.nextInt();
        }

        System.out.println("\nA CONTINUACION SE MUESTRAN LOS NUMEROS INGRESADOS EN ORDEN INVERSO: ");

        for(int i = numeros.length-1;i >= 0 ; i--){
            System.out.print(numeros[i]+", ");
        }

    }

}
