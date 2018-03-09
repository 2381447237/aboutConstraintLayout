package com.youli.myconstraintlayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv;
    private CommonAdapter adapter;
    private List<Content> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        lv=findViewById(R.id.lv);

        for(int i=0;i<100;i++){

            data.add(new Content("第"+i+"个"));

        }

        LvSetAdapter(data);

        ((TextView)findViewById(R.id.tvt)).setText(Calendar.YEAR+"-"+Calendar.MONTH+"-"+Calendar.DATE+"");

    }

    private void LvSetAdapter(List<Content> data){

        if(adapter==null){

            adapter=new CommonAdapter<Content>(this,data,R.layout.item) {
                @Override
                public void convert(CommonViewHolder holder, Content item, int position) {

                    TextView numberTv=holder.getView(R.id.tv);
                    numberTv.setText(item.getTitle());
                }
            };

            lv.setAdapter(adapter);

        }else{

            adapter.notifyDataSetChanged();
        }

    }

}
