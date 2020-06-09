package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class cc implements Runnable{
    //public int[] axis;//為了城市運行而已不重要
    public void run() {

        //-------客戶端連線-----
        Socket s = null;
        String buffer=null;
        try {
            //連線傳房名----------下
            System.out.println("ready to connect to server ........................");

            s=new Socket("192.168.2.1",4629);//模擬器要用10.0.2.2代替127.0.0.1,若是模擬器連模擬器舊社127.0.0.1 手機行動網路無法當伺服器但pc可以當伺服器 適用wifi橋接
            PrintWriter writerg = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            writerg.println("ggininder");

            writerg.flush();
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(reader3.readLine());
            //連線傳房名-------------上

            //MainActivity.abnormal=false;%%%
            //PrintWriter writer3 = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            writerg.println("s");//[[[[[[[[[[[[[[[
            writerg.flush();//等別人之後再跑
            //System.out.println("ccstart");

           while(true){
                ///訊息///訊息傳送
                //axis=new int[6];

                //PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

              for(int i=0;i<6;i++){
                writerg.println(MainActivity.ax[i]);
               writerg.flush();
               System.out.println(i+"傳送:"+MainActivity.ax[i]);
              }


               for(int i=0;i<6;i++){

                   buffer=reader3.readLine();
                   MainActivity.axbuffer[i]=Integer.parseInt(buffer);

                   System.out.println("收到:"+MainActivity.axbuffer[i]);



               }

               //[[[[[[[[[[[[[[[[

              // System.out.println("s");








               //PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                //writer.println("安安");

                //writer.write(""+MainActivity.a);
                // writer.println("::"+MainActivity.a2+"::"+MainActivity.b2+"::"+MainActivity.c2+"::"+MainActivity.d2);
                //writer.println("::"+MainActivity.a3+"::"+MainActivity.b3+"::"+MainActivity.c3+"::"+MainActivity.d3);

                //writer.close();//要加，會變很快 加了reader會出錯


                /*BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                for(int i=0;i<12;i++){
                    axis[i]=Integer.parseInt(reader.readLine());//////////////////////這是原本的--------------------------------reader
                    System.out.println(axis[i]);
                }*/
                //logcat會印出錯誤不知為何*//////

            }

        } catch (IOException e) {
            e.printStackTrace();
        }//androidmanifest必須先加入這一行<uses-permission android:name= "android.permission.INTERNET"/> 給他權限連線







    }
}
