package cn.edu.gdmec.android.recyclerviewapplication;

import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by apple on 18/5/8.
 */

public class Msg {
    private String content;
    private int type;
    private  String time;
    public final static int TYPE_RECEIVED=0;
    public final static int TYPE_SEND=1;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
        this.time = timeData();
    }
    public String getContent(){
        return content;
    }

    public int getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String timeData(){
        Date date=new Date();
        String timeData=String.format("%tH",date)+String.format("%tM",date)+String.format("%tS",date);
        return timeData;

    }

}
