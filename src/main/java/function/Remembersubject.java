package function;

import java.io.IOException;

public class Remembersubject {
    public String remembersubject(String msgText) throws IOException {
        System.out.println("here");
        String text;
        String[] arrB = new String[3];
        String[] cut = new String[3];
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
            System.out.println(cut[0]);
            System.out.println(cut[1]);
            System.out.println(cut[2]);
            if (cut[2].equals("จันทร์") || cut[2].equals("อังคาร") || cut[2].equals("พุธ") || cut[2].equals("พฤหัส") || cut[21].equals("ศุกร์") || cut[2].equals("เสาร์") || cut[2].equals("อาทิตย์")) {
                text = "ชื่อวิชาคือ" + "\n" + cut[1] + "\n" + "เรียนวัน" + cut[2] + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
            } else {
                text = "ไม่บอกวันเรียนน้องจำดีจำไม่ได้น้า";
            }
        } catch (Exception e) {
            text = "ขออภัยด้วยครับน้องจำดีไม่สามารถบันทึกได้สำเร็จ";
        }
        return text ;
    }
}
