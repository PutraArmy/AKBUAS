package com.example.a10116331uasakb.Fragment;

/**
 * 16 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.presenter.ContactActivityPresenter;
import com.example.a10116331uasakb.view.ContactView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact extends Fragment implements ContactView {

    private ContactActivityPresenter contact;
    private TextView Hp, Email, IG, FB;

    private String hp, email, ig, fb;
    ImageButton telp, emailBtn, igButton, fbButton, fbMaps ;

    public Contact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.contact, container, false);
        // Inflate the layout for this fragment
        contact = new ContactActivityPresenter(this);

        Hp      = (TextView) view.findViewById(R.id.HP);
        Email   = (TextView) view.findViewById(R.id.email);
        IG      = (TextView) view.findViewById(R.id.IG);
        FB      = (TextView) view.findViewById(R.id.FB);

        telp = (ImageButton) view.findViewById(R.id.Imgphone) ;
        telp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String phoneNumber = hp;
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));

                startActivity(dialPhoneIntent);
            }
        });

        emailBtn = (ImageButton) view.findViewById(R.id.Imgemail);
        emailBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Uri webpage = Uri.parse("https://mail.google.com/mail/u/0/?tab=wm#inbox?compose=new");
                Intent emailIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(emailIntent);
            }
        });

        igButton = (ImageButton) view.findViewById(R.id.ImgIG);
        igButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Uri webpage = Uri.parse("https://www.instagram.com/putra_army/?hl=id");
                Intent emailIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(emailIntent);
            }
        });

        fbButton = (ImageButton) view.findViewById(R.id.ImgFB);
        fbButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Uri webpage = Uri.parse("https://www.facebook.com/putmyhaseptri");
                Intent emailIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(emailIntent);
            }
        });

        fbMaps = (ImageButton) view.findViewById(R.id.ImgMaps);
        fbMaps.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri = Uri.parse("geo:-6.886871, 107.615303");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);
            }

        });


        contact.isiDataHP("082117494117");
        contact.isiDataEmail("armhy333@gmail.com");
        contact.isiDataIG("@putra_army");
        contact.isiDataFB("Putra Armhy");



        return view;
    }

    @Override
    public void isiProfileHp(String info) {
        Hp.setText(info);
        hp = info.toString();
    }

    @Override
    public void isiProfileEmail(String info) {
        Email.setText(info);
        email = info.toString();
    }

    @Override
    public void isiProfileIG(String info) {
        IG.setText(info);
        ig = info.toString();
    }

    @Override
    public void isiProfileFB(String info) {
        FB.setText(info);
        fb  = info.toString();
    }
}
