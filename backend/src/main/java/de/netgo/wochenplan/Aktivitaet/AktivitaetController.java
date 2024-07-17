package de.netgo.wochenplan.Aktivitaet;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import de.netgo.wochenplan.jooq.tables.pojos.Aktivitaet;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aktivitaeten")
public class AktivitaetController {

  private final AktivitaetService aktivitaetService;

  AktivitaetController(final AktivitaetService aktivitaetService) {
    this.aktivitaetService = aktivitaetService;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Aktivitaet>> getAktivitaeten() {
    return ResponseEntity.ok(aktivitaetService.findAllAktivitaeten());
  }

  @GetMapping(value = "/wochenplan/{wochenplanId}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Aktivitaet>> getAktivitaetenByWochenplanId(@PathVariable final UUID wochenplanId) {
    return ResponseEntity.ok(aktivitaetService.findAllAktivitaetenByWochenplanId(wochenplanId));
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createAktivitaet(@RequestBody final AktivitaetDto aktivitaet) {
    aktivitaetService.createAktivitaet(aktivitaet);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAktivitaet(@PathVariable final UUID id) {
    aktivitaetService.deleteAktivitaet(id);
    return ResponseEntity.ok().build();
  }

}
