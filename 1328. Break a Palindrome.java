class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        char[] tmp = palindrome.toCharArray();
        boolean flag = false;
        for(int i = 0; i < tmp.length / 2; i++){
            if(tmp[i] != 'a'){
                tmp[i] = 'a';
                flag = true;
                break;
            }
        }
        if(flag == false){
            tmp[tmp.length - 1] = 'b';
        }
        return new String(tmp);
    }
}