package sample;
import java.util.HashMap;
public class Mapping {
    static HashMap<String,String> registerMap = new HashMap<>();
    static HashMap<String,String> JandIOperationMap = new HashMap<>();
    static HashMap<String,String> RFunctionMap = new HashMap<>();
    static void setResiterMap(){
        registerMap.put("$ze","0");
        registerMap.put("$at","1");
        registerMap.put("$v0","2");
        registerMap.put("$v1","3");
        registerMap.put("$a0","4");
        registerMap.put("$a1","5");
        registerMap.put("$a2","6");
        registerMap.put("$a3","7");
        registerMap.put("$t0","8");
        registerMap.put("$t1","9");
        registerMap.put("$t2","10");
        registerMap.put("$t3","11");
        registerMap.put("$t4","12");
        registerMap.put("$t5","13");
        registerMap.put("$t6","14");
        registerMap.put("$t7","15");
        registerMap.put("$s0","16");
        registerMap.put("$s1","17");
        registerMap.put("$s2","18");
        registerMap.put("$s3","19");
        registerMap.put("$s4","20");
        registerMap.put("$s5","21");
        registerMap.put("$s6","22");
        registerMap.put("$s7","23");
        registerMap.put("$t8","24");
        registerMap.put("$t9","25");
        registerMap.put("$k0","26");
        registerMap.put("$k1","27");
        registerMap.put("$gp","28");
        registerMap.put("$sp","29");
        registerMap.put("$fp","30");
        registerMap.put("$ra","31");

    }
    static void setJandIOperationMap(){
        JandIOperationMap.put("j","2");
        JandIOperationMap.put("addi","8");
        JandIOperationMap.put("slti","10");
        JandIOperationMap.put("andi","12");
        JandIOperationMap.put("ori","13");
        JandIOperationMap.put("beq","4");
        JandIOperationMap.put("bne","5");
        JandIOperationMap.put("lui","15");
        JandIOperationMap.put("sw","43");
        JandIOperationMap.put("lw","35");

    }
    static void setRFunctionMap(){
        RFunctionMap.put("add","32");
        RFunctionMap.put("sub","34");
        RFunctionMap.put("and","36");
        RFunctionMap.put("or","37");
        RFunctionMap.put("nor","39");
        RFunctionMap.put("sll","0");
        RFunctionMap.put("srl","2");
        RFunctionMap.put("sra","3");
        RFunctionMap.put("slt","42");
    }
}
