/**
 * 電卓の入力状態を表す列挙型。
 * CalculatorModel がユーザー入力をどう解釈するかの判断に使用する。
 */
public enum InputState {

    // 初期状態、または計算結果表示直後の状態
    READY,

    // 数字を入力している状態
    INPUT_NUMBER,

    // 演算子を入力した直後の状態
    INPUT_OPERATOR,

    // エラーが発生している状態
    ERROR
}