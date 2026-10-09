import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 電卓アプリケーションの画面を担当するクラス。
 * MVC におけるビューとして、表示ラベルとキーパッドを管理する。
 */
public class CalculatorFrame extends JFrame {

    // 計算式や計算結果を表示するラベル
    private JLabel displayLabel = new JLabel("0");

    // 数字ボタンや演算子ボタンを配置するキーパッド用パネル
    private JPanel keypadPanel;

    // 各数字（0～9）の入力ボタン
    private JButton zeroButton = new JButton("0");
    private JButton oneButton = new JButton("1");
    private JButton twoButton = new JButton("2");
    private JButton threeButton = new JButton("3");
    private JButton fourButton = new JButton("4");
    private JButton fiveButton = new JButton("5");
    private JButton sixButton = new JButton("6");
    private JButton sevenButton = new JButton("7");
    private JButton eightButton = new JButton("8");
    private JButton nineButton = new JButton("9");

    // 小数点を入力するボタン
    private JButton decimalPointButton = new JButton(".");

    // 演算子や制御用のボタン
    private JButton additionButton = new JButton("+");
    private JButton subtractionButton = new JButton("−");
    private JButton multiplicationButton = new JButton("×");
    private JButton divisionButton = new JButton("÷");
    private JButton equalsButton = new JButton("=");
    private JButton clearButton = new JButton("C");

    /**
     * 電卓ウィンドウを初期化する。
     * 画面の基本設定と表示ラベル、キーパッドの配置を行う。
     */
    public CalculatorFrame() {

        // ウィンドウの基本設定を行う
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(330, 460);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        // 表示ラベルの見た目を設定する
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        displayLabel.setPreferredSize(new Dimension(330, 60));
        add(displayLabel, BorderLayout.NORTH);

        // キーパッドを 5 行 4 列で作成する
        keypadPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        // 1行目
        keypadPanel.add(sevenButton);
        keypadPanel.add(eightButton);
        keypadPanel.add(nineButton);
        keypadPanel.add(divisionButton);

        // 2行目
        keypadPanel.add(fourButton);
        keypadPanel.add(fiveButton);
        keypadPanel.add(sixButton);
        keypadPanel.add(multiplicationButton);

        // 3行目
        keypadPanel.add(oneButton);
        keypadPanel.add(twoButton);
        keypadPanel.add(threeButton);
        keypadPanel.add(subtractionButton);

        // 4行目
        keypadPanel.add(zeroButton);
        keypadPanel.add(decimalPointButton);
        keypadPanel.add(equalsButton);
        keypadPanel.add(additionButton);

        // 5行目
        keypadPanel.add(clearButton);
        keypadPanel.add(new JButton());
        keypadPanel.add(new JButton());
        keypadPanel.add(new JButton());

        add(keypadPanel, BorderLayout.CENTER);
    }

    /**
     * 画面に表示する文字列を設定する。
     *
     * @param text 表示ラベルに設定する文字列
     */
    public void setDisplay(String text) {
        displayLabel.setText(text);
    }

    /**
     * 画面上の各ボタンにコントローラーを関連付ける。
     *
     * @param c ボタン操作を処理するコントローラー
     */
    public void bindController(CalculatorController c) {
        zeroButton.addActionListener(event -> c.onDigit('0'));
        oneButton.addActionListener(event -> c.onDigit('1'));
        twoButton.addActionListener(event -> c.onDigit('2'));
        threeButton.addActionListener(event -> c.onDigit('3'));
        fourButton.addActionListener(event -> c.onDigit('4'));
        fiveButton.addActionListener(event -> c.onDigit('5'));
        sixButton.addActionListener(event -> c.onDigit('6'));
        sevenButton.addActionListener(event -> c.onDigit('7'));
        eightButton.addActionListener(event -> c.onDigit('8'));
        nineButton.addActionListener(event -> c.onDigit('9'));

        decimalPointButton.addActionListener(event -> c.onDot());

        additionButton.addActionListener(event -> c.onOperator(Operator.ADD));
        subtractionButton.addActionListener(event -> c.onOperator(Operator.SUB));
        multiplicationButton.addActionListener(event -> c.onOperator(Operator.MUL));
        divisionButton.addActionListener(event -> c.onOperator(Operator.DIV));

        equalsButton.addActionListener(event -> c.onEquals());
        clearButton.addActionListener(event -> c.onClear());
    }
}
