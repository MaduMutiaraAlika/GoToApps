package com.madumutiaraalika.gotoapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center","Driving Direction","Website","Info Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);

    }

    private void tampilkanpilihan(String pilihan) {
        try{
            Intent a = null;
            if (pilihan.equals("Call Center")){
                String nomortel = "tel:0761-1701999";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));


            } else if (pilihan.equals("SMS Center"))
            {
                String smsText="Madu Mutiara Alika / P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081327631793"));
                a.putExtra("sms_body",smsText);
            } else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs ="https://www.google.co.id/maps/place/RUMAH+SAKIT+AWAL+BROS+PANAM/@0.5139625,101.3711351,12z/data=!4m5!3m4!1s0x31d5a8f5db0db97b:0x8f4c180a400c2d84!8m2!3d0.4632232!4d101.3903332";
                a=new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            }else if (pilihan.equals("Website"))
            {
                String website = "http://www.awalbros.com";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }else if (pilihan.equals("Info Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bros");
            }
            startActivity(a);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
