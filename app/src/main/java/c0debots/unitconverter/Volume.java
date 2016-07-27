package c0debots.unitconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
    private TextView volume_input,volume_output;
    private Keyboard keyboard;
    private String input,output,in_label,out_label;
    private Double in_value,out_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_converter);




        input_spinner = (Spinner) findViewById(R.id.length_input_spinner);
        output_spinner= (Spinner) findViewById(R.id.lenght_output_spinner);
        volume_input = (TextView) findViewById(R.id.length_input);
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
        if(view.getId()==R.id.one)
        {
            input=input+"1";
        }
        if(view.getId()==R.id.two)
        {
            input=input+"2";
        }
        if(view.getId()==R.id.three)
        {
            input=input+"3";
        }
        if(view.getId()==R.id.four)
        {
            input=input+"4";
        }
        if(view.getId()==R.id.five)
        {
            input=input+"5";
        }
        if(view.getId()==R.id.six)
        {
            input=input+"6";
        }
        if(view.getId()==R.id.seven)
        {
            input=input+"7";
        }
        if(view.getId()==R.id.eight)
        {
            input=input+"8";
        }
        if(view.getId()==R.id.nine)
        {
            input=input+"9";
        }
        if(view.getId()==R.id.zero)
        {
            input=input+"0";
        }
        if(view.getId()==R.id.erase)
        {
            if(input!=null && input.length()>0)
            input = input.substring(0,input.length()-1);
        }

        volume_input.setText(input);
        in_value = Double.parseDouble(input);


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