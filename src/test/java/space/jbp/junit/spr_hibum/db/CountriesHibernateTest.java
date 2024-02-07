package space.jbp.junit.spr_hibum.db;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static space.jbp.junit.spr_hibum.db.CountryService.COUNTRY_INIT_DATA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import space.jbp.junit.spr_hibum.db.model.Country;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class CountriesHibernateTest {

  @Autowired
  private CountryService countryService;

  private List<Country> expectedCountries = new ArrayList<>();
  private List<Country> expected국Countries = new ArrayList<>();

  @Test
  void testCountryList() {
    List<Country> countries = countryService.getAllCountries();
    assertNotNull(countries);
    assertEquals(expectedCountries.size(), countries.size());
    expectedCountries.forEach(ec -> {
      assertTrue(countries.contains(ec));
    });
  }
  
  @BeforeEach
  public void setUp() {
    countryService.init();
    initExpectedCountryLists();
  }

  @AfterEach
  public void dropDown() {
    countryService.clear();
  }
  private void initExpectedCountryLists() {
    Stream.of(COUNTRY_INIT_DATA).forEach(item -> {
      Country c = new Country(item[0], item[1]);
      expectedCountries.add(c);
      if (item[0].contains("국")) {
        expected국Countries.add(c);
      }
    });
  }

}
