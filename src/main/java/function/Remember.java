package function;

import crud.Memberdb;

public class Remember {
    public String remembers(String msgText,String id)  {
        String text ;
        String[] arrB = new String[2];
            if (msgText.contains("ส่ง")){
                arrB = msgText.split("ส่ง");
            } else if (msgText.contains("กำหนดส่ง")){
                arrB = msgText.split("กำหนดส่ง");
            }
            if (arrB[0] != null && arrB[1] != null ){
                text = "งานของคุณคือ"+"\n"+arrB[0]+"\n"+"กำหนดส่งคือ"+arrB[1]+"\n"+"บันทึกข้อมูลเสร็จเเล้วครับ";
                Memberdb m = new Memberdb();
                m.insertmember(id);
                boolean check = m.checkmember(id);
                System.out.println(check);

            }
            else {
                text = "ไม่มีกำหนดส่งน้องจำดีช่วยไม่ได้น้า";
            }
        return text;
    }
}
