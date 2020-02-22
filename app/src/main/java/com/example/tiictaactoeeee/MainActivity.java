package com.example.tiictaactoeeee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1=zero 2=cross
    int player = 1;
    int gameState[] ={0,0,0,0,0,0,0,0,0};
    int [][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    Boolean active = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tapped(View v){

        ImageView img =(ImageView) v;
        String tag_value =img.getTag().toString();
        if (active && gameState[Integer.parseInt(tag_value)]==0) {
            gameState[Integer.parseInt(tag_value)] = player;
            Log.i("pressed", tag_value + "selected by player" + player);
            img.setTranslationY(-1500);
            if (player == 1) {
                img.setImageResource(R.drawable.zero);
                img.animate().translationYBy(1500).rotation(0 * 10).setDuration(500);
                player = 2;
            } else {
                img.setImageResource(R.drawable.cross);
               img.animate().translationYBy(1500).rotation(0 * 10).setDuration(500);
                player = 1;
            }
            for (int[] winningPosition : winningPosition) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 0) {

                    active = false;
                    String winner = "";
                    if (player == 1) {
                        winner = "played 2";

                    } else {
                        winner = "played 1";

                    }


                    //someone won
                    //Toast.makeText(this, winner + " won", Toast.LENGTH_SHORT).show();
                    TextView winnerNotification = (TextView) findViewById(R.id.winnerNameText);
                    winnerNotification.setVisibility(View.VISIBLE);
                    Button playAgainbutton = (Button) findViewById(R.id.playAgainbutton);

                    winnerNotification.setText(winner + " won");


                    playAgainbutton.setVisibility(View.VISIBLE);


                    playAgainbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playAgain(v);
                        }
                    });
                }

            }

                boolean check_not_zero = true;
                for (int i = 0; i < gameState.length; i++) {
                    if (gameState[i] == 0) {
                        check_not_zero = false;
                    }

                }

                if (check_not_zero) {

                    TextView winnerNotification = (TextView) findViewById(R.id.winnerNameText);
                    winnerNotification.setVisibility(View.VISIBLE);
                    Button playAgainbutton = (Button) findViewById(R.id.playAgainbutton);
                    winnerNotification.setText("Tie");
                    playAgainbutton.setVisibility(View.VISIBLE);
                    playAgainbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            playAgain(v);
                        }
                    });


            }
        }
    }
    public void playAgain(View v){

        Button playAgainbutton = (Button) findViewById(R.id.playAgainbutton);
        TextView winnerNotification = (TextView) findViewById(R.id.winnerNameText);

        //winnerNotification.setText(winner + " won");
        playAgainbutton.setVisibility(View.INVISIBLE);
        winnerNotification.setVisibility(View.INVISIBLE);




               //removing image
               ImageView imageView1 =findViewById(R.id.imageView1);
               ImageView imageView2=findViewById(R.id.imageView2);
               ImageView imageView3 =findViewById(R.id.imageView3);
               ImageView imageView4 =findViewById(R.id.imageView4);
               ImageView imageView5 =findViewById(R.id.imageView5);
               ImageView imageView6 =findViewById(R.id.imageView6);
               ImageView imageView7 =findViewById(R.id.imageView7);
               ImageView imageView8 =findViewById(R.id.imageView8);
               ImageView imageView9 =findViewById(R.id.imageView9);





               imageView1.setImageDrawable(null);
               imageView2.setImageDrawable(null);
               imageView3.setImageDrawable(null);
               imageView4.setImageDrawable(null);
               imageView5.setImageDrawable(null);
               imageView6.setImageDrawable(null);
               imageView7.setImageDrawable(null);
               imageView8.setImageDrawable(null);
               imageView9.setImageDrawable(null);

               player = 1;
               for(int i=0 ; i<gameState.length;i++){
                   gameState[i] = 0;
               }

               active = true;


           }

}
