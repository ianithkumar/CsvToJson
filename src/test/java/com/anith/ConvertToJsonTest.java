package com.anith;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConvertToJsonTest {

  @Test
  public void calculateAgeTest() throws Exception {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date dobDate = simpleDateFormat.parse("01-01-2000");
    Date currDate = simpleDateFormat.parse("31-12-2023");
    long timeDiff = currDate.getTime() - dobDate.getTime();
    long diff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
    Assert.assertEquals(24, diff / 365);
  }
}
