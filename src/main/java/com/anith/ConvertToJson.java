package com.anith;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConvertToJson {

  public void convert(String csvFileName, String jsonFileName) {
    try {
      BufferedReader br = new BufferedReader(new FileReader(csvFileName));
      BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFileName));

      String[] header = br.readLine().split(",");
      String line;
      while ((line = br.readLine()) != null) {
        String[] columns = line.split(",");
        String json = "{";
        for (int i = 0; i < columns.length; i++) {
          if (i == 2) {
            json += "\"" + "age" + "\":" + calculateAge(columns[i]) + ",";
          } else {
            json += "\"" + header[i] + "\":" + "\"" + columns[i] + "\"" + ",";
          }
        }
        json = json.substring(0, json.length() - 1);
        json += "}";
        writer.write(json + "\n");
      }
      br.close();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private int calculateAge(String dob) throws Exception {
    Date dobDate = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
    Calendar cal = Calendar.getInstance();
    long timeDiff = cal.getTime().getTime() - dobDate.getTime();
    long diff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

    System.out.println(diff);

    return (int) (diff / 365);
  }
}

