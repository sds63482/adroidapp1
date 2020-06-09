package com.example.myapplication;

import com.example.myapplication.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.*;
import java.net.Socket;

public class ccreader implements Runnable//只能比cc先連上server不知為啥,程式碼根cc一樣 只不過會動到主程式座標變動
{
    @Override
    public void run() {
        //-------客戶端連線-----
        Socket s = null;
        String buffer=null;
        try {
            System.out.println("guesser ready to connect to server ........................");

            s=new Socket("192.168.0.183",4629);//模擬器要用10.0.2.2代替127.0.0.1,若是模擬器連模擬器舊社127.0.0.1 手機行動網路無法當伺服器但pc可以當伺服器 適用wifi橋接
            PrintWriter writergo = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            writergo.println("ggininder");

            writergo.flush();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(reader2.readLine());

           // while(MainActivity.abnormal){}//若不正常啟動先client 在猜的人%%%
           // BufferedReader reader3 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writergo.println("s");//[[[[[[[[[[[[[[[
            writergo.flush();//client後街上[[[[[[[[[[[[[[[[[[
            //while(){等待...if(連上房間)break;}
            System.out.println("readerstart");
            while(true){
                ///訊息///訊息傳送

                /*PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                for(int i=0;i<12;i++){
                    writergo.println(MainActivity.ax[i]);//////////////////////這是原本的--------------------------------writer
                    writergo.flush();}*/



                //PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                //writer.println("安安");

                //writer.write(""+MainActivity.a);
                // writer.println("::"+MainActivity.a2+"::"+MainActivity.b2+"::"+MainActivity.c2+"::"+MainActivity.d2);
                //writer.println("::"+MainActivity.a3+"::"+MainActivity.b3+"::"+MainActivity.c3+"::"+MainActivity.d3);

                //writer.close();//要加，會變很快 加了reader會出錯


               // BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                for(int i=0;i<6;i++){
                    System.out.println("SSSSSSS");
                    buffer=reader2.readLine();
                    if (buffer!=null&&buffer!="s"){if(buffer!="")MainActivity.ax[i]=Integer.parseInt(buffer);}

                    System.out.println("收到:"+MainActivity.ax[i]);



                }
                //BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
               //reader2.readLine();//[[[[[[[[[[[[[[[[


               //緩衝使之順序為傳送收到傳送收到[[[[[[[[[[[[[[[[[
                //logcat會印出錯誤不知為何*//////

            }

        } catch (IOException e) {
            e.printStackTrace();
        }//androidmanifest必須先加入這一行<uses-permission android:name= "android.permission.INTERNET"/> 給他權限連線





    }
}
