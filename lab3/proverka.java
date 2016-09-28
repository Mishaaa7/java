public class proverka{

	public static void main (String[] args) {
		labw03 test = new labw03();
		
		System.out.println(test.logika(1, -4, 71));
		System.out.println(test.logika(14, 1.25, 8));
		System.out.println(test.logika(1, 1.25, -1));
		
		test.poka(22);
		test.poka(24);
		test.poka(861);
		
		
		double[] mas1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		double[] mas2 = { 0, 1, 2, 3, 4, 3, 2, 7, 8, 9, 10, 11, 2, 13, 14 };
		double[] mas3 = { 0, 0, -1, -10 };
		test.massivy(mas1);
		test.massivy(mas2);
		test.massivy(mas3);
		
		
		
	}
}