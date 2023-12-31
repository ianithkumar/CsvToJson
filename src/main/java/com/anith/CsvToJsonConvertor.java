package com.anith;


public class CsvToJsonConvertor {

  public static void main(String[] args) {
    String csvFilePath = "C:\\Users\\anith\\OneDrive\\Documents\\CsvFileForProject.csv";
    String jsonFilePath = "C:\\Users\\anith\\OneDrive\\Documents\\CsvFileForProject.json";
    ConvertToJson convertToJson = new ConvertToJson();
    convertToJson.convert(csvFilePath, jsonFilePath);
  }
}