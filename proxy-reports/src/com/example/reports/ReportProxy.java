package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport report;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // Starter placeholder: intentionally incorrect.
        // Students should remove direct real loading on every call.

                    // authentication
        if(!accessControl.canAccess(user, classification)) 
        {
            System.out.println("Access denied for user : " + user.getName());
        }
        
                    // lazy loading 
        if(report == null)
        {
            report = new RealReport(reportId, title, classification);
        }
        report.display(user);
    }
}
