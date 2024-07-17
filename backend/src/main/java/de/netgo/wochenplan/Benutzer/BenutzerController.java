package de.netgo.wochenplan.Benutzer;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import de.netgo.wochenplan.jooq.tables.pojos.Benutzer;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/benutzer")
public class BenutzerController {

  private final BenutzerService benutzerService;

  BenutzerController(final BenutzerService benutzerService) {
    this.benutzerService = benutzerService;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Benutzer>> getBenutzer() {
    return ResponseEntity.ok(benutzerService.findAllBenutzer());
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createBenutzer(@RequestBody final Benutzer benutzer) {
    benutzerService.createBenutzer(benutzer);
    return ResponseEntity.ok().build();
  }
}
