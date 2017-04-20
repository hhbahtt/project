package com.tripotreat.tripotreat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class HomeActivity extends Activity {

    private ImageSwitcher simpleImageSwitcher1,simpleImageSwitcher2;
    Button btnNext,btnNext1;


    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView btn=(ImageView)findViewById(R.id.imageView);

// get The references of Button and ImageSwitcher
        btnNext = (Button) findViewById(R.id.button3 );
        btnNext1 = (Button) findViewById(R.id.button4 );
        simpleImageSwitcher1 = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher1);
        simpleImageSwitcher2 = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher2);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        simpleImageSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        simpleImageSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        simpleImageSwitcher2.setInAnimation(in);
        simpleImageSwitcher2.setOutAnimation(out);
        simpleImageSwitcher1.setInAnimation(in);
        simpleImageSwitcher1.setOutAnimation(out);


        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                simpleImageSwitcher1.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                simpleImageSwitcher2.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                Intent intent=new Intent(HomeActivity.this,LoadingActivity.class);
                startActivity(intent);
            }
        });

    }

}
