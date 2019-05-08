package function;

import java.io.IOException;

public class Point {
    public String recievepoint(String msgText) throws IOException {
        String text;
        String[] arrB = new String[3];
        String[] cut = new String[3];
        try {
            if (msgText.contains("จำคะเเนนเก็บ")){
                arrB = msgText.split("จำคะเเนนเก็บ");
            }else if (msgText.contains("จำคะเเนน")){
                arrB = msgText.split("จำคะเเนน");
            }
            if (arrB[1].contains("=")){
                cut = arrB[1].split("=");
            }else if (arrB[1].contains("ได้")){
                cut = arrB[1].split("ได้");
            }
            int point = Integer.parseInt(cut[1]);
                text = "ชื่อวิชาคือ" + "\n" + cut[0] + "\n" + "คะเเนนของคุณคือ" + point + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
//            String[] arrB = msgText.split("-");
//            int point = Integer.parseInt(arrB[2]);
//            text = "ชื่อวิชาคือ" + "\n" + arrB[1] + "\n" + "คะเเนนของคุณคือ" + point + "\n" + "บันทึกข้อมูลเสร็จเเล้วครับ";
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
