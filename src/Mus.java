public class Mus{
    private int pebernoed;

    public void setPebernoed(int no){
        pebernoed=no;
    }

    public void resetPebernoed(){
        pebernoed=(int)(Math.random()*120);
    }

    public int getPebernoed(){
        return pebernoed;
    }

    public boolean check(int no){
        if(pebernoed==no){
            return true;
        }else{
            return false;
        }
    }
}