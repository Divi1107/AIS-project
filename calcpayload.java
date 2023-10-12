package Payload;
import java.util.*;

public class calcpayload {
    public static void pay(String payload)
    {
        //covert payload str to char array
        /*convert character to ascii
        To recover the six bits, subtract 48 from the ASCII character value; if the result is greater than 40 subtract 8.begin with "0" (64) and end with "W" (87); however, the intermediate range "X" (88) to "\_" (95) is not used.
        length of payload = 28 char, bits =168 bits*/
        char payloadChar[] = payload.toCharArray();
        if(payloadChar.length!=28)
        {
            System.out.println("Message is not of type 1,2 or 3.Try other message");
            System.exit(0);
        }
    try
    {
        int payloadAscii[] = new int[payloadChar.length];
        int payloadDec[] = new int[payloadChar.length];
        String payloadBin="";
        for(int i=0;i<payloadChar.length;i++)
        {
            payloadAscii[i] =(int)payloadChar[i];
            payloadDec[i] = payloadAscii[i]-48;
            if (payloadDec[i]>40)
            payloadDec[i]=payloadAscii[i]-48-8;
        }
        //decimal to 6 bit binary  
        String bin6;
        for(int i=0;i<payloadDec.length;i++)
        { 
           String bin = Integer.toBinaryString(payloadDec[i]);
           char paddingCharacter = '0'; 
          if (bin.length() <= 6) {
              int paddingLength = 6 - bin.length();
              String padding = new String(new char[paddingLength]).replace('\0', paddingCharacter);
              bin6 = padding + bin;             
             // System.out.println(bin6); append bin6 to payloadbin
             payloadBin=payloadBin+bin6;
      } 
    }
    } 
    catch (Exception e)
        {
          System.out.println(e);
        }
}
}