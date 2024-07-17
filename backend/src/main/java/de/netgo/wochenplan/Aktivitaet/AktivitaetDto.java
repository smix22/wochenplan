package de.netgo.wochenplan.Aktivitaet;

import java.util.UUID;

public class AktivitaetDto {
private String name;
private String wochentag;
private UUID wochenplanId;

  public String getName() {
    return name;
  }

  public AktivitaetDto setName(final String name) {
    this.name = name;
    return this;
  }

  public String getWochentag() {
    return wochentag;
  }

  public AktivitaetDto setWochentag(final String wochentag) {
    this.wochentag = wochentag;
    return this;
  }

  public UUID getWochenplanId() {
    return wochenplanId;
  }

  public AktivitaetDto setWochenplanId(final UUID wochenplanId) {
    this.wochenplanId = wochenplanId;
    return this;
  }
}
