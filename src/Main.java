import java.util.ArrayList;

public class Main {
    static FReader reader;
    public static void main(String[] args) {
        reader = new FReader();
        ArrayList<Integer> nums = reader.readFile("examples/test_A2_R32_P8.txt");
        System.out.println("Data recieved: "+ nums.toString());
    }
}