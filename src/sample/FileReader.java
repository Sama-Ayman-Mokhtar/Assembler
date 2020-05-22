package sample;
import java.util.Scanner;
import java.io.File;
public class FileReader {
    static Scanner scan;
    static  void openFile(){
            try{
                File file = new File("Assembly");
                scan = new Scanner(file);
            }
            catch (Exception e){
                System.out.println("File not Found!");
            }
    }
    static  void readFile(){
        while(scan.hasNext()){
            Controller.instruction.add(scan.nextLine());
        }
    }
    static void closeFile(){
                scan.close();
    }

    static int findLabelLine(String label){
        int lineNum = 1;
        openFile();
        while(scan.hasNext()){
            if (scan.nextLine().startsWith(label))
                break;
            else{
                lineNum ++;
            }
        }
        closeFile();
        return lineNum;
    }
}
