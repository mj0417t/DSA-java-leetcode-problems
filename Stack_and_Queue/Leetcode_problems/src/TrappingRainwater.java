public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    private static int trap2(int[] height) {
        int n=height.length;
        int lmax=0,rMax=0,total=0,l=0,r=n-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(lmax>height[l])
                    total+=lmax-height[l];
                else
                    lmax=height[l];
                l++;
            }else {
                if(rMax>height[r])
                    total+=rMax-height[r];
                else
                    rMax=height[r];
                r--;
            }
        }
        return total;
    }

    private static int[] prefixMax(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i]=Math.max(prefix[i-1],arr[i]);
        }
        return prefix;
    }

    private static int[] suffixMax(int[] arr){
        int n= arr.length;
        int[] suffix = new int[n];
        suffix[n-1]=arr[n-1];
        for (int i = n-2; i >=0; i--) {
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        return suffix;
    }
    public static int trap(int[] height) {
        int[] leftMax=prefixMax(height);
        int[] rightMax=suffixMax(height);

        int total=0;
        for(int i=0;i<height.length;i++){
            int lMax=leftMax[i], rMax=rightMax[i];
            if(height[i]<lMax && height[i]<rMax)
                total+=Math.min(lMax,rMax)-height[i];
        }
        return total;
    }
}
