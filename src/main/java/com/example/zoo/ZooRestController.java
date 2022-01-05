package com.example.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {
  private final ZooService zooService;

  public ZooRestController(ZooService zooService) {
    this.zooService = zooService;
  }

  @GetMapping("/example")
  public ResponseEntity<Zoo> getZooExample() {
    return ResponseEntity.ok(zooService.getExampleZoo());
  }

  @GetMapping("/empty")
  public ResponseEntity<Zoo> getEmptyZoo() {
    return ResponseEntity.ok(zooService.getEmptyZoo());
  }

  @GetMapping("/empty-with-name/")
  public ResponseEntity<Zoo> getEmptyZooWithName(@RequestParam String name) {
    return ResponseEntity.ok(zooService.getEmptyZooWithName(name));
  }

  @GetMapping("/puszeczek")
  public ResponseEntity<Zoo> getPuszeczek() {
    return ResponseEntity.ok(zooService.getZooOfName("Puszeczek"));
  }

  @GetMapping("/all")
  public ResponseEntity<List<Zoo>> getAll() {
    return ResponseEntity.ok(zooService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Zoo>> getById(@PathVariable("id") Integer id) {
    Optional<Zoo> zoo = zooService.getById(id);
    return zoo.isPresent() ? ResponseEntity.ok(zoo) : ResponseEntity.notFound().build();
  }

  @GetMapping("/great-id")
  public ResponseEntity<List<Zoo>> getAllWithGreatId() {
    return ResponseEntity.ok(zooService.getAllWithGreatId());
  }
}
