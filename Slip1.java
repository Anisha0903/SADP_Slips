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

public class LowerCaseDecoratorUserInput {
    public static void main(String[] args) {
        System.out.println("Enter your text (Press Enter to finish):");

        try {
            // Take input from keyboard (System.in)
            InputStream in = System.in;

            // Wrap with lowercase decorator
            InputStream lowerIn = new LowerCaseInputStream(in);

            int c;
            System.out.print("Converted to lowercase: ");
            while ((c = lowerIn.read()) != -1) {  
                // Stop if user presses Enter (ASCII 10)
                if (c == '\n') break;
                System.out.print((char) c);
            }

            lowerIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

   
        
