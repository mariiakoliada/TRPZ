package ia32.koliada.finance.bridge;

public interface ReportFormat {
    void generateHeader(String title);
    void generateBody(String content);
    void generateFooter();
}