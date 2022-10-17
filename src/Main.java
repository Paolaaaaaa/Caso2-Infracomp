import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static FReader reader;
    static AgingAlgorithm agingAlgorithm;
    static TablaPagina tp;
    static Time_ timee;
    public Main()
    {

    }



    public static void main(String[] args) {
        int ram = 4;
        int tlb = 4;

        reader = new FReader();
        timee = new Time_();

        tp = new TablaPagina(ram,timee);

        ArrayList<Integer> nums = reader.readFile("examples/test_A2_R32_P8.txt");
        agingAlgorithm = new AgingAlgorithm(nums,  tp,  tlb, timee);
        agingAlgorithm.run();
        //while (true){agingAlgorithm.run();wait(1);}// para que corra cada milisegundo

        //Scanner input = new Scanner (System.in);
        System.out.println("Escriba el numero de entradas en la TLB: ");
        //tlb= input.nextInt();
        System.out.println("Numeros de marcos de pagina en memoria RAM");
        //ram= input.nextInt();

        System.out.println("Data recieved: "+ nums.toString());


        System.out.println("En tiempo total de respuesta es de :"+timee.getTime().toString()+" ns (nano segundos)");
    }
}