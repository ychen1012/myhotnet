import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






public class Tree {
//树 类;
		private List<Node> list = new ArrayList<Node>();//node类型的数组 List

		class Node {//节点类
		String data;//数据子节点
		String parent;//父节点
		}
		public void add(String parent, String child) {//添加新的节点
		Node n = new Node();
		n.data = child;
		n.parent = parent;
		list.add(n);
		}
		/**
		* 获取父节点
		*/
		public String getParent(String x) {//get 父亲节点
		for (int i = 0; i < list.size(); i++) {//循环
		if (list.get(i).data.equals(x)) {// 比较内容
		return list.get(i).parent;//返回父亲节点
		}
		}
		return null;
		}
		public List<String> getChild(String x) {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
		if (list.get(i).parent.equals(x)) {
		newList.add(list.get(i).data);
		}
		}
		return newList;
		}
		public int distance(Tree t,String x,String y) {
		int distance=0;
		for (int i = 0; i < t.getChild(x).size(); i++) {
		if (t.getChild(x).toString().contains(y)) {
		distance=1;
		break;
		}
		else {
		String city=t.getChild(x).get(i);
		int z=distance(t,t.getChild(x).get(i),y);
		if (z!=0) {//这里判断下，如果先前有节点已经包含了就跳出来
		distance=z+1;
		break;
		}
		}
		}
		return distance;
		}

		
		public int lengths(String id1,String id2){
			
			Tree a = new Tree();
			String ss;
			ArrayList words;
			ss = new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/WHOLE.txt", "utf-8");
			ss=ss.replaceAll("\\s+", ",");
			words =new Getfile().toarray(ss);//原始数组;
			words.remove(0);
			ArrayList Treelist =new ArrayList();
			for(int i=0;i<words.size()/3;i++){
				Treelist.add(String.valueOf(words.get(3*i+0)).trim());
				Treelist.add(String.valueOf(words.get(3*i+2)).trim());
			}
			for(int i=0;i<Treelist.size()/2-1;i++){
				if (Treelist.get(2*i+1).equals(Treelist.get(2*i)))
						{
					Treelist.set(2*i+1, "root");
						}
			}
			ArrayList hashmap1=new ArrayList();//hash匹配用数组；
			for(int i=0;i<words.size()/3;i++){
				hashmap1.add(words.get(3*i+0));
				hashmap1.add(words.get(3*i+1));
			}
			for(int i=0;i<Treelist.size()/2;i++){
				a.add(String.valueOf(Treelist.get(2*i+1)).trim(),String.valueOf(Treelist.get(2*i+0)).trim());
				//a.add("1", "0");
				//a.add("2", "1");
			}
			HashMap<String,String>map=new HashMap<String,String>();
			for(int i=0;i<hashmap1.size()/2;i++){
				map.put(String.valueOf(hashmap1.get(2*i+1)),String.valueOf(hashmap1.get(2*i)));
			}
			HashMap<String,String>glos=new HashMap();
			glos =new Getfile().getgloss_hash("1111");
			
			
			id1=map.get(glos.get(id1));
			id2=map.get(glos.get(id2));
			ArrayList<String>id1s=new ArrayList();
			ArrayList<String>id2s=new ArrayList();
			HashMap<String,Integer>id1h=new HashMap();
			HashMap<String,Integer>id2h=new HashMap();
			while(!a.getParent(id1).equals("root")){
				id1=a.getParent(id1);
				id1s.add(id1);
			}
			id1s.add("root");
			while(!a.getParent(id2).equals("root")){
				id2=a.getParent(id2);
				id2s.add(id2);
			}
			id2s.add("root");
			for(int i=0;i<id1s.size();i++){
				id1h.put(String.valueOf(id1s.get(i)),i+1 );
			}
			for(int i=0;i<id2s.size();i++){
				id2h.put(String.valueOf(id2s.get(i)),i+1 );
			}
			int i=0;
			while(!id2s.contains(id1s.get(i))&&i<=id1s.size()-1){
				i=i+1;
			}
			int number1 =i;
			int number2 =id2h.get(id1s.get(i));
			return number1+number2;
			
		}


		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree a = new Tree();
		String ss;
		ArrayList words;
		ss = new Getfile().readTostring("D:/JAVA/ECLIPSE/demo/src/tree/WHOLE.txt", "utf-8");
		ss=ss.replaceAll("\\s+", ",");
		words =new Getfile().toarray(ss);//原始数组;
		words.remove(0);
		ArrayList Treelist =new ArrayList();
		for(int i=0;i<words.size()/3;i++){
			Treelist.add(String.valueOf(words.get(3*i+0)).trim());
			Treelist.add(String.valueOf(words.get(3*i+2)).trim());
		}
		for(int i=0;i<Treelist.size()/2-1;i++){
			if (Treelist.get(2*i+1).equals(Treelist.get(2*i)))
					{
				Treelist.set(2*i+1, "root");
					}
		}
		ArrayList hashmap1=new ArrayList();//hash匹配用数组；
		for(int i=0;i<words.size()/3;i++){
			hashmap1.add(words.get(3*i+0));
			hashmap1.add(words.get(3*i+1));
		}
		for(int i=0;i<Treelist.size()/2;i++){
			a.add(String.valueOf(Treelist.get(2*i+1)).trim(),String.valueOf(Treelist.get(2*i+0)).trim());
			//a.add("1", "0");
			//a.add("2", "1");
		}
		HashMap<String,String>map=new HashMap<String,String>();
		for(int i=0;i<hashmap1.size()/2;i++){
			map.put(String.valueOf(hashmap1.get(2*i+1)),String.valueOf(hashmap1.get(2*i)));
		}
		HashMap<String,String>glos=new HashMap();
		
}
}
