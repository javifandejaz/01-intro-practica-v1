package ejercicio1_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Letras {

    public static void main(String[] args) {

        Contador contador = new Contador();

        contador.ingresarTexto();

        contador.contarLetras();

        contador.visualizarRecuento();

    }

}


class Contador{

    Scanner ingreso = new Scanner(System.in);

    String texto;

    List <Integer>  cantidad= new ArrayList<>();
    List <Character>  caracteres = new ArrayList<>();

    void ingresarTexto(){

        System.out.println("A continuacion ingrese el texto deseado: ");

        texto=ingreso.nextLine();

    }

    void contarLetras(){

        for(int i = 0; i<texto.length(); i++){

            char letrita=texto.charAt(i);
            int cont=0;

            for(int j=0;j<texto.length();j++){

                if(letrita == texto.charAt(j) && !caracteres.contains(letrita) && letrita != ' '){
                    cont+=1;
                }

            }
            if(cont > 0){
                caracteres.add(letrita);
                cantidad.add(cont);
            }

        }

    }

    void visualizarRecuento(){

        System.out.println("A continuacion las letras y su cantidad: ");

        for (int i= 0; i<caracteres.size(); i++){

            System.out.println("La letra "+caracteres.get(i)+" tiene un total de "+ cantidad.get(i)+" posiciones.");

        }

    }
}
