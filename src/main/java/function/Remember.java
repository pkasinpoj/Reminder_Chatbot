package function;

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
    public String remembers(String msgText)  {
        String text ;
        String[] arrB = new String[2];
            if (msgText.contains("ส่ง")){
                arrB = msgText.split("ส่ง");
            } else if (msgText.contains("กำหนดส่ง")){
                arrB = msgText.split("กำหนดส่ง");
            }
            if (arrB[0] != null && arrB[1] != null ){
                text = "งานของคุณคือ"+"\n"+arrB[0]+"\n"+"กำหนดส่งคือ"+arrB[1]+"\n"+"บันทึกข้อมูลเสร็จเเล้วครับ";
            }
            else {
                text = "บันทึกไม่สำเร็จครับ";
            }

        return text;
    }

}
