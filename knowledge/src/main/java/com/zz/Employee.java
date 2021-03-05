package com.zz;

import java.util.Objects;

public class Employee  {

   public String name;
   public String address;
   public transient int SSN;
   public int number;

   public void mailCheck() {
      System.out.println("Mailing a check to " + name
              + " " + address);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public int getSSN() {
      return SSN;
   }

   public void setSSN(int SSN) {
      this.SSN = SSN;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Employee employee = (Employee) o;
      return SSN == employee.SSN &&
              number == employee.number &&
              Objects.equals(name, employee.name) &&
              Objects.equals(address, employee.address);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, address, SSN, number);
   }


}

