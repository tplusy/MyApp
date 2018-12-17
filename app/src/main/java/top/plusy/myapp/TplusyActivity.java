package top.plusy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.plusy.myapp.ui.tplusy.TplusyFragment;

public class TplusyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tplusy_activity);
        Intent intent = getIntent();
        if(intent.hasExtra(TplusyAction.FLAGS)) {
            int flags = intent.getIntExtra(TplusyAction.FLAGS, 0);
            if(flags == TplusyAction.FLAG_ANIMATOR) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, TplusyFragment.newInstance())
                        .commitNow();
            }
        }
        else {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, TplusyFragment.newInstance())
                        .commitNow();
            }
        }
    }
}
