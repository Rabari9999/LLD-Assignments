import java.util.*;

public class OnboardingService {
    private final FakeDb db;
    private final Parsing par;
    private final Validation valid;
    private final Printing print;

    public OnboardingService(FakeDb db,Parsing par,Validation valid,Printing print) { this.db = db; this.par = par;this.valid = valid;this.print = print;}

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        // Map<String,String> kv = new LinkedHashMap<>();
        // String[] parts = raw.split(";");
        // for (String p : parts) {
        //     String[] t = p.split("=", 2);
        //     if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        // }
        Map<String,String> kv = par.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        // List<String> errors = new ArrayList<>();
        // if (name.isBlank()) errors.add("name is required");
        // if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        // if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        // if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");

        // if (!errors.isEmpty()) {
        //     System.out.println("ERROR: cannot register");
        //     for (String e : errors) System.out.println("- " + e);
        //     return;
        // }
        valid.valid(name,email,phone,program);

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        // System.out.println("OK: created student " + id);
        // System.out.println("Saved. Total students: " + db.count());
        // System.out.println("CONFIRMATION:");
        // System.out.println(rec);
        print.print(id,db,rec);
    }
}
