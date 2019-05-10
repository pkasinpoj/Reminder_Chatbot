package gateway;

import function.Greeting;
import function.Point;
import function.Remember;
import function.Remembersubject;

import java.io.IOException;

public class Recieveinfo {
    public String Recieveinfo (String msgText,String id) throws IOException {
        String text;
        if (msgText.contains("ช่วยจำหน่อย") || msgText.contains("จำให้หน่อย") ){
                Greeting g = new Greeting();
                String restext = g.greeting();
                text = restext;
        } else if (msgText.contains("จำวิชาเรียน") || msgText.contains("จำวิชา")  ){
                Remembersubject r = new Remembersubject();
                String restext = r.remembersubject(msgText);
                text = restext;
        } else if (msgText.contains("จำคะเเนนเก็บ") || msgText.contains("จำคะเเนน")  ){
                Point p = new Point();
                String restext = p.recievepoint(msgText);
                text = restext;
        } else if (msgText.contains("ดูคะเเนนเก็บ") || msgText.contains("ดูคะเเนน")  ){
                Point p = new Point();
                String restext = p.getpoint(msgText);
                text = restext;
        } else  {
            try {
                Remember r = new Remember();
                String restext = r.remembers(msgText,id);
                text = restext;
            }catch (Exception e){
                text = "มันคืออะไรอ่าาาาครับ";
            }
        }
        return text;
    }
}
