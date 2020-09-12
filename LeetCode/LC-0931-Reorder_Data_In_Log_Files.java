class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            String[] first = a.split(" ",2);
            String[] second = b.split(" ",2);
            boolean d1 = Character.isDigit(first[1].charAt(0));
            boolean d2 = Character.isDigit(second[1].charAt(0));
            // When both are digits : Maintain the order.
            // When one is digit and other is letter, letter comes before digit.
            if(d1 && d2)
                return 0;
            else if(d1 && !d2)
                return 1;
            else if(!d1 && d2)
                return -1;
            else{
                //In case of both letters, Maintain lexocographic order.
                int compare = first[1].compareTo(second[1]);
                if(compare == 0){
                    // In case of ties, use identifiers to break the tie.
                    return first[0].compareTo(second[0]);
                }
                return compare;
            }
        });
        return logs;
    }
}