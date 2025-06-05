//package 1920.Q1b;
//如果都在默认包（没有 package 声明）：确保 Book.java 和 TextBook.java 文件位于同一个目录下。当你编译 TextBook.java 时，编译器应该能自动找到同一目录下的 Book.java

//import java.awt.print.Book;
//这是显式调用book类 没必要

public class TextBook extends Book{
    //类名通常使用帕斯卡命名法 (PascalCase)，即每个单词首字母大写

    //public String subject; —— 不对 首要原因：封装
    //如果还有子类就是setter gettter出场了
    //这里用private是因为textbook没有子类了
    private String subject;
    //String title = new String();
    //—— 不能这样写
    public TextBook(String title, Boolean  hasElectronic, String subject){
        //参数名大写可以，但通常不推荐
        super(title, hasElectronic);
        this.subject = subject;
        //this subject = Subject;
    }
    
    //既然用了private 就要getter setter
    public String getSubject(){
        return this.subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public String toString (){
        return "TextbookName:" + title + "dianzi?:" + hasElectronic + "subject:" + subject;    
    }

}
