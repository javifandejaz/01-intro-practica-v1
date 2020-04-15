package ejercicio1_4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Nombres {

    public static void main(String[] args) {

        Datos nuevos = new Datos ();

        nuevos.ingresarDatos();

        nuevos.mostrarNombres();

    }


}

class Datos{

    Scanner ingreso = new Scanner(System.in);

    String [] companieros;

    void ingresarDatos(){

        System.out.println("Ingrese la cantidad de companieros: ");

        int cant= ingreso.nextInt();
        ingreso.nextLine();

        companieros= new String[cant];

        for(int i = 0; i < companieros.length; i ++){
            System.out.print("Ingrese el nombre del "+(i+1)+" companiero: ");
            companieros[i]=ingreso.nextLine();

        }

    }

    void mostrarNombres(){

        System.out.println("Indique una letra para buscar los nombres: \n");

        String letra= ingreso.nextLine();

        System.out.println("Los nombres con la letra "+letra+" son: \n");

        for(int i=0; i<companieros.length; i++){

            if(companieros[i].substring(0,1).equalsIgnoreCase(letra)){

                System.out.println("_"+companieros[i]);
            }

        }

        System.out.println("FIN");

    }






}
