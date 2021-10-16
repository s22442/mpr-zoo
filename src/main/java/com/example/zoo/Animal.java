package com.example.zoo;

public class Animal {
  private Integer id;
  private String name;
  private String specimen;
  private AnimalDiet diet;
  private AnimalType type;
  private boolean isHungry;
  private AnimalHealth health;

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

  public String getSpecimen() {
    return specimen;
  }

  public void setSpecimen(String specimen) {
    this.specimen = specimen;
  }

  public AnimalDiet getDiet() {
    return diet;
  }

  public void setDiet(AnimalDiet diet) {
    this.diet = diet;
  }

  public AnimalType getType() {
    return type;
  }

  public void setType(AnimalType type) {
    this.type = type;
  }

  public boolean isHungry() {
    return isHungry;
  }

  public void setHungry(boolean hungry) {
    isHungry = hungry;
  }

  public AnimalHealth getHealth() {
    return health;
  }

  public void setHealth(AnimalHealth health) {
    this.health = health;
  }

  public Animal(
      Integer id,
      String name,
      String specimen,
      AnimalDiet diet,
      AnimalType type,
      boolean isHungry,
      AnimalHealth health) {
    this.id = id;
    this.name = name;
    this.specimen = specimen;
    this.diet = diet;
    this.type = type;
    this.isHungry = isHungry;
    this.health = health;
  }
}
