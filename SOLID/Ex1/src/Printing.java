public class Printing {
    public void print(String id , FakeDb db, StudentRecord rec)
    {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
