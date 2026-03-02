import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final Cgr cgr;
    private final CreditsEarned creditsEarned;
    private final Attandance attandance;
    private final DisciplinaryFlag displinaryFlag;

    public EligibilityEngine(FakeEligibilityStore store,Cgr cgr,CreditsEarned creditsEarned,Attandance attandance, DisciplinaryFlag disciplinaryFlag) 
            { this.store = store; this.cgr = cgr; this.creditsEarned = creditsEarned ; this.attandance = attandance ; this.displinaryFlag = disciplinaryFlag;}


    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        reasons.add(cgr.check(s));
        reasons.add(displinaryFlag.check(s));
        reasons.add(attandance.check(s));
        reasons.add(creditsEarned.check(s));


        // // OCP violation: long chain for each rule
        // if (s.disciplinaryFlag != LegacyFlags.NONE) {
        //     status = "NOT_ELIGIBLE";
        //     reasons.add("disciplinary flag present");
        // } else if (s.cgr < 8.0) {
        //     status = "NOT_ELIGIBLE";
        //     reasons.add("CGR below 8.0");
        // } else if (s.attendancePct < 75) {
        //     status = "NOT_ELIGIBLE";
        //     reasons.add("attendance below 75");
        // } else if (s.earnedCredits < 20) {
        //     status = "NOT_ELIGIBLE";
        //     reasons.add("credits below 20");
        // }
        if(!reasons.isEmpty()){
            status = "NON_ELIGIBLE";
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}