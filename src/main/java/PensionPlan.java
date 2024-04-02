import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    public String toJsonString(){
        return "{"
                + "\"planReferenceNumber\":\"" + planReferenceNumber + "\","
                + "\"enrollmentDate\":\"" + enrollmentDate + "\","
                + "\"monthlyContribution\":" + monthlyContribution
                + "}";
    }
}
