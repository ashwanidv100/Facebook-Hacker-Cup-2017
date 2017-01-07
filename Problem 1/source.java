import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Problem1 {
	
	public static void main(String[] args) throws Exception {
		
		String FILENAME = "input1.txt"; // Files should be in root
		
		BufferedReader br = null;
		FileReader fr = null;

		fr = new FileReader(FILENAME);
		br = new BufferedReader(fr);

		br = new BufferedReader(new FileReader(FILENAME));
		
		int nbOfCases = Integer.parseInt(br.readLine());
		String currentCase = br.readLine();
		String output = "";
		
		for (int i = 0; i < nbOfCases; i++, currentCase = br.readLine()) {
			int P, X, Y;
			String[] exploded = currentCase.split(" ");
			
			P = Integer.parseInt(exploded[0]);
			X = Integer.parseInt(exploded[1]);
			Y = Integer.parseInt(exploded[2]);
			
			if (circleContains(P, X, Y)) {
				output += "Case #" + (i+1) + ": black\n";
			} else {
				output += "Case #" + (i+1) + ": white\n";
			}
		}
		
		System.out.print(output.substring(0, output.length() - 1));
		br.close();
	}
	
	static boolean circleContains(int P, int X, int Y) {
		if (P == 0)
			return false;
		
		// Outside the circle if the distance from the center to the point is greater than r
		if (Math.sqrt(Math.pow(50 - X, 2) + Math.pow(50 - Y, 2)) > 50)
			return false;

		// Inside if angle between the point and the center (> 0 && < P)
		double angle = get360Degree(Math.toDegrees(Math.atan2(Y - 50, X - 50)));
		double percent = (angle * 100) / 360;
		if (percent > P)
			return false;
		
		return true;
	}
	
	static double get360Degree(double angle) {
		if (angle < 0)
			return 180 + 180 + angle;
		return angle;
	}
	
	

}

