public class TablaPagina  extends Thread{

    private static Integer[] table_p;
    private static Integer[] table_ram;
    private static Integer apuntadorRam;
    private static Integer[] appTablep;
    Time_ time;

    public TablaPagina(Integer ram, Time_ time)
    {
        this.table_p= new Integer[64];// para 64 paginas
        this.table_ram= new Integer[ram];// para marcos de pagina
        this.appTablep = new Integer[ram];
        this.apuntadorRam = 0;
        this.time = time;


    }

    public Integer traducirDir(Integer entrada)
    {
        Integer respuesta = -1;
        if (this.table_p[entrada] != null)
        {
            time.sumTime(10L);// tiempo de traducción de direcciones
            respuesta=this.table_p[entrada];

        }
        return respuesta;

    }
    public Integer getFromRam(Integer direccion)
    {
        Integer respuesta = -1;
        if (this.table_ram[direccion]!=null)
        {
            time.sumTime(30L);
            respuesta=this.table_ram[direccion];

        }
        return respuesta;

    }

    public synchronized void serchErr()
    {
        if (appTablep[apuntadorRam]!=null)
        {
            this.table_p[appTablep[apuntadorRam]]=-1;// actualización ultimo numero antes de este en cambiar en tp


        }

    }

    public synchronized void cargardataRam(Integer muns)
    {

        this.table_ram[apuntadorRam]=muns;//  nuevo numero en ram

        this.table_p[muns]=apuntadorRam;//nuevo numero en tp
        serchErr(); //actualización numero antiguo
        this.appTablep[apuntadorRam]=muns;// ultimo numero en cambiar en la tp

        time.sumTime(10000000L);// 1 ms por la carga de memoria secundaria a memoria ram
        apuntadorRam++;// dice cual es el siguiente espacio a llenar
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
            run(direccion);//se vuelve a hacer la consulta en tp

        }
        else

        {
            Integer dir =getFromRam(direccionreal);
            if (dir==-1)
            {
                cargardataRam(direccion);
                run(direccion);

            }

        }



    }
}
