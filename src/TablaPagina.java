public class TablaPagina  extends Thread{

    private static Integer[] table_p;
    private static Integer[] table_ram;
    private static Integer apuntadorRam;
    Time_ time;

    public TablaPagina(Integer ram, Time_ time)
    {
        this.table_p= new Integer[64];// para 64 paginas
        this.table_ram= new Integer[ram];// para marcos de pagina
        this.apuntadorRam = 0;
        this.time = time;


    }

    public Integer traducirDir(Integer entrada)
    {
        Integer respuesta = -1;
        if (this.table_p[entrada] != null)
        {
            time.sumTime(10);
            respuesta=this.table_p[entrada];

        }
        return respuesta;

    }
    public long getFromRam(Integer direccion)
    {
        long respuesta = 0;
        if (this.table_ram[direccion]!=null)
        {
            time.sumTime(30);
            respuesta=this.table_ram[direccion];

        }
        return respuesta;

    }

    public synchronized void cargardataRam(Integer muns)
    {
        this.table_ram[apuntadorRam]=muns;
        this.table_p[muns]=apuntadorRam;
        time.sumTime(10);
        apuntadorRam++;
        if(apuntadorRam==table_ram.length)
        {
            apuntadorRam=0;
        }
    }



    public  void run(Integer direccion)
    {
        Integer direccionreal =traducirDir(direccion);
        if (direccionreal==-1)// cuando no existe la dirección real/ tp
        {
            cargardataRam(direccion);// se carga desde el disco

        }
        else

        {
            getFromRam(direccionreal);

        }



    }
}
