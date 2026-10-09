/**
 * 例外をログ出力するクラス。
 */
public class ErrorHandler {

    /**
     * 捕捉した例外の内容を標準エラー出力に表示する。
     *
     * @param exception try-catchで捕まえた例外
     */
    public static void handle(Exception exception) {
        if (exception == null) {
            return;
        }

        String message = exception.getMessage();

        if (message == null || message.isEmpty()) {
            System.err.println("計算エラーが発生しました。");
            return;
        }

        System.err.println(message);
    }
}
