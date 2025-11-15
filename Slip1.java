import java.io.*;

// Custom Decorator Class
class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        if (result != -1) {
            for (int i = offset; i < offset + result; i++) {
                b[i] = (byte) Character.toLowerCase((char) b[i]);
            }
        }
        return result;
    }
}

public class LowerCaseDecoratorDemo {
    public static void main(String[] args) {
        String input = "HELLO JAVA DECORATOR PATTERN!";

        byte[] inputBytes = input.getBytes();

        try {
            InputStream in = new ByteArrayInputStream(inputBytes);
            InputStream lowerIn = new LowerCaseInputStream(in);

            int c;
            System.out.println("Converted Output:");
            while ((c = lowerIn.read()) != -1) {
                System.out.print((char) c);
            }

            lowerIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
