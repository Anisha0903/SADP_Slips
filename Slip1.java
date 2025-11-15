import java.io.*;

// Decorator Class
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

public class Slip1 {
    public static void main(String[] args) throws IOException {

        System.out.print("Enter your text: ");

        // Step 1: Read full user input line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();

        // Step 2: Convert it into bytes
        ByteArrayInputStream byteIn = new ByteArrayInputStream(userInput.getBytes());

        // Step 3: Wrap with your decorator
        LowerCaseInputStream lowerIn = new LowerCaseInputStream(byteIn);

        System.out.print("Converted to lowercase: ");

        int c;
        while ((c = lowerIn.read()) != -1) {
            System.out.print((char) c);
        }

        lowerIn.close();
    }
}
 
            
    
