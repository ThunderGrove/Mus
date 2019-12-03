import com.sun.source.tree.WhileLoopTree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fileio {
    private String fileURL="lastgame.txt";

    public void saveArrayListToFile(ArrayList<String>content)throws Exception{
        java.io.File file=new java.io.File(fileURL);

        try(
            java.io.PrintWriter in=new java.io.PrintWriter(file);
        ){
            for(int i=0;i<content.size();i++){
                if(i!=(content.size()-1)){
                    in.println(content.get(i));
                }else{
                    in.print(content.get(i));
                }
            }
        }
    }

    public ArrayList<String>loadArrayListFromFile() throws FileNotFoundException {
        ArrayList<String>lines=new ArrayList<String>();
        java.io.File file=new java.io.File(fileURL);

        Scanner fromFile=new Scanner(file);

        while(fromFile.hasNextLine()){
            lines.add(fromFile.nextLine());
        }

        return lines;
    }
}
