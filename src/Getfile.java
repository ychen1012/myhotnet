import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;



public class Getfile {//��д�ļ�����;
	/*
	 * readtoString ���ļ������ڴ棬��String�ĸ�ʽ���д��棻
	 */
	public String readTostring(String filePath,String encoding){//��ȡ�ļ� ���ļ�·���ͱ����ʽ

		File file= new File(filePath);//�µ��ļ��࣬���� �ļ�·����
	Long fileLength = new Long(file.length());//����������
		
		byte[] fileContent = new byte[fileLength.intValue()];//���ַ�����洢�ļ���
		try{
			FileInputStream in =new FileInputStream(file);//�����ļ�
			in.read(fileContent);//���ļ���intValue()���ı����ȣ�
			in.close();//�رն��ļ�
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){//�쳣����
			e.printStackTrace();
		}
		try{
			return new String(fileContent,encoding);//����һ���涨���ַ������String
			
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
		String[] words=s.split("/");//��б�����ָ��ַ�������Ϊ��ԭʹ�ö��ŷָ���ԣ�Ϊ�˱�����ţ�����/���ָ
		for(int i=0;i<words.length;i++){
			ssr.add(words[i]);
		}
		return ssr;//����ArrayList���飻
	}
	
	
	
	
public HashMap getgloss_hash(String path){//����·����Ȼ�󣬷���HashMap������������glossary����ʵ�� ���ʺ���ԭ�Ķ�Ӧ��ϵ��
		
		ArrayList glo =new ArrayList();
		String gloss=new String();
		gloss=new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/glossary.txt", "gbk");
		gloss=gloss.replaceAll("\\s+", "/");//����glossary��txt���д����ո����ԣ�\\s�������ո�
		glo=new Getfile().toarray1(gloss);//ת��ArrayList��glossary;

		HashMap<String,String>dic =new HashMap<String,String>();
		for(int i=0;i<glo.size()/3;i++){
			dic.put(String.valueOf(glo.get(3*i)), new Getfile().mainyiyuan(String.valueOf(glo.get(3*i+2))));
		}//glossary�У��������Ϊ��ÿ�����ڵ�Ϊһ�飬��һ��Ϊ���ʣ��ڶ���Ϊ���ԣ�������Ϊ��ԭ��
		//����ԭ�� ���ʵĶ�Ӧ��ϵ hash��
		return dic;
	}



public HashMap getwhole_hash(String path){//ͬ������whole�ļ���
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
	



public String mainyiyuan(String s){//ȡ����ԭ  ����������������Է�������ԭ
	ArrayList<String>yiyuan =new ArrayList();// ��Ϊÿ���ʵ���ԭ��ֹһ�������ԣ�ֻȡ��һ������ԭ��ÿ�ΰ���ԭ���룬Ȼ��ָ����ArrayList��Ȼ��ֻȡArrayList�ĵ�һ����
	String[] words =s.split(",");
	for(int i=0;i<words.length;i++){
	yiyuan.add(words[i]);
}
	return String.valueOf(yiyuan.get(0));//��������ԭ������~~~~
}
}
