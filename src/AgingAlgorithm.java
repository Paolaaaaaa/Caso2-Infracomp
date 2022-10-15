import java.util.ArrayList;

public class AgingAlgorithm implements Runnable {
    ArrayList<Integer> nums;
    int ram;
    int tlb;

    public int ageingAlgorithm(ArrayList<Integer> nums, int ram, int tlb) {
        int ret = 0;

        return ret;
    }

    public AgingAlgorithm(ArrayList<Integer> nums, int ram, int tlb) {
        this.nums = nums;
        this.ram = ram;
        this.tlb = tlb;
    }
    public AgingAlgorithm() {
        
    }
    @Override
    public void run() {
        ageingAlgorithm(this.nums, this.ram, this.tlb);
    }
}
