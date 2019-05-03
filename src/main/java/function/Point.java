package function;

import java.io.IOException;

public class Point {
    public String recievepoint(String msgText) throws IOException {
        String text;
        try {
            String[] arrB = msgText.split("-");
            int point = Integer.parseInt(arrB[2]);
            text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "คะเเนนของคุณ" + point + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
    public String getpoint() throws IOException {
        String text;
        try {
            text = "คะเเนนคุณคือ 99";
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
}
