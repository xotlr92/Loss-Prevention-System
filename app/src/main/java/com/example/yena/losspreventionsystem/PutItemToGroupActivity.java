package com.example.yena.losspreventionsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PutItemToGroupActivity extends AppCompatActivity {

    private ArrayList<ItemInfo> itemList;
    private Button btCancel, btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_item_to_group);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_information_put_group);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = LPSDAO.getItemInfo(this);
        final InformationAdapter adapter = new InformationAdapter(itemList,InformationAdapter.PUT_GROUP);
        recyclerView.setAdapter(adapter);

        btCancel = (Button)findViewById(R.id.bt_put_to_group_cancel);
        btSave = (Button)findViewById(R.id.bt_put_to_group_save);

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ItemInfo> itemsInGroup = new ArrayList<ItemInfo>();
                for(int i=0;i<itemList.size();i++){
                    if(itemList.get(i).checked){
                        itemsInGroup.add(itemList.get(i));
                    }
                }


                Log.d("PutItemToGroupActivity ", "checked item # "+itemsInGroup.size());
            }
        });
    }
}
