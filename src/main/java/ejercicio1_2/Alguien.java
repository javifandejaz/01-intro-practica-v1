package ejercicio1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MiMain{

    public static void main(String[] args) {
        Alguien yo = new Alguien();

        yo.datoParaEntero();

        yo.datoParaListaA();


    }
}



public class Alguien {
    Scanner dato = new Scanner(System.in);
    int entero;
    List <Integer> listaA = new ArrayList<>();
    List <Integer> listaB = new ArrayList<>();


    void datoParaEntero(){
        System.out.println("Ingrese un entero: ");
        entero= dato.nextInt();

    }

    void datoParaListaA(){

        for(int i=0;i<20; i++){
            System.out.println("Ingrese el "+(i+1)+" entero de la lista");
            int num= dato.nextInt();
            listaA.add(num);


            if(num > entero){

                listaB.add(num);
            }
        }

        System.out.println("Los mayores al entero son: "+ listaB);


    }

}
