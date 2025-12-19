package src;

import java.util.Arrays;

public class NationalCodeValidator {

    public static boolean isValid(String code) {

        // باید 10 رقم باشد
        if (!code.matches("\\d{10}")) return false;

        // کدهای ناصحیح که همه ارقام یکسانند
        String[] invalids = {
                "0000000000","1111111111","2222222222","3333333333",
                "4444444444","5555555555","6666666666","7777777777",
                "8888888888","9999999999"
        };
        if (Arrays.asList(invalids).contains(code)) return false;

        // محاسبه رقم کنترل
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (code.charAt(i) - '0') * (10 - i);
        }

        int r = sum % 11;
        int c = code.charAt(9) - '0';

        return (r < 2 && c == r) || (r >= 2 && c == 11 - r);
    }
}
