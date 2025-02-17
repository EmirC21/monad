package com.example.application.views.personel;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Personel")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
@Route("personel")
public class PersonelView extends VerticalLayout {

    private final PersonelService personelService;
    private final PersonelPresenter personelPresenter;
    private final Grid<Personel> grid = new Grid<>(Personel.class);
    private final Button yenileButton = new Button("Yenile");

    @Autowired
    public PersonelView(PersonelService personelService, PersonelPresenter personelPresenter) {
        this.personelService = personelService;
        this.personelPresenter = personelPresenter;

        grid.setItems(getTumPersoneller());

        yenileButton.addClickListener(event -> {
            personelPresenter.yeniPersonelEkle();
            grid.setItems(getTumPersoneller());
        });

        add(grid, yenileButton);
    }

    public List<Personel> getTumPersoneller() {
        List<Personel> tumPersoneller = new ArrayList<>(personelService.getAllPersonel());
        tumPersoneller.addAll(personelPresenter.getEkstraPersoneller());
        return tumPersoneller;
    }
}
