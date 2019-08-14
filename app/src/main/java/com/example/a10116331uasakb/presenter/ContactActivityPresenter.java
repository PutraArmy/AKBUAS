package com.example.a10116331uasakb.presenter;

/**
 * 16 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import com.example.a10116331uasakb.model.ContactModel;
import com.example.a10116331uasakb.view.ContactView;


public class ContactActivityPresenter implements ContactPresenter {
    private ContactView contactView;
    private ContactModel contact = new ContactModel();

    public ContactActivityPresenter(ContactView contactView) {
        this.contactView  = contactView;
    }

    @Override
    public void isiDataHP(String HP) {
        contact.setHp(HP);
        contactView.isiProfileHp(contact.getHp());
    }

    @Override
    public void isiDataEmail(String Email) {
        contact.setEmail(Email);
        contactView.isiProfileEmail(contact.getEmail());
    }

    @Override
    public void isiDataIG(String IG) {
        contact.setIG(IG);
        contactView.isiProfileIG(contact.getIG());
    }

    @Override
    public void isiDataFB(String FB) {
        contact.setFB(FB);
        contactView.isiProfileFB(contact.getFB());
    }
}


