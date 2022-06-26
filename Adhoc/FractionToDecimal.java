//https://leetcode.com/problems/fraction-to-recurring-decimal/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator <0 == denominator <0 || numerator ==0) ? "":"-";
        sb.append(sign);
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        long rem = num%den;
        if(rem ==0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(rem != 0){
            if(!map.containsKey(rem)){
                map.put(rem,sb.length());
            }else{
                int index = map.get(rem);
                return sb.substring(0,index) +"(" + sb.substring(index)+")";
            }
            rem *= 10;
            sb.append(rem/den);
            rem = rem%den;
        }
        return sb.toString();
    }
}
