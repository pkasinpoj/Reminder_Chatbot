package function;

import java.io.IOException;

public class Remembersubject {
    public String remembersubject(String msgText) throws IOException {
        String text;
        String[] arrB = new String[3];
        try {
            if (msgText.contains("เรียนวัน")){
                arrB = msgText.split("เรียนวัน");
            }else {
                arrB = msgText.split("เรียน");
            }
            if (arrB[2].equals("จันทร์") || arrB[2].equals("อังคาร") || arrB[2].equals("พุธ") || arrB[2].equals("พฤหัส") || arrB[2].equals("ศุกร์") || arrB[2].equals("เสาร์") || arrB[2].equals("อาทิตย์")) {
                text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "เรียนวัน" + arrB[2] + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
            } else {
                text = "ไม่บอกวันเรียนน้องจำดีจำไม่ได้น้า";
            }
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
}
