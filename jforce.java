import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.math.BigInteger;


class jforce{
    
    public static String os = System.getProperty("os.name").toLowerCase();

    public static String crypto(String str, String hashing){
        try {
            MessageDigest md = MessageDigest.getInstance(hashing);
            byte[] digestmessage = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, digestmessage);
            String hashtext = b.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public static void combo(int max, char[] chr, String data, String hashed){
        if (data.length() == max){
            //System.out.println(crypto(data) + ": " + hashed + ":" + data);
            System.out.print(String.format("\r \u001B[36m Trying: %s  Lngth: %d \u001B[0m", data, max));
            if (hashed.trim().equals(crypto(data, "MD5")) | hashed.trim().equals(crypto(data, "MD5").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: MD5 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "SHA1")) | hashed.trim().equals(crypto(data, "SHA1").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: SHA1 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "SHA-224")) | hashed.trim().equals(crypto(data, "SHA-224").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: SHA-224 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "SHA-256")) | hashed.trim().equals(crypto(data, "SHA-256").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: SHA-256 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "SHA-384")) | hashed.trim().equals(crypto(data, "SHA-384").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: SHA-384 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "SHA-512")) | hashed.trim().equals(crypto(data, "SHA-512").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: SHA-512 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }
            else if (hashed.trim().equals(crypto(data, "MD2")) | hashed.trim().equals(crypto(data, "MD2").toUpperCase())){
                System.out.println(String.format("\u001B[36m Type: MD2 Cracked: %s \u001B[0m", data));
                System.exit(0);
            }

        }else{
            for (int x=0; x < chr.length; x++){
                String oldData = data;
                data += chr[x];
                combo(max, chr, data, hashed);
                data = oldData;
                

            }   
        }
    }

    public static void clear_console(){
        try {
            if(oswindows()){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else if(oslinux()){
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }


    public static void main(String[] args) {
        clear_console();

        try {
            int len = Integer.parseInt(args[0]);
            String hashed = args[1];

            char[] wdlist = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'z', 'y',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z', 'Y', '/', '.',
            ';', '"', ']', '[', '+', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ':', '|', ',', '=', '-', '_', '!', '@', '#', '$', '%', '^', 
            '&', '*', '(' ,')' ,'~', '`', 92, 39};
            //'\ ', "'",  '`'
            
            combo(len, wdlist, "", hashed);
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Usage: java jforce [Length] [Hash]");
        }    
    }
    public static boolean oswindows(){return os.contains("windows") | os.contains("win");}
    public static boolean oslinux(){return os.contains("linux") | os.contains("unix");}
}
