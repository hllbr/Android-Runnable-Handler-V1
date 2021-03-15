package com.hllbr.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView ;

   // bir işlem yapıcam ve ne kadr sürdüğünü hesaplayacak ardından sayacı sıfıryılor olucam

    //bir integer değer oluşturuyorum ve bu değeri her saniye arttırmak istiyorum global değişken olarak tanımlıyorum çünkü arttırma işlemim bittiğinde bson süreyi yazdırmak istiyorum..

    int number ;

    Runnable runnable ;//bir işlemi birden fazla kez belirttiğimiz sayıda yada periyotta yapmamıza olanak sağlayan bir arayüz(interface)

    Handler handler ;//ele almak yönetmek olarak çevirebilirim .bu yapı ile ruunable yapsını ele alıyoruz.handler ruunable ve message lar ile çalışmamıza olanak sağlayan bir arayüz(interface)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        //bu alanda değerimi 0 oalrak başlatmak istediğimi belirttim.

    }

    public void start(View view){
        /*start butonuna basldığında sayacın çalıştırılma işlemleri

        textView.setText("TIME :"+number);

        number++ ;

        textView.setText("TIME :"+number);

        burada zamanla ilgili hirbir işlem gerçekleştiremem

        bir kez arttırma oluyor zamandan bağımsız birmantığı var ben bunu istemiyorum zamanla değişkenimi ilişkilendirmek istiyorum

        while yada for gibi loop lar ilede yapabilirim fakat bunlar saydırma oluyor bunlarında zaman ile bir ilişkisi söz konusu değil

        loopları sleep ile(Thread.sleep(1000); uyutarak yazdırmakta mümkün fakat buda verimsiz bir yöntem

        threadlerin yaptığı işlemi bana daha kolay elde etme imkanı veren runnable adlı bir yapı sağlıyor

        runnable ile birlikte birde handler adlı başka bir yapım daha var istediğim işlemi gerçekleştirmek için bunlara ihtiyacım var

        *****Handler ifadesinin iki tanımlama yöntemi var

        1) handler = new Handler(); 2) handler = new Handler(Looper.getMainLooper));


        */
        handler = new Handler(Looper.getMainLooper());

        runnable = new Runnable() {
            @Override
            public void run() {

                //bu alanda yazdığım herşey belirttiğim periyotta olacak

                textView.setText("TIME : "+number);

                number++ ;

                textView.setText("time "+number);

                //bu yapı henüz aktif değil (çalıştırılmış durumda değil) bunu aktifleştirmek(başlatmak) için handler kullanmam gerekiyor.

                handler.postDelayed(runnable,1000);//bu yapı bir runnable'ı soruyor bir de rötar zamanını soruyor (kaç milisaniyede bu runnable çalıştırması gerekitiğini )
            }
        };
        //handler da henüz aktif durumda değil ne yapacağını ifade ettim handler ı aktifleştirdiğim(başlattığımda) runnable da başlamış olacak istediğim koşullarda koşturulacak
        handler.post(runnable);
        /*
        Kodun şuanki durumunda  birden fazla kez basıldığında ruunable birden fazla kez çalıştırılığı için sayacım hızlanıyor..Bunun önüne geçmemiz gerekiyor bu kullanıcı hatası ile oluşacak proglemlerden değilProgramcı tarafından düşünülmesi gerekn problemlerden biridir.
         
         */




    }
    public void stop(View view){

        //sayacı durdurmak ve bununla birlikte yada sonrasında yapmak istediğim işlemleri yazacağım alan








    }
}