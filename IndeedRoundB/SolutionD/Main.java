package SolutionD;


import java.io.*;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = null;

	private static int findLowerHuts(int[] huts, int index, int hi, int step){
		int lowerHuts = 0;
		if (null == huts){
			return lowerHuts;
		}
		do {
			index += step;
			if (index < 0 || index >= huts.length || hi < huts[index]){
				break;
			}
			++lowerHuts;
		} while (true);
		return lowerHuts;
	}

	public static void main (String[] args){
		try {
			scanner = new Scanner(System.in);
			int total = scanner.nextInt();
			int [] huts = new int[total];
			int [] riseLeft = new int[total];
			int [] riseRight = new int[total];
			for (int i = 0 ; i < total; ++i){
				huts[i] = scanner.nextInt();
				if (i > 0 && huts[i] >= huts[i-1]){
					riseLeft[i] = riseLeft[i-1] + 1;
				}
			}
			for (int i = huts.length -2; i >= 0; --i){
				if (huts[i] >= huts[i+1]){
					riseRight[i] = riseRight[i+1] + 1;
				}
			}
			//System.out.println(huts);
			for (int i = 0; i < huts.length; ++i){
				int left = findLowerHuts(huts, i - riseLeft[i], huts[i], -1);
				int right = findLowerHuts(huts, i + riseRight[i], huts[i], 1);
				System.out.println(left + right + riseLeft[i] + riseRight[i]);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (null != scanner){
				try{
					scanner.close();
				}  catch (Exception e){
					e.printStackTrace();
				}
			}
		}

	}
}
