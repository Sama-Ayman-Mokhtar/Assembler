package sample;

public class MachineCode {
    static void RFormat(String[] inst){
        String oper = "000000";
        String func = Tool.decimalToNBitsBinary( Mapping.RFunctionMap.get((inst[0])), 6 );
        String rd = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[1].substring(0,3)) ), 5) ;
        String rs = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[2].substring(0,3)) ), 5) ;
        String rt = Tool.decimalToNBitsBinary(Mapping.registerMap.get( inst[3] ) , 5) ;

         String res = oper.concat(rs).concat(rt).concat(rd).concat("00000").concat(func);
        System.out.println(res);
    }
    static void RFormatShift(String[] inst){
        String oper = "000000";
        String func = Tool.decimalToNBitsBinary( Mapping.RFunctionMap.get((inst[0])), 6 );
        String rd = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[1].substring(0,3)) ), 5) ;
        String rs = "00000" ;
        String rt = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[2].substring(0,3)) ), 5) ;
        String shift = Tool.decimalToNBitsBinary(inst[3],5);

         String res = oper.concat(rs).concat(rt).concat(rd).concat(shift).concat(func);
        System.out.println(res);
    }
     static void Iformat(String[] inst){

        String oper = Tool.decimalToNBitsBinary( Mapping.JandIOperationMap.get((inst[0])), 6 );
        String rs = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[1].substring(0,3)) ), 5) ;
        String rt = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[2].substring(0,3)) ), 5) ;
        String immediate = Tool.decimalToNBitsBinary( inst[3]  , 16) ;

         String res = oper.concat(rt).concat(rs).concat(immediate);
        System.out.println(res);
    }
    static void IformatLUI(String[] inst){

        String oper = Tool.decimalToNBitsBinary( Mapping.JandIOperationMap.get((inst[0])), 6 );
        String rt = Tool.decimalToNBitsBinary(Mapping.registerMap.get( (inst[1].substring(0,3)) ), 5) ;
        String immediate = Tool.decimalToNBitsBinary( inst[2]  , 16) ;

         String res = oper.concat("00000").concat(rt).concat(immediate);
        System.out.println(res);
    }
}
