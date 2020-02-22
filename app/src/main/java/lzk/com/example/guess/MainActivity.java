package lzk.com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int Randomnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gen_rand();
    }
    public void Gen_rand(){
        Randomnumber= new Random().nextInt(1000-1+1)+1;
    }


    public void checknum(View view){
        TextView txtview =findViewById(R.id.texthint);
        EditText inputnum = findViewById(R.id.editnum);
        ImageView btn = findViewById(R.id.checkbtn);
        ImageView no = findViewById(R.id.no);
        ImageView yes = findViewById(R.id.yes);
        ImageView up =findViewById(R.id.up);
        ImageView down=findViewById(R.id.down);

        String strinput;
        strinput = inputnum.getText().toString();
        int num=-1;
        try {
            num = Integer.parseInt(strinput);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if(num>0&&num<1001){
            if (num>Randomnumber){
                txtview.setText("Guessed large! Try again");
            }else if(num<Randomnumber){
                txtview.setText("Guessed small! Try again");
            }else{
                txtview.setText("Guessed Right! Yeah!");
            }

        }else{
            Toast.makeText(MainActivity.this,"Hey, the input is wrong!",Toast.LENGTH_LONG).show();
        }


        }
    }
