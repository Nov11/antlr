package pb3.checker;

import org.apache.commons.lang3.StringUtils;

public interface Checker {
    static void checkString(String s) {
        if (StringUtils.isEmpty(s)) {
            System.out.println("empty");
        }
    }

    static void checkDouble(double d) {
    }

    static void checkInt32(int i) {
        if (i == 0) {
            System.out.println("int zero");
        }
    }
}
