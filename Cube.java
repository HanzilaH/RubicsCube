import java.util.Scanner;
/**
 * Movements:
 * r for right clockwise
 * ri for right anticlockwise
 * l for left clockwise
 * li for left anticlockwise
 * b for back anticlockwise
 * bi for back clockwise
 * d for down clockwise
 * di for down anticlockwise
 * f for front clockwise 
 * fi for front anticlockwise
 * u for up clockwise
 * ui for up anticlockwise
 */
public class Cube{

	//O for Orange color
	//Y for yellow color
	//R for red color
	//G for green color
	//B for blue color
	//W for white color
	
	private char[][] side_f = {
								{'O','O','O'},
								{'O','O','O'},
								{'O','O','O'}
							};

	private char[][] side_b = {
								{'Y','Y','Y'},
								{'Y','Y','Y'},
								{'Y','Y','Y'}
							};

	private char[][] side_r ={
								{'R','R','R'},
								{'R','R','R'},
								{'R','R','R'}
							};

	private char[][] side_l ={
								{'G','G','G'},
								{'G','G','G'},
								{'G','G','G'}
							};

	private char[][] side_d ={
								{'B','B','B'},
								{'B','B','B'},
								{'B','B','B'}
							};

	private char[][] side_u ={
								{'W','W','W'},
								{'W','W','W'},
								{'W','W','W'}
							};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cube cube = new Cube();
		System.out.println("Start?(y/n) Type 'exit' to exit the program");
		String input =  scanner.nextLine();
		if (input.equals("y")) {
			cube.printCube();
			
			while (!input.equals("exit")){
				System.out.println("Which move?");
				input =  scanner.nextLine();
				switch (input){
					case "r":
						System.out.println("After Right");
						cube.right();
						cube.printCube();
						break;
					case "ri":
						System.out.println("After Right Inverse");
						cube.rightInverse();
						cube.printCube(); 
						break;
					case "l":
						System.out.println("After Left");
						cube.left();
						cube.printCube(); 
						break;
					case "li":
						System.out.println("After left Inverse");
						cube.leftInverse();
						cube.printCube(); 
						break;
					case "u":
						System.out.println("After Up rotation");
						cube.up();
						cube.printCube(); 
						break;
					case "ui":
						System.out.println("After Up Inverse");
						cube.upInverse();
						cube.printCube(); 
						break;
					case "b":
						System.out.println("After Back rotation");
						cube.back();
						cube.printCube(); 
						break;
					case "bi":
						System.out.println("After Back Inverse");
						cube.backInverse();
						cube.printCube(); 
						break;
					case "f":
						System.out.println("After front rotation");
						cube.front();
						cube.printCube(); 
						break;
					case "fi":
						System.out.println("After front Inverse");
						cube.frontInverse();
						cube.printCube(); 
						break;
					case "d":
						System.out.println("After down rotation");
						cube.down();
						cube.printCube(); 
						break;

					case "di":
						System.out.println("After down Inverse");
						cube.downInverse();
						cube.printCube(); 
						break;

				}
			}
		}
		
	}

	public Cube(){
	}

	/**
	 * This method prints the whole cube and calls the printSection for each section
	 */
	public void printCube(){
		this.printSection(null, side_u, null);
		System.out.println();
		this.printSection(side_l, side_f, side_r);
		System.out.println();
		this.printSection(null, side_d, null);
		System.out.println();
		this.printSection(null, side_b, null);


	}

	/**
	 * This method is used to print one section of a cube
	 */
	private void printSection(char[][] sideA, char[][] sideB, char[][] sideC){
		if (sideA == null && sideC == null ) {
			for (int i = 0;i<3 ;i++ ) {
				System.out.print("-  -  -   ");
				for (int j = 0;j<2 ;j++ ) {
					System.out.print(sideB[i][j]+", ");
				}
				System.out.println(sideB[i][2] +"  -  -  - ");
			}


		}else if (sideA != null && sideC != null ) {
			for (int i = 0;i<3 ;i++ ) {
				for (int j=0;j<2 ;j++ ) {

					System.out.print(sideA[i][j]+", ");
				}
				System.out.print(sideA[i][2] + "   ");

				for (int j=0;j<2 ;j++ ) {

					System.out.print(sideB[i][j]+", ");
				}
				System.out.print(sideB[i][2] + "   ");

				for (int j=0;j<2 ;j++ ) {

					System.out.print(sideC[i][j]+", ");
				}
				System.out.println(sideC[i][2] + "  ");
			}
		}
	}

	/**
	 * This is only a convenience function
	 * @param side is the side you want to print
	 */
	public void printSide(char[][] side){
		for (int i=0; i<3;i++ ) {
			for (int j=0;j<2 ;j++ ) {
				System.out.print(side[i][j]+", ");
			}
			System.out.println(side[i][2]);
		}
		
	}

	/**
	 * This is for clockwise movement of a side
	 * @param side is the side you want to rotate
	 */
	public void clockWise(char[][] side){
		char[][]side_copy = new char[3][3];
		for (int i = 0; i < side_copy.length; i++) {
		    for (int j = 0; j < side_copy[i].length; j++) {
		        side_copy[i][j] = side[i][j];
		    }
		}

		for (int i= 0;i<3 ;i++ ) {
			side[i][2] = side_copy[0][i];
			side[i][1] = side_copy[1][i];
			side[i][0] = side_copy[2][i];
		}

	}

	/**
	 * This is for antiClockwise movement of a side 
	 * 3 clockwise movements equal 1 antiClockwise movement
	 * @param side is the side you want to rotate
	 */
	public void antiClockWise(char[][] side){
		this.clockWise(side);
		this.clockWise(side);
		this.clockWise(side);
		// char[][]side_copy = new char[3][3];
		// for (int i = 0; i < side_copy.length; i++) {
		//     for (int j = 0; j < side_copy[i].length; j++) {
		//         side_copy[i][j] = side[i][j];
		//     }
		// }
		// for (int i= 0;i<3 ;i++ ) {
		// 	side[i][0] = side_copy[0][i];
		// 	side[i][1] = side_copy[1][i];
		// 	side[i][2] = side_copy[2][i];
		// }
	}

	/**
	 * One more convenience function 
	 * Instead of repeating the code each time i just call this function
	 * @param side is the Cube side which is to be copied
	 * @return char[][] 2D array of characters
	 */
	public char[][] copyArray(char[][] side){
		char[][]side_copy = new char[3][3];
		for (int i = 0; i < side_copy.length; i++) {
		    for (int j = 0; j < side_copy[i].length; j++) {
		        side_copy[i][j] = side[i][j];
		    }
		}
		return side_copy;
	}

	/**
	 * Called for (Clockwise) movement of the right side
	 * Movement R
	 */
	public void right(){
		char[][]up_copy = this.copyArray(side_u);
		

		for (int i = 0;i<3 ;i++ ) {

			side_u[i][2] = side_f[i][2];
			side_f[i][2] = side_d[i][2];
			side_d[i][2] = side_b[i][2];
			side_b[i][2] = up_copy[i][2];
			
		}
		
		this.clockWise(side_r);



	}

	/**
	 * Called for (Anticlockwise) movement of the right side 
	 * Movement Ri (Right inverse)
	 */
	public void rightInverse(){

		char[][]front_copy = this.copyArray(side_f);

		for (int i = 0;i<3 ;i++ ) {

			side_f[i][2] = side_u[i][2];
			side_u[i][2] = side_b[i][2];
			side_b[i][2] = side_d[i][2];
			side_d[i][2] = front_copy[i][2];
			
		}

		this.antiClockWise(side_r);

	
	}

	/**
	 * (clockwise) Movement for the left side
	 */
	public void left(){
		char[][]front_copy = this.copyArray(side_f);


		for (int i = 0;i<3 ;i++ ) {

			side_f[i][0] = side_u[i][0];
			side_u[i][0] = side_b[i][0];
			side_b[i][0] = side_d[i][0];
			side_d[i][0] = front_copy[i][0];
			
		}
		this.clockWise(side_l);
	
	}

	/**
	 * (Anticlockwise) Movement for left or Left inverse 
	 */
	public void leftInverse(){
		char[][]up_copy = this.copyArray(side_u);

		for (int i = 0;i<3 ;i++ ) {

			side_u[i][0] = side_f[i][0];
			side_f[i][0] = side_d[i][0];
			side_d[i][0] = side_b[i][0];
			side_b[i][0] = up_copy[i][0];
			
		}

		this.antiClockWise(side_l);
	}

	/**
	 * (Clockwise) Movement for the front side
	 */
	public void front(){
		char[][]up_copy = this.copyArray(side_u);

		for (int i = 0;i<3 ;i++ ) {

			side_u[2][i] = side_l[i][2];
			side_l[i][2] = side_d[0][i];
			side_d[0][i] = side_r[i][0];
			side_r[i][0] = up_copy[2][i];
			
		}
		this.clockWise(side_f);


	}

	/**
	 * (AntiClockwise) movement of front side or Front Inverse
	 */
	public void frontInverse(){
		char[][]up_copy = this.copyArray(side_u);
		for (int i = 0;i<3 ;i++ ) {

			side_u[2][i] = side_r[i][0];
			side_r[i][0] = side_d[0][i];
			side_d[0][i] = side_l[i][2];
			side_l[i][2] = up_copy[2][i];
			
		}
		this.antiClockWise(side_f);
	}

	/**
	 * (Clockwise) movement of the up side
	 */
	public void up(){
		char[][]left_copy = this.copyArray(side_l);
		for (int i = 0;i<3 ;i++ ) {

			side_l[0][i] = side_f[0][i];
			side_f[0][i] = side_r[0][i];
			side_r[0][i] = side_b[0][i];
			side_b[0][i] = left_copy[0][i];
			
		}

		this.clockWise(side_u);
	}

	/**
	 * (Anticlockwise) movement of the up side or Up inverse
	 */
	public void upInverse(){
		char[][] right_copy = this.copyArray(side_r);
		for (int i = 0;i<3 ;i++ ) {

			side_r[0][i] = side_f[0][i];
			side_f[0][i] = side_l[0][i];
			side_l[0][i] = side_b[0][i];
			side_b[0][i] = right_copy[0][i];
			
		}

		this.clockWise(side_u);
	}

	/**
	 * (Anticlockwise) movement of the down side or Down Inverse
	 * 
	 */
	public void downInverse(){
		char[][]left_copy = this.copyArray(side_l);
		for (int i = 0;i<3 ;i++ ) {

			side_l[2][i] = side_f[2][i];
			side_f[2][i] = side_r[2][i];
			side_r[2][i] = side_b[2][i];
			side_b[2][i] = left_copy[2][i];
			
		}

		this.antiClockWise(side_d);
	}

	/**
	 * (Cloclwise) movement of the down side 
	 */
	public void down(){
		char[][] right_copy = this.copyArray(side_r);
		for (int i = 0;i<3 ;i++ ) {

			side_r[2][i] = side_f[2][i];
			side_f[2][i] = side_l[2][i];
			side_l[2][i] = side_b[2][i];
			side_b[2][i] = right_copy[2][i];
			
		}

		this.clockWise(side_d);
	}

	/**
	 * (Anticlockwise) movement of the back side
	 */
	public void back(){
		char[][]up_copy = this.copyArray(side_u);
		for (int i = 0;i<3 ;i++ ) {

			side_u[0][i] = side_r[i][2];
			side_r[i][2] = side_d[2][i];
			side_d[2][i] = side_l[i][0];
			side_l[i][0] = up_copy[0][i];
			
		}
		this.antiClockWise(side_b);
	}

	/**
	 * Clockwise movement of the back side
	 */
	public void backInverse(){
		char[][]up_copy = this.copyArray(side_u);

		for (int i = 0;i<3 ;i++ ) {

			side_u[0][i] = side_l[i][0];
			side_l[i][0] = side_d[2][i];
			side_d[2][i] = side_r[i][2];
			side_r[i][2] = up_copy[0][i];
			
		}
		this.clockWise(side_b);
	}

}