import java.util.ArrayList;

public class Main {
    static FReader reader;
    static AgingAlgorithm agingAlgorithm;
    public static void main(String[] args) {
        int ram = 4;
        int tlb = 4;

        reader = new FReader();

        ArrayList<Integer> nums = reader.readFile("examples/test_B2_R32_P8.txt");
        agingAlgorithm = new AgingAlgorithm(nums,  ram,  tlb);
        agingAlgorithm.run();
        //while (true){agingAlgorithm.run();wait(1);}// para que corra cada milisegundo

        System.out.println("Data recieved: "+ nums.toString());
    }
}