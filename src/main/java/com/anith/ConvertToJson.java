package com.anith;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConvertToJson {
  public void convert(String csvFileName, String jsonFileName) {

    //Read CSV File
    List<List<String>> read = new ArrayList<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(csvFileName));
      BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFileName));

      String line;

      String[] header = br.readLine().split(",");
      System.out.println(header);

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
    long secondsForYear = (60 * 60 * 24 * 365);
    return (int) (timeDiff / secondsForYear);
  }
  //Convert CSV File To Json File

}

