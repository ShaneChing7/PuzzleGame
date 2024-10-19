package shane.util;

import java.util.Random;

public class CodeUtil {
    private String code;
    private static final int length = 5 ;


    public CodeUtil() {
    }



    public static String getCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return "CodeUtil{code = " + code + "}";
    }
}
