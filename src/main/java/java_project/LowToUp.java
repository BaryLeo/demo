package java_project;

import java.io.*;

/**
 * 将文本中的字母全部转换成大写
 */
public class LowToUp {
    public void exchange() throws IOException {
        String s ="";
        File file = new File("C:\\Users\\Leo\\Desktop\\mycode.asm");
        InputStreamReader in = null;
        BufferedReader br = null;
        StringBuilder content = null;
        try {
            in = new InputStreamReader(new FileInputStream(file),"UTF-8");
            br = new BufferedReader(in);
            content = new StringBuilder();
            while ((s=br.readLine())!=null){
                content = content.append(s+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            br.close();
        }
        String res = content.toString().toUpperCase();
        System.out.println(res);

        FileOutputStream outputStream = null;
        try {
            File nfile = new File("C:\\Users\\Leo\\Desktop\\微机实验\\3117003911_刘家杰\\刘家杰_实验一\\a.asm");
            //创建文件
            nfile.createNewFile();
            outputStream = new FileOutputStream(nfile);
            outputStream.write(res.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
