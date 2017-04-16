package com.tripotreat.tripotreat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ProgressBar bar=(ProgressBar)findViewById(R.id.progress);
        NewThread obj=new NewThread(bar);
        obj.start();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyProgressBar extends ProgressBar
    {
        public MyProgressBar(Context context) {
            super(context);
        }

        @Override
        public void setProgress(int progress)
        {
            super.setProgress(progress);
            if(progress == this.getMax())
            {
                //Do stuff when progress is max
                Intent intent  = new Intent(LoadingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }
}

class NewThread extends Thread
{
    ProgressBar bar;
    public NewThread(ProgressBar bar)

    {
        this.bar=bar;
    }
    @Override
    public void run()
    {
        for(int i=0;i<=100;i++)
        {
            bar.setProgress(i);
            try
            {
                Thread.sleep(40);
            }catch(InterruptedException ex){}
        }

    }

}
