package function;

import condition.ConditionSubject;
import java.io.IOException;

public class Remembersubject {
    public String remembersubject(String msgText) throws IOException {
        String text;
        try {
            ConditionSubject c = new ConditionSubject();
            String[] cut = c.conditionsubject(msgText);
            if (cut[1].equals("จันทร์") || cut[1].equals("อังคาร") || cut[1].equals("พุธ") || cut[1].equals("พฤหัส") || cut[1].equals("ศุกร์") || cut[1].equals("เสาร์") || cut[1].equals("อาทิตย์")) {
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
