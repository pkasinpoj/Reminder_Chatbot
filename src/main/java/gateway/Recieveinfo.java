package gateway;

import function.Greeting;
import function.Point;
import function.Remember;
import function.Remembersubject;

import java.io.IOException;

public class Recieveinfo {
    public String Recieveinfo (String msgText) throws IOException {
        String text;
        if (msgText.contains("ช่วยจำหน่อย") || msgText.contains("จำให้หน่อย") ){
            try {
                Greeting g = new Greeting();
                String restext = g.greeting();
                text = restext;
            }catch (Exception e){
                text = "อ่าาา ทำไมน้องจำดีไม่เข้าใจเลย";
            }
        } else if (msgText.contains(",")){
            try {
                Remember r = new Remember();
                String restext = r.remember(msgText);
                text = restext;
            }catch (Exception e){
                text = "ไม่สามารถบันทึกได้ครับ";
            }
        } else if (msgText.contains("จำวิชาเรียน") || msgText.contains("จำวิชา")  ){
            try {
                Remembersubject r = new Remembersubject();
                String restext = r.remembersubject(msgText);
                text = restext;
            }catch (Exception e){
                text = "มันคืออะไรหรอครับ";
            }
        } else if (msgText.contains("จำคะเเนนเก็บ") || msgText.contains("จำคะเเนน")  ){
            try {
                Point p = new Point();
                String restext = p.recieveponit(msgText);
                text = restext;
            }catch (Exception e){
                text = "มันคืออะไรหรอครับ";
            }
        } else  {
            text = "มันคืออะไรอ่าาาาครับ";
        }
        return text;
    }
}
