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
    return new Zoo(
        1,
        "Wesołe Zoo",
        "Zoo, sala 107, Polsko-Japońska Akademia Technik Komputerowych, Gdańsk Brzegi 55",
        false,
        null);
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
}
