package message;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import retrofit2.Response;

import java.io.IOException;

public class Replytouser {
    String lChannelAccessToken = "bc+8q2pwNvPHxyxIBWPybTCZPwta9FWvYCjuiGopSAYgve+4cYTOCXDasIOhMpwFtslAhBjmV2TQLM89bILLiz3A8nQ9iYWXAnJUSzMH+f/vTCQ6rogw6e4sOlPptKO1Sd4oOgLtnObK2fk8+g089QdB04t89/1O/w1cDnyilFU=";
    public void replyToUser(String rToken, String messageToUser){
        System.out.println("this"+lChannelAccessToken);
        TextMessage textMessage = new TextMessage(messageToUser);
        ReplyMessage replyMessage = new ReplyMessage(rToken, textMessage);
        try {
            Response<BotApiResponse> response = LineMessagingServiceBuilder
                    .create(lChannelAccessToken)
                    .build()
                    .replyMessage(replyMessage)
                    .execute();
            System.out.println("Reply Message: " + response.code() + " " + response.message());
        } catch (IOException e) {
            System.out.println("Exception is raised ");
            e.printStackTrace();
        }
    }
}
