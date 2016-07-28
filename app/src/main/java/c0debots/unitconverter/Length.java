package c0debots.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 7/27/2016.
 */
public class Length extends Activity{

    private Keyboard keyboard;
    private String input,output;
    private  double in_value,out_value;
    private Spinner input_spinner,output_spinner;
    private TextView length_input,length_output;
    DecimalFormat df;
    private String nano,micro,mili,centi,meter,kilo,inch,feet,yard,miles,in_label,out_label;

// test change
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_converter);
        nano="Nanometers";
        micro="Microns";
        mili="Millimeters";
        centi="Centimeters";
        meter="Meters";
        kilo="Kilometers";
        inch="Inches";
        feet="Feet";
        yard="Yards";
        miles="Miles";
        input="";
        output="";
        in_value=0.0;
        out_value=0.0;
        keyboard= new Keyboard();
        in_value=0;
        input_spinner = (Spinner) findViewById(R.id.length_input_spinner);
        output_spinner= (Spinner) findViewById(R.id.lenght_output_spinner);

        length_input= (TextView) findViewById(R.id.length_input);
        length_output = (TextView) findViewById(R.id.length_output);


        List<String> SpinnerArray = new ArrayList<String>();
        SpinnerArray.add(nano);
        SpinnerArray.add(micro);
        SpinnerArray.add(mili);
        SpinnerArray.add(centi);
        SpinnerArray.add(meter);
        SpinnerArray.add(kilo);
        SpinnerArray.add(inch);
        SpinnerArray.add(feet);
        SpinnerArray.add(yard);
        SpinnerArray.add(miles);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, SpinnerArray);
        input_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        input_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                in_label = parent.getItemAtPosition(position).toString();
                convertLength();
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
                convertLength();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }

    public void lengthClciked(View view) {
        if(input=="0")
            input="";
        if (view.getId() == R.id.one) {
            if(length_input.length()>10)
                return;
            input = input + "1";
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

        length_input.setText(input);
        in_value = Double.parseDouble(length_input.getText().toString());

        convertLength();
    }



    private void convertLength()
    {
        // FOR CONVERTING NANO TO OTHERS  \\\\\\\\\\\

        if(in_label==nano && out_label==nano)
        {
            out_value=in_value*1;
            length_output.setText(""+out_value+"  nm");
        }
        else if(in_label==nano && out_label==micro)
        {
            out_value=in_value*0.001;
            length_output.setText(out_value+" um");
        }
        else if(in_label==nano && out_label==mili)
        {
            out_value=in_value*0.000001;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==nano && out_label==centi)
        {
            out_value=in_value*0.0000001;
            length_output.setText(""+out_value+"  cm");
        }
        else if(in_label==nano && out_label==meter)
        {
            double multiplier = 0.000000001;
            out_value=in_value*multiplier;
            length_output.setText(""+out_value+"  m");
        }
        else if(in_label==nano && out_label==kilo)
        {
            double multiplier = 0.0000000001;
            out_value=in_value*multiplier;
            length_output.setText(""+out_value+" km");
        }

        else if(in_label==nano && out_label==inch)
        {
            double x= 0.00000003937008;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==nano && out_label==feet)
        {
            double x=0.0000000328084;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==nano && out_label==yard)
        {
            double x =0.00000000109361;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==nano && out_label==miles)
        {
            double x =0.00000000000062;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }

        // for converting microns to else \\\\\\\\\\\


        else if(in_label==micro && out_label==nano)
        {
            double x = 1000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==micro && out_label==micro)
        {
            out_value=in_value;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==micro && out_label==mili)
        {
            double x = 0.001;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==micro && out_label==centi)
        {
            double x= 0.0001;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==micro && out_label==meter)
        {
            double x = 0.000001;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==micro && out_label==kilo)
        {
            double   x =       0.000000001;
            out_value= in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==micro && out_label==inch)
        {
            double x =         0.000039;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==micro && out_label==feet)
        {
            double x=          0.000003;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==micro && out_label==yard)
        {
            double x=          0.000001;
            out_value= in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==micro && out_label==miles)
        {
            double x =         0.00000000062137;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }

        // for converting millimeters to else ///////////


        else if(in_label==mili && out_label==nano)
        {
            double x =         1000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==mili && out_label==micro)
        {
            double x = 1000;
            out_value= in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==mili && out_label==mili)
        {
            out_value=in_value;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==mili && out_label==centi)
        {
            double x =0.1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==mili && out_label==meter)
        {
            double x= 0.001;
            out_value =in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==mili && out_label==kilo)
        {
            double x =         0.000001;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==mili && out_label==inch)
        {
            double x=          0.03937;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==mili && out_label==feet)
        {
            double x =         0.003281;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==mili && out_label==yard)
        {
            double x=          0.001094;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==mili && out_label==miles)
        {
            double x=          0.00000062137119;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }


        /// for converting centimeters to other  \\\\\\\\\\\\

        else if(in_label==centi && out_label==micro)
        {
            double x =1000;
            out_value= in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==centi && out_label==nano)
        {
            double x = 10000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==centi && out_label==mili)
        {
            double x = 10;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==centi && out_label==centi)
        {
            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==centi && out_label==meter)
        {
            double x = 0.01;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==centi && out_label==kilo)
        {
            double x = 10000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==centi && out_label==inch)
        {
            double x = 0.3837;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==centi && out_label==feet)
        {
            double x = 0.032;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==centi && out_label==yard)
        {
            double x = 0.10;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==centi && out_label==miles)
        {
            double x = 0.000006;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }

        //  for converting meters to else  \\\\\\\\\\\

        else if(in_label==meter && out_label==nano)
        {
            double x = 1000000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==meter && out_label==micro)
        {
            double x = 1000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==meter && out_label==mili)
        {
            double x = 1000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==meter && out_label==centi)
        {
            double x = 100;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==meter && out_label==meter)
        {
            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==meter && out_label==kilo)
        {
            double x = 0.001;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==meter && out_label==inch)
        {
            double x = 39.5;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==meter && out_label==feet)
        {
            double x = 3.30;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==meter && out_label==yard)
        {
            double x = 1.09;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==meter && out_label==miles)
        {
            double x = 0.000621;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }


        // for converting km to else  /////////

        else if(in_label==kilo && out_label==nano)
        {
            String value ="1000000000000";
            double x = Double.parseDouble(value);
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==kilo && out_label==micro)
        {

            double x = 1000000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==kilo && out_label==mili)
        {

            double x = 1000000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==kilo && out_label==centi)
        {

            double x = 100000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==kilo && out_label==meter)
        {

            double x = 1000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==kilo && out_label==kilo)
        {

            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==kilo && out_label==inch)
        {

            double x = 39370;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==kilo && out_label==feet)
        {

            double x = 3280;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==kilo && out_label==miles)
        {

            double x = 0.627;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }
        else if(in_label==kilo && out_label==yard)
        {

            double x = 1093;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }

    /////// for converting inches to else   //////////////

        else if(in_label==inch && out_label==nano)
        {

            double x = 25400000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==inch && out_label==micro)
        {

            double x = 25400;
            out_value=in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==inch && out_label==mili)
        {

            double x = 25.4;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==inch && out_label==centi)
        {

            double x = 2.54;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==inch && out_label==meter)
        {

            double x = 0.0254;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==inch && out_label==kilo)
        {

            double x = 0.000025;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==inch && out_label==inch)
        {

            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==inch && out_label==feet)
        {

            double x =0.0833;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==inch && out_label==yard)
        {

            double x = 0.027;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==inch && out_label==miles)
        {

            double x = 0.000016;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }


        // for converting feets to other  ///////////

        else if(in_label==feet && out_label==nano)
        {

            double x = 304800000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==feet && out_label==micro)
        {

            double x = 304800;
            out_value=in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==feet && out_label==mili)
        {

            double x = 304.8;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==feet && out_label==centi)
        {

            double x = 30.48;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==feet && out_label==meter)
        {

            double x = 0.3048;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==feet && out_label==inch)
        {

            double x = 12;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==feet && out_label==kilo)
        {

            double x = 0.000305;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==feet && out_label==feet)
        {

            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==feet && out_label==yard)
        {

            double x = 0.333;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==feet && out_label==miles)
        {

            double x = 0.000189;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }


        // for converting yards to else  /////////
        else if(in_label==yard && out_label==nano)
        {

            double x = 914400000;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==yard && out_label==micro)
        {

            double x = 914400;
            out_value=in_value*x;
            length_output.setText(""+out_value+" um");
        }
        else if(in_label==yard && out_label==mili)
        {

            double x = 914.4;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==yard && out_label==centi)
        {

            double x = 91.4;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==yard && out_label==meter)
        {

            double x = 0.914;
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if(in_label==yard && out_label==kilo)
        {

            double x = 0.000914;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==yard && out_label==inch)
        {

            double x = 36;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==yard && out_label==feet)
        {

            double x = 3;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==yard && out_label==yard)
        {

            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==yard && out_label==miles)
        {

            double x = 0.000568;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }


        /// for converting miles to else  ////////////

        else if(in_label==miles && out_label==nano)
        {
            String value = "1609344000000";
            double x= Double.parseDouble(value);
            out_value=in_value*x;
            length_output.setText(""+out_value+" nm");
        }
        else if (in_label == miles && out_label == micro) {
                String val = "160934400";
                double x = Double.parseDouble(val);
                out_value = in_value * x;
                length_output.setText("" + out_value + " um");
            }
        else if(in_label==miles && out_label==mili)
        {

            double x = 1609344;
            out_value=in_value*x;
            length_output.setText(""+out_value+" mm");
        }
        else if(in_label==miles && out_label==centi)
        {

            double x = 160934.4;
            out_value=in_value*x;
            length_output.setText(""+out_value+" cm");
        }
        else if(in_label==miles && out_label==meter)
        {

            double x = 1609.344;
            out_value=in_value*x;
            length_output.setText(""+out_value+" m");
        }
        else if(in_label==miles && out_label==kilo)
        {

            double x = 1.609;
            out_value=in_value*x;
            length_output.setText(""+out_value+" km");
        }
        else if(in_label==miles && out_label==inch)
        {

            double x = 63360;
            out_value=in_value*x;
            length_output.setText(""+out_value+" in");
        }
        else if(in_label==miles && out_label==feet)
        {

            double x = 5280;
            out_value=in_value*x;
            length_output.setText(""+out_value+" ft");
        }
        else if(in_label==miles && out_label==yard)
        {

            double x = 1760;
            out_value=in_value*x;
            length_output.setText(""+out_value+" yd");
        }
        else if(in_label==miles && out_label==miles)
        {

            double x = 1;
            out_value=in_value*x;
            length_output.setText(""+out_value+" M");
        }




    }

}
