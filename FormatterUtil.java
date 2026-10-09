import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 計算結果を表示用文字列に整形するユーティリティクラス。
 */
public class FormatterUtil {

    // 通常表示できる最大桁数（小数点と負号は含めない）
    private static final int MAX_DISPLAY_DIGITS = 8;

    // 指数表記の仮数部の小数点以下桁数
    private static final int SCIENTIFIC_SCALE = 7;

    private FormatterUtil() {
    }

    /**
     * 計算結果を画面表示用の文字列に整形する。
     *
     * @param value 表示対象の値
     * @return 表示用文字列
     */
    public static String formatResultForDisplay(BigDecimal value) {
        if (value == null || value.signum() == 0) {
            return "0";
        }

        BigDecimal stripped = value.stripTrailingZeros();
        String plain = stripped.toPlainString();

        if (countDisplayDigits(plain) > MAX_DISPLAY_DIGITS) {
            return toScientificString(stripped);
        }

        return plain;
    }

    // 通常表記の中に含まれる数字の個数を数える
    private static int countDisplayDigits(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    // BigDecimal の値を指数表記に変換する
    private static String toScientificString(BigDecimal value) {
        if (value.signum() == 0) {
            return "0";
        }

        int exponent = value.precision() - value.scale() - 1;

        BigDecimal mantissa = value.movePointLeft(exponent)
                .setScale(SCIENTIFIC_SCALE, RoundingMode.HALF_UP);

        return mantissa.toPlainString() + "e" + exponent;
    }
}
