class Solution {
    public int lengthOfLongestSubstring(String s) {
        //have left and right index at the beginning
        //have a variable for the maximum length
        //initialize the hashset
        //run the right index from the left until the length of the string
        //if hashset contains the element that is at right index of string then remove the element from the charset that is at left index
        //increase the left index
        //if not just the add the element at the right index of the string to the hashset
        //calculate the maximum length of the hashset
        //return the max_length


        //solution
        int left=0;
        int max_length=0;
        HashSet<Character> map = new HashSet<Character>();

        for(int right=0; right<s.length(); right++){
            while(map.contains(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }

            map.add(s.charAt(right));
            max_length = Math.max(max_length, right-left+1);

        }

        return max_length;
    }
}
