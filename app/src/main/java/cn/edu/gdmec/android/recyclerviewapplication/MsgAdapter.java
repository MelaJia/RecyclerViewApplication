package cn.edu.gdmec.android.recyclerviewapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by apple on 18/5/8.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    //写一个从外部得到的List的全局变量
    private List<Msg> msgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View myView;
        LinearLayout left_layout;
        LinearLayout right_layout;
        TextView left_msg;
        TextView right_msg;


        public ViewHolder(View itemView) {
            super(itemView);
            myView=itemView;
            left_layout=itemView.findViewById(R.id.left_layout);
            right_layout=itemView.findViewById(R.id.right_layout);
            left_msg=itemView.findViewById(R.id.left_msg);
            right_msg=itemView.findViewById(R.id.right_msg);

        }
    }

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sum_activity,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getPosition();
                Msg msg=msgList.get(position);
                Toast.makeText(v.getContext(), "消息时间"+msg.getTime(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=msgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.right_layout.setVisibility(View.GONE);
            holder.left_msg.setText(msg.getContent());
        }
        if (msg.getType()==Msg.TYPE_SEND){
            holder.left_layout.setVisibility(View.GONE);
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.right_msg.setText(msg.getContent());
        }


    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


}
