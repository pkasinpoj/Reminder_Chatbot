package condition;

import java.io.IOException;

public class ConditionSubject {
    public static String[] conditionsubject (String msgText) throws IOException {
        String[] arrB = new String[3];
        String[] cut = new String[3];
        if (msgText.contains("วิชาเรียน")){
            arrB = msgText.split("วิชาเรียน");
        }else if (msgText.contains("วิชา")){
            arrB = msgText.split("วิชา");
        }
        if (arrB[1].contains("เรียนวัน")){
            cut = arrB[1].split("เรียนวัน");
        }else if (arrB[1].contains("เรียน")){
            cut = arrB[1].split("เรียน");
        }
        return cut ;
    }
}
