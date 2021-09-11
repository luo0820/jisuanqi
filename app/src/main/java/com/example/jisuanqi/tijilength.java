package com.example.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class tijilength extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Spinner s1,s2,s3,s4;
    String string1,string2,string3,string4;
    String str1="",str2="",str3="",str4="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tijilength);

        tijikjian();
        spinner();



       e1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
                    str1=editable.toString();
                    Log.v("TAG",str1);
                    if(str1.equals("")){
                        Toast.makeText(tijilength.this,"请输入",Toast.LENGTH_LONG).show();
                    }else{
                    lengthhuan();
           }
           }
       });
            e3.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
                    str3=editable.toString();
                    Log.v("TAG",str3);
                    if(str3.equals("")){
                        Toast.makeText(tijilength.this,"请输入",Toast.LENGTH_LONG).show();
                    }else{
                    tijihuan();
           }
           }
       });




    }

    private void tijihuan() {
        double n=Double.valueOf(str3);
        if(string3.equals(string4)){
            str4=str3;
        }else if(string3.equals("立方厘米 cm³")){
            tlizhuan(n);
        }else{
            qitatizhuan(n);
        }
        e4.setText(str4);

    }

    private void qitatizhuan(double n) {
        double x=qitzhuanli(n);
        tlizhuan(x);
    }

    private double qitzhuanli(double n) {
        double m=0;
        switch (string3){
            case "立方米 m³":
                m=n*1000000;
                break;
            case "立方分米 dm³":
            case "升 l":
                m=n*1000;
                break;
            case "立方厘米 cm³":
            case "毫升 ml":
                m=n;
                break;
            case "立方毫米 mm³":
                m=n*0.001;
                break;
            case "分升 dl":
                m=n*100;
                break;
            case "厘升 cl":
                m=n*10;
                break;
            default:
        }
        return m;

    }

    private void tlizhuan(double n) {
        double m = 0;
        switch (string4){
            case "立方米 m³":
                m=n*0.000001;
                break;
            case "立方分米 dm³":
            case "升 l":
                m=n*0.001;
                break;
            case "立方厘米 cm³":
            case "毫升 ml":
                m=n;
                break;
            case "立方毫米 mm³":
                m=n*1000;
                break;
            case "分升 dl":
                m=n*0.01;
                break;
            case "厘升 cl":
                m=n*0.1;
                break;
            default:
        }
        str4=m+"";
    }


    private void spinner() {
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.length);
        //        Toast.makeText(tijilength.this,"原为："+s[i],Toast.LENGTH_LONG).show();
                string1=s[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.length);
             //   Toast.makeText(tijilength.this,"原为："+s[i],Toast.LENGTH_LONG).show();
                string2=s[i];
                Toast.makeText(tijilength.this,"原为："+string1+"\n"+"转为："+string2,Toast.LENGTH_LONG).show();
                Log.v("TAG","原为："+string1+"\n"+"转为："+string2);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.tiji);
        //        Toast.makeText(tijilength.this,"原为："+s[i],Toast.LENGTH_LONG).show();
                string3=s[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.tiji);
             //   Toast.makeText(tijilength.this,"原为："+s[i],Toast.LENGTH_LONG).show();
                string4=s[i];
                Toast.makeText(tijilength.this,"原为："+string3+"\n"+"转为："+string4,Toast.LENGTH_LONG).show();
                Log.v("TAG","原为："+string3+"\n"+"转为："+string4);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void lengthhuan() {
        double n=Double.valueOf(str1);
        if(string1.equals(string2)){
            str2=str1;
        }else if(string1.equals("毫米 mm")){
            haozhuan(n);
        }else{
            qitazhuan(n);
        }
        e2.setText(str2);

    }

    private void qitazhuan(double n) {
       double  x= nzhunahao(n);//返回毫米
        haozhuan(x);
    }

    private double nzhunahao(double n) {
        double m = 0;
        switch (string1){
            case "千米 km":
                m= n*1000000;
                break;
            case "米 m":
                m=n*1000;
                break;
            case "分米 dm":
               m= n*100;
                break;
            case "厘米 cm":
              m=n*10;
                break;
            case "微米 um":
               m=n*0.001;
                break;
            case "纳米 nm":
              m=n*0.000001;
                break;
            case "皮米 pm":
               m=n*0.000000001;
                break;
            default:
        }
        return  m;

    }

    private void haozhuan(double n) {
        double m;
        switch (string2){
            case "千米 km":
                m=n*0.000001;
                break;
            case "米 m":
                m=n*0.001;
                break;
            case "分米 dm":
                m=n*0.01;
                break;
            case "厘米 cm":
                m=n*0.1;
                break;
            case "毫米 mm":
                m=n;
                break;
            case "微米 um":
                m=n*1000;
                break;
            case "纳米 nm":
                m=n*1000000;
                break;
            case "皮米 pm":
                m=n*1000000000;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + string2);
        }
        str2=m+"";

    }



    private void tijikjian() {
    e1=findViewById(R.id.edit1);
    e2=findViewById(R.id.edit2);
    e3=findViewById(R.id.edit3);
    e4=findViewById(R.id.edit4);

    s1=findViewById(R.id.spinner1);
    s2=findViewById(R.id.spinner2);
    s3=findViewById(R.id.spinner3);
    s4=findViewById(R.id.spinner4);
    }
}