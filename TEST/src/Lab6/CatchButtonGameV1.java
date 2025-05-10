package Lab6;

// javax.swing.* : 这是Java Swing库，用于创建图形用户界面 (GUI)。
// '*' 是一个通配符，表示导入 javax.swing 包下的所有公共类。
// 例如，JFrame (窗口), JButton (按钮), JPanel (面板) 都来自这里。
import javax.swing.*;

// java.awt.* : 这是Java的抽象窗口工具集 (Abstract Window Toolkit)，是Swing的基础。
// 它包含了一些核心的GUI功能，如布局管理器 (GridLayout), 颜色 (Color), 字体 (Font)。
import java.awt.*;

// java.awt.event.* : 这个包包含了处理GUI事件所需的类和接口。
// 事件是指用户的操作，如点击鼠标、按下键盘等。
// MouseAdapter 和 MouseEvent 来自这里。
import java.awt.event.MouseAdapter; // 用于简化鼠标事件处理
import java.awt.event.MouseEvent;    // 代表一个鼠标事件对象

// java.util.Random : 这个类用于生成伪随机数。我们需要它来随机选择按钮的位置。
import java.util.Random;


// 'extends JFrame' : 这部分是关键！
//    - 'extends' 是Java中用于表示继承的关键字。
//    - 'JFrame' 是Swing库中的一个类，代表一个带有标题栏、边框和标准窗口操作（最小化、最大化、关闭）的顶级窗口。
//    - 所以，`CatchButtonGameV1 extends JFrame` 意味着 `CatchButtonGameV1` 类
//      是一个特殊类型的 `JFrame`。它继承了 `JFrame` 的所有公共和受保护的属性和方法，
//      因此 `CatchButtonGameV1` 的对象本身就是一个窗口。
public class CatchButtonGameV1 extends JFrame {

        // 2. 定义常量 (Constants)
    // 'private static final' :
    //    - 'private': 这些常量只能在本类 (`CatchButtonGameV1`) 内部访问。
    //    - 'static': 这些常量属于类本身，而不是类的某个特定对象。意味着无论创建多少个游戏对象，这些常量的值都是共享的，且只有一份。
    //    - 'final': 表示这些变量的值一旦被初始化后就不能再改变。它们是真正的常量。
    // 常量名通常用全大写字母，并用下划线分隔单词。

    private static final int GRID_SIZE = 3; // 网格的边长 (例如，3 表示 3x3 网格)
    private static final int TOTAL_BUTTONS = GRID_SIZE * GRID_SIZE; // 根据边长计算总按钮数 (3*3 = 9)
    private static final String CATCH_ME_TEXT = "Click me"; // 那个会逃跑的按钮上显示的文本

        // 3. 定义成员变量 (Instance Variables / Fields)
    // 这些变量属于 `CatchButtonGameV1` 类的每一个对象（实例）。
    // 每个游戏窗口对象都会有自己的一套这些变量。
    // 'private' 表示它们只能被本类的方法访问，这是封装性的体现。

    private JButton[] buttons; // 一个 JButton 对象的数组。JButton 是Swing中的按钮类。
                               // 这个数组将用来存放网格中的所有按钮。

    private Random random;     // Random 类的对象，用于生成随机数，以便随机选择按钮。

    private int currentCatchMeButtonIndex; // 一个整数，用来记录当前显示 "Click me" 文本的按钮
                                           // 在 `buttons` 数组中的索引位置。初始时可以设为一个无效索引，如 -1。

        /**
     * CatchButtonGameV1 类的构造函数 (Constructor)。
     * 当使用 `new CatchButtonGameV1()` 创建一个游戏对象时，这个构造函数会被自动调用。
     * 它的主要工作是初始化游戏窗口和内部组件。
     */
    public CatchButtonGameV1() {
        // 3.1 初始化 JFrame 的基本属性 (因为我们的类继承自 JFrame，所以可以直接调用 JFrame 的方法)

        // setTitle(String title): 设置窗口的标题栏文本。
        setTitle("Catch me if you can!");

        // setDefaultCloseOperation(int operation): 设置当用户点击窗口右上角的关闭按钮 (X) 时的行为。
        // JFrame.EXIT_ON_CLOSE: 表示点击关闭按钮时，应用程序将完全退出。
        // 如果不设置这个，窗口关闭了，但Java程序可能仍在后台运行，消耗资源。
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setSize(int width, int height): 设置窗口的初始宽度和高度，单位是像素。
        setSize(400, 400);

        // setLocationRelativeTo(Component c): 设置窗口相对于另一个组件的位置。
        // 如果参数是 null，窗口会显示在屏幕的中央。
        setLocationRelativeTo(null);

        // 3.2 初始化成员变量
        // 创建一个 JButton 数组，其大小为 TOTAL_BUTTONS (9)。
        // 此时数组中每个元素都还是 null，我们稍后会用真正的 JButton 对象填充它。
        buttons = new JButton[TOTAL_BUTTONS];

        // 创建一个新的 Random 对象，用于后续的随机数生成。
        random = new Random();

        // 初始化当前 "Click me" 按钮的索引为 -1，表示还没有按钮被选中。
        currentCatchMeButtonIndex = -1;

        // 3.3 创建 JPanel 并设置其布局管理器
        // JPanel 是一个通用的轻量级容器，可以用来组织和容纳其他Swing组件（如按钮）。
        // 你可以把它想象成一个画板或者一个子区域，可以在上面摆放东西。
        // 'new GridLayout(GRID_SIZE, GRID_SIZE, 5, 5)' : 这是设置 JPanel 的布局管理器。
        //    - LayoutManager (布局管理器) 负责决定容器内组件的大小和位置。
        //    - GridLayout 将容器划分为大小相等的行和列组成的网格。
        //        - 第一个 GRID_SIZE (3): 指定网格的行数。
        //        - 第二个 GRID_SIZE (3): 指定网格的列数。
        //        - 第一个 5: 指定组件之间的水平间隙 (hgap)，单位是像素。
        //        - 第二个 5: 指定组件之间的垂直间隙 (vgap)，单位是像素。
        JPanel panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE, 5, 5));

        // 3.4 创建按钮，为按钮添加事件监听器，并将按钮添加到 JPanel 中
        // 使用一个 for 循环来创建 TOTAL_BUTTONS (9) 个按钮。
        for (int i = 0; i < TOTAL_BUTTONS; i++) {
            // 'buttons[i] = new JButton("");' : 创建一个新的 JButton 对象。
            //   参数 "" 表示按钮上初始时没有文本。
            //   并将这个新创建的按钮对象存储在 `buttons` 数组的第 i 个位置。
            buttons[i] = new JButton("");

            // 'buttons[i].setFont(new Font("Arial", Font.BOLD, 16));' : 设置按钮上文本的字体。
            //    - "Arial": 字体名称。
            //    - Font.BOLD: 字体样式 (粗体)。Font.PLAIN 是普通，Font.ITALIC 是斜体。
            //    - 16: 字体大小。
            buttons[i].setFont(new Font("Arial", Font.BOLD, 16));

            // 'buttons[i].setFocusable(false);' : 设置按钮是否可以获得焦点。
            //    - 焦点通常表现为组件周围的虚线框，表示它是当前活动的组件。
            //    - 在这个游戏中，我们不希望按钮显示焦点框，所以设为 false，让界面更清爽。
            buttons[i].setFocusable(false);

            // 'final int buttonIndex = i;' : 这一行非常重要，涉及到匿名内部类的变量捕获。
            //    - 我们将要在下面的匿名内部类 (MouseAdapter) 中使用循环变量 'i'。
            //    - Java规定，匿名内部类只能访问其外部作用域中的 final 或 effectively final 变量。
            //    - "effectively final" 指的是变量在初始化后其值没有再被改变过。
            //    - 将 'i' 赋值给一个新的 'final' 变量 'buttonIndex'，确保每个监听器都捕获到正确的按钮索引。
            final int buttonIndex = i; // 这个 buttonIndex 对于每个按钮的监听器来说都是一个固定的值。

            // 'buttons[i].addMouseListener(MouseListener listener);' : 为当前按钮添加一个鼠标事件监听器。
            //    - 当鼠标在这个按钮上发生特定动作（进入、退出、点击等）时，监听器会收到通知。
            // 'new MouseAdapter() { ... }' : 这里我们创建了一个匿名内部类的对象。
            //    - 'MouseAdapter' 是一个实现了 'MouseListener' 接口的空适配器类。
            //      'MouseListener' 接口定义了多个方法 (mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited)。
            //      如果我们只需要其中一两个方法，继承 'MouseAdapter' 并只重写 (override) 我们需要的方法会更简洁。
            //    - '{ ... }' 大括号内是这个匿名内部类的具体实现。
            buttons[i].addMouseListener(new MouseAdapter() {
                // '@Override' : 这是一个注解，表示下面的方法是重写 (覆盖) 父类 (MouseAdapter) 的方法。
                //               这不是必需的，但有助于编译器检查和代码可读性。
                @Override
                // 'public void mouseEntered(MouseEvent e)' : 当鼠标光标进入到这个按钮的区域时，此方法会被调用。
                //    - 'MouseEvent e' : 参数 e 是一个 MouseEvent 对象，包含了关于此次鼠标事件的详细信息 (虽然我们这里没用它)。
                public void mouseEntered(MouseEvent e) {
                    // 检查当前鼠标进入的按钮 (由 buttonIndex 标识) 是否就是那个显示 "Click me" 的按钮
                    // (由 currentCatchMeButtonIndex 记录)。
                    if (buttonIndex == currentCatchMeButtonIndex) {
                        // 如果是，就调用 moveCatchMeText() 方法，让 "Click me" 文本跳到另一个按钮上。
                        moveCatchMeText();
                    }
                }

                // 我们没有重写 mouseClicked, mousePressed 等方法，因为题目要求：
                // ii) 用户永远无法成功点击 "Click me" 按钮。
                // iii) 点击其他按钮 (没有 "Click me" 文本的按钮) 不产生结果。
                // MouseAdapter 已经为空实现了这些方法，所以我们不需要额外处理。
            });

            // 'panel.add(buttons[i]);' : 将刚刚创建和配置好的按钮 `buttons[i]` 添加到 `panel` (JPanel) 中。
            // GridLayout 会自动将按钮放置在网格的下一个可用位置。
            panel.add(buttons[i]);
        }

        // 3.5 将 JPanel 添加到 JFrame
        // 'add(panel);' : 将包含所有按钮的 `panel` 添加到当前的 `JFrame` (即 `CatchButtonGameV1` 对象本身) 中。
        // 默认情况下，JFrame 使用 BorderLayout，如果不指定位置，它会添加到 BorderLayout.CENTER 区域。
        add(panel);

        // 3.6 初始随机放置 "Click me" 文本
        // 调用一个我们自己定义的方法来随机选择一个按钮，并把 "Click me" 文本放上去。
        placeInitialCatchMeText();

        // 3.7 设置窗口可见 (通常在所有组件添加完毕后调用)
        // 'setVisible(true);' : 使窗口及其内容显示在屏幕上。
        // 注意：在实际的Swing应用中，更推荐将 setVisible(true) 的调用放在 main 方法的
        // SwingUtilities.invokeLater 内部，以确保所有GUI操作都在事件分派线程(EDT)中完成。
        // 这里暂时注释掉，我们将在 main 方法中处理它。
        // setVisible(true);
    }

    /**
     * 私有辅助方法：在游戏初始化时，随机选择一个按钮并设置其文本为 "Click me"。
     * 'private' 表示这个方法只能在 CatchButtonGameV1 类内部被调用。
     */
    private void placeInitialCatchMeText() {
        // 'random.nextInt(TOTAL_BUTTONS)' : 生成一个介于 0 (包含) 和 TOTAL_BUTTONS (不包含) 之间的随机整数。
        // 例如，如果 TOTAL_BUTTONS 是 9, 它会生成 0 到 8 之间的一个随机数。
        // 这个随机数将作为 `buttons` 数组的索引。
        int randomIndex = random.nextInt(TOTAL_BUTTONS);

        // 'buttons[randomIndex].setText(CATCH_ME_TEXT);' : 获取随机选中的那个按钮对象，
        // 并调用它的 setText() 方法，将其显示的文本设置为 CATCH_ME_TEXT ("Click me")。
        buttons[randomIndex].setText(CATCH_ME_TEXT);

        // 更新 `currentCatchMeButtonIndex` 成员变量，记录下当前 "Click me" 按钮的索引。
        currentCatchMeButtonIndex = randomIndex;

        // (可选) 在控制台打印信息，方便调试，看看初始位置在哪里。
        System.out.println("初始 'Click me' 文本在按钮: " + randomIndex);
    }

    /**
     * 私有辅助方法：将 "Click me" 文本从当前按钮移动到一个新的随机按钮。
     * 这个方法会在鼠标进入当前的 "Click me" 按钮时被调用。
     */
    private void moveCatchMeText() {
        // 1. 清除当前按钮上的 "Click me" 文本
        //    首先检查 `currentCatchMeButtonIndex` 是否有效 (不是初始的 -1)。
        if (currentCatchMeButtonIndex != -1) {
            // 获取当前带有 "Click me" 文本的按钮，并将其文本设置为空字符串 ""。
            buttons[currentCatchMeButtonIndex].setText("");
        }

        // 2. 找到一个新的随机位置，并确保这个新位置与旧位置不同。
        int newIndex;
        // 使用一个 do-while 循环来确保新选的索引 `newIndex` 与当前的 `currentCatchMeButtonIndex` 不同。
        // 这样可以避免文本“跳到”它自己原来的位置上（虽然概率很小，但逻辑上应该避免）。
        do {
            newIndex = random.nextInt(TOTAL_BUTTONS); // 随机选择一个新索引
        } while (newIndex == currentCatchMeButtonIndex && TOTAL_BUTTONS > 1);
        // 循环条件：只要新索引和旧索引相同，并且总按钮数大于1（如果只有一个按钮，这个循环会无限进行，所以加个保护）
        // 对于这个V1版本，TOTAL_BUTTONS 固定为9，所以 TOTAL_BUTTONS > 1 总是成立。

        // 3. 在新选中的按钮上设置 "Click me" 文本
        buttons[newIndex].setText(CATCH_ME_TEXT);

        // 4. 更新 `currentCatchMeButtonIndex` 为新的索引
        currentCatchMeButtonIndex = newIndex;

        // (可选) 在控制台打印信息，方便调试。
        System.out.println("'Click me' 文本移动到按钮: " + newIndex);
    }

        /**
     * 主方法 (main method)，Java程序的入口点。
     * 当你运行 `java CatchButtonGameV1` 命令时，JVM (Java虚拟机) 会首先寻找并执行这个 `main` 方法。
     * 'public static void main(String[] args)' :
     *    - 'public': 表示这个方法可以从任何地方被访问。
     *    - 'static': 表示这个方法属于类本身 (CatchButtonGameV1)，而不是类的某个特定对象。
     *                因此，可以在没有创建 CatchButtonGameV1 对象的情况下调用它 (JVM就是这么做的)。
     *                这也是为什么 `main` 方法不能直接访问非 `static` 的成员变量或方法的原因。
     *    - 'void': 表示这个方法不返回任何值。
     *    - 'main': 这是JVM约定的特殊方法名。
     *    - 'String[] args': 这是命令行参数。当用户在命令行运行程序时，可以传递参数给程序，
     *                     这些参数会以字符串数组的形式存储在 `args` 中。在这个V1版本中我们没有使用它。
     * @param args 命令行参数数组 (在这个V1版本中未使用)。
     */
    public static void main(String[] args) {
        // SwingUtilities.invokeLater(Runnable doRun) :
        // 这是一个非常重要的Swing工具方法。Swing的GUI组件操作和更新不是线程安全的，
        // 意味着如果你从主线程 (main方法所在的线程) 或其他非特定线程直接创建或修改Swing组件，
        // 可能会导致界面冻结、绘制错误或更复杂的并发问题。
        //
        // Swing规定，所有对Swing组件的创建、修改和查询都应该在所谓的
        // "事件分派线程" (Event Dispatch Thread, EDT) 中执行。
        //
        // 'invokeLater' 方法接受一个 'Runnable' 对象作为参数。'Runnable' 是一个接口，
        // 它只有一个方法：`void run()`。
        // 'invokeLater' 会将这个 'Runnable' 对象放到EDT的事件队列中。当EDT有空闲时，
        // 它会从队列中取出这个 'Runnable' 对象并执行其 `run()` 方法。
        // 这样做可以确保GUI相关的代码在正确的线程中安全地执行。
        SwingUtilities.invokeLater(new Runnable() { // 创建一个 Runnable 接口的匿名实现类
            @Override // 重写 Runnable 接口的 run 方法
            public void run() {
                // 这部分代码将在事件分派线程 (EDT) 中执行。

                // 'CatchButtonGameV1 game = new CatchButtonGameV1();' :
                // 创建 CatchButtonGameV1 类的一个实例 (对象)。
                // 这会调用 CatchButtonGameV1 的构造函数，从而初始化整个游戏窗口和组件。
                CatchButtonGameV1 game = new CatchButtonGameV1();

                // 'game.setVisible(true);' :
                // 调用游戏窗口对象的 setVisible 方法，使其在屏幕上显示出来。
                // 这是启动GUI的最后一步。
                game.setVisible(true);
            }
        });
    }
}
