package c0debots.unitconverter;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 7/29/2016.
 */
public class Weight extends Activity {

    private Keyboard keyboard;
    private String input,output;
    private  double in_value,out_value;
    private Spinner input_spinner,output_spinner;
    private TextView length_input,length_output;
    private ActionBar actionBar;
    DecimalFormat df;
    List<String> SpinnerArray;
    private String mili,kilo,gram,pound,ton,in_label,out_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_layout);

        actionBar = getActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#00695C"));

        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#004D40"));
        }

        mili = "Milligrams";
        kilo="Kilograms";
        pound= "Pounds";
        gram="Grams";
        ton="Tons";

        SpinnerArray = new ArrayList<String>();
        SpinnerArray.add("Milligrams");
        SpinnerArray.add("Grams");
        SpinnerArray.add("Kilograms");
        SpinnerArray.add("Pounds");
        SpinnerArray.add("Tons");


        in_value=0.0;
        out_value=0.0;
        keyboard= new Keyboard();
        input="";
        input_spinner = (Spinner) findViewById(R.id.length_input_spinner);
        output_spinner= (Spinner) findViewById(R.id.lenght_output_spinner);

        length_input= (TextView) findViewById(R.id.length_input);
        length_input.setSelected(true);
        length_output = (TextView) findViewById(R.id.length_output);
        length_output.setSelected(true);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, SpinnerArray);
        input_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        input_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                in_label = parent.getItemAtPosition(position).toString();
                convertWeight();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



        output_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        output_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                out_label = parent.getItemAtPosition(position).toString();
                convertWeight();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



    }


    public void buttonClicked(View view) {
        if(input=="0")
            input="";
        if (view.getId() == R.id.one) {
            if(length_input.length()>10)
                return;
            input = input + "1";
        }
        if(view.getId()==R.id.decimal)
        {
            if(length_input.length()>10)
                return;
            if(input.equals(""))
                return;
            input = input + ".";
        }
        if(view.getId()==R.id.invert)
        {
            if(input.equals(""))
                return;
            String temp = in_label;
            in_label=out_label;
            out_label=temp;

        }

        if (view.getId() == R.id.two) {
            if(length_input.length()>10)
                return;
            input = input + "2";
        }
        if (view.getId() == R.id.three) {
            if(length_input.length()>10)
                return;
            input = input + "3";
        }
        if (view.getId() == R.id.four) {
            if(length_input.length()>10)
                return;
            input = input + "4";
        }
        if (view.getId() == R.id.five) {
            if(length_input.length()>10)
                return;
            input = input + "5";
        }
        if (view.getId() == R.id.six) {
            if(length_input.length()>10)
                return;
            input = input + "6";
        }
        if (view.getId() == R.id.seven) {
            if(length_input.length()>10)
                return;
            input = input + "7";
        }
        if (view.getId() == R.id.eight) {
            if(length_input.length()>10)
                return;
            input = input + "8";
        }
        if (view.getId() == R.id.nine) {
            if(length_input.length()>10)
                return;
            input = input + "9";
        }
        if (view.getId() == R.id.zero) {
            if(length_input.length()>10)
                return;
            input = input + "0";
        }
        if (view.getId() == R.id.erase) {
            if(length_input.length()==1)
                input="0";
            if (input != null && input.length() > 1)
                input = input.substring(0, input.length() - 1);
        }
        if(view.getId()==R.id.sing)
            return;


        if(length_input.getText().toString()!="") {
            length_input.setText(input);
            in_value = Double.parseDouble(length_input.getText().toString());
        }

        convertWeight();
    }

    private void convertWeight()
    {
        // for converting grams to others  ///////

        if(in_label==gram && out_label==gram)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+" g");
        }
        else if(in_label==gram && out_label==mili)
        {
            out_value=in_value*1000;
            length_output.setText(""+out_value+" mg");
        }
        else if(in_label==gram && out_label==kilo)
        {
            out_value=in_value*0.001;
            length_output.setText(""+out_value+" kg");
        }
        else if(in_label==gram && out_label==pound)
        {
            out_value=in_value*0.0022;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==gram && out_label==ton)
        {
            out_value=in_value*0.0000001;
            length_output.setText(""+out_value+" T");
        }

        // for converting milligrams to else  ///////

        else if(in_label==mili && out_label==mili)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+" mg");
        }
        else if(in_label==mili && out_label==gram)
        {
            out_value=in_value*0.001;
            length_output.setText(""+out_value+" g");
        }
        else if(in_label==mili && out_label==kilo)
        {
            out_value=in_value*0.000001;
            length_output.setText(""+out_value+" kg");
        }
        else if(in_label==mili && out_label==pound)
        {
            out_value=in_value*0.000002;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==mili && out_label==ton)
        {
            out_value=in_value*0.0000000012;
            length_output.setText(""+out_value+" T");
        }


        // for converting kilograms to else  ////

        else if(in_label==kilo && out_label==mili)
        {
            out_value=in_value*0.000001;
            length_output.setText(""+out_value+" mg");
        }
        else if(in_label==kilo && out_label==gram)
        {
            out_value=in_value*0.001;
            length_output.setText(""+out_value+" g");
        }
        else if(in_label==kilo && out_label==kilo)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+" kg");
        }
        else if(in_label==kilo && out_label==pound)
        {
            out_value=in_value*2.20;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==kilo && out_label==ton)
        {
            out_value=in_value*0.00098;
            length_output.setText(""+out_value+" T");
        }

        // for converting pounds to else   //////

        else if(in_label==pound && out_label==gram)
        {
            out_value=in_value*453;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==pound && out_label==mili)
        {
            out_value=in_value*453592;
            length_output.setText(""+out_value+" mg");
        }
        else if(in_label==pound && out_label==kilo)
        {
            out_value=in_value*0.455;
            length_output.setText(""+out_value+" kg");
        }
        else if(in_label==pound && out_label==pound)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==pound && out_label==ton)
        {
            out_value=in_value*0.00046;
            length_output.setText(""+out_value+" mg");
        }

        // for converting tons to others   //////

        else if(in_label==ton && out_label==mili)
        {
            out_value=in_value*1016046909;
            length_output.setText(""+out_value+" mg");
        }
        else if(in_label==ton && out_label==gram)
        {
            out_value=in_value*1016047;
            length_output.setText(""+out_value+" g");
        }
        else if(in_label==ton && out_label==kilo)
        {
            out_value=in_value*1016.5;
            length_output.setText(""+out_value+" kg");
        }
        else if(in_label==ton && out_label==pound)
        {
            out_value=in_value*2240;
            length_output.setText(""+out_value+" lb");
        }
        else if(in_label==ton && out_label==ton)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+" T");
        }






    }


}
