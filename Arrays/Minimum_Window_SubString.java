class Solution {
    public String minWindow(String s, String t) {
        //in edge case check is the length or the string is empty or not
        //create a hashmap to count the frequency of character of the target string
        //put all the characters of the target string in that HashMap
        //create a hashmap for the windowstring
        //define all the required variables
        //minleft variable is required to store the starting index of finalized (minimal length of target substring found in main string )
        //minlength to find the minimum window size for the given target
        //expand the window until the length of string
        //check the character from the string at the right index and if it is in target hashmap then put it into window hashmap
        //also if their frequency matches then increase the count
        //shrink the window by checking if count is equal to the size of the target hashmap
        //find the minlength and minleft by compairing window size with the current minleft
        //if character at left index is already in target hashmap then decrease it from window hashmap
        //also if value of leftcharacter is less in window map than the target map then decrease the count
        //increase left and right
        //return empty if not found
        //return the substring that starts from the minleft and goes until the minlength
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> freqt = new HashMap<>();
        for(char c : t.toCharArray()){
            freqt.put(c, freqt.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> wins = new HashMap<>();
        int left = 0;
        int right = 0;
        int minlength = Integer.MAX_VALUE;
        int minleft =0;
        int count=0;

        while(right < s.length()){
            char rightChar = s.charAt(right);

            if(freqt.containsKey(rightChar)){
                wins.put(rightChar, wins.getOrDefault(rightChar,0)+1);

                if(wins.get(rightChar).intValue() == freqt.get(rightChar).intValue()){
                    count++;
                }
            }



        while(count == freqt.size()){
            if(right-left+1 < minlength){
                minlength = right-left+1;
                minleft = left;
            }
            char leftChar = s.charAt(left);
            if(freqt.containsKey(leftChar)){
                wins.put(leftChar, wins.get(leftChar)-1);

                if(wins.get(leftChar) < freqt.get(leftChar)){
                    count--;
                }
            }
            left++;
        }
        right++;
        }
        return minlength == Integer.MAX_VALUE ? "": s.substring(minleft, minleft+ minlength);
    }
}
