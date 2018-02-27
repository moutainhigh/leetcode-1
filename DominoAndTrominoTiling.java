public class DominoAndTrominoTiling {
	static final int MODULUS = 1000000007;

	public int numTilings(int N) {
		int[][] tilings = new int[N + 1][3];
		tilings[0][0] = 1;
		for (int i = 1; i < tilings.length; i++) {
			tilings[i][0] = addMod(addMod(tilings[i - 1][0], i >= 2 ? tilings[i - 2][0] : 0),
					addMod(tilings[i - 1][1], tilings[i - 1][2]));
			tilings[i][1] = addMod(tilings[i - 1][2], i >= 2 ? tilings[i - 2][0] : 0);
			tilings[i][2] = addMod(tilings[i - 1][1], i >= 2 ? tilings[i - 2][0] : 0);
		}
		return tilings[N][0];
	}

	int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}
}
