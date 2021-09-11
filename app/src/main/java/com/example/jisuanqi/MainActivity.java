package com.example.jisuanqi;

import static java.lang.Math.sin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button sin,cos,c,x,ln,lx,jia,gx,njie,zuo,you,jian,xy,one,two,three,chen
            ,four,five,six,chu,jue,seven,eight,ninth,π,e,ling,dian,deng,huans,jin,help,huis;
    EditText result;
    String str="";
    Boolean xyt=false,tui=false;
    int i=0;
    double xt=0,yt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kongjian();
        sin.setOnClickListener(this::onclick);
        cos.setOnClickListener(this::onclick);
        c.setOnClickListener(this::onclick);
        x.setOnClickListener(this::onclick);
        ln.setOnClickListener(this::onclick);
        lx.setOnClickListener(this::onclick);
        jia.setOnClickListener(this::onclick);
        gx.setOnClickListener(this::onclick);
        njie.setOnClickListener(this::onclick);
        zuo.setOnClickListener(this::onclick);
        you.setOnClickListener(this::onclick);
        jian.setOnClickListener(this::onclick);
        xy.setOnClickListener(this::onclick);
        one.setOnClickListener(this::onclick);
        two.setOnClickListener(this::onclick);
        three.setOnClickListener(this::onclick);
        chen.setOnClickListener(this::onclick);
        four.setOnClickListener(this::onclick);
        five.setOnClickListener(this::onclick);
        six.setOnClickListener(this::onclick);
        chu.setOnClickListener(this::onclick);
        jue.setOnClickListener(this::onclick);
        seven.setOnClickListener(this::onclick);
        eight.setOnClickListener(this::onclick);
        ninth.setOnClickListener(this::onclick);
        π.setOnClickListener(this::onclick);
        e.setOnClickListener(this::onclick);
        ling.setOnClickListener(this::onclick);
        dian.setOnClickListener(this::onclick);
        deng.setOnClickListener(this::onclick);

        huis.setOnClickListener(this::onclick);
        jin.setOnClickListener(this::onclick);
        help.setOnClickListener(this::onclick);
        huans.setOnClickListener(this::onclick);
    }



    private void kongjian() {
        sin =findViewById(R.id.btn_sin);
        cos=findViewById(R.id.btn_cos);
        c=findViewById(R.id.btn_c);
        x=findViewById(R.id.btn_x);
        ln=findViewById(R.id.btn_ln);
        lx=findViewById(R.id.btn_1x);
        jia=findViewById(R.id.btn_jia);
        gx=findViewById(R.id.btn_gx);
        njie=findViewById(R.id.btn_njie);
        zuo =findViewById(R.id.btn_zuo);
        you=findViewById(R.id.btn_you);
        jian=findViewById(R.id.btn_jian);
        xy=findViewById(R.id.btn_xy);
        one=findViewById(R.id.btn_one);
        two=findViewById(R.id.btn_two);
        three=findViewById(R.id.btn_three);
        chen=findViewById(R.id.btn_chen);
        four=findViewById(R.id.btn_four);
        five=findViewById(R.id.btn_five);
        six=findViewById(R.id.btn_six);
        chu=findViewById(R.id.btn_chu);
        jue=findViewById(R.id.btn_jue);
        seven=findViewById(R.id.btn_seven);
        eight=findViewById(R.id.btn_eight);
        ninth=findViewById(R.id.btn_ninth);
        π=findViewById(R.id.btn_π);
        e=findViewById(R.id.btn_e);
        ling=findViewById(R.id.btn_ling);
        dian=findViewById(R.id.btn_dian);
        deng=findViewById(R.id.btn_deng);

        result=findViewById(R.id.a_edit);
        huis=findViewById(R.id.btn_hui_lv);
        jin=findViewById(R.id.btn_jin_zhi);
        help=findViewById(R.id.btn_help);
        huans=findViewById(R.id.btn_hu_an);
    }

    public void onclick(View v) {
        switch (v.getId()){
            case R.id.btn_help:
                Toast.makeText(this,"本计算器是由罗国雄制作，有任何疑问可向罗国雄咨询，联系方式18485385358",Toast.LENGTH_LONG).show();
            break;
            case R.id.btn_hui_lv:
                Intent intent1 = new Intent(this,huansuan.class);
                startActivity(intent1);
                break;
            case R.id.btn_hu_an:
                Intent intent3 = new Intent(this,tijilength.class);
                startActivity(intent3);
                break;
            case R.id.btn_jin_zhi:
                Log.v("TAG","进制转换！！");
                Intent intent2 = new Intent(this,jinzhi.class);
                startActivity(intent2);
                break;
            case R.id.btn_c:
                str="";
                result.setText("0");
                break;
            case R.id.btn_x:
                str= tuige(str);
                result.setText(str);
                break;

            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_ninth:
            case R.id.btn_ling:
            case R.id.btn_dian:
                if(str.equals("0")&&str.length()==1&&v.getId()!=R.id.btn_dian){
                    str="";
                }
                gezhi(str);

                    str+=((Button)v).getText();
                result.setText(str);
                if(xyt){
                    xytshu(str,i++);
                    result.setText(str);
                    str="";
                }
                break;
            case R.id.btn_sin:
             //   str=teshu(str,1);
                str+=((Button)v).getText();
                result.setText(str);
                break;
            case R.id.btn_cos:
            //    str=teshu(str,2);
                str+=((Button)v).getText();
                result.setText(str);
                break;
            case R.id.btn_ln:
              //  str=teshu(str,3);
                str+=((Button)v).getText()+" ";
                result.setText(str);
                break;
            case R.id.btn_1x:
                str=teshu(str,4);
                result.setText(str);
                break;
            case R.id.btn_gx:
                str=teshu(str,5);
                result.setText(str);
                break;
            case R.id.btn_xy:
                xyt=true;
                Toast.makeText(this,"x的y次方",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_njie:
                str=teshu(str,6);
                result.setText(str);
                break;
            case R.id.btn_jue:
                str=teshu(str,7);
                result.setText(str);
                break;
            case R.id.btn_π:
                double pi= Math.PI;
                str+=String.valueOf(pi);
                result.setText(str);
                break;
            case R.id.btn_e:
                double e= Math.E;
                str+=String.valueOf(e);
                result.setText(str);
                break;
            case R.id.btn_zuo:
                str+=((Button)v).getText()+" ";
                result.setText(str);
                break;
            case R.id.btn_you:
                str+=" "+((Button)v).getText();
                result.setText(str);
                break;
            case R.id.btn_jia:
            case R.id.btn_jian:
            case R.id.btn_chen:
            case R.id.btn_chu:
                str+=" "+((Button)v).getText()+" ";
                result.setText(str);
                break;
            case R.id.btn_deng:
                if(xyt){
                    result.setText(Math.pow(xt,yt)+"");
                    xyt=false;
                    str="";
                    xt=yt=0;
                    i=0;
                }else{
                    jisuan();}
                break;

        }

    }

    private void gezhi(String tr) {
        boolean pan=true;

        if(tr.length()>2){
            String sr=tr.substring(tr.length()-1,tr.length());
            switch (sr){
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case ".":
                    pan=false;
                    break;
            }
          //  Log.v("TAG","倒数第二个："+sr);
            if(!sr.equals(" ")&&pan){
            str+=" ";}
        }
    }

    private void xytshu(String str ,int i) {
        if (i ==0) {
            xt=Double.valueOf(str) ;
        }else if(i==1){
            yt=Double.valueOf(str) ;
        }
        Log.v("TAG",xt+"");
        Log.v("TAG",yt+"");
    }
    private String teshu(String ts,int j) {
    //    String[] s=ts.split(" ");

        double m=Double.valueOf(ts) ;
        double n = 0,zhuan=m;

        if(j==1||j==2) zhuan=Math.toRadians(m);


        if (j==1){
            n=Math.sin(zhuan);
        } else if (j==2){
            n=Math.cos(zhuan);
        }else if (j==3){
            n=Math.log(zhuan);
        }else if (j==4){
            n=1/zhuan;
        }else if (j==5){
            n=Math.sqrt(zhuan);
        }else if (j==6){
            n++;
            for(double i=zhuan;i>0;i--){
                n*=i;
            }
        }else if (j==7){
            n=Math.abs(zhuan);
            Log.v("TAG",ts+"结果"+n);

        }

        DecimalFormat d=new DecimalFormat("0.000");
        ts=ts.replace(ts,d.format(n));
        if(j==7){
            ts=ts.replace(" ","");
        }
      //  Log.v("TAG",ts.length()+"结果");

        return ts;
    }

    private String tuige(String str) {

        Log.v("TAG","长度："+str.length());
        if(str.length()>1){
            if(str.substring(str.length()-2,str.length()).contains(" ")){
                str=str.substring(0,str.length()-2);
            }
            else{
                str=str.substring(0,str.length()-1);
            }}else{
            str="0";
        }
        // Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return str;
    }

    private void jisuan() {
        String[] a=str.split(" ");
        ArrayList bm=new ArrayList();
        for (int i=0;i<a.length;i++){
            bm.add(a[i]);
        }
        for(int i=0;i<bm.size();i++){
            if(bm.get(i).equals("sin")){
            String    guo= teshu((String) bm.get(i+1),1);
            Log.v("TAG",guo+":"+guo.length());
              bm.set(i,guo.trim());
                bm.remove(i+1);
            }else  if(bm.get(i).equals("cos")){
            String    guo= teshu((String) bm.get(i+1),2);
            Log.v("TAG",guo+":"+guo.length());
              bm.set(i,guo.trim());
                bm.remove(i+1);
            }else  if(bm.get(i).equals("ln")){
            String    guo= teshu((String) bm.get(i+1),3);
            Log.v("TAG",guo+":"+guo.length());
              bm.set(i,guo.trim());
                bm.remove(i+1);
            }
        }

//        for(int i=0;i<bm.size();i++){
//            Log.v("TAG","第"+i+"个："+bm.get(i)+"");
//        }

 //       Log.v("TAG","第个："+bm.size()+"");

//        if(a.length>bm.size()){
//            s
//            for (int i=0;i<bm.size();i++){
//                a[i]= (String) bm.get(i);
//                Log.v("TAG",i+"数组："+a[i]);
//            }
//        }
//
//




        Stack<Double> nums = new Stack();
        Stack<String> symbol=new Stack();
        double num1 = 0;
        double num2 = 0;
        String oper="" ;
        double res = 0;
        //  Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        for (int i=0;i<bm.size();i++) {
            if (issymbol((String) bm.get(i))) {
                if (!symbol.isEmpty()) {
                    if (priority((String) bm.get(i)) <= priority( symbol.peek())&&!symbol.peek().equals("(")) {
                        num1 =  nums.pop();
                        num2 =  nums.pop();
                        oper =  symbol.pop();
                        res = cal(num1, num2, oper);
                                Log.v("TAG","计算过程:num1="+num1+"  num2="+num2+"  res="+res);

                        nums.push(res);
                        if(priority((String) bm.get(i))==0){
                            i--;
                            continue;
                        }else{
                            symbol.push((String) bm.get(i));
                        }
                    } else if (bm.get(i).equals(")")) {
                        symbol.push((String) bm.get(i));
                        if ( bm.get(i).equals( ")")) {
                            String oper1 = (String) symbol.pop();
                            while (true) {
                                //右括号
                                num1 = Double.valueOf(nums.pop());
                                num2 = Double.valueOf(nums.pop());
                                oper = (String) symbol.pop();
                                res = cal(num1, num2, oper);

                                //把运算的结果如数栈
                                nums.push(res);
                                if(symbol.peek().equals("(")){
                                    String oper2= symbol.pop();
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        symbol.push((String) bm.get(i));
                    }
                }else{
                    symbol.push((String) bm.get(i));
                }
            }else{
                double m=Double.valueOf((String) bm.get(i));
                nums.push(m);
            }
        }
        while(true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(symbol.isEmpty()) {
                break;
            }
            num1 = (double) nums.pop();
            num2 = (double)nums.pop();
            oper = (String) symbol.pop();
            res = cal(num1, num2, oper);
            Log.v("TAG","计算过程:num1="+num1+"  "+oper+"  num2="+num2+"  res="+res);

            nums.push(res);//入栈
        }
        double resu=(double)nums.pop();
        Log.v("TAG",resu+"=result");
        symbol.clear();
        nums.clear();
        result.setText(resu+"");

    }

//    private ArrayList shuzu(String[] a, String s) {
//        ArrayList b=new ArrayList();
//        for(int j=0;j<a.length;j++){
//            if(a[j].equals(s)){
//                continue;
//            }else {
//                b.add(a[j]);
//            }
//        }
//        return  b;
//    }

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public int priority(String oper) {
        if(oper.equals("(") || oper.equals(")")) {
            return 2;
        }else if(oper.equals( "*" )|| oper.equals( "/")){
            return 1;
        } else if (oper .equals("-") || oper.equals("+")) {
            return 0;
        } else {
            return -1; // 假定的表达式只有 (),+, - , * , /
        }
    }
    public  boolean issymbol(String s){
        return (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("(")||s.equals(")"));
    }
    public double cal(double num1, double num2, String oper) {
        double res = 0; // res 用于存放计算的结果
        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num2 - num1;// 注意顺序
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}
