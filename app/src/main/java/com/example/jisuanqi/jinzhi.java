package com.example.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class jinzhi extends AppCompatActivity {
    Button c2,x2,zero2,dian2,a,b,c,d,e,f,
            one2,two2,three2,four2,five2,six2,seven2,eight2,ninth2;
    EditText text1,text2;
    Spinner sp1,sp2;
    String st1,st2;
    String str="",str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
        jinzhik();
        c2.setOnClickListener(this::onclick);
        x2.setOnClickListener(this::onclick);
        zero2.setOnClickListener(this::onclick);
        dian2.setOnClickListener(this::onclick);
        one2.setOnClickListener(this::onclick);
        two2.setOnClickListener(this::onclick);
        three2.setOnClickListener(this::onclick);
        four2.setOnClickListener(this::onclick);
        five2.setOnClickListener(this::onclick);
        six2.setOnClickListener(this::onclick);
        seven2.setOnClickListener(this::onclick);
        eight2.setOnClickListener(this::onclick);
        ninth2.setOnClickListener(this::onclick);
        a.setOnClickListener(this::onclick);
        b.setOnClickListener(this::onclick);
        c.setOnClickListener(this::onclick);
        d.setOnClickListener(this::onclick);
        e.setOnClickListener(this::onclick);
        f.setOnClickListener(this::onclick);

        text1.setOnClickListener(this::onclick);
        text2.setOnClickListener(this::onclick);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.jinzhi);
                Toast.makeText(jinzhi.this,"原为："+s[i],Toast.LENGTH_LONG).show();
                st1=s[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[]  s=getResources().getStringArray(R.array.jinzhi);
                Toast.makeText(jinzhi.this,"转为："+s[i],Toast.LENGTH_LONG).show();
                st2=s[i];
                Log.v("TAG","原为："+st1+"\n"+"转为："+st2);
               }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void jinzhik() {
        c2=findViewById(R.id.clear2);
        x2=findViewById(R.id.del2);
        zero2=findViewById(R.id.zero2);
        dian2=findViewById(R.id.dian2);
        a=findViewById(R.id.a);
        b =findViewById(R.id.b);
        c=findViewById(R.id.c);
        d=findViewById(R.id.d);
        e=findViewById(R.id.e);
        f=findViewById(R.id.f);
        one2=findViewById(R.id.one2);
        two2=findViewById(R.id.two2);
        three2=findViewById(R.id.three2);
        four2=findViewById(R.id.four2);
        five2=findViewById(R.id.five2);
        six2=findViewById(R.id.six2);
        seven2=findViewById(R.id.seven2);
        eight2=findViewById(R.id.eight2);
        ninth2=findViewById(R.id.ninth2);

        text1=findViewById(R.id.ed1);
        text2=findViewById(R.id.ed2);
        sp1=findViewById(R.id.sp1);
        sp2=findViewById(R.id.sp2);
    }
    public  void onclick(View v){
        switch (v.getId()){
            case R.id.clear2:
                str="";
                text1.setText("0");
                text2.setText("0");
                break;
            case R.id.del2:
                str= tuige(str);
                text1.setText(str);
                break;
            case R.id.one2:
            case R.id.two2:
            case R.id.three2:
            case R.id.four2:
            case R.id.five2:
            case R.id.six2:
            case R.id.seven2:
            case R.id.eight2:
            case R.id.ninth2:
            case R.id.zero2:
            case R.id.dian2:
            case R.id.a:
            case R.id.b:
            case R.id.c:
            case R.id.d:
            case R.id.e:
            case R.id.f:
                if(str.equals("0")&&str.length()==1&&v.getId()!=R.id.dian2){
                    str="";
                }
                str+=((Button)v).getText();
                text1.setText(str);
               jinzhizhuan(str);
                text2.setText(str2);
                break;

        }



    }

    private void jinzhizhuan(String str) {
        if(!str.contains("a")&&!str.contains("b")&&!str.contains("c")&&!str.contains("d")
                &&!str.contains("e")&&!str.contains("f")){
        int n=Integer.valueOf(str);
        Integer.toHexString(n);
        if(st1.equals(st2)){
            str2=str;
        }else if(st1.equals("十进制")){
            shizhun(n);
        }else{
            qitazhuan(n);
        }}else {
            qitazhuan(0);
        }
    }

    private void qitazhuan( int n) {
       String tong= nzhuanshi();//返回一个十进制字符串
        shizhun(Integer.valueOf(tong));
        Log.v("TAG:",tong);
        Log.v("TAG:",st2);


    }

    private String nzhuanshi() {
        if(st1.equals("二进制")){
            return  ""+ Integer.parseInt(str,2);
        } if(st1.equals("八进制")){
            return  ""+ Integer.parseInt(str,8);
        } else{
            return  ""+ Integer.parseInt(str,16);
        }
    }

    private void shizhun(int n) {
        if(st2.equals("十进制")){
            str2=n+"";
        }
         if(st2.equals("二进制")){
            str2=Integer.toBinaryString(n);
        }else if(st2.equals("八进制")){
            str2=Integer.toOctalString(n);
        }else if(st2.equals("十六进制")){
            str2=Integer.toHexString(n);
        }
    }

    private String tuige(String str) {
        if(str.length()>1){
            if(str.substring(str.length()-1,str.length()).equals(" ")){
                str=str.substring(0,str.length()-2);
            }else{
                str=str.substring(0,str.length()-1);
            }}else{
            str="0";
        }
        // Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return str;
    }
}