

public class DisciplinaryFlag implements Eligibility{
    public String check(StudentProfile s){
        StringBuilder reasons = new StringBuilder();
        if(s.disciplinaryFlag != LegacyFlags.NONE) {
            reasons.append("disciplinary flag present");
        } 
        return reasons.toString();
    };
}
