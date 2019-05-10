package function;

import condition.ConditionPoint;
import crud.Pointdb;

import java.io.IOException;

public class Point {
    public String recievepoint(String msgText,String id) throws IOException {
        String text;
        try {
            ConditionPoint c = new ConditionPoint();
            String[] cut = c.conditionpoint(msgText);
            int point = Integer.parseInt(cut[1]);
            Pointdb p = new Pointdb();
            boolean check = p.insertpoint(cut[0],point,id);
            if (check){
                text = "ชื่อวิชาคือ" + "\n" + cut[0] + "\n" + "คะเเนนของคุณคือ" + point + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
            }else {
                text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
            }
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
    public String getpoint(String msgText) throws IOException {
        String text;
        try {
           ConditionPoint c = new ConditionPoint();
            String[] arrB = c.conditiongetpoint(msgText);
            text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "คะเเนนของคุณคือ" + "99" + "\n" + "ขอบคุณครับ";
        } catch (Exception e) {
            text = "เอ๋ ไม่มีชื่อวิชาน้องจำดีเช็คให้ไม่ได้นะ";
        }
        return text ;
    }
}
