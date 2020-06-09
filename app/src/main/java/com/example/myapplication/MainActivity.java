package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {


    //Button go;
    ImageView cup1, cup2, cup3;

    Handler handler;

    public static int[] ax=new int[6];//位置暫存廣域變數
    public static int[] axbuffer=new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //go=(Button)findViewById(R.id.go);
        //go.setOnTouchListener(btnlistener);

        cup1 = (ImageView) findViewById(R.id.cup1);
        cup2 = (ImageView) findViewById(R.id.cup2);
        cup3 = (ImageView) findViewById(R.id.cup3);
        cup1.setOnTouchListener(imgListener);
        cup2.setOnTouchListener(imgListener);
        cup3.setOnTouchListener(imgListener);
         ax[0]=20;//初始化位置
         ax[1]=200;//dp
         ax[2]=50;
         ax[3]=200;
         ax[4]=100;
         ax[5]=200;
        axbuffer[0]=20;//初始化位置
        axbuffer[1]=200;//dp
        axbuffer[2]=50;
        axbuffer[3]=200;
        axbuffer[4]=100;
        axbuffer[5]=200;



        // setContentView(new game(this));/////////////////////





    }

    public void client(){
        //---------------------客戶端開啟-------------

        cc bb = new cc();
        Thread x = new Thread(bb);
        x.start();
       /* try {
            x.join();//join要加等待執行緒跑完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*///新版本猜杯子不用加看情況

        // a++;//testing work!=====================================
        //---------------------------------------------
    }
    //傳送給對方位置
   /* private View.OnTouchListener btnlistener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {//更新位置
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    v.setVisibility(View.GONE);

                    for (int i=0;i<=10;i++){///////////////////////axbuffer[7]==1
                        cup1.setX(axbuffer[0]+=5);
                    cup1.setY(axbuffer[1]+=5);
                    cup2.setX(axbuffer[2]+=5);
                    cup2.setY(axbuffer[3]+=5);
                    cup3.setX(axbuffer[4]+=5);
                    cup3.setY(axbuffer[5]+=5);
                        System.out.println("jjjjj");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                /*case MotionEvent.ACTION_DOWN:

                     event.getX();                  //觸控的X軸位置
                     y = event.getY();
                    System.out.println("go");
                    break;
                   case MotionEvent.ACTION_MOVE:
                     ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)cup1.getLayoutParams();
                    lp.leftMargin = ax[0];
                    lp.rightMargin = ax[1];
                    cup1.requestLayout();
                    ViewGroup.MarginLayoutParams lp2 = (ViewGroup.MarginLayoutParams)cup2.getLayoutParams();
                    lp2.leftMargin = ax[4];
                    lp2.rightMargin = ax[5];
                    cup2.requestLayout();
                    ViewGroup.MarginLayoutParams lp3 = (ViewGroup.MarginLayoutParams)cup3.getLayoutParams();
                    lp3.leftMargin = ax[8];
                    lp3.rightMargin = ax[9];
                    cup3.requestLayout();
                    System.out.println("go");
                    break;
                /

            }

            return true;
        }
      };   */


    private View.OnTouchListener imgListener = new View.OnTouchListener() {

        private float x, y;    // 原本圖片存在的X,Y軸位置
        private int mx, my; // 圖片被拖曳的X ,Y軸距離長度

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (v.getId()) {
                case R.id.cup1:
                    switch (event.getAction()){
                   case MotionEvent.ACTION_DOWN:

                       ax[0]=(int)event.getRawX();                  //觸控的X軸位置
                       ax[1]= (int)event.getRawY();


                   case MotionEvent.ACTION_MOVE:
                       ax[0]=(int)event.getRawX()-10;                  //觸控的X軸位置
                       ax[1]= (int)event.getRawY()-40;
                    //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)v.getLayoutParams();
                    //lp.leftMargin = ax[0]+v.getLeft();
                    //lp.rightMargin = ax[1]+v.getTop();
                       v.setX(ax[0]);//設中心點
                    v.setY(ax[1]);//減少誤差
                    //cup1.requestLayout();
                    break;}
                    /*switch (event.getAction()) {          //判斷觸控的動作

                        case MotionEvent.ACTION_DOWN:// 按下圖片時
                            x = event.getX();                  //觸控的X軸位置
                            y = event.getY();                  //觸控的Y軸位置

                        case MotionEvent.ACTION_MOVE:// 移動圖片時

                            //getX()：是獲取當前控件(View)的座標

                            //getRawX()：是獲取相對顯示螢幕左上角的座標
                            mx = (int) (event.getRawX() - x);
                            my = (int) (event.getRawY() - y);

                            ax[0]=mx;
                            ax[1]=my;
                            ax[2]=mx+v.getWidth();
                            ax[3]=my + v.getHeight();

                            v.layout(mx, my, mx + v.getWidth(), my + v.getHeight());

                            break;
                        }*/
                 break;


                case R.id.cup2:
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:

                            ax[2]=(int)event.getRawX();                  //觸控的X軸位置
                            ax[3]= (int)event.getRawY();


                        case MotionEvent.ACTION_MOVE:
                            ax[2]=(int)event.getRawX()-40;                  //觸控的X軸位置
                            ax[3]= (int)event.getRawY()-40;
                            //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)v.getLayoutParams();
                            //lp.leftMargin = ax[0]+v.getLeft();
                            //lp.rightMargin = ax[1]+v.getTop();
                            v.setX(ax[2]);//setXY設中心點
                            v.setY(ax[3]);//-40減少誤差
                            //cup1.requestLayout();
                            break;}
                    break;
                case R.id.cup3:
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:

                            ax[4]=(int)event.getRawX();                  //觸控的X軸位置
                            ax[5]= (int)event.getRawY();


                        case MotionEvent.ACTION_MOVE:
                            ax[4]=(int)event.getRawX()-40;                  //觸控的X軸位置
                            ax[5]= (int)event.getRawY()-60;
                            //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)v.getLayoutParams();
                            //lp.leftMargin = ax[0]+v.getLeft();
                            //lp.rightMargin = ax[1]+v.getTop();
                            v.setX(ax[4]);//setXY設中心點
                            v.setY(ax[5]);//-40減少誤差
                            //cup1.requestLayout();
                            break;}
                    break;


            }
            return true;
        }




    };
    //接收對方送來位置
    public void virtualserver(View view){
        client();////////////////////////////////////////////

       /* Thread hh=new Thread(new ccreader());
        hh.start();*/

    }
    public void guess(View view){
        ccreader aa = new ccreader();
        Thread y = new Thread(aa);
        //y.start();

    }


    public void move(View v){
        mo vv=new mo();
        Thread z=new Thread(vv);
        z.start();
    }
    public class mo implements Runnable{

        @Override
        public void run() {
            while (true){
                for(int i=0;i<6;i++){
                    cup1.setX(axbuffer[0]+=5);
                    cup1.setY(axbuffer[1]+=5);
                    cup2.setX(axbuffer[2]+=5);
                    cup2.setY(axbuffer[3]+=5);
                    cup3.setX(axbuffer[4]+=5);
                    cup3.setY(axbuffer[5]+=5);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ax[i]);}
            }
        }
    }

}
