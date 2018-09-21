package gui.awt;

import static java.lang.Thread.sleep;

public class AwtRunner {
    public static void main(String[] args) throws Exception {
        new MyWindow().showWindowDemo();
        sleep(4000);
    }
}
