import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoriaVirtual extends Thread{
    private static Map  tp = new HashMap();


    private static Integer[]  tbl ;
    private static Integer lstInt;


    private static Map  ram = new HashMap();

    public MemoriaVirtual(Integer entradasTBL)
    {
        this.tbl = new Integer[entradasTBL] ;
        this.lstInt = -1;

    }



    public void tblfifo(Integer entrada)
    {
        boolean intable = false;
        for (int i = 0; i < this.tbl.length; i++) {
            if (tbl[i].equals(entrada)){
                intable =true;
                break;} // si ya está en la tabla se para el for

        }
        if (!intable && lstInt<tbl.length-1)
        {
            this.lstInt ++;
            this.tbl[this.lstInt]= entrada;// si no está en tabla y el apuntador está dentro del rango se cambia la entrada del elemento más antiguo


        }
        if (!intable && lstInt==tbl.length-1)// si no está en la tabla y el apuntador llegó al ultimo elmento  se cambia el elemento del inicio que era el más antiguo
        {
            this.lstInt = 0;
            this.tbl[this.lstInt]=entrada;
        }

    }


}
