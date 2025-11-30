package ia32.koliada.finance.bridge;

public class TextFormat implements ReportFormat {
    @Override
    public void generateHeader(String title) {
        System.out.println("########## " + title + " ##########");
    }

    @Override
    public void generateBody(String content) {
        System.out.println(content);
    }

    @Override
    public void generateFooter() {
        System.out.println("##################################");
    }
}