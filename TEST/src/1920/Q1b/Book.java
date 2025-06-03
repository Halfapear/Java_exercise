package 1920.Q1b;

public class Book {
    public String title;
    public Boolean hasElectronic;
    //is Boolean not bool

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

    public Book(String title){
        this.title = title;
    }
}
