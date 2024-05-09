package io.spring.swagger.domain.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {

    // 고유 트랜잭션 키를 생성한다.
    public static String generateTrxKey() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

        return formatter.format(new Date()) + generateRandom4Digit();
    }

    // 4자리 랜덤 숫자를 생성한다.
    public static String generateRandom4Digit() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9000) + 1000);
    }

}
