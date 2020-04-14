package ejercicio1_4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Nombres {

    public static void main(String[] args) {

        Datos nuevos = new Datos ();

        nuevos.ingresarDatos();






    }


}

class Datos{

    Scanner ingreso = new Scanner(System.in);

    String [][] companieros;




    void ingresarDatos(){

        System.out.println("Ingrese la cantidad de companieros: ");
        int cant= ingreso.nextInt();

        companieros = new String[cant][1];

        for( int i = 0; i < companieros.length; i ++){
            System.out.println("Ingrese el nombre del "+(i+1)+" companiero: ");
            companieros[i][0]=ingreso.nextLine();
            for(int j = 0; j < 1; j ++){
                System.out.println("Ingrese el apellido del "+(i+1)+" companiero: ");
                companieros[i][j]=ingreso.nextLine();
            }



        }

    }

    void mostrarNombres(){

        System.out.println("Indique una letra para buscar los nombres: \n");
        String letra= ingreso.nextLine();

        System.out.println("Los nombres con la lerea indicada son: 'n");

        



    }






}
