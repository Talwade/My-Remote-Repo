/*package com.flp.ems.view;

import java.util.Scanner;

public class BootClass {
	private static int opt;
	static Scanner s = new Scanner(System.in);
	static UserInteraction ui = new UserInteraction();

	public static void main(String[] args) {

		menuSelection();

	}

	public static void menuSelection() {
		while (true) {
			System.out.println("Enter option \n 0.Add \n1.Modify \n2.Search  \n3Remove \n4.Display  \n5. Exit");
			opt = s.nextInt();
			switch (opt) {
			case 0:
				System.out.println("");

				ui.AddEmployee();

				break;

			case 1:
				System.out.println("");

				ui.ModifyEmployee();
				break;

			case 2:
				ui.SearchEmployee();
				break;

			case 3:
				ui.RemoveEmployee();
				break;

			case 4:
				ui.getAll();
				break;

			case 5:
				System.exit(0);
			default:
				break;
			}
		}

	}
}
 */

package com.flp.ems.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flp.ems.domain.Employee;

public class BootClass {

	static int ch;
	static UserInteraction ui = new UserInteraction();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		menuSelection();

	}

	public static void menuSelection() throws ClassNotFoundException, SQLException {

		while (true) {
			System.out
					.println("Enter ur choice 1.Add \n2.Modify \n3.Remove \n4.Search \n5.GetAllEmp \n6.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				ui.AddEmployee();

				break;
			case 2:
				ui.ModifyEmployee();
				break;
			case 3:
				ui.RemoveEmployee();
				break;
			case 4:
				ui.SearchEmployee();

				break;
			case 5:
				ui.getAll();

				break;
			case 6:
				System.exit(0);
				break;
			}

		}
	}

}
