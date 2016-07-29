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
public class Temperature extends Activity {


    private Keyboard keyboard;
    private String input, output,cel,fern,kel;
    private double in_value, out_value;
    private Spinner input_spinner, output_spinner;
    private TextView length_input, length_output;
    private ActionBar actionBar;
    private String out_label, in_label;
    DecimalFormat df;
    List<String> SpinnerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_layout);


        actionBar = getActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#00695C"));

        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#004D40"));
        }


        cel="Celsius";
        fern="Fahrenheit";
        kel="Kelvin";

        SpinnerArray = new ArrayList<String>();
        SpinnerArray.add("Celsius");
        SpinnerArray.add("Fahrenheit");
        SpinnerArray.add("Kelvin");


        in_value = 0.0;
        out_value = 0.0;
        keyboard = new Keyboard();
        input = "";
        input_spinner = (Spinner) findViewById(R.id.length_input_spinner);
        output_spinner = (Spinner) findViewById(R.id.lenght_output_spinner);

        length_input = (TextView) findViewById(R.id.length_input);
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
                convertTemp();
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
                convertTemp();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }


    public void weightClicked(View view) {
        if (input == "0")
            input = "";
        if (view.getId() == R.id.one) {
            if (length_input.length() > 10)
                return;
            input = input + "1";
        }
        if (view.getId() == R.id.decimal) {
            if (length_input.length() > 10)
                return;
            if (input.equals(""))
                return;
            input = input + ".";
        }
        if (view.getId() == R.id.invert) {
            if (input.equals(""))
                return;
            String temp = in_label;
            in_label = out_label;
            out_label = temp;

        }

        if (view.getId() == R.id.two) {
            if (length_input.length() > 10)
                return;
            input = input + "2";
        }
        if (view.getId() == R.id.three) {
            if (length_input.length() > 10)
                return;
            input = input + "3";
        }
        if (view.getId() == R.id.four) {
            if (length_input.length() > 10)
                return;
            input = input + "4";
        }
        if (view.getId() == R.id.five) {
            if (length_input.length() > 10)
                return;
            input = input + "5";
        }
        if (view.getId() == R.id.six) {
            if (length_input.length() > 10)
                return;
            input = input + "6";
        }
        if (view.getId() == R.id.seven) {
            if (length_input.length() > 10)
                return;
            input = input + "7";
        }
        if (view.getId() == R.id.eight) {
            if (length_input.length() > 10)
                return;
            input = input + "8";
        }
        if (view.getId() == R.id.nine) {
            if (length_input.length() > 10)
                return;
            input = input + "9";
        }
        if (view.getId() == R.id.zero) {
            if (length_input.length() > 10)
                return;
            input = input + "0";
        }
        if (view.getId() == R.id.erase) {
            if (length_input.length() == 1)
                input = "0";
            if (input != null && input.length() > 1)
                input = input.substring(0, input.length() - 1);
        }
        if (view.getId() == R.id.sing)
            return;


        if (length_input.getText().toString() != "") {
            length_input.setText(input);
            in_value = Double.parseDouble(length_input.getText().toString());
        }

        convertTemp();


    }

    private void convertTemp() {


        // for converting cel to others  ////

        if(in_label==cel && out_label== cel)
        {
            double mul = 1;
            out_value=in_value*mul;
            length_output.setText(""+out_value+" C");
        }
        else if (in_label==cel && out_label==fern)
        {
            double mul = 1.8;
            out_value=(in_value*mul) + 32;
            length_output.setText(""+out_value+" F");
        }
        else if (in_label==cel && out_label==kel)
        {
            double mul = 1;
            out_value=(in_value*mul) + 273.15;
            length_output.setText(""+out_value+" K");
        }

        //  for converting fernhite to others  ///


        else if (in_label==fern && out_label==fern)
        {
            double mul = 1;
            out_value=in_value*mul;
            length_output.setText(""+out_value+" F");
        }
        else if (in_label==fern && out_label==cel)
        {
            double mul = 0.5556;
            out_value=(in_value-32)*mul;
            length_output.setText(""+out_value+" C");
        }
        else if (in_label==fern && out_label==kel)
        {
            double mul = 0.5559;
            out_value=(in_value+459.67)*mul;
            length_output.setText(""+out_value+" K");
        }

        // for converting kelvin to else  ///

        else if (in_label==kel && out_label==kel)
        {
            double mul = 1;
            out_value=(in_value*mul);
            length_output.setText(""+out_value+" K");
        }
        else if (in_label==kel && out_label==cel)
        {
            double mul = 1;
            out_value=(in_value*mul) - 273.15;
            length_output.setText(""+out_value+" C");
        }
        else
        {
            double mul = 1.8;
            out_value=(in_value*mul) - 459.67;
            length_output.setText(""+out_value+" F");
        }

    }

}
