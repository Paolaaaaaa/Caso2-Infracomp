public class Time_ {

    static Long time;


    public Time_(){
       this.time = 0L;
    }

    public Long getTime() {
        return this.time;
    }
    public Long setTime(Long nuevtime)
    {
        return this.time=nuevtime;
    }
    public Long sumTime(Long time1)
    {
        return this.time+=time1;
    }
}
