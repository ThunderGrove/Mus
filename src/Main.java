import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        String msg="";
        boolean activeGame=false;
        Mus mus=new Mus();
        Log log=new Log();
        Fileio io=new Fileio();
        String cmd="";
        int selectedNumber=0;

        System.out.println("Velkommen til mus spillet.");
        System.out.println("Skriv new for nyt spil");
        System.out.println("Skriv load for at indlæse sidste gemte spil");
        System.out.println("Når et spil er i gang skriv save for at gemme");
        System.out.println("Skriv exit for at lukket spillet");

        Scanner keyInput=new Scanner(System.in);

        while(true){
            cmd=keyInput.next();
            if(cmd.equals("exit")||cmd.equals("Exit")){
                break;
            }

            if(activeGame){
                if(cmd.equals("save")||cmd.equals("Save")){
                    ArrayList<String>theLog=log.getLog();

                    io.saveArrayListToFile(theLog);
                }else{
                    try{
                        selectedNumber = Integer.parseInt(cmd);

                        log.addToLog(Integer.toString(selectedNumber));
                        if (mus.check(selectedNumber)) {
                            msg = "Correct";
                            log.addToLog(msg);
                            break;
                        }
                        msg = "Enter your guess:";
                        log.addToLog(msg);
                    }catch(Exception e) {

                    }
                }
            }else{
                if(cmd.equals("new")||cmd.equals("New")){
                    mus.resetPebernoed();
                    activeGame=true;
                    log.addToLog(Integer.toString(mus.getPebernoed()));
                    msg="Enter your guess:";
                    log.addToLog(msg);
                }else if(cmd.equals("load")||cmd.equals("Load")){
                    ArrayList<String>load=io.loadArrayListFromFile();
                    mus.setPebernoed(Integer.parseInt(load.get(0)));
                    log.addToLog(load.get(0));
                    for(int i=1;i<load.size();i++) {
                       log.addToLog(load.get(i));
                    }
                    activeGame=true;
                }
            }
        }



        /*mus.resetPebernoed();

        log.addToLog(Integer.toString(mus.getPebernoed()));

        Scanner input=new Scanner(System.in);

        while(!lastResult){
            msg="Enter your guess:";
            log.addToLog(msg);
            int g=input.nextInt();
            log.addToLog(Integer.toString(g));
            if(mus.check(g)){
                lastResult=true;
                msg="Correct";
                log.addToLog(msg);
            }
        }

        for(int i=0;i<10;i++){
            System.out.println("");
        }

        ArrayList<String>theLog=log.getLog();

        for(int i=0;i<theLog.size();i++){
            System.out.println(theLog.get(i));
        }

        io.saveArrayListToFile(theLog);*/
    }
}