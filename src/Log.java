import java.util.ArrayList;

public class Log{
    private ArrayList<String>log=new ArrayList<String>();

    public void addToLog(String msg){
        log.add(msg);
        System.out.println(msg);
    }

    public ArrayList<String> getLog(){
        return log;
    }
}
