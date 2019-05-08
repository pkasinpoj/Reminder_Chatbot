package com.chatbot.jumdee;

import classas.Payload;
import com.google.gson.Gson;
import com.linecorp.bot.client.LineSignatureValidator;
import events.LeaveGR;
import events.ManageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import gateway.Recieveinfo;
import message.Replytouser;
@RestController
@RequestMapping(value="/linebot")
public class LineBotController
{
    @Autowired
    @Qualifier("com.linecorp.channel_secret")
    String lChannelSecret;

    @Autowired
    @Qualifier("com.linecorp.channel_access_token")
    String lChannelAccessToken;

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
        {
            System.out.println("Payload: " + aPayload);
        }
        Gson gson = new Gson();
        Payload payload = gson.fromJson(aPayload, Payload.class);
        ManageEvent m = new ManageEvent();
        m.manageEvent(payload);
//        String msgText = " ";
//        String idTarget = " ";
//        String eventType = payload.events[0].type;
//        Replytouser r = new Replytouser();
//        if (eventType.equals("join")){
//            if (payload.events[0].source.type.equals("group")){
//                r.replyToUser(payload.events[0].replyToken, "Hello Group");
//            }
//            if (payload.events[0].source.type.equals("room")){
//                r.replyToUser(payload.events[0].replyToken, "Hello Room");
//            }
//        } else if (eventType.equals("message")){
//            if (payload.events[0].source.type.equals("group")){
//                idTarget = payload.events[0].source.groupId;
//            } else if (payload.events[0].source.type.equals("room")){
//                idTarget = payload.events[0].source.roomId;
//            } else if (payload.events[0].source.type.equals("user")){
//                idTarget = payload.events[0].source.userId;
//            }
//
//            if (!payload.events[0].message.type.equals("text")){
//                r.replyToUser(payload.events[0].replyToken, "ขอโทษด้วยครับน้องจำดีไม่รู้จัก");
//            } else {
//                msgText = payload.events[0].message.text;
//                msgText = msgText.toLowerCase();
//
//                if (!msgText.contains("bot leave")){
//                    Recieveinfo datatext = new Recieveinfo();
//                    String recievetext = datatext.Recieveinfo(msgText);
//                    r.replyToUser(payload.events[0].replyToken,recievetext);
//                } else {
//                    LeaveGR l = new LeaveGR();
//                    if (payload.events[0].source.type.equals("group")){
//                        l.leaveGR(payload.events[0].source.groupId, "group");
//                    } else if (payload.events[0].source.type.equals("room")){
//                        l.leaveGR(payload.events[0].source.roomId, "room");
//                    }
//                }
//
//            }
//        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

