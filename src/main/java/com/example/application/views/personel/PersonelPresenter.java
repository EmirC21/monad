package com.example.application.views.personel;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonelPresenter {

    private final List<Personel> ekstraPersoneller = new ArrayList<>();
    private final PersonelService personelService;
    public PersonelPresenter(PersonelService personelService) {
        this.personelService = personelService;
    }


    public void yeniPersonelEkle() {

        String yeniTc = String.format("%011d", 12345678901L +personelService.getAllPersonel().size()+getEkstraPersoneller().size());
        Personel yeniPersonel = new Personel(yeniTc, "Son", "Kişi");

        ekstraPersoneller.add(yeniPersonel);
    }

    public List<Personel> getEkstraPersoneller() {
        return new ArrayList<>(ekstraPersoneller);
    }
}