package demo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

public class Hello {

    public static void main(String[] args) throws IOException {
        readAsStream();
        readAsUrl();
    }

    private static void readAsStream() throws IOException {
        System.out.println("------------ readAsStream -------------");
        InputStream stream = Hello.class.getClassLoader().getResourceAsStream("data.txt");
        String content = IOUtils.toString(stream, Charset.defaultCharset());
        System.out.println(content);
    }

    private static void readAsUrl() throws IOException {
        System.out.println("------------ readAsUrl -------------");
        URL resource = Hello.class.getClassLoader().getResource("data.txt");
        System.out.println("resource: " + resource);
        System.out.println("resource.toExternalForm(): " + resource.toExternalForm());

        String content = IOUtils.toString(new URL(resource.toExternalForm()), Charset.defaultCharset());
        System.out.println(content);
    }

}
