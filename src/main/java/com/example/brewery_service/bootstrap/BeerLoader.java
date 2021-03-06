package com.example.brewery_service.bootstrap;

import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "123123123123";
    public static final String BEER_2_UPC = "063123456789";
    public static final String BEER_3_UPC = "063123456608";

    private final BeerRepository beerRepositories;

    public BeerLoader(BeerRepository beerRepositories) {
        this.beerRepositories = beerRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepositories.count() == 0) {
            beerRepositories.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .price(new BigDecimal("10.50"))
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .build());

            beerRepositories.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.50"))
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .build());

            beerRepositories.save(Beer.builder()
                    .beerName("No Hammers on the bar")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.50"))
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .build());
        }
    }
}
