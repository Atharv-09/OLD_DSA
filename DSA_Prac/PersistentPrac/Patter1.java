

class Main{


	static void find(int n){


		for(int i=0;i<n;i++){

			for(int sp=2*(n-i);sp>=0;sp--){

				System.out.print(" ");
			}

			for(int j=0;j<=i;j++){
				System.out.print(" *");
			}

			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		find(5);
	}
}