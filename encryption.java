import java.io.*;
import java.util.*;
public class encryption{
	public static int count = 0;
	//function which will return the kth permutation of a string
    public static String permute(String str, int l, int r,int k, String ans)
    {
		if(ans == ""){
			if (l == r){
				//System.out.println(str);
				count++;
				if(count == k)
					ans = str;
			}
			else
			{
				for (int i = l; i <= r ; i++)
				{
					str = swap(str,l,i);
					ans = permute(str, l+1, r,k,ans);
					str = swap(str,l,i);
				}
			}
		}
		return ans;
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
	public static void main(String args[]){
		int t; //number of test cases
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		char arr[] = new char[26];
		//System.out.println(arr[0]);
		for(int i = 0; i < t; i++){
            String alph = "abcdefghijklmnopqrstuvwxyz";
			sc.nextLine();
			String str = sc.nextLine(); //input string
			String map = sc.nextLine(); //string to be mapped with input
			char res[] = new char[26];
			int iter = 0;
			int len = str.length();
			int k = sc.nextInt(); //Kth permutation
			for(int j = 0; j < len; j++)
            {
                char ch1 = str.charAt(j);
                char ch2 = map.charAt(j);
                res[ch1-97] = ch2;
				int ind = alph.indexOf(ch2);
                if(ind+1 > alph.length())
                    alph = alph.substring(0,ind);
                else
                    alph = alph.substring(0,ind) + alph.substring(ind+1);
				//System.out.println(alph);
            }
			String ans ="";
			count = 0;
            String output = permute(alph,0,alph.length()-1,k,ans);
            //System.out.println(output);
			//System.out.println("encrypte string ");
            for(int j = 0 ; j < 26; j++){
                if(res[j] == '\u0000'){
                    res[j] = output.charAt(iter);
					//System.out.println(output.charAt(iter));
                    iter++;
                }
				System.out.print(res[j]);
			}
			System.out.println("");
		}
	}
}
