import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static FReader reader;
    static AgingAlgorithm agingAlgorithm;
    static Integer time;
    static TablaPagina tp;
    public Main()
    {
        this.time = 0;

    }

    public Integer getTime() {
        return this.time;
    }
    public Integer setTime(Integer nuevtime)
    {
        return this.time=nuevtime;
    }
    public Integer sumTime(Integer time1)
    {
        return this.time+=time1;
    }


    public static void main(String[] args) {
        int ram = 4;
        int tlb = 4;

        reader = new FReader();
        tp = new TablaPagina(ram);

        ArrayList<Integer> nums = reader.readFile("examples/test_A2_R32_P8.txt");
        agingAlgorithm = new AgingAlgorithm(nums,  tp,  tlb);
        agingAlgorithm.run();
        //while (true){agingAlgorithm.run();wait(1);}// para que corra cada milisegundo

        //Scanner input = new Scanner (System.in);
        System.out.println("Escriba el numero de entradas en la TLB: ");
        //tlb= input.nextInt();
        System.out.println("Numeros de marcos de pagina en memoria RAM");
        //ram= input.nextInt();

        System.out.println("Data recieved: "+ nums.toString());
    }
}