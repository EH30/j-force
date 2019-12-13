import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;


class jforce{
    
    public static String md2(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] digestmessage = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, digestmessage);
            String hashtext = b.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digestmessage = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, digestmessage);
            String hashtext = b.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
    }

    public static String sha224(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("sha-224");
            byte[] messagedigest = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, messagedigest);

            String hashtext = b.toString(16);

            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }

            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha256(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("sha-256");
            byte[] messagedigest = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, messagedigest);
            String hashtext = b.toString(16);

            while (hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha384(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("sha-384");
            byte[] messagedigest = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, messagedigest);

            String hashtext = b.toString(16);

            while (hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }

            return hashtext.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
    }
    public static String sha1(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digestmessage = md.digest(str.getBytes());

            BigInteger e = new BigInteger(1, digestmessage);

            String hashtext = e.toString(16);

            while (hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha512(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messagedigest = md.digest(str.getBytes());

            BigInteger b = new BigInteger(1, messagedigest);

            String hashtext = b.toString(16);

            while (hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void combo(int max, char[] chr, String data, String hashed){
        if (data.length() == max){
            //System.out.println(crypto(data) + ": " + hashed + ":" + data);

            if (hashed.trim().equals(md5(data)) | hashed.trim().equals(md5(data).toUpperCase())){
                System.out.println("Type: md5 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(sha1(data)) | hashed.trim().equals(sha1(data).toUpperCase())){
                System.out.println("Type: sha1 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(sha224(data)) | hashed.trim().equals(sha224(data).toUpperCase())){
                System.out.println("Type: sha224 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(sha256(data)) | hashed.trim().equals(sha256(data).toUpperCase())){
                System.out.println("Type: sha256 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(sha384(data)) | hashed.trim().equals(sha384(data).toUpperCase())){
                System.out.println("Type: sha384 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(sha512(data)) | hashed.trim().equals(sha512(data).toUpperCase())){
                System.out.println("Type: sha512 Cracked: " + data);
                System.exit(1);
            }
            else if (hashed.trim().equals(md2(data)) | hashed.trim().equals(md2(data).toUpperCase())){
                System.out.println("Type: md2 Cracked: " + data);
                System.exit(1);
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Hash: ");
        String hashed = input.nextLine();

        System.out.print("Length: ");
        int len = input.nextInt();
        input.close();

        char[] wdlist = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'z', 'y',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z', 'Y', '/', '.',
         ';', '"', ']', '[', '+', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ':', '|', ',', '=', '-', '_', '!', '@', '#', '$', '%', '^', 
         '&', '*', '(' ,')' ,'~', '`', 92, 39};         
         //'\ ', "'",  '`'

        combo(len, wdlist, "", hashed);
        
    }
}
