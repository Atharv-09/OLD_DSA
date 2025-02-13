import java.util.*;


class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int ali[] = new int[n];
		int bob[] = new int[n];

		int ali_MaxTimeIndex = 0;
		int bob_MaxTimeIndex = 0;
		for(int i=0;i<n;i++){
			ali[i] = sc.nextInt();

			if(ali[i]>ali[ali_MaxTimeIndex]){
				ali_MaxTimeIndex = i;
			}
		}

		for(int i=0;i<n;i++){
			bob[i] = sc.nextInt();

			if(bob[i]>bob[bob_MaxTimeIndex]){
				bob_MaxTimeIndex = i;
			}
		}

		ali[ali_MaxTimeIndex] = 0;
		bob[bob_MaxTimeIndex] = 0;

		int aliceTotalTime=0,bobTotalTime=0;

		for(int i=0;i<n;i++){

			aliceTotalTime += ali[i];
			bobTotalTime += bob[i];

		}

		if(aliceTotalTime < bobTotalTime){
			System.out.println("ALICE");
		}else if(aliceTotalTime > bobTotalTime){
			System.out.println("BOB");
		}else{
			System.out.println("DRAW");
		}


	}
}


/*

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DSA_Prac
$ java Main
3
4 1 3
2 2 7
DRAW

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DSA_Prac
$ java Main
5
3 1 3 3 4
1 6 2 5 3
ALICE

hp@Atharv-Pc MINGW64 ~/Desktop/C++/DSA/DSA_Prac
$ java Main
5
1 6 2 5 3
3 1 3 3 4
BOB


*/