package condition;

import crud.Memberdb;

public class CheckMember {
    public static void checkid(String idline){
        try{
            Memberdb m = new Memberdb();
            boolean check = m.checkmember(idline);
            if (!check) {
                m.insertmember(idline);
            }
        }catch (Exception e){
            System.out.println("checkid+"+e);
        }
    }
}
