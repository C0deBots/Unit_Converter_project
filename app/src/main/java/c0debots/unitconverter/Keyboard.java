package c0debots.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Developer on 7/26/2016.
 */
public class Keyboard extends Activity{

    public Button one,two,three,four,five,six,seven,eight,nine,ten,decimal,sing,zero;
    public ImageButton invert,erase,calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intializeKeyboard();
    }

    public void intializeKeyboard()
    {
        one= (Button) findViewById(R.id.one);
        two= (Button) findViewById(R.id.two);
        three= (Button) findViewById(R.id.three);
        four= (Button) findViewById(R.id.four);
        five= (Button) findViewById(R.id.five);
        six= (Button) findViewById(R.id.six);
        seven= (Button) findViewById(R.id.seven);
        eight= (Button) findViewById(R.id.eight);
        nine= (Button) findViewById(R.id.nine);
        zero= (Button) findViewById(R.id.zero);
        decimal= (Button) findViewById(R.id.decimal);

        calculator= (ImageButton) findViewById(R.id.calculator);
        invert= (ImageButton) findViewById(R.id.invert);
        erase= (ImageButton) findViewById(R.id.erase);

    }


}
