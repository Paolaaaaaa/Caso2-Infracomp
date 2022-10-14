import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static FReader reader;
    static Integer entradas;
    static Integer numMarcospg;

    public static void main(String[] args) {
        reader = new FReader();
        ArrayList<Integer> nums = reader.readFile("examples/test_A2_R32_P8.txt");
        System.out.println("Data recieved: "+ nums.toString());


        /**
         * Entradas y numMarcospg
         * */
        Scanner input = new Scanner (System.in);
        System.out.println("Escriba el numero de entradas en la TLB: ");
        entradas= input.nextInt();
        System.out.println("Numeros de pagina en memoria RAM");
        numMarcospg= input.nextInt();

    }
}