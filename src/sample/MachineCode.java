package sample;

public class MachineCode {
    static void RFormat(String[] inst){
        String func = Tool.decimalToNBitsBinary( Mapping.RFunctionMap.get((inst[0])), 6 );
        String rd = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[1].substring(0,3)) ), 5) ;
        String rs = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[2].substring(0,3)) ), 5) ;
        String rt = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[3].substring(0,3)) ), 5) ;
        char[] mc = new char[6];
        for (int i = 0; i < 6 ; i++) {
            mc[i] ='0';
        }
         String res = String.valueOf(mc).concat(rs).concat(rt).concat(rd).concat("00000").concat(func);
        System.out.println(res);
    }
}
