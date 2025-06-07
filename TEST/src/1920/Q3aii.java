package 1920;

public class Q3aii {
    public SubClass (){
        this("Default", 5);

    }

    public SubClass(String name, int i ){
        super(i);
        //才发现 super不需要返回？ 连 void 都没有
        //它是一个特殊的指令 所以我只需要记住它 我super之后 就把之前的变量初始化完成了（你之前肯定是声明了一些东西的）
        //还有一些格式问题：这里的i不需要int 了 之前括号内搞了
        this.name = name;
        //所以到底怎么输入的 是命令行输入的是吧 —— 不对
        //是main里面干的 ：Car myCar = new Car("V6", "宝马");
    }
}
