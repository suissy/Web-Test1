package webadv.s16201502.p02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

/**Web高级编程第一次实验
 * 本模块用于测试登录账户和密码
 * 使用io流读取文件账户和密码，账户以明文形式存储，密码以hex256加密形式存储
 * maven执行指令顺序为：
 * 编译：mvn compile
 * 运行：mvn exec:java
 * @author 16201502-袁湾
 * @version 1.0
 * @since 2019/5/17
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException, FileNotFoundException
    {
    	/*FileOutputStream fop=new FileOutputStream(new File("account.txt"));
    	byte[] bs=("system\r\n").getBytes();
    	try {
			fop.write(bs);
			bs=sha256hex("123456").getBytes();
			fop.write(bs);
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}*/
    	System.out.println("Hello World!");//测试
    	Scanner input=new Scanner(System.in);
//    	if (args.length < 1) {
//            System.err.println("Please provide an input!");
//            System.exit(0);
//        }
    	System.out.print("account: ");
    	String account=input.nextLine();
    	System.out.print("password: ");
    	String password=sha256hex(input.nextLine());
    	System.out.println(password);
    	try {
    		//fop.flush();
			login(account,password);
			//fop.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        //System.out.println(sha256hex());
    }
    public static void login(String account,String password) throws IOException {
		InputStream fis=new FileInputStream(new File("account.txt"));
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		String a;
		String[] bStrings=new String[2];
		int index=0;
		while ((a=br.readLine())!=null) {//按行读取
			bStrings[index]=a;
			bStrings[index].trim();
			//System.out.println(bStrings[index]);//测试
			index++;
		}
		if (bStrings[0].equals(account)&&bStrings[1].equals(password)) {
			System.out.println("success!");
		}else {
			System.out.println("error!");
		}
	}
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

}
