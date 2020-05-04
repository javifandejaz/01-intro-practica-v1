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
    abstract void paraSueldo();

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
        sueldoBase=ingreso.nextDouble();
    }


}

class DatosDeEmpleados {

    Scanner ingreso = new Scanner(System.in);
    List <Empleado> listaDeEmpleados = new ArrayList<>();

    void carga() {

        int dato = 0;

        while (dato < 21){

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

            empleado.paraSueldo();

            listaDeEmpleados.add(empleado);

            System.out.println("Presione '1' para continuar o '0' para finalizar ");
            dato=ingreso.nextInt();

            if( dato== 1){

                dato+=1;
            }
            else{
                dato=30;
            }

            ingreso.nextLine();
        }
    }
    void listar(){

        //iNTENTO DE FORMAT

        String formato="Dni: %-10d Nombre: %-10s Apellido: %-10s Sueldo: %-15.2f";

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
    void paraSueldo(){
        this.setHsExtra();
        this.setHsMes();
    }
    double getSueldo(){
        return sueldoBase * ((hsExtra * 1.5)+hsMes) / hsMes;
    }

}


class Vendedor extends Empleado {

    double porcenComision;
    double totalVtas;
    double sueldo;

    void setPorcenComision(){
        System.out.print("Indique el porcentaje de comision: ");
        porcenComision=ingreso.nextDouble();
    }
    void setTotalVtas(){
        System.out.print("Indique el total de las ventas: ");
        totalVtas=ingreso.nextInt();
    }

    void paraSueldo(){
        this.setPorcenComision();
        this.setTotalVtas();
    }
    double getSueldo(){

        return sueldoBase + (porcenComision*totalVtas/100);
    }

}