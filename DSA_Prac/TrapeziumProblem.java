class Main{


	static void printTrap(int n){

	int num = 1;

	int fHalf = 1;
	int sHal = n*n+1;

		for(int totalLine=n;totalLine>=1;totalLine--){

			for(int sp=n;sp>totalLine;sp--){
				System.out.print(" ");
			}

			for(int leftHalfC=1;leftHalfC<=totalLine;leftHalfC++){

				if(leftHalfC==totalLine){
					System.out.print(fHalf);
				}else
					System.out.print(fHalf+"*");

				fHalf++;
			}

			for(int rightHalfC=1;rightHalfC<=totalLine;rightHalfC++){

				System.out.print("*"+sHal);
				sHal++;

			}
			// as it incrmented the shalf by 1 more 
			sHal--;

			sHal = sHal-(totalLine-1)*2; 
			System.out.println();

		}
	}
	public static void main(String[] args) {
		
		printTrap(4);
	}
}