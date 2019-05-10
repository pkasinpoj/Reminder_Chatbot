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
    public String getpoint(String msgText,String idline) throws IOException {
        String text;
        try {
           ConditionPoint c = new ConditionPoint();
            String[] arrB = c.conditiongetpoint(msgText);
            Pointdb p = new Pointdb();
            int point = p.showpoint(arrB[1],idline);
            if (point != 0){
                text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "คะเเนนของคุณคือ" + point + "\n" + "ขอบคุณครับ";
            }else {
                text = "ไม่มีคะเเนนเลยอ่าครับ";
            }
        } catch (Exception e) {
            text = "เอ๋ ทำไมไม่มีคะเเเนนเลยนะ";
        }
        return text ;
    }
}
