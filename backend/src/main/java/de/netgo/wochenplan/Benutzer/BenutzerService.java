package de.netgo.wochenplan.Benutzer;

import de.netgo.wochenplan.jooq.tables.daos.BenutzerDao;
import de.netgo.wochenplan.jooq.tables.pojos.Benutzer;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BenutzerService {

//  private final DSLContext dsl;

  private final BenutzerDao benutzerDao;

  BenutzerService(final BenutzerDao benutzerDao) {
//    this.dsl = dsl;
    this.benutzerDao = benutzerDao;
  }

  @Transactional(readOnly = true)
  public List<Benutzer> findAllBenutzer() {
    return benutzerDao.findAll();
//    final List<Benutzer> benutzerList = dsl.selectFrom(BENUTZER).fetchInto(Benutzer.class);
  }

  @Transactional
  public void createBenutzer(final Benutzer benutzer) {
    benutzerDao.insert(new Benutzer().setId(UUID.randomUUID()).setName(benutzer.getName()));
  }
}
