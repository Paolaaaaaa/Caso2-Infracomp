import java.sql.Time;
import java.util.ArrayList;

public class AgingAlgorithm implements Runnable {
    ArrayList<Integer> nums;
    int tlb;
    private static Integer[]  tbl_tab ;// talb
    private static Integer lstInt;// ultima posicion en actualizar
    TablaPagina tp;
    Time_ time;

    public int ageingAlgorithm(ArrayList<Integer> nums, TablaPagina tp, int tlb) {
        int ret = 0;
        this.tbl_tab = new Integer[tlb] ;

        {
            for (int i = 0; i < nums.size(); i++) {
                boolean intable = false;

                for (int j = 0; j < tlb; j++) {
                    if (this.tbl_tab[j]!= null && this.tbl_tab[j].equals(nums.get(i))) {
                        intable = true;
                        time.sumTime(2);
                        // suma 2ns
                        break;
                    } // si ya está en la tabla se para el for
                }

                    if ( intable== false && lstInt<tbl_tab.length-1)
                    {
                        this.lstInt ++;
                        tp.run(nums.get(i));
                        this.tbl_tab[this.lstInt]= nums.get(i);// si no está en tabla y el apuntador está dentro del rango se cambia la entrada del elemento más antiguo
                        ret ++; // hay fallo de pagina
                        time.sumTime(30);



                    }
                    else if (intable ==false && lstInt==tbl_tab.length-1)// si no está en la tabla y el apuntador llegó al ultimo elmento  se cambia el elemento del inicio que era el más antiguo
                    {
                        this.lstInt = 0;
                        tp.run(nums.get(i));
                        this.tbl_tab[this.lstInt]=nums.get(i);
                        time.sumTime(30);


                        ret++; // hay fallo de pagia ya que no estba en la tabla
                    }

                }



        }
        System.out.println("Fallos de paginas: "+ret);

        return ret;
    }

    public AgingAlgorithm(ArrayList<Integer> nums,TablaPagina tp, int tlb, Time_ time) {
        this.nums = nums;
        this.tp =tp;
        this.tlb = tlb;
        this.tbl_tab = new Integer[tlb] ;
        this.lstInt = -1;
        this.time = time;
    }

    public AgingAlgorithm() {

    }


    @Override
    public void run() {
        ageingAlgorithm(this.nums, this.tp, this.tlb);
    }
}