package com.anith;


import java.io.IOException;

public class CsvToJsonConvertor {
  public static void main(String[] args) throws IOException {
    String csvFilePath = "C:\\Users\\anith\\OneDrive\\Documents\\CsvFileForProject.csv";
    String jsonFilePath = "C:\\Users\\anith\\OneDrive\\Documents\\CsvFileForProject.json";
    ConvertToJson convertToJson = new ConvertToJson();
    convertToJson.convert(csvFilePath, jsonFilePath);
  }
}