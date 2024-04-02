import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static List<String> monthlyUpComingEnrolment(List<Employee> employees){
        LocalDate firstDayOfNextMonth =  LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth  =   firstDayOfNextMonth.withDayOfMonth(firstDayOfNextMonth.lengthOfMonth());

        return employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e ->e.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth))
                .filter(e -> e.getEmploymentDate().plusYears(5).isAfter(firstDayOfNextMonth))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .map(Employee::toJsonString)
                .collect(Collectors.toList());
    }
    public static List<String> sortByLastNameAndYearlySalaryDescAsJson(List<Employee> employees){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .sorted(Comparator.comparing(Employee::getYearlySalary).reversed())
                .map(Employee::toJsonString)
                .toList();

    }

    public static void main(String[] args) {
        PensionPlan pensionPlan1 = new PensionPlan("EX1089", LocalDate.of(2023,1,17), 100);
        PensionPlan pensionPlan2 = new PensionPlan("SM2307", LocalDate.of(2019,11,4), 1000);

        List<Employee> employees = new ArrayList<>() {
            {
                add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018,1,17), 105945.50, pensionPlan1));
                add(new Employee(2, "Benard", "Shaw",LocalDate.of(2019,4,3), 60000, null));
                add(new Employee(3, "Carly", "Agar", LocalDate.of(2014,5,16), 842000., pensionPlan2));
                add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2019,5,2), 74500.0, null));
            }
        };

        System.out.println(sortByLastNameAndYearlySalaryDescAsJson(employees));
        System.out.println( monthlyUpComingEnrolment(employees));






    }

}
