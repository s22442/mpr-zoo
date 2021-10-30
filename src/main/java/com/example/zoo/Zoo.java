package com.example.zoo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String location;
  private boolean isClosed;

  @OneToMany private List<Animal> animals;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public boolean isClosed() {
    return isClosed;
  }

  public void setClosed(boolean closed) {
    isClosed = closed;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public void setAnimals(List<Animal> animals) {
    this.animals = animals;
  }

  public Zoo() {}

  public Zoo(Integer id, String name, String location, boolean isClosed, List<Animal> animals) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.isClosed = isClosed;
    this.animals = animals;
  }

  public String toString() {
    return "Zoo{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", location='"
        + location
        + '\''
        + ", isClosed="
        + isClosed
        + ", animals="
        + animals
        + '}';
  }
}
