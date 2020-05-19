package sample;
import java.util.ArrayList;

public class Controller {
        static ArrayList<String> instruction = new ArrayList<>();
        static void start(){
            for (String inst: instruction) {
                String[] instDivided = inst.split(" ");
                if(instDivided[0].compareTo("and") == 0 || instDivided[0].compareTo("or") == 0
                        || instDivided[0].compareTo("nor")== 0  || instDivided[0].compareTo("add") == 0
                        || instDivided[0].compareTo("sub") == 0 || instDivided[0].compareTo("slt") == 0 ){
                    MachineCode.RFormat(instDivided);

                }
                else if(instDivided[0].compareTo("sll") == 0 || instDivided[0].compareTo("srl") == 0
                        || instDivided[0].compareTo("sra")== 0){
                    MachineCode.RFormatShift(instDivided);

                }
                else if(instDivided[0].compareTo("andi") == 0 || instDivided[0].compareTo("ori") == 0
                        || instDivided[0].compareTo("addi")== 0 || instDivided[0].compareTo("slti") == 0 ){
                    MachineCode.Iformat(instDivided);

                }
                else if(instDivided[0].compareTo("lui") == 0 ){
                    MachineCode.IformatLUI(instDivided);

                }
                else if(instDivided[0].compareTo("lw") == 0 || instDivided[0].compareTo("sw") == 0){
                    MachineCode.IformatLWsw(instDivided);

                }

            }
        }

}
