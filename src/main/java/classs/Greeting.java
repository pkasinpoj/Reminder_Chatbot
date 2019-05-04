package classs;

import java.io.IOException;
import java.util.Random;

public class Greeting {
    public String greeting() throws IOException {
        Random r = new Random();
        int randomnum = r.nextInt(3);
        String []answers = new String[3];
        answers[0] = "วันนี้จะให้น้องจำดีช่วยจำอะไรดีครับ";
        answers[1] = "ได้เลยครับ อย่าลืมพิมพ์สิ่งที่อยากให้จำตามด้วย,เเละตามด้วยวันที่";
        answers[2] = "พิมพ์มาเลยครับน้องจำดีจำได้";
        return answers[randomnum];
    }
}
