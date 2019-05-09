package com.chatbot.jumdee;
import classas.Payload;
import com.google.gson.Gson;
import com.linecorp.bot.client.LineSignatureValidator;
import config.Connect;
import events.ManageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@RestController
@RequestMapping(value="/linebot")
public class LineBotController
{
    @Autowired
    @Qualifier("com.linecorp.channel_secret")
    String lChannelSecret;

    @RequestMapping(value="/callback", method=RequestMethod.POST)
    public ResponseEntity<String> callback(
            @RequestHeader("X-Line-Signature") String aXLineSignature,
            @RequestBody String aPayload) throws IOException {
        final String text=String.format("The Signature is: %s",
                (aXLineSignature!=null && aXLineSignature.length() > 0) ? aXLineSignature : "N/A");
        System.out.println(text);
        final boolean valid=new LineSignatureValidator(lChannelSecret.getBytes()).validateSignature(aPayload.getBytes(), aXLineSignature);
        System.out.println("The signature is: " + (valid ? "valid" : "tidak valid"));
        if(aPayload!=null && aPayload.length() > 0)
        { System.out.println("Payload: " + aPayload); }
        Gson gson = new Gson();
        Payload payload = gson.fromJson(aPayload, Payload.class);
        ManageEvent m = new ManageEvent();
        Connect c = new Connect();
        Connection con = c.connectiondb();
        m.manageEvent(payload);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

