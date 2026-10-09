import javax.swing.SwingUtilities;

/**
 * 電卓アプリケーションを起動するメインクラス。
 * ビューとコントローラーを生成して関連付けし、画面を表示する。
 */
public class CalculatorApp {

    /**
     * アプリケーションを起動する。
     * Swing の画面生成処理はイベントディスパッチスレッド上で実行する。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // 電卓画面を表示するビューを生成する
            CalculatorFrame view = new CalculatorFrame();

            // ビューを操作するコントローラーを生成する
            CalculatorController controller = new CalculatorController(view);

            // ビューにコントローラーを関連付ける
            view.bindController(controller);

            // 電卓画面を表示する
            view.setVisible(true);
        });
    }
}
