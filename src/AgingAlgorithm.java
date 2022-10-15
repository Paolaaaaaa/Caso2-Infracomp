import java.util.ArrayList;

public class AgingAlgorithm implements Runnable {
    ArrayList<Integer> nums;
    int ram;
    int tlb;// tamaño tlb
    private static Integer[]  tbl_tab ;// talb
    private static Integer lstInt;// ultima posicion en actualizar

    public int ageingAlgorithm(ArrayList<Integer> nums, int ram, int tlb) {
        int ret = 0;
        {
            boolean intable = false;
            for (int i = 0; i < nums.size(); i++) {
                int entrada = nums.get(i);
                for (int j = 0; j < tlb; i++) {
                    if (tbl_tab[j].equals(entrada)){
                        intable =true;
                        ret = 1 ; // si la entrada está en la pagina no hay fallo de pagina
                        break;} // si ya está en la tabla se para el for


                    if (!intable && lstInt<tbl_tab.length-1)
                    {
                        this.lstInt ++;
                        this.tbl_tab[this.lstInt]= entrada;// si no está en tabla y el apuntador está dentro del rango se cambia la entrada del elemento más antiguo
                        ret = 0; // hay fallo de pagina


                    }
                    if (!intable && lstInt==tbl_tab.length-1)// si no está en la tabla y el apuntador llegó al ultimo elmento  se cambia el elemento del inicio que era el más antiguo
                    {
                        this.lstInt = 0;
                        this.tbl_tab[this.lstInt]=entrada;
                        ret = 0; // hay fallo de pagia ya que no estba en la tabla
                    }

                }

            }

            }

        return ret;
    }

    public AgingAlgorithm(ArrayList<Integer> nums, int ram, int tlb) {
        this.nums = nums;
        this.ram = ram;
        this.tlb = tlb;
        this.tbl_tab = new Integer[tlb] ;
        this.lstInt = -1;
    }

    @Override
    public void run() {
        ageingAlgorithm(this.nums, this.ram, this.tlb);
    }
}
