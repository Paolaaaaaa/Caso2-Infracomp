import java.util.ArrayList;

public class Main {
    static FReader reader;
    static AgingAlgorithm agingAlgorithm;
    public static void main(String[] args) {
        int ram = 4;
        int tlb = 4;

        reader = new FReader();

        ArrayList<Integer> nums = reader.readFile("examples/test_A2_R32_P8.txt");
        agingAlgorithm = new AgingAlgorithm(nums,  ram,  tlb);

        System.out.println("Data recieved: "+ nums.toString());
    }
}