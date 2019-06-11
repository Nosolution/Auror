package org.seec.muggle.auror.util;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/6/5 12:10
 * @Version 1.0
 **/
public class CaptchaUtil {
    public static String getCaptcha() {
        char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = codeSequence[(int) (Math.random() * 35)];//其实也许可以用SecureRandom？
        }
        String codeStr = String.valueOf(code);
        return codeStr;
    }
}
