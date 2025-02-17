package com.example.application.views.personel;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.List;

@PageTitle("Personel")
@Route("personel")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
public class PersonelView extends VerticalLayout {

    private final PersonelService personelService;
    private Grid<Personel> grid;
    private ListDataProvider<Personel> dataProvider;

    @Autowired
    public PersonelView(PersonelService personelService) {
        this.personelService = personelService;
        configureGrid();
        add(createSearchField(), grid);
    }

    private void configureGrid() {
        grid = new Grid<>(Personel.class);
        List<Personel> personelList = personelService.getAllPersonel();
        dataProvider = new ListDataProvider<>(personelList);
        grid.setDataProvider(dataProvider);
        grid.setColumns("ad", "soyad");
    }

    private TextField createSearchField() {
        TextField searchField = new TextField();
        searchField.setPlaceholder("Ada göre ara...");
        searchField.setClearButtonVisible(true);
        searchField.addValueChangeListener(event ->
                dataProvider.setFilter(Personel::getAd, ad -> ad.toLowerCase().contains(event.getValue().toLowerCase())));
        return searchField;
    }
}