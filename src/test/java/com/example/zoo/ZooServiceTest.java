package com.example.zoo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ZooServiceTest {

  private final ZooService zooService = new ZooService(null);

  @Test
  void shouldAddAnimalToZoo() {
    Zoo zoo = new Zoo(null, null, null, false, new ArrayList<>());

    Animal animal = new Animal();
    animal.setName("Puszek");

    zooService.addAnimalToZoo(zoo, animal);

    assertThat(zoo.getAnimals()).hasSize(1);
  }

  @Test
  void shouldNotAddAnimalToZoo() {
    Zoo zoo = new Zoo(null, null, null, false, new ArrayList<>());

    zooService.addAnimalToZoo(zoo, new Animal());

    assertThat(zoo.getAnimals()).isEmpty();
  }

  @Test
  void shouldRemoveAnimalFromZooByIndex() {
    Zoo zoo = new Zoo(null, null, null, false, new ArrayList<>());
    Animal animal = new Animal();
    animal.setName("Puszek");
    zooService.addAnimalToZoo(zoo, animal);

    zooService.removeAnimalFromZooByIndex(zoo, 0);

    assertThat(zoo.getAnimals()).isEmpty();
  }

  @Test
  void shouldNotRemoveAnimalFromZooByIndex() {
    Zoo zoo = new Zoo(null, null, null, false, new ArrayList<>());
    Animal animal = new Animal();
    animal.setName("Puszek");
    zooService.addAnimalToZoo(zoo, animal);

    zooService.removeAnimalFromZooByIndex(zoo, 999);

    assertThat(zoo.getAnimals()).hasSize(1);
  }

  @Test
  void shouldGetAnimalFromZooByName() {
    String name = "Puszek";

    Zoo zoo =
        new Zoo(
            null,
            null,
            null,
            false,
            List.of(new Animal(null, name, null, null, null, false, null)));

    Animal animal = zooService.getAnimalFromZooByName(zoo, name);

    assertThat(animal).isNotNull();
  }

  @Test
  void shouldNotGetAnimalFromZooByName() {
    String name = "Puszek";

    Zoo zoo =
        new Zoo(
            null,
            null,
            null,
            false,
            List.of(new Animal(null, null, null, null, null, false, null)));

    Animal animal = zooService.getAnimalFromZooByName(zoo, name);

    assertThat(animal).isNull();
  }

  @Test
  void shouldChangeZooName() {
    String name = "Oruńskie wesołe zoo";

    Zoo zoo = this.zooService.getEmptyZoo();

    zooService.changeZooName(zoo, name);

    assertThat(zoo.getName()).isEqualTo(name);
  }

  @Test
  void shouldNotChangeZooName() {
    Zoo zoo = this.zooService.getEmptyZoo();

    zooService.changeZooName(zoo, null);

    assertThat(zoo.getName()).isNull();
  }

  @Test
  void shouldChangeZooLocation() {
    String targetLocation = "Orunia";

    Zoo zoo = new Zoo(null, "Oruńskie Zoo", "Nieorunia", true, null);

    zooService.changeZooLocation(zoo, targetLocation);

    assertThat(zoo.getLocation()).isEqualTo(targetLocation);
  }

  @Test
  void shouldAppendZooName() {
    String zooName = "Oruńskie Zoo";
    String zooNamePrefix = " na Oruni";

    Zoo zoo = new Zoo(null, zooName, "Orunia", true, null);

    zooService.appendZooName(zoo, zooNamePrefix);

    assertThat(zoo.getName()).isEqualTo(zooName + zooNamePrefix);
  }

  @Test
  void shouldNotAppendZooName() {
    String zooName = "Oruńskie Zoo";

    Zoo zoo = new Zoo(null, zooName, "Orunia", true, null);

    zooService.appendZooName(zoo, null);

    assertThat(zoo.getName()).isEqualTo(zooName);
  }

  @Test
  void shouldCloseZoo() {
    Zoo zoo = new Zoo(null, null, null, false, null);

    zooService.closeZoo(zoo);

    assertThat(zoo.isClosed()).isTrue();
  }

  @Test
  void shouldNotCloseZoo() {
    Zoo zoo = new Zoo(null, null, null, true, null);

    zooService.closeZoo(zoo);

    assertThat(zoo.isClosed()).isTrue();
  }
}
