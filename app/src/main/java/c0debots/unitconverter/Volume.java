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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 7/26/2016.
 */
public class Volume extends Activity {

    private Spinner input_spinner,output_spinner;
    private TextView length_input,volume_output;
    private Keyboard keyboard;
    private String input,output,in_label,out_label;
    private Double in_value,out_value;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_converter);


        actionBar = getActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#00695C"));

        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#004D40"));
        }





        input_spinner = (Spinner) findViewById(R.id.length_input_spinner);
        output_spinner= (Spinner) findViewById(R.id.lenght_output_spinner);
        length_input = (TextView) findViewById(R.id.length_input);
        volume_output= (TextView) findViewById(R.id.length_output);
        keyboard = new Keyboard();
        input="";
        output="";
        in_value=0.0;
        out_value=0.0;



        List<String> SpinnerArray = new ArrayList<String>();
        SpinnerArray.add("Milliliters");
        SpinnerArray.add("Cubic Centimeters");
        SpinnerArray.add("Liters");
        SpinnerArray.add("Cups");
        SpinnerArray.add("Quarts");
        SpinnerArray.add("Gallons");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, SpinnerArray);
        input_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        input_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                in_label = parent.getItemAtPosition(position).toString();
                convertVolume();

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
                convertVolume();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


}

    public void buttonClicked(View view)
    {
        if(input=="0")
            input="";
        if (view.getId() == R.id.one) {
            if(length_input.length()>10)
                return;
            input = input + "1";
        }
        if(view.getId()==R.id.sing)
            return;
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

        if(length_input.getText().toString()!="") {
            length_input.setText(input);
            in_value = Double.parseDouble(length_input.getText().toString());
        }


        convertVolume();



    }

    private void convertVolume()
    {

        ////////  FOR CONVERSION OF ML TO ELSE \\\\\\\\\\\\\\

        if(in_label=="Milliliters" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  cm3");
        }
        else if(in_label=="Milliliters" && out_label=="Liters")
        {
            out_value = in_value*0.001;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Milliliters" && out_label=="Milliliters")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Milliliters" && out_label=="Cups")
        {
            out_value= in_value*0.00422675;
            volume_output.setText(""+out_value+"  us cpus");
        }
        else if(in_label=="Milliliters" && out_label=="Quarts")
        {
            out_value= in_value*0.00105669;
            volume_output.setText(""+out_value+"  QT");
        }
        else if(in_label=="Milliliters" && out_label=="Gallons")
        {
            out_value= in_value*0.000264172;
            volume_output.setText(""+out_value+"  GL");
        }

        /////// FOR CONVERSION OF CUBIC CENTI TO ELSE \\\\\\\\\\\\\\

        else if(in_label=="Cubic Centimeters" && out_label=="Milliliters")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Cubic Centimeters" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  cm3");
        }
        else if(in_label=="Cubic Centimeters" && out_label=="Liters")
        {
            out_value = in_value*0.001;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Cubic Centimeters" && out_label=="Cups")
        {
            out_value= in_value*0.00422675;
            volume_output.setText(""+out_value+"  us cpus");
        }
        else if(in_label=="Cubic Centimeters" && out_label=="Quarts")
        {
            out_value= in_value*0.00105669;
            volume_output.setText(""+out_value+"  QT");
        }
        else if(in_label=="Cubic Centimeters" && out_label=="Gallons")
        {
            out_value= in_value*0.000264172;
            volume_output.setText(""+out_value+"  GL");
        }

        /////// FOR CONVERTING LITERS TO ELSE \\\\\\\\\\\\\

        else if(in_label=="Liters" && out_label=="Milliliters")
        {
            out_value= in_value*1000;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Liters" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*1000;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Liters" && out_label=="Liters")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Liters" && out_label=="Cups")
        {
            out_value= in_value*4.22675;
            volume_output.setText(""+out_value+"  us cups");
        }
        else if(in_label=="Liters" && out_label=="Quarts")
        {
            out_value= in_value*1.05669;
            volume_output.setText(""+out_value+"  QT");
        }
        else if(in_label=="Liters" && out_label=="Gallons")
        {
            out_value= in_value*0.264172;
            volume_output.setText(""+out_value+"  GL");
        }

        //// FOR CONVERTING CUPS TO ELSE  \\\\\\\\\\\\\\\\\\\
        else if(in_label=="Cups" && out_label=="Milliliters")
        {
            out_value= in_value*236.588;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Cups" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*236.588;
            volume_output.setText(""+out_value+"  cm3");
        }
        else if(in_label=="Cups" && out_label=="Liters")
        {
            out_value= in_value*0.236588;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Cups" && out_label=="Cups")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  us cups");
        }
        else if(in_label=="Cups" && out_label=="Quarts")
        {
            out_value= in_value*0.25;
            volume_output.setText(""+out_value+"  QT");
        }
        else if(in_label=="Cups" && out_label=="Gallons")
        {
            out_value= in_value*0.0625;
            volume_output.setText(""+out_value+"  GL");
        }

        //////// FOR CONVERTING QUARTS TO ELSE \\\\\\\\\\\\\

        else if(in_label=="Quarts" && out_label=="Milliliters")
        {
            out_value= in_value*946.353;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Quarts" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*946.353;
            volume_output.setText(""+out_value+"  cm3");
        }
        else if(in_label=="Quarts" && out_label=="Liters")
        {
            out_value= in_value*0.946353;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Quarts" && out_label=="Cups")
        {
            out_value= in_value*4;
            volume_output.setText(""+out_value+"  us cups");
        }
        else if(in_label=="Quarts" && out_label=="Gallons")
        {
            out_value= in_value*0.25;
            volume_output.setText(""+out_value+"  GL");
        }

        ///////  FOR CONVERTING GALOLONS TO ELSE  \\\\\\\\\\\\
        else if(in_label=="Gallons" && out_label=="Gallons")
        {
            out_value= in_value*1;
            volume_output.setText(""+out_value+"  GL");
        }
        else if(in_label=="Gallons" && out_label=="Milliliters")
        {
            out_value= in_value*3785.41;
            volume_output.setText(""+out_value+"  ml");
        }
        else if(in_label=="Gallons" && out_label=="Liters")
        {
            out_value= in_value*3.78541;
            volume_output.setText(""+out_value+"  L");
        }
        else if(in_label=="Gallons" && out_label=="Cups")
        {
            out_value= in_value*15.7725;
            volume_output.setText(""+out_value+"  us cups");
        }
        else if(in_label=="Gallons" && out_label=="Quarts")
        {
            out_value= in_value*4;
            volume_output.setText(""+out_value+"  QT");
        }
        else if(in_label=="Gallons" && out_label=="Cubic Centimeters")
        {
            out_value= in_value*3785.41;
            volume_output.setText(""+out_value+"  cm3");
        }



    }

}