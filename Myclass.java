import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;
import java.util.*;


public class Myclass {


public static void encryption()
throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
{

try
{
Cipher cipher=Cipher.getInstance("DES");
KeyGenerator keyg=KeyGenerator.getInstance("DES");
Key key=keyg.generateKey();
 
cipher.init(Cipher.ENCRYPT_MODE, key); 
Scanner inScanner = new Scanner(System.in);
inScanner.useDelimiter("\\r\\n");
System.out.print("Enter input file path and name:");
String inFile = inScanner.next();
System.out.println("You have entered : " + inFile);           
FileInputStream fs = new FileInputStream(inFile); // FAILED HERE
CipherInputStream cipt=new CipherInputStream(new FileInputStream(new File(inFile)), cipher);
System.out.println("Present Working Directory (PWD) : " + System.getProperty("user.dir"));
System.out.println("Check PWD for ENCRYPTED and DECRYPTED IMAGES.");
FileOutputStream fileip=new FileOutputStream(new File("./encrypt.png"));

int i;
while((i=cipt.read())!=-1)
{
fileip.write(i);

}



cipher.init(Cipher.DECRYPT_MODE, key);
  
CipherInputStream ciptt=new CipherInputStream(new FileInputStream(new File("./encrypt.png")), cipher);

FileOutputStream fileop=new FileOutputStream(new File("./decrypt.png"));

int j;
while((j=ciptt.read())!=-1)
{
fileop.write(j);
}




}
catch(Exception e)
{
e.printStackTrace();
}


}





public static void main(String[] args)
{
try
{
Myclass.encryption(); 

}catch(Exception e)
{
e.printStackTrace();
}

}
}