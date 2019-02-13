package com.example.tamer.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2, b3, b4;
    Intent i, seciciolustur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.Button1);
        b2 = findViewById(R.id.Button2);
        b3 = findViewById(R.id.Button3);
        b4 = findViewById(R.id.Button4);


    }

    public void explicitcalistir(View view)//explicit açık intent
    {
        /*i = new Intent(this,ActivityB.class);
        startActivity(i);*/

       /* i = new Intent();
        i.setClassName("com.example.tamer.myapplication","com.example.tamer.myapplication.ActivityB");
        startActivity(i);*/


        Uri haritakordinat = Uri.parse("geo:36.574844,139.239418");
        i = new Intent(Intent.ACTION_VIEW,haritakordinat);
        startActivity(i);


    }
    public void impilicitcalistir(View view)
    {
        if (view.getId()==b2.getId())
        {
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:36.574844,139.239418"));
            seciciolustur=Intent.createChooser(i,"Uygulama Seçiniz");
            startActivity(seciciolustur);
        }
        if (view.getId()==b3.getId())
        {
            i = new Intent();
            i.setData(Uri.parse("market://details?id=com.facebook.katana"));
            seciciolustur = Intent.createChooser(i, "Facebook açıl");
            startActivity(seciciolustur);
        }
        if (view.getId()==b4.getId())
        {
            i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto"));
            /*Uri mailintent = Uri.parse("mailto");
            i = new Intent(Intent.ACTION_SEND,mailintent);*/

            String[] gönderilecekMailadresleri = {"tamertinaz@gmail.com","aaa@hotmail.com","bbb@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL, gönderilecekMailadresleri);
            i.putExtra(Intent.EXTRA_SUBJECT, "Mailin konusu");
            i.putExtra(Intent.EXTRA_TEXT,"Mailin içeriğinde yazan text");
            i.setType("message/rfc822");
            seciciolustur=Intent.createChooser(i,"Mail gönderme uygulamasını seç");
            startActivity(seciciolustur);

        }

    }
}
