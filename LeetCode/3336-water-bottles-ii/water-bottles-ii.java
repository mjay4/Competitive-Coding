class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles, remBottles = numBottles;
        while (remBottles >= numExchange) {
            remBottles-= numExchange;
            System.out.println(numBottles + " " + numExchange + " " + ans);
            numExchange++;
            ans++;
            remBottles++;
        }
        return ans;
    }
}