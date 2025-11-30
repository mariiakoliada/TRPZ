package ia32.koliada.finance.bridge;

public class PdfFormat implements ReportFormat {
    @Override
    public void generateHeader(String title) {
        System.out.println("[PDF] --- " + title + " ---");
    }

    @Override
    public void generateBody(String content) {
        System.out.println("[PDF] Content: " + content);
    }

    @Override
    public void generateFooter() {
        System.out.println("[PDF] --- End of Document ---");
    }
}