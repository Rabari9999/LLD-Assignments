
public class CreditsEarned implements Eligibility{
    public String check(StudentProfile s){
        StringBuilder reasons = new StringBuilder();
        if (s.earnedCredits < 20) {
            reasons.append("credits below 20");
        }
        return reasons.toString();
    };
}
