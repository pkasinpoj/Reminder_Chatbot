package condition;

import java.io.IOException;

public class ConditionPoint {
    public static String[] conditionpoint (String msgText) throws IOException {
        String[] arrB = new String[3];
        String[] cut = new String[3];
            if (msgText.contains("จำคะเเนนเก็บ")){
                arrB = msgText.split("จำคะเเนนเก็บ");
            }else if (msgText.contains("จำคะเเนน")){
                arrB = msgText.split("จำคะเเนน");
            }
            if (arrB[1].contains("ได้คะเเนน")){
                cut = arrB[1].split("ได้คะเเนน");
            }else if (arrB[1].contains("ได้")){
                cut = arrB[1].split("ได้");
            }
        return cut ;
    }
    public static String[] conditiongetpoint (String msgText) throws IOException {
        String[] arrB = new String[2];
        if (msgText.contains("วิชา")){
            arrB = msgText.split("วิชา");
        }else if (msgText.contains("เก็บ")){
            arrB = msgText.split("เก็บ");
        }else if (msgText.contains("คะเเนน"))
            arrB = msgText.split("คะเเนน");
        return arrB ;
    }
}
