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
}
