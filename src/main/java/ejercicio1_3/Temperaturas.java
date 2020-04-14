package ejercicio1_3;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Temperaturas {

    public static void main(String[] args) {

        Datos datos = new Datos();

        datos.ingresoTemp();

        datos.temperaturaMinimaYMaxima();

    }
}


class Datos{

    double [] temperaturas = new double[24];

    double minima= 1000;
    double media=0;
    double maxima=-1000;
    double total=0;

    void ingresoTemp(){

        Scanner ingreso = new Scanner(System.in);

        for(int i = 0; i<temperaturas.length; i++){

            System.out.println("ingrese la "+ (i+1) + " temperatura: ");

            double dato = ingreso.nextDouble();

            temperaturas[i]=dato;

            total +=temperaturas[i];

            media=total/temperaturas.length;

        }


    }

    void temperaturaMinimaYMaxima(){

        for( double temp: temperaturas){

            if( minima > temp){

                minima=temp;
            }
            else if( maxima < temp){
                maxima = temp;
            }

        }

        System.out.println(minima);
        System.out.println(maxima);

        this.grafico();

    }

    private void grafico(){

        for( int i = 0; i< temperaturas.length; i ++){

            System.out.print(i+ "  ");
            int valor=(int)Math.round(temperaturas[i]);

            for(double j = 0 ; j < valor; j++){
                System.out.print("*");

            }

            if(temperaturas[i] == minima){

                System.out.println(" "+temperaturas[i] + " -- !! TEMPERATURA MINIMA !! --");

            }
            else if(temperaturas[i]==maxima){

                System.out.println(" "+temperaturas[i] + " -- !! TEMPERATURA MAXIMA !! --");
            }
            else{
                System.out.println(" "+temperaturas[i]);
            }

        }

        System.out.print("La temperatura media es: ");
        System.out.printf("%1.1f", media);

    }



}
