package message;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import retrofit2.Response;
import token.Gettoken;

import java.io.IOException;

public class Replytouser {
    Gettoken g = new Gettoken();
    String lChannelAccessToken = g.getAccessToken();
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