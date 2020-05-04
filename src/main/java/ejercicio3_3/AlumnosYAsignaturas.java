package ejercicio3_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnosYAsignaturas {

    public static void main(String[] args) {

        List<Alumno> listaDeAlumnos = new ArrayList<>();
        List<Asignatura> listaDeAsignaturas = new ArrayList<>();

        Scanner ingreso = new Scanner(System.in);
        int opcion = 1;
        while (opcion == 1) {

            System.out.println("Indique la opcion deseada:\n");

            System.out.println("1. Crear nuevo alumno.\n" +
                    "2. Crear nueva asignatura.\n" +
                    "3. Matricular alumno en asignatura.\n" +
                    "4. Listado de alumnos matriculados en una asignatura.\n" +
                    "5. Listado de asignaturas en las que está matriculado un alumno y total de horas.\n" +
                    "6. Salir\n");

            opcion = ingreso.nextInt();
            ingreso.nextLine();

            if (opcion == 1) {

                System.out.print("Ingrese el nombre del alumno: ");
                String nombre = ingreso.nextLine();
                System.out.print("Ingrese el apellido: ");
                String apellido = ingreso.nextLine();
                System.out.print("Ingrese el email: ");
                String email = ingreso.nextLine();

                listaDeAlumnos.add(new Alumno(nombre, apellido, email));
            } else if (opcion == 2) {

                System.out.print("Ingrese el nombre de la asignatura: ");
                String nombre = ingreso.nextLine();
                System.out.print("Ingrese las horas semanales: ");
                int horas = ingreso.nextInt();

                listaDeAsignaturas.add(new Asignatura(nombre, horas));

                opcion=1;
            } else if (opcion == 3) {

                System.out.print("ingrese el nombre de la asignatura: ");
                String asignatura = ingreso.nextLine();
                System.out.print("ingrese el nombre del alumno: ");
                String alumno = ingreso.nextLine();
                System.out.print("ingrese el apellido del alumno: ");
                String apellido = ingreso.nextLine();

                for (Asignatura asignat : listaDeAsignaturas) {
                    if (asignat.nombre.equalsIgnoreCase(asignatura)) {
                        for (Alumno alumn : listaDeAlumnos) {
                            if (alumn.nombre.equalsIgnoreCase(alumno)) {
                                if (alumn.apellido.equalsIgnoreCase(apellido)) {
                                    asignat.matricular(alumn);
                                    alumn.incorporaAsignatura(asignat);
                                }
                            }
                        }
                    }
                }
                opcion=1;

            } else if (opcion == 4) {

                String formato = "  %-15s  %-15s  %-15s";

                System.out.print("ingrese el nombre de la asignatura: ");
                String asignatura = ingreso.nextLine();
                System.out.println("A continuacion los alumnos en la asignatura " + asignatura+": ");
                System.out.println(String.format(formato, "Nombre", "Apellido", "Email"));
                for (Asignatura asignat : listaDeAsignaturas) {
                    if (asignat.nombre.equalsIgnoreCase(asignatura)) {
                        for (Alumno alumn : asignat.alumnosMatriculados) {
                            System.out.println(String.format(formato, alumn.nombre, alumn.apellido, alumn.email));
                        }
                    }
                }
                System.out.println(" ");
                System.out.println("precione ENTER para continuar.");
                ingreso.nextLine();
                opcion=1;
            }


            else if (opcion == 5) {

                String formatoA = "%-15s  %-15s";
                String formatoB = "%-15s  %-15d";

                System.out.print("ingrese el nombre del alumno: ");
                String nombre = ingreso.nextLine();
                System.out.print("ingrese el apellido del alumno: ");
                String apellido = ingreso.nextLine();
                System.out.println("A continuacion las asignaturas del alumno " + nombre + " " + apellido);
                System.out.println(String.format(formatoA, "Nombre", "Horas semanales"));
                for (Alumno alumn : listaDeAlumnos) {
                    if (alumn.nombre.equalsIgnoreCase(nombre) && alumn.apellido.equalsIgnoreCase(apellido)) {
                        for (Asignatura asignatura : alumn.asignaturasDelAlumno) {

                            System.out.println(String.format(formatoB, asignatura.nombre, asignatura.horasSemanales));
                        }
                    }
                }
                System.out.println(" ");
                System.out.println("precione ENTER para continuar.");
                ingreso.nextLine();
                opcion=1;
            } else if (opcion == 6) {

                System.out.println("Precione una tecla para salir");
                ingreso.nextLine();
                opcion=0;

            } else {
                System.out.println("A ingresado una opcion incorrecta, vuelva a intentarlo..");
                System.out.println("Precione una tecla para volver al menu");
                ingreso.nextLine();
                opcion=1;

            }

        }
    }
}


class Alumno{

    List <Asignatura> asignaturasDelAlumno = new ArrayList<>();


    String nombre;
    String apellido;
    String email;

    Alumno(String nombre, String apellido, String email){

        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
    }

    void incorporaAsignatura(Asignatura asignatura){
        asignaturasDelAlumno.add(asignatura);
    }

}


class Asignatura{

    List <Alumno> alumnosMatriculados=new ArrayList<>();

    String nombre;
    int horasSemanales;

    Asignatura(String nombre, int horasSemanales){

        this.nombre=nombre;
        this.horasSemanales=horasSemanales;
    }
    void matricular(Alumno alumno){

        alumnosMatriculados.add(alumno);
    }

}