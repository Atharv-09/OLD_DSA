import java.util.*;


class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();


		if((a+b+c) != (x+y)){
			System.out.println("NO");
		}else{


			if(Math.min(Math.min(a,b),c) > y || Math.min(Math.min(a,b),c) > x){
				System.out.println("No");
			}else{
				System.out.println("YES");
			}
		}

	}
}