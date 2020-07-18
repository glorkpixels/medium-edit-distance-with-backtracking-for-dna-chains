import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MEHMET_HAMDI_USLU_2400000145 {
	static StringBuilder str = new StringBuilder();
	static StringBuilder chng = new StringBuilder();
	static int mainscore = 0;
	static int gappenalty= 5;
	static String blossomtable[][] = {
			{ "*", "A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V",
					"B", "Z", "X", "*" },
			{ "A", "4", "-1", "-2", "-2", "0", "-1", "-1", "0", "-2", "-1", "-1", "-1", "-1", "-2", "-1", "1", "0",
					"-3", "-2", "0", "-2", "-1", "0", "-4" },
			{ "R", "-1", "5", "0", "-2", "-3", "1", "0", "-2", "0", "-3", "-2", "2", "-1", "-3", "-2", "-1", "-1", "-3",
					"-2", "-3", "-1", "0", "-1", "-4" },
			{ "N", "-2", "0", "6", "1", "-3", "0", "0", "0", "1", "-3", "-3", "0", "-2", "-3", "-2", "1", "0", "-4",
					"-2", "-3", "3", "0", "-1", "-4" },
			{ "D", "-2", "-2", "1", "6", "-3", "0", "2", "-1", "-1", "-3", "-4", "-1", "-3", "-3", "-1", "0", "-1",
					"-4", "-3", "-3", "4", "1", "-1", "-4" },
			{ "C", "0", "-3", "-3", "-3", "9", "-3", "-4", "-3", "-3", "-1", "-1", "-3", "-1", "-2", "-3", "-1", "-1",
					"-2", "-2", "-1", "-3", "-3", "-2", "-4" },
			{ "Q", "-1", "1", "0", "0", "-3", "5", "2", "-2", "0", "-3", "-2", "1", "0", "-3", "-1", "0", "-1", "-2",
					"-1", "-2", "0", "3", "-1", "-4" },
			{ "E", "-1", "0", "0", "2", "-4", "2", "5", "-2", "0", "-3", "-3", "1", "-2", "-3", "-1", "0", "-1", "-3",
					"-2", "-2", "1", "4", "-1", "-4" },
			{ "G", "0", "-2", "0", "-1", "-3", "-2", "-2", "6", "-2", "-4", "-4", "-2", "-3", "-3", "-2", "0", "-2",
					"-2", "-3", "-3", "-1", "-2", "-1", "-4" },
			{ "H", "-2", "0", "1", "-1", "-3", "0", "0", "-2", "8", "-3", "-3", "-1", "-2", "-1", "-2", "-1", "-2",
					"-2", "2", "-3", "0", "0", "-1", "-4" },
			{ "I", "-1", "-3", "-3", "-3", "-1", "-3", "-3", "-4", "-3", "4", "2", "-3", "1", "0", "-3", "-2", "-1",
					"-3", "-1", "3", "-3", "-3", "-1", "-4" },
			{ "L", "-1", "-2", "-3", "-4", "-1", "-2", "-3", "-4", "-3", "2", "4", "-2", "2", "0", "-3", "-2", "-1",
					"-2", "-1", "1", "-4", "-3", "-1", "-4" },
			{ "K", "-1", "2", "0", "-1", "-3", "1", "1", "-2", "-1", "-3", "-2", "5", "-1", "-3", "-1", "0", "-1", "-3",
					"-2", "-2", "0", "1", "-1", "-4" },
			{ "M", "-1", "-1", "-2", "-3", "-1", "0", "-2", "-3", "-2", "1", "2", "-1", "5", "0", "-2", "-1", "-1",
					"-1", "-1", "1", "-3", "-1", "-1", "-4" },
			{ "F", "-2", "-3", "-3", "-3", "-2", "-3", "-3", "-3", "-1", "0", "0", "-3", "0", "6", "-4", "-2", "-2",
					"1", "3", "-1", "-3", "-3", "-1", "-4" },
			{ "P", "-1", "-2", "-2", "-1", "-3", "-1", "-1", "-2", "-2", "-3", "-3", "-1", "-2", "-4", "7", "-1", "-1",
					"-4", "-3", "-2", "-2", "-1", "-2", "-4" },
			{ "S", "1", "-1", "1", "0", "-1", "0", "0", "0", "-1", "-2", "-2", "0", "-1", "-2", "-1", "4", "1", "-3",
					"-2", "-2", "0", "0", "0", "-4" },
			{ "T", "0", "-1", "0", "-1", "-1", "-1", "-1", "-2", "-2", "-1", "-1", "-1", "-1", "-2", "-1", "1", "5",
					"-2", "-2", "0", "-1", "-1", "0", "-4" },
			{ "W", "-3", "-3", "-4", "-4", "-2", "-2", "-3", "-2", "-2", "-3", "-2", "-3", "-1", "1", "-4", "-3", "-2",
					"11", "2", "-3", "-4", "-3", "-2", "-4" },
			{ "Y", "-2", "-2", "-2", "-3", "-2", "-1", "-2", "-3", "2", "-1", "-1", "-2", "-1", "3", "-3", "-2", "-2",
					"2", "7", "-1", "-3", "-2", "-1", "-4" },
			{ "V", "0", "-3", "-3", "-3", "-1", "-2", "-2", "-3", "-3", "3", "1", "-2", "1", "-1", "-2", "-2", "0",
					"-3", "-1", "4", "-3", "-2", "-1", "-4" },
			{ "B", "-2", "-1", "3", "4", "-3", "0", "1", "-1", "0", "-3", "-4", "0", "-3", "-3", "-2", "0", "-1", "-4",
					"-3", "-3", "4", "1", "-1", "-4" },
			{ "Z", "-1", "0", "0", "1", "-3", "3", "4", "-2", "0", "-3", "-3", "1", "-1", "-3", "-1", "0", "-1", "-3",
					"-2", "-2", "1", "4", "-1", "-4" },
			{ "X", "0", "-1", "-1", "-1", "-2", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-2", "0", "0",
					"-2", "-1", "-1", "-1", "-1", "-1", "-4" },
			{ "*", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4", "-4",
					"-4", "-4", "-4", "-4", "-4", "-4", "1" } };

	private static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	static int DNAMATCHER(String str1, String str2, int m, int n) {
		int resultsTable[][] = new int[m + 1][n + 1];// Table for storing the results of the operations of each cell.

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					resultsTable[i][j] = j; // If the first input string is empty insert second string's characters.
				} else if (j == 0) {
					resultsTable[i][j] = i; // If the second input string is empty insert first string's characters.
				}

				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) // Last characters are same.
				{
					resultsTable[i][j] = resultsTable[i - 1][j - 1];
				} else // Last charaacters are different. Find the minimum.
				{

					resultsTable[i][j] = 1 + min(resultsTable[i][j - 1], // Insert
							resultsTable[i - 1][j], // Remove // delete
							resultsTable[i - 1][j - 1]); // Replace //substition
				}

//				System.out.print(resultsTable[i][j] + "\t"); // Displaying the table of results to console.

			}
//			System.out.println();

		}

		System.out.println(backtrace(resultsTable, m, n, str1, str2)); // Adding backtrace to console.
		return 0;
	}

	public static void main(String[] args) {

		// your code starts from here…
		// inputs:
		// Copy “Blosum62.docx” into a matrix here.
		// Read “input.txt” file.
	

		String str1 = "";
		String str2 = "";
		try {

			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			for (int i = 0; myReader.hasNextLine(); i++) {
				String data = myReader.nextLine();
				if (i == 0) {
					str1 = data;

				} else {
					str2 = data;
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("Sequences were these:");
		System.out.println( str1);
		System.out.println( str2);
		DNAMATCHER(str1, str2, str1.length(), str2.length());

		System.out.println("Sequences will become these:");
		System.out.println( str1);
		System.out.println(str.reverse().toString());
		System.out.println("Score:" + mainscore);

		// output:
		// Print the maximum alignment score
		// Print the best alignment of given two sequences

	}

	private static String backtrace(int[][] resultsTable, int m, int n, String str1, String str2) {
		int insert = 0;
		int delete = 0;
		int substition = 0;
		boolean endOfMatrix = false;

		while (!endOfMatrix) {
			if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
				str.append(str2.charAt(n - 1));
				String compare = String.valueOf(str2.charAt(n - 1));

				for (int i = 0; i < blossomtable.length; i++) {
					if (blossomtable[0][i].equals(compare)) {
						mainscore += Integer.valueOf(blossomtable[i][i]);
//						System.out.println(blossomtable[i][i]);
					}
				}

				m--;
				n--;
				if (m == 0 && n == 0) {
					endOfMatrix = true;
					break;
				} else if (m == 0) {
					while (!endOfMatrix) {

						insert++;
						n--;
						if (n == 0) {
//							str.append(str2.charAt(n));
							endOfMatrix = true;
							break;
						}
					}
				} else if (n == 0) {
					while (!endOfMatrix) {
						delete++;
//						System.out.println("delete2");
						str.append("-");
						m--;
						if (m == 0) {
							endOfMatrix = true;
							break;
						}
					}
				}

			} else {
				if (resultsTable[m][n] == resultsTable[m - 1][n - 1] + 1) {
					substition++;
					insert++;
//					System.out.println(str1.charAt(m-1));
//					System.out.println(str2.charAt(n-1));
					String compare = String.valueOf(str2.charAt(n - 1));
					String compare2 = String.valueOf(str1.charAt(m - 1));

					int temp1 = 0;
					int temp2 = 0;

					for (int i = 0; i < blossomtable.length; i++) {

						if (blossomtable[0][i].equals(compare)) {
							temp1 = i;
						}

					}

					for (int i = 0; i < blossomtable.length; i++) {
						if (blossomtable[0][i].equals(compare2)) {
							temp2 = i;
						}
					}

					if (temp1 != 0 && temp2 != 0) {
//				s		System.out.println(blossomtable[temp1][temp2]);
						mainscore += Integer.valueOf(blossomtable[temp1][temp2]);
					}

					str.append(str2.charAt(n - 1));
					m--;
					n--;
				} else if (resultsTable[m][n] == resultsTable[m - 1][n] + 1) {
					str.append("-");
					delete++;
//					System.out.println("delete3");
					mainscore -= 	gappenalty;
					m--;
				} else if (resultsTable[m][n] == resultsTable[m][n - 1] + 1) {
//					str.append(str2.charAt(n-1));
					insert++;
					n--;
				}

				if (m == 0 && n == 0) {
					endOfMatrix = true;
					break;
				} else if (m == 0) {
					while (!endOfMatrix) {
						insert++;
						n--;
						if (n == 0) {
							endOfMatrix = true;
							break;
						}
					}
				} else if (n == 0) {
					while (!endOfMatrix) {
						str.append("-");
						delete++;
//						System.out.println("delete4");
						mainscore -= gappenalty;
						m--;
						if (m == 0) {
							endOfMatrix = true;
							break;
						}
					}
				}

//				str.append(str2.charAt(n-1));

			}
		}
		return ("");
	}
}
