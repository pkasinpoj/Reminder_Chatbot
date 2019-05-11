package events;

import classas.Payload;
import function.Solution;
import gateway.Recieveinfo;
import message.Replytouser;

import java.io.IOException;

public class ManageEvent {
    public void manageEvent(Payload payload) throws IOException
    {
        String msgText = " ";
        String idTarget = " ";
        String eventType = payload.events[0].type;
        Replytouser r = new Replytouser();
        if (eventType.equals("join")){
            if (payload.events[0].source.type.equals("group")){
                r.replyToUser(payload.events[0].replyToken, "Hello Group");
            }else if (payload.events[0].source.type.equals("room")){
                r.replyToUser(payload.events[0].replyToken, "Hello Room");
            }else {
                Solution s = new Solution();
                String text = s.greeting();
                r.replyToUser(payload.events[0].replyToken,text);
            }
        } else if (eventType.equals("message")){
            if (payload.events[0].source.type.equals("group")){
                idTarget = payload.events[0].source.groupId;
            } else if (payload.events[0].source.type.equals("room")){
                idTarget = payload.events[0].source.roomId;
            } else if (payload.events[0].source.type.equals("user")){
                idTarget = payload.events[0].source.userId;
            }
            if (!payload.events[0].message.type.equals("text")){
                r.replyToUser(payload.events[0].replyToken, "ขอโทษด้วยครับน้องจำดีไม่รู้จัก");
            } else {
                msgText = payload.events[0].message.text;
                msgText = msgText.toLowerCase();

                if (!msgText.contains("bot leave")){
                    Recieveinfo datatext = new Recieveinfo();
                    String recievetext = datatext.Recieveinfo(msgText,idTarget);
                    r.replyToUser(payload.events[0].replyToken,recievetext);
                } else {
                    LeaveGR l = new LeaveGR();
                    if (payload.events[0].source.type.equals("group")){
                        l.leaveGR(payload.events[0].source.groupId, "group");
                    } else if (payload.events[0].source.type.equals("room")){
                        l.leaveGR(payload.events[0].source.roomId, "room");
                    }
                }
            }
        }
    }
}
