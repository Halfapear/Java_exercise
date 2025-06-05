package 1920.Q1b;

import java.awt.print.Book;

public class TextBook extends Book{
    //public String subject; —— 不对 首要原因：封装
    //如果还有子类就是setter gettter出场了
    //这里用private是因为textbook没有子类了
    private String subject;
    //String title = new String();
    //—— 不能这样写
    public Textbook(String Subject, ){

    }
    
}
