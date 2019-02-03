package fileParsing;

public class Employee {

  String name;
  int age;
  String companyName;

  public Employee(String name, int age, String companyName) {
    this.name = name;
    this.age = age;
    this.companyName = companyName;
  }

  public String toString() {
    return "Employee[ name = " + name + ", age = " + age + ", companyName =" + companyName + "]";
  }
}
