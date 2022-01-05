package com.example.zoo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

  private final ZooRepository zooRepository;

  public ZooService(ZooRepository zooRepository) {
    this.zooRepository = zooRepository;
  }

  public Zoo getExampleZoo() {
    Animal dog =
        new Animal(
            null,
            "Puszek",
            "dog but better",
            AnimalDiet.MEAT,
            AnimalType.AIR,
            true,
            AnimalHealth.DEAD);

    Zoo zoo =
        new Zoo(
            null,
            "Wesołe Zoo",
            "Zoo Example, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
            false,
            List.of(dog));

    this.zooRepository.save(zoo);

    return zoo;
  }

  public Zoo getEmptyZoo() {
    return new Zoo(null, null, null, false, null);
  }

  public Zoo getEmptyZooWithName(String name) {
    return new Zoo(null, name, null, false, null);
  }

  public Zoo getZooOfName(String name) {
    return new Zoo(
        1,
        name,
        "Zoo, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
        false,
        null);
  }

  public List<Zoo> getAll() {
    return this.zooRepository.findAll();
  }

  public Optional<Zoo> getById(Integer id) {
    return this.zooRepository.findById(id);
  }

  public List<Zoo> getAllWithGreatId() {
    return this.zooRepository.findAllByIdGreaterThan(5);
  }

  public void addAnimalToZoo(Zoo zoo, Animal animal) {
    if (animal.getName() != null) {
      zoo.addAnimal(animal);
    }
  }

  public void removeAnimalFromZooByIndex(Zoo zoo, int index) {
    if (index < zoo.getAnimals().size()) {
      zoo.removeAnimalByIndex(index);
    }
  }

  public Animal getAnimalFromZooByName(Zoo zoo, String name) {
    return name != null ? zoo.getAnimalByName(name) : null;
  }

  public void changeZooName(Zoo zoo, String newName) {
    if (newName != null) {
      zoo.setName(newName);
    }
  }

  public void changeZooLocation(Zoo zoo, String newLocation) {
    if (newLocation != null) {
      zoo.setLocation(newLocation);
    }
  }

  public void appendZooName(Zoo zoo, String prefix) {
    if (prefix != null) {
      zoo.setName(zoo.getName() + prefix);
    }
  }

  public void closeZoo(Zoo zoo) {
    if (!zoo.isClosed()) {
      zoo.setClosed(true);
    }
  }

  public boolean existsById(Integer id) {
    return zooRepository.existsById(id);
  }

  public void deleteById(Integer id) {
    zooRepository.deleteById(id);
  }

  public Zoo findById(Integer id) {
    Optional<Zoo> zooById = zooRepository.findById(id);

    return zooById.orElse(null);
  }
}
