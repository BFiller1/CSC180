package exercises.seven;

public class Padding {

	char endOfText = 0x1e;
	public String pad(Object obj, int len){

		String str = obj.toString();
		
//		if(len < str.length()){
			StringBuilder sb = new StringBuilder(str);
			if(len > sb.length()){
				while(len > sb.length()){
					sb.append(endOfText);
				}
				str = sb.toString();
//				System.out.println(str);
			}
			else{
					str = sb.substring(0, len);
//					System.out.println(str);
			}
			str = sb.toString();
			return str;
	}
	public Object unpad(String str){
		str = str.replaceAll("0x1e", "");
//		str.replace('-', ' ');
//		System.out.println(str);
		return str;
	}
}
