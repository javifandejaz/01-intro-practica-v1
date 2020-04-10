package ejercicios1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1_1 {

    public static void main(String [] args){

        int [] numeros = new int[10];

        Scanner ingresoDatos = new Scanner(System.in);

        for(int i=0; i<10;i++){
            System.out.println("ingresa un numero entero por favor: ");
            numeros[i]=ingresoDatos.nextInt();
        }

        System.out.println("\nA CONTINUACION SE MUESTRAN LOS NUMEROS INGRESADOS EN ORDEN INVERSO: ");

        for(int i=9; i>=0;i--){
            System.out.print(numeros[i]+", ");
        }

    }

}
