package top.plusy.myapp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import top.plusy.myapp.adapter.MyAdapter;
import top.plusy.myapp.adapter.MyData;
import top.plusy.myapp.adapter.SimpleAdapter;
import top.plusy.myapp.adapter.SimpleData;
import top.plusy.myapp.adapter.onItemClickListener;
import top.plusy.myapp.animation.MyAnimation;

public class AnimatorActivity extends AppCompatActivity implements onItemClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private SimpleData<MyData> simpleData = new SimpleData<>(1);
    private MyAdapter myAdapter = new MyAdapter(simpleData);
    private SimpleAdapter simpleAdapter = new SimpleAdapter();

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        addAllData();
        simpleAdapter.setOnItemClickListener(this);
        myAdapter.addDelegateAdapter(simpleAdapter);
        recyclerView.setAdapter(myAdapter);

        textView = findViewById(R.id.text);
        textView.setOnClickListener(this);
    }

    private void addAllData(){
        String[] animations = getResources().getStringArray(R.array.animations);
        for(String title : animations) {
            simpleData.dataList.add(new MyData(title));
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        switch (position){
            case 0:
            {
                MyAnimation.startColorGradientAnimation(textView, 0xffffff00, 0xff0000ff);
                MyAnimation.startTranslater(textView);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.test);
        animatorSet.setTarget(v);
        animatorSet.start();
        MyAnimation.startColorGradientAnimation(textView, 0xffffff00, 0xff00ffff);
        Random random = new Random();
        if(random.nextInt() %2 == 0) {
            MyAnimation.startTranslater(v);
        } else {
            MyAnimation.startTranslater2(v);
        }
        MyAnimation.startRotate(textView);
    }
}
