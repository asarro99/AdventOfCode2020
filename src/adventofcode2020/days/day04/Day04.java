package adventofcode2020.days.day04;

import adventofcode2020.templates.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day04 extends Day {
  private List<Passport> passportList;
  private int validPassports;

  @Override
  protected Result evaluate() {
    return new Result(resolveFirst(), resolveSecond());
  }

  private int resolveFirst() {
    PassportPopulator();
    for (Passport pass : passportList) {
      if (pass.isValidPartOne()) validPassports = validPassports + 1;
    }
    return validPassports;
  }

  private int resolveSecond() {
    PassportPopulator();

    for (Passport pass : passportList) {
      if (pass.isValidPartTwo()) validPassports++;
    }
    return validPassports;
  }

  private void PassportPopulator() {
    Passport passport = new Passport();
    passportList = new ArrayList<>();
    validPassports = 0;
    passportList.add(passport);

    for (String line : lines) {
      if (line.isBlank()) {
        passport = new Passport();
        passportList.add(passport);
        continue;
      }
      String[] lineData = line.split(" ");

      for (String lineD : lineData) {
        String[] data = lineD.split(":");
        passport.addPassportData(data[0], data[1]);
      }
    }
  }

  private static class Passport {
    private final HashMap<String, String> passportData = new HashMap<>();

    public void addPassportData(String key, String value) {
      this.passportData.put(key, value);
    }

    public boolean isValidPartOne() {
      if (passportData.keySet().size() == 7 && !passportData.containsKey("cid")) return true;
      return passportData.keySet().size() == 8;
    }

    public boolean isValidPartTwo() {
      if ((passportData.keySet().size() != 7 || passportData.containsKey("cid"))
          && passportData.keySet().size() != 8) return false;

      if (!passportData.get("byr").matches("^(200[0-2]|19[2-9][0-9])$")) return false;
      if (!passportData.get("iyr").matches("^(2020|201[0-9])$")) return false;
      if (!passportData.get("eyr").matches("^(2030|202[0-9])$")) return false;
      if (!passportData.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$"))
        return false;
      if (!passportData.get("hcl").matches("^(#[0-9a-f]{6})$")) return false;
      if (!passportData.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")) return false;
      return passportData.get("pid").matches("^[0-9]{9}$");
    }
  }
}
