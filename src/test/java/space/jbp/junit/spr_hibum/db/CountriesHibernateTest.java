package space.jbp.junit.spr_hibum.db;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

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
  void test() {
    fail("Not yet implemented");
  }

}
