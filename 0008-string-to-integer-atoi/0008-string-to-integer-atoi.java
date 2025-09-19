class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        long result = 0;
        int sign = 1;
        int i = 0;
        char sig = s.charAt(0);
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            sign = sig=='+'?1:-1;
            i++;
        }
        StringBuilder str = new StringBuilder();
        while(i<s.length() &&  Character.isDigit(s.charAt(i))){
                str.append(s.charAt(i));
                i++;
        }
        if(str.length()==0) return 0;

        try {
            result = Long.parseLong(str.toString());
        } catch (NumberFormatException e) {
            // Handle overflow and underflow
            result = (sign == 1) ? Long.MAX_VALUE : Long.MIN_VALUE;
        }

        result= result * sign;
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)result;


    }
}