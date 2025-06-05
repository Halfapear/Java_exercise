package 1920.Q1b;

public class Book {
    public String title;
    public Boolean hasElectronic;
    //is Boolean not bool —— 这里用 Boolean (包装类) 而不是 boolean (基本类型) 是可以的，但通常情况下，如果一个属性只需要表示真/假，并且没有“未指定”或 null 的状态需求，那么使用基本类型 boolean 会更高效，也更符合通常的实践
    //ps Boolean 可以是 true, false, 或者 null
    //像这里 我就不应该写static是吧 因为每个子类都需要自己的
    //然后在子类比如textbook 我还需要String title = new String();一下 —— 正确做法：
    //super.title 访问父类 this.title是子类 并不需要new一个新的 这样就是完全新的了
    //
    //2025年6月5日16:53:11 真是萌新

    public String getTitle(){
        return this.title;
        //this 忘了 我还是习惯不了 还是不熟
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Boolean getEle(){
        return this.hasElectronic;
    }

    public void setEle(Boolean Ele){
        this.hasElectronic = Ele;
    }

    public Book(String title, Boolean Ele){
        this.title = title;
        this.hasElectronic = Ele;
    }

    @Override
    public String toString(){
        return "BookName: " + title + "dianziban?" + (hasElectronic ? yes : no);
    }
}
