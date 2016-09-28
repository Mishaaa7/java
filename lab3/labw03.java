public class labw03 implements primer {
	public int count = 0;
	public int sum = 0;
	public double up = 0;
	public int sost = 0;
	
	     
	public double logika (double d1, double d2, double d3) {
		if (d1<0 || d2<0 || d3<0) return 0;
		else return 1;
	}
	public void poka(int N) {
		System.out.println("Chislo: "+N);
		while (N > 1) {
			sum+=N%10;
			N=(N/10)-(N%10)/10;
			count++;
		}
		System.out.println("Summa cifr: "+sum);
		System.out.println("Kolichestvo cifr: "+count);
		count = 0;
		sum = 0;
	}
	
	public void massivy(double[] A) {
		for (int i = 0; i < (A.length-1); i++) {
			while (A[i] < A[i+1]) {
				if (i<13) i++;
				else break;
				sost = 1;
			}
			if (sost == 1) {
				up++;
				sost = 0;
			}
		}
		System.out.println("Functcia vozrastaet " + up +"raz");
		up = 0;
		sost = 0;
	}
}