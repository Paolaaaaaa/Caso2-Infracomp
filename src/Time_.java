public class Time_ {

    static Integer time;


    public Time_(){
       this.time = 0;
    }

    public Integer getTime() {
        return this.time;
    }
    public Integer setTime(Integer nuevtime)
    {
        return this.time=nuevtime;
    }
    public Integer sumTime(Integer time1)
    {
        return this.time+=time1;
    }
}
