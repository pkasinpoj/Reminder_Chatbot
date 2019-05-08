package function;

import condition.ConditionPoint;

import java.io.IOException;

public class Point {
    public String recievepoint(String msgText) throws IOException {
        String text;
        try {
            ConditionPoint c = new ConditionPoint();
            String[] cut = c.conditionpoint(msgText);
            int point = Integer.parseInt(cut[1]);
                text = "ชื่อวิชาคือ" + "\n" + cut[0] + "\n" + "คะเเนนของคุณคือ" + point + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
    public String getpoint(String msgText) throws IOException {
        String text;
        try {
            String[] arrB = msgText.split("-");
            text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "คะเเนนของคุณคือ" + "99" + "\n" + "ขอบคุณครับ";
        } catch (Exception e) {
            text = "เอ๋ ไม่มีชื่อวิชาน้องจำดีเช็คให้ไม่ได้นะ";
        }
        return text ;
    }
}
