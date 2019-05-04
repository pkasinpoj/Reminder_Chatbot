package classes;

import java.io.IOException;

public class Remember {
    public String remember(String msgText) throws IOException {
        String text ;
        try {
            String[] arrB = msgText.split(",");
            System.out.println("a"+arrB[0]);
            text = "งานของคุณคือ"+"\n"+arrB[0]+"\n"+"กำหนดส่งคือ"+arrB[1]+"\n"+"บันทึกข้อมูลเสร็จเเล้วครับ";
        }catch (Exception e){
            text = "บันทึกไม่สำเร็จครับ";
        }
        return text;
    }

}
