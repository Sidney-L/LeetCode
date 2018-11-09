class Solution {
    public int numFriendRequests(int[] ages) {
        /*
         Arrays.sort(ages);
         if(ages.length > 1){
         for (int i = 0; i < ages.length / 2; i++) {
         int temp = ages[i]; // swap numbers
         ages[i] = ages[ages.length - 1 - i];
         ages[ages.length - 1 - i] = temp;
         }
         }
         int count = 0;
         for(int i = 0; i<ages.length; i++){
         for(int j = i+1; j < ages.length; j++){
         if(ages[j] > 0.5*ages[i]+7){
         count++;
         if(ages[j]==ages[i])
         count++;
         }
         else
         break;
         }
         }
         return count;
         */
        int[] count = new int[121];
        for (int age: ages) count[age]++;
        
        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }
        
        return ans;
    }
}
