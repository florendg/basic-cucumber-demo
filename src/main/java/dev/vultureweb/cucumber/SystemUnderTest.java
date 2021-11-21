package dev.vultureweb.cucumber;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SystemUnderTest {

   public String isItFriday(LocalDate date) {
      return date.getDayOfWeek() == DayOfWeek.FRIDAY ? "TGIF" : "Nope";
   }
}
