public class Q2d(){
    //22:40 
    public static int[] repeat(int[] input, int n ){
        // Why? To prevent errors and handle trivial cases gracefully.
        if (n <= 0) {
            System.out.println("Debug: n is " + n + ", returning empty array.");
            return new int[0]; // Repeat 0 or negative times means an empty result.
        }
        if (input == null || input.length == 0)  {
            System.out.println("Debug: inputArray is null or empty, returning empty array.");
            return new int[0]; // Nothing to repeat from an empty or null array.
        }
        int r = a*n;
        int[] newnums = new int[r];
        //int[] newnums[]; —— 这里只声明了 但没创建并初始化长度 + 后面那个就不加括号了
        int a = input.length ;
        for(int i = 0 ;i<a; i++){
            //循环变量 i 和 p 未初始化为0
            for(int p = 0 ;p<n ; p++){
                newnums[i*n + p] = input[i];
            }
        }
        //忘加return了
        return newnums;

        }
    public static void main(String args[]){
        //接受输入
        int[] nums = args[];
        int n;

        
    }
}