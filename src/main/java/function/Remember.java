package function;
import crud.Rememberdb;

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
                boolean result = false;
                Rememberdb r = new Rememberdb();
                result = r.insertremember(arrB[0],arrB[1],id);
                if (result){
                    text = "งานของคุณคือ"+"\n"+arrB[0]+"\n"+"กำหนดส่งคือ"+arrB[1]+"\n"+"บันทึกข้อมูลเสร็จเเล้วครับ";
                }else{
                    text = "บันทึกข้อมูลไม่สำเร็จครับ";
                }
            }
            else {
                text = "ไม่มีกำหนดส่งน้องจำดีช่วยไม่ได้น้า";
            }
        return text;
    }
    public String showremembers(String msgText,String id)  {
        String text ;
        String[] arrB = new String[2];
        try {
            if (msgText.contains("ส่ง")){
                arrB = msgText.split("ส่ง");
            } else if (msgText.contains("กำหนดส่ง")){
                arrB = msgText.split("กำหนดส่ง");
            }
            if (arrB[0] != null && arrB[1] != null ){
                String result = "";
                Rememberdb r = new Rememberdb();
                result = r.showremember(arrB[1],id);
                if (result != ""){
                    text = result;
                }else{
                    text = "ไม่มีข้อมูลครับ";
                }
            }else {
                text = "ไม่มีข้อมูลครับ";
            }
        }
        catch (Exception e){
             text = "ขอโทษด้วยครับไม่มีข้อมูล";
        }
        return text;
    }
}
