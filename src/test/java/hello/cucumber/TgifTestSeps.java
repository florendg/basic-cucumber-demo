package hello.cucumber;

import dev.vultureweb.cucumber.SystemUnderTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TgifTestSeps {

   private final SystemUnderTest systemUnderTest = new SystemUnderTest();
   private LocalDate testDate;
   private String answer;

   @Given("today is {string}")
   public void today_is(String day) {
      DayOfWeek expectedDayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
      testDate = LocalDate.now();
      while(testDate.getDayOfWeek() != expectedDayOfWeek) {
         testDate = testDate.plusDays(1);
      }
   }

   @When("I ask whether it is Friday")
   public void i_ask_whether_it_is_friday() {
      answer =  systemUnderTest.isItFriday(testDate);
   }

   @Then("the answer should be {string}")
   public void the_answer_should_be(String expectedAnswer) {
      assertEquals(expectedAnswer, answer);
   }

}
