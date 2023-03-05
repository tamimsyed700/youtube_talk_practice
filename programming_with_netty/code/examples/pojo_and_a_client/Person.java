package com.agiledeveloper;

import java.io.Serializable;

public class Person implements Serializable {
  private final String _firstName;
  private final String _lastName;
  private final int _age;
  private boolean _approved;

  public Person(String firstName, String lastName, int age) {
    _firstName = firstName;
    _lastName = lastName;
    _age = age;
  }

  public String getFirstName() {
    return _firstName;
  }

  public String getLastName() {
    return _lastName;
  }

  public int getAge() {
    return _age;
  }

  public boolean getApproved() {
    return _approved;
  }

  public void setApproved(boolean approved) {
    _approved = approved;
  }
}
