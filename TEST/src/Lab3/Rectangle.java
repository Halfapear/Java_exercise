
public class Rectangle {
    int l;
    int w;
    //4.19 二刷 我都忘了要在main外面写方法了
    public int area(){
        return l * w;
    }
    public static void main(String[] args){
        Rectangle rec1 = new Rectangle();
        rec1.l = 8;
        rec1.w = 6;
        System.out.println("The area is " +  rec1.area());

    }
}
