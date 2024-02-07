package space.jbp.junit.spr_hibum.db.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COUNTRY")
@NoArgsConstructor
@Getter
@Setter
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int id;
  
  @Column(name = "NAME")
  private String name;
  
  @Column(name = "CODE_NAME")
  private String codeName;

  @Override
  public String toString() {
    return "Country [name=" + name + ", codeName=" + codeName + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeName, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Country other = (Country) obj;
    return Objects.equals(codeName, other.codeName)
        && Objects.equals(name, other.name);
  }

  public Country(String name, String codeName) {
    super();
    this.name = name;
    this.codeName = codeName;
  }
  
}
