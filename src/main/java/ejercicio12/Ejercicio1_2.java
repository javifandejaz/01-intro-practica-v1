package ejercicio12;

public class Ejercicio1_2 {

    int a = 200;
    int [] b = {10,4,411,100,58,62,87,233,75,90,11,56,33,68,110,8055,905,18,500,736};
    int [] c = new int[6];


    int mostrarA(){ return a ;
    }

    int[] mostrarB(){return b ;
    }

    int[] mostrarC(){

        this.mostrarMayoresQueA();
        return c ;
    }

    void mostrarMayoresQueA(){

        int j = 0;

        for(int i=0; i < 20; i++){

            if (b[i] > a) {

                c[j] = b[i];

                j += 1;
            }
        }
    }
}

