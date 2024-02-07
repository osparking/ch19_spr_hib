package space.jbp.junit.spr_hibum.db;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import space.jbp.junit.spr_hibum.db.model.Country;

public class CountryService {
  @PersistenceContext
  private EntityManager em;
  public static final String[][] COUNTRY_INIT_DATA = { { "호주", "AU" },
      { "대한민국", "KR" }, { "일본", "JP" }, { "중국", "CN" },
      { "미국", "US" }, { "영국", "UK" } };

  @Transactional
  public void init() {
    Stream.of(COUNTRY_INIT_DATA)
        .forEach(data -> em.persist(new Country(data[0], data[1])));
  }

  @Transactional
  public void clear() {
    em.createQuery("delete from Country c").executeUpdate();
  }

  @SuppressWarnings("unchecked")
  public List<Country> getAllCountries() {
    return em.createQuery("select c from Country c").getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<Country> getAll국Countries() {
    return em.createQuery("select c from Country c where name like '%국%'")
        .getResultList();
  }

}
