class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length == 0)
            return true;
        int index = 0;
        while(index < A.length-1 && A[index] == A[index+1])
            index++;
        if(index == A.length-1)
            return true;
        else{//index < length-2
            if(A[index] < A[index+1]){
                for(int i = index; i < A.length-1; i++){
                    if(A[i] > A[i+1])
                        return false;
                }
                return true;
            }
            else{//A[index] > A[index+1]
                for(int i = index; i < A.length-1; i++){
                    if(A[i] < A[i+1])
                        return false;
                }
                return true;
            }
        }
    }
}
