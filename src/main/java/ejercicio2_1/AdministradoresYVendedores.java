package ejercicio2_1;

import com.sun.deploy.util.StringUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradoresYVendedores {

    public static void main(String[] args) {

        DatosDeEmpleados nueva = new DatosDeEmpleados();

        nueva.carga();

        nueva.listar();

    }

}

abstract class Empleado{

    Scanner ingreso = new Scanner(System.in);

    int dni;
    String nombre;
    String apellido;
    String email;
    double sueldoBase;

    abstract double getSueldo();

    void dni(){
        dni=ingreso.nextInt();
        ingreso.nextLine();
    }
    void nombre(){
        nombre=ingreso.nextLine();
        nombre= nombre.substring(0,1).toUpperCase()+nombre.substring(1).toLowerCase();
    }
    void apellido(){
        apellido=ingreso.nextLine();
        apellido= apellido.substring(0,1).toUpperCase()+apellido.substring(1).toLowerCase();
    }
    void email(){
        email=ingreso.nextLine();
    }
    void sueldoBase(){
        sueldoBase=ingreso.nextInt();
    }


}

class DatosDeEmpleados {

    Scanner ingreso = new Scanner(System.in);
    List <Empleado> listaDeEmpleados = new ArrayList<>();

    void carga() {

        int dato = 0;

        while (dato == 0){

            Empleado empleado;

            System.out.println("Indique 'A' si es administrativo o 'V' si es vendedor");

            String tipo = ingreso.nextLine();

            if (tipo.equalsIgnoreCase("A")){
                empleado = new Administrativo();
            } else {
                empleado = new Vendedor();
            }

            System.out.print("Ingrese el dni: ");
            empleado.dni();

            System.out.print("Ingrese el nombre: ");
            empleado.nombre();

            System.out.print("Ingrese el apellido: ");
            empleado.apellido();

            System.out.print("Ingrese el email: ");
            empleado.email();

            System.out.print("Ingrese el sueldo base: ");
            empleado.sueldoBase();

            listaDeEmpleados.add(empleado);

            System.out.println("Presione 0 para continuar o 1 para finalizar ");

            dato=ingreso.nextInt();

            ingreso.nextLine();
        }
    }
    void listar(){

        //iNTENTO DE FORMAT

        String formato="Dni: %d\tNombre: %s\tApellido: %s\tSueldo: %.2f";

        listaDeEmpleados.forEach(empleado ->
                System.out.println(String.format
                        (formato,+empleado.dni,empleado.nombre,empleado.apellido,empleado.getSueldo())));

        //PREFIERO ESTA FORMA:

        //listaDeEmpleados.forEach(empleado -> System.out.println(" Empleado: "+empleado.dni+" "
          //      +empleado.nombre+" "+empleado.apellido+" sueldo:"+empleado.getSueldo()));

    }

}


class Administrativo extends Empleado{

    int hsExtra=10;
    int hsMes=192;

    void setHsExtra(){
        System.out.print("Indique la cantidad de horas extra realizadas: ");
        hsExtra=ingreso.nextInt();
    }
    void setHsMes(){
        System.out.print("Indique la cantidad de horas trabajadas: ");
        hsMes=ingreso.nextInt();
    }
    double getSueldo(){
        return sueldoBase * ((hsExtra * 1.5)+hsMes) / hsMes;
    }

}


class Vendedor extends Empleado {

    double porcenComision=0.10;
    int totalVtas=250000;

    void setPorcenComision(){
        System.out.print("Indique el porcentaje de comision: ");
        porcenComision=ingreso.nextDouble();
    }
    void setTotalVtas(){
        System.out.print("Indique el total de las ventas: ");
        totalVtas=ingreso.nextInt();
    }
    double getSueldo(){
        return sueldoBase + (porcenComision*totalVtas/100);
    }

}