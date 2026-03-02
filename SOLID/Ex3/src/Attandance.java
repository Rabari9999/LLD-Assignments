public class Attandance implements Eligibility {
    @Override
    public String check(StudentProfile s){
        //apply attendance logic
        StringBuilder sb = new StringBuilder();
        if(s.attendancePct < 75) {
            sb.append("attendance below 75");
        }
        return sb.toString();
    }

}
