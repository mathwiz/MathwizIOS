package gui.awt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AwtRunner {
    public static void main(String[] args) throws IOException {
        new MyWindow().showWindowDemo();
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
