package ejercicio1_6;

import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {

        Datos dato=new Datos();

        dato.ingresaDatos();

        dato.muestraDatos();

    }

}


class Datos{
    Scanner ingreso = new Scanner(System.in);
    int [][] numeros = new int[3][3];

    void ingresaDatos (){
        System.out.println("A continuación va a ingresar los datos de las filas \n");
        for(int i=0; i<numeros.length; i++){
            System.out.println("Ingrese los datos de la fila n° "+(i+1));
            for(int j=0;j<numeros.length; j++){
                System.out.print("Ingrese el "+(j+1)+" dato: ");
                numeros[i][j]=ingreso.nextInt();
            }
        }
        System.out.println();
    }

    void muestraDatos(){
        System.out.println("A continuacion se mostraran los datos de la matriz 3x3: ");
        String tipo = " %3d ";
        for(int i=0;i<numeros.length;i++){
            System.out.println();
            for(int j=0;j<numeros.length;j++){
                System.out.format(tipo,numeros[i][j]);
            }
        }
    }


}