package ejercicio1_7;

import java.util.Random;

public class Matriz10x10 {

    public static void main(String[] args) {

        Dato matriz = new Dato();

        matriz.datosAleatorios();

        matriz.muestraDatos();

    }

}


class Dato{

    int [][] numeros = new int[10][10];
    Random datos = new Random();

    void datosAleatorios(){
        for(int i = 0;i<numeros.length;i++){
            for(int j=0;j<numeros.length;j ++){
                numeros[i][j]=datos.nextInt(100);
            }
        }

    }

    void muestraDatos(){
        System.out.println("A continuacion se mostraran los datos de la matriz 10x10: ");
        String tipo = " %3d ";
        for(int i=0;i<numeros.length;i++){
            System.out.println();
            for(int j=0;j<numeros.length;j++){
                System.out.format(tipo,numeros[i][j]);
            }
        }
    }


}