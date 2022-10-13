import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FReader {
    public ArrayList<Integer> readFile(String s) {
        ArrayList<Integer> ret = new ArrayList();
        try {
            File myObj = new File(s);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ret.add(Integer.valueOf(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return ret;
    }

    public FReader() {

    }
}
