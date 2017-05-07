import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;



public class Getfile {
	/*
	 * readtoString ���ļ������ڴ棬��String�ĸ�ʽ���д��棻
	 */
	public String readTostring(String filePath,String encoding){//��ȡ�ļ� ���ļ�·���ͱ����ʽ

		File file= new File(filePath);
	Long fileLength = new Long(file.length());
		
		byte[] fileContent = new byte[fileLength.intValue()];
		try{
			FileInputStream in =new FileInputStream(file);
			in.read(fileContent);//���ļ���intValue()���ı����ȣ�
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
	 * toarray ��String�ָ�ɵ��ʴ���ArrayList����,�ָ��ı�;���ڷָ�whole.txt
	 * String s ��Ҫ���� 
	 */
	public ArrayList toarray(String s){//��,���ָ��ı���ת��ArrayList��ʽ��
		ArrayList<String> ssr=new ArrayList();
		String[] words= s.split(",");
		for(int i=0;i<words.length;i++){
			
			ssr.add(words[i]);
		}
		return ssr;
		
	}
	
	/*
	 * toarray1 ��String�ָ�ɵ��ʴ���ArrayList����/�ָ��ı������ڷָ�glossary.txt
	 */
	public ArrayList toarray1(String s){//����glossary.txt
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
		glo=new Getfile().toarray1(gloss);//ת��ArrayList��glossary;

		HashMap<String,String>dic =new HashMap<String,String>();
		for(int i=0;i<glo.size()/3;i++){
			dic.put(String.valueOf(glo.get(3*i)), new Getfile().mainyiyuan(String.valueOf(glo.get(3*i+2))));
		}
		
		return dic;
	}



public HashMap getwhole_hash(String path){
	String s =new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/WHOLE.txt", "utf-8");
	ArrayList f=new Getfile().toarray(s);
f.remove(0);//ԭʼ���飻
ArrayList g = new ArrayList(); //�����������飻
for(int i=0;i<f.size()/3-1;i++){
	g.add(f.get(3*i+0).toString());
	g.add(f.get(3*i+2).toString());
}
ArrayList hashmap =new ArrayList();//hashmap ArrayList ���� hashmapƥ������飻
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
	



public String mainyiyuan(String s){//ȡ����ԭ
	ArrayList<String>yiyuan =new ArrayList();
	String[] words =s.split(",");
	for(int i=0;i<words.length;i++){
	yiyuan.add(words[i]);
}
	return String.valueOf(yiyuan.get(0));
}
}
