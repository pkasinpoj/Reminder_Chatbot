package function;

import java.io.IOException;

public class Remembersubject {
    public String remembersubject(String msgText) throws IOException {
        System.out.println("here");
        String text;
        String[] arrB = new String[3];
        String[] cut = new String[2];
        try {
            if (msgText.contains("วิชา")){
                arrB = msgText.split("วิชา");
            }else if (msgText.contains("วิชาเรียน")){
                arrB = msgText.split("วิชาเรียน");
            }
            System.out.println(arrB[1]);
            if (arrB[1].contains("เรียนวัน")){
                cut = arrB[1].split("เรียนวัน");
            }else if (arrB[1].contains("เรียน")){
                cut = arrB[1].split("เรียน");
            }
            if (arrB[2].equals("จันทร์") || arrB[2].equals("อังคาร") || arrB[2].equals("พุธ") || arrB[2].equals("พฤหัส") || arrB[2].equals("ศุกร์") || arrB[2].equals("เสาร์") || arrB[2].equals("อาทิตย์")) {
                text = "ชื่อวิชาคือ" + "\n" + cut[0] + "\n" + "เรียนวัน" + cut[1] + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
            } else {
                text = "ไม่บอกวันเรียนน้องจำดีจำไม่ได้น้า";
            }
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
}
