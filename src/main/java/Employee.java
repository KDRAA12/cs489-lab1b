import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public String toJsonString() {
       return  "{" +
                "\"employeeId\":" + employeeId + "," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"employmentDate\":\"" + employmentDate + "\"," +
                "\"yearlySalary\":" + yearlySalary + "," +
                "\"pensionPlan\":" + (pensionPlan != null ? pensionPlan.toJsonString() : "null") +
                "}";

    }

}
