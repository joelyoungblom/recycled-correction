package recycledcorrection;

public class Main {
    public Main() { }
    public static void main(String[] args) {
        RecycleCorrector rc = new RecycleCorrector();
        RecycleCorrectorGUI rcg = new RecycleCorrectorGUI(rc);
    }
}
