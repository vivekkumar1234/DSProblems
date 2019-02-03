package fileParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StdIn {

  /**
   * @param strings
   * @throws FileNotFoundException 
   */
  public static void main(String... strings) throws FileNotFoundException {
    File f = new File("C:\\project\\Practise\\src\\fileParsing\\test.txt");
    List<Employee> employeeList = new ArrayList<>();
    try (Scanner sc = new Scanner(f)) {
      while (sc.hasNext()) {
        String str = sc.next();
        employeeList.add(createEmployee(str));
      }
    }
    employeeList.parallelStream().forEach(System.out::println);

  }

  public static Employee createEmployee(String str) {
  /*  Scanner sc = new Scanner(str);
    sc.useDelimiter("[\\s*,\\s*]");
    String name = sc.next();
    int age = sc.nextInt();
    String companyName = sc.hasNext() ? sc.next() : "";
    Employee emp = new Employee(name, age, companyName);
    sc.close();*/
    String[] strArr = str.split("[\\s,\\s]");
    if(Str)
    String name = str
    int age = sc.nextInt();
    String companyName = sc.hasNext() ? sc.next() : "";
    Employee emp = new Employee(name, age, companyName);
    Employee emp = new Employee(name, age, companyName);
    return emp;
  }

}
