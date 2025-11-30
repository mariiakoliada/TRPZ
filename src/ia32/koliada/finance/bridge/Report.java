package ia32.koliada.finance.bridge;

public abstract class Report {
    protected ReportFormat format;

    public Report(ReportFormat format) {
        this.format = format;
    }

    public abstract void buildReport();
}