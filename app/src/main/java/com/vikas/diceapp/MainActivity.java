package com.vikas.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
      private ImageView diceleft,diceright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.RollButton);
        //two dice  initialization
        diceleft=findViewById(R.id.diceLeft);
        diceright=findViewById(R.id.diceRight);
        //with help of array to store diceImage reference
        int diceRandom[]={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        //mediaplayer implemenation
        MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);
         // this method is use to if u click on button do changes
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Random random=new Random();
              final   int myRandomNumLeft=random.nextInt(6);
               final int myRandomNumRight=random.nextInt(6);
                diceleft.setImageResource(diceRandom[myRandomNumLeft]);
                diceright.setImageResource(diceRandom[myRandomNumRight]);
                // left dice Shank function
                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(diceleft);
                // right dice Shank function
                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(diceright);

                //mediaPlayer start
                mp.start();

            }
        });
    }

}