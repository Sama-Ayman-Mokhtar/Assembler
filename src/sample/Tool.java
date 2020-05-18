package sample;

public class Tool {
    static String decimalToNBitsBinary(String dNum, int nDigitsBinary){
        String b = Integer.toBinaryString(Integer.parseInt(dNum));
        String s  = extendByZeros(b,nDigitsBinary);
        return s;
    }
    static private String extendByZeros(String b, int nDigitsBinary){
         int length =  b.length();
         int left = nDigitsBinary - b.length();
         char[] arr = new char[nDigitsBinary];
         for (int i = 0; i < left ; i++) {
             arr[i] = '0';
         }
         for (int i = 0; i < length ; i++) {
             arr[left + i] = b.charAt(i);
         }

         return String.valueOf(arr);
     }
}
