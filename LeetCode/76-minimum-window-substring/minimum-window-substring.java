class Solution {
    public String minWindow(String s, String t) {
        // Store the frequency of the T string. 
        Map<Character, Integer> freqMap = new HashMap<>();

        // Update the frequency in the map. 
        for (char ch: t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int start =0, end=0, tCounter=t.length(), minStart=0, minLen = Integer.MAX_VALUE;

        // Iterate over s till last character. 
        while(end < s.length()) {
            char charAtEnd = s.charAt(end++);

            // If character exists in t, decrease the tCounter. 
            if (freqMap.get(charAtEnd) != null && freqMap.get(charAtEnd) > 0) {
                tCounter--;
            } 

            // Decrease frqMap count. If character doesn't exist in T, it would be negative. 
            freqMap.put(charAtEnd, freqMap.getOrDefault(charAtEnd, 0) - 1);

            while (tCounter == 0) {

                // If end-start less than minLen, we have found a smaller string. 
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end-start;
                }

                // Start moving the start counter to find smallest window. 
                char charAtStart = s.charAt(start++);
                freqMap.put(charAtStart, freqMap.getOrDefault(charAtStart, 0) + 1);
                if (freqMap.get(charAtStart) > 0) {
                    tCounter++;
                }
            }
        }
 
        if (minLen != Integer.MAX_VALUE)
            return s.substring(minStart, minStart+minLen);
        return "";
    }
}