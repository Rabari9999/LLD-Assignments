public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        Cgr cg = new Cgr();
        CreditsEarned ce = new CreditsEarned();
        DisciplinaryFlag df = new DisciplinaryFlag();
        Attandance at = new Attandance();
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), cg , ce , at, df);
        engine.runAndPrint(s);
    }
}
