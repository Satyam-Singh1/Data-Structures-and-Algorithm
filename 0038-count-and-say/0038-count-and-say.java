class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder str = new StringBuilder("1");
        n--;
        while (n-- > 0) {
            int len = str.length();
            int cnt = 1;
            if(str.length()==1){
                str.append("1");
                continue;
            }
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < len; i++) {
                char ch = str.charAt(i);
                if (ch == str.charAt(i -1)) {
                    cnt++;
                } else {
                    temp.append(cnt).append(str.charAt(i-1));
                    cnt = 1;
                }
            }
            temp.append(cnt).append(str.charAt(len-1));
            str = temp;
           
        }
        return str.toString();

    }
}