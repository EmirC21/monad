package com.example.application.views.personel;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonelService {

    public List<Personel> getAllPersonel() {
        return Arrays.asList(
                new Personel("12345678901", "EMİRCAN", "OĞUZTÜRK"),
                new Personel("23456789012", "Ayşe", "Kaya"),
                new Personel("34567890123", "Mehmet", "Demir"),
                new Personel("45678901234", "Fatma", "Çelik"),
                new Personel("56789012345", "Ahmet", "Şahin"),
                new Personel("67890123456", "Zeynep", "Koç"),
                new Personel("78901234567", "Mustafa", "Öztürk"),
                new Personel("89012345678", "Elif", "Aydın"),
                new Personel("90123456789", "Burak", "Güneş"),
                new Personel("01234567890", "Cem", "Aksoy")
        );
    }
}
