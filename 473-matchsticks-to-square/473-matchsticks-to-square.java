class Solution {
   public static boolean findmatch(int len,int t,int b,int l,int r,int target,int[] stick){
   
    if(t==b&&b==l&&l==r&&len==-1)return true;  //if all sides are equal and all sticks are used then square can be formed
    if(t>target||b>target||l>target||r>target||len==-1)return false; // if any side is larger than target , square cannot be formed
    boolean a1=findmatch(len-1,t+stick[len],b,l,r,target,stick);if(a1)return true;
    boolean a2=findmatch(len-1,t,b+stick[len],l,r,target,stick);if(a2)return true;
    boolean a3=findmatch(len-1,t,b,l+stick[len],r,target,stick);if(a3)return true;
    boolean a4=findmatch(len-1,t,b,l,r+stick[len],target,stick);if(a4)return true;
    return false;   
	
}
public boolean makesquare(int[] matchsticks) {

    int sum=0;
    for(int i:matchsticks)sum+=i;
    Arrays.sort(matchsticks);
    if(sum%4!=0)return false;
   return findmatch(matchsticks.length-1,0,0,0,0,sum/4,matchsticks);
   
}
}
