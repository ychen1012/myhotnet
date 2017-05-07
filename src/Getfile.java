import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;



public class Getfile {
	/*
	 * readtoString 将文件读入内存，以String的格式进行储存；
	 */
	public String readTostring(String filePath,String encoding){//读取文件 ，文件路径和编码格式

		File file= new File(filePath);
	Long fileLength = new Long(file.length());
		
		byte[] fileContent = new byte[fileLength.intValue()];
		try{
			FileInputStream in =new FileInputStream(file);
			in.read(fileContent);//读文件，intValue()即文本长度；
			in.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			return new String(fileContent,encoding);
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			System.err.println("????????");
			return null;
		}
	}
	
	
	/*
	 * toarray 将String分割成单词存入ArrayList，用,分割文本;用于分割whole.txt
	 * String s 需要先用 
	 */
	public ArrayList toarray(String s){//用,来分割文本，转成ArrayList格式；
		ArrayList<String> ssr=new ArrayList();
		String[] words= s.split(",");
		for(int i=0;i<words.length;i++){
			
			ssr.add(words[i]);
		}
		return ssr;
		
	}
	
	/*
	 * toarray1 将String分割成单词存入ArrayList，用/分割文本，用于分割glossary.txt
	 */
	public ArrayList toarray1(String s){//处理glossary.txt
		ArrayList<String>ssr=new ArrayList();
		String[] words=s.split("/");
		for(int i=0;i<words.length;i++){
			ssr.add(words[i]);
		}
		return ssr;
	}
	
	
	
	
public HashMap getgloss_hash(String path){
		
		ArrayList glo =new ArrayList();
		String gloss=new String();
		gloss=new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/glossary.txt", "gbk");
		gloss=gloss.replaceAll("\\s+", "/");
		glo=new Getfile().toarray1(gloss);//转成ArrayList的glossary;

		HashMap<String,String>dic =new HashMap<String,String>();
		for(int i=0;i<glo.size()/3;i++){
			dic.put(String.valueOf(glo.get(3*i)), new Getfile().mainyiyuan(String.valueOf(glo.get(3*i+2))));
		}
		
		return dic;
	}



public HashMap getwhole_hash(String path){
	String s =new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/WHOLE.txt", "utf-8");
	ArrayList f=new Getfile().toarray(s);
f.remove(0);//原始数组；
ArrayList g = new ArrayList(); //构建树的数组；
for(int i=0;i<f.size()/3-1;i++){
	g.add(f.get(3*i+0).toString());
	g.add(f.get(3*i+2).toString());
}
ArrayList hashmap =new ArrayList();//hashmap ArrayList 用于 hashmap匹配的数组；
for(int i=0;i<f.size()/3-1;i++){
	hashmap.add(f.get(3*i+0));
	hashmap.add(f.get(3*i+1));
}
HashMap<String,String>map=new HashMap<String,String>();
for(int i=0;i<hashmap.size()/2;i++){
	map.put(String.valueOf(hashmap.get(2*i+1)),String.valueOf(hashmap.get(2*i)));
}
return map;
}
	



public String mainyiyuan(String s){//取主义原
	ArrayList<String>yiyuan =new ArrayList();
	String[] words =s.split(",");
	for(int i=0;i<words.length;i++){
	yiyuan.add(words[i]);
}
	return String.valueOf(yiyuan.get(0));
}
}
