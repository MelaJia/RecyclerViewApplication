package cn.edu.gdmec.android.recyclerviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText editText;
    private Button sendButton;
    private RecyclerView recyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        editText=findViewById(R.id.enter);
        sendButton=findViewById(R.id.send);
        recyclerView=findViewById(R.id.chatroomRecycleView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        msgAdapter=new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
     //   recyclerView.addItemDecoration(new Di);
      //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=editText.getText().toString();
                if (!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    editText.setText("");

                }
            }
        });
    }

    public void initMsgs() {
        Msg msg1=new Msg("Hello",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("Thanks",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("Byet",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4=new Msg("oo",Msg.TYPE_SEND);
        msgList.add(msg4);


    }
}
