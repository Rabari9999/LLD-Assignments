
public class Cgr implements Eligibility{
    public String check(StudentProfile s){
        StringBuilder reasons = new StringBuilder();
        if (s.cgr < 8.0) {
            reasons.append("CGR below 8.0");
        }
        return reasons.toString();
    };
}
