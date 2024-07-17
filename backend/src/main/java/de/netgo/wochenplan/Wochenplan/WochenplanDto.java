package de.netgo.wochenplan.Wochenplan;

import java.util.UUID;

public class WochenplanDto {
private String name;
private UUID benutzerId;

  public String getName() {
    return name;
  }

  public WochenplanDto setName(final String name) {
    this.name = name;
    return this;
  }

  public UUID getBenutzerId() {
    return benutzerId;
  }
  public WochenplanDto setBenutzerId(final UUID benutzerId) {
    this.benutzerId = benutzerId;
    return this;
  }
}
