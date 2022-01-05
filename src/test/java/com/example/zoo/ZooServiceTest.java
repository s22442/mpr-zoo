package com.example.zoo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZooServiceTest {

  @Mock private ZooRepository zooRepository;

  @InjectMocks private ZooService zooService;

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

  @Test
  void shouldFindById() {
    when(zooRepository.findById(any())).thenReturn(Optional.of(new Zoo()));

    Zoo zooById = zooService.findById(1);

    assertThat(zooById).isNotNull();
  }

  @Test
  void shouldNotFindById() {
    when(zooRepository.findById(any())).thenReturn(Optional.empty());

    Zoo zooById = zooService.findById(1);

    assertThat(zooById).isNull();
  }

  @Test
  void shouldExistById() {
    when(zooRepository.existsById(any())).thenReturn(true);

    boolean zooExists = zooService.existsById(1);

    assertThat(zooExists).isTrue();
  }

  @Test
  void shouldNotExistById() {
    when(zooRepository.existsById(any())).thenReturn(false);

    boolean zooExists = zooService.existsById(1);

    assertThat(zooExists).isFalse();
  }

  @Test
  void shouldGetAll() {
    List<Zoo> zoos = new ArrayList<>();
    zoos.add(new Zoo());
    when(zooRepository.findAll()).thenReturn(zoos);

    List<Zoo> allZoos = zooService.getAll();

    assertThat(allZoos).hasSize(zoos.size());
  }

  @Test
  void shouldNotGetAll() {
    List<Zoo> allZoos = zooService.getAll();

    assertThat(allZoos).isEmpty();
  }

  @Test
  void shouldDeleteById() {
    zooService.deleteById(1);
    verify(zooRepository, times(2)).deleteById(any());
  }
}
