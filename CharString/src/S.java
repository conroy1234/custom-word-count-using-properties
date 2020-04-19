
public class S {

	public static void main(String[] args) {
		System.out.println(new S().getNumber("coalcad", 'c'));
	}
	
	
public int getNumber(String str,char c) {	
	int index =0;
	
	for(int i=0;i<str.length();i++) {
		
		if(str.charAt(i)==c) {
			index++;
		}
	}
	String result = str.replace(""+c, ""+index);
	
	System.out.println(result);
	
	return index;
}
}
