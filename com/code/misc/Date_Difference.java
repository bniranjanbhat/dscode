package com.code.misc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Date_Difference {
	public static final int NUMBER_DAYS_YEAR = 365;

	public static void main(String[] args) {
		boolean valid_date = true;
		int date_diff = 0;
		String to_date = "";
		String from_date = "";
		while (valid_date) {

			System.out.println("Enter From Date");
			Scanner s = new Scanner(System.in);
			from_date = s.nextLine();

			if (validate_date(from_date) == true) {
				break;
			}
		}
		while (valid_date) {
			System.out.println("Enter To Date");
			Scanner s = new Scanner(System.in);
			to_date = s.nextLine();
			if (validate_date(to_date) == true) {
				break;
			}
		}
		String[] date_to = to_date.split("\\-");
		String[] date_from = from_date.split("\\-");
		if (date_to[1].equals(date_from[1]) && (date_to[2].equals(date_from[2]))) {
			int count = 0;
			if (Integer.parseInt(date_to[0])== 29 && leap_year(Integer.parseInt(date_from[2]))) {
				count++;
			}
			count = Integer.parseInt(date_to[0]) - Integer.parseInt(date_from[0]);

			System.out.println(
					"Number of days difference between " + to_date + " and " + from_date + " is " + count + " days");
			System.exit(1);
		} else if (date_to[2].equals(date_from[2])) {
			int count = count_complete_month(Integer.parseInt(date_from[1]), Integer.parseInt(date_to[1]))
					+ (get_Number_days(Integer.parseInt(date_from[1])) - Integer.parseInt(date_from[0]))
					+ Integer.parseInt(date_to[0]);
			if (Integer.parseInt(date_from[1]) <= 2 && leap_year(Integer.parseInt(date_from[2]))) {
				count++;
			}

			System.out.println("Number of days difference between " + to_date + " and " + from_date + " is " + count);
			System.exit(1);
		}
		date_diff = NUMBER_DAYS_YEAR * count_complete_year(Integer.parseInt(date_to[2]), Integer.parseInt(date_from[2]))
				+ (get_Number_days(Integer.parseInt(date_from[1])) - Integer.parseInt(date_from[0]))
				+ (getRemainingDaysInFromdate(Integer.parseInt(date_from[1])));
		if (Integer.parseInt(date_from[1]) <= 2 && leap_year(Integer.parseInt(date_from[2]))) {
			date_diff++;
		}
		if (Integer.parseInt(date_from[1]) >= 2 && leap_year(Integer.parseInt(date_to[2]))) {
			date_diff++;
		}
		date_diff = date_diff
				+ count_complete_year_leap_year(Integer.parseInt(date_to[2]), Integer.parseInt(date_from[2]));

		System.out.println(
				"Number of days difference between " + to_date + " and " + from_date + " is" + date_diff + " days");

	}

	public static boolean leap_year(int year) {
		int year_ = 0;

		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		}
		return false;

	}

	public static boolean validate_date(String date) {
		if (Pattern.matches("[0-9\\-]+", date) == false) {
			System.out.println("From Date is not Valid.Please Enter a valid date");
			return false;
		}
		String[] date_format = date.split("\\-");
		if (Integer.parseInt(date_format[0]) <= 0 && Integer.parseInt(date_format[0]) > 31) {
			System.out.println("Given Date is not Valid Please Enter Valid Date");
			return false;
		} else if (Integer.parseInt(date_format[1]) <= 0 && Integer.parseInt(date_format[1]) > 12) {
			System.out.println("Given Month is not Valid Please Enter Valid Month");
			return false;
		} else {
			try {
				Integer.parseInt(date_format[2]);
			} catch (NumberFormatException e) {
				System.out.println("Given Year is not Valid Please Enter Valid Year");
				return false;
			}
		}
		return true;
	}

	public static int count_complete_year(int from_year, int to_year) {
		int count = 0;
		for (int i = from_year + 1; i < to_year; i++) {
			count++;
		}
		return count;

	}

	public static int count_complete_month(int from_month, int to_month) {
		int count = 0;
		int[] num_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int i = from_month + 1; i < to_month; i++) {
			count = count + num_days[i];
		}
		return count;

	}

	public static int count_complete_year_leap_year(int from_year, int to_year) {
		int count = 0;
		for (int i = from_year + 1; i < to_year; i++) {
			if (leap_year(i))
				count++;
		}
		return count;

	}

	public static int get_Number_days(int month) {
		{
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				return 31;
			} else if (month == 4 || month == 9 || month == 11) {
				return 30;
			} else if (month == 2) {
				return 28;
			} else {
				return 0;
			}
		}

	}

	public static int getRemainingDaysInFromdate(int month) {
		int[] num_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int sum = 0;
		for (int i = month; i < 12; i++) {
			sum = sum + num_days[i];
		}
		return sum;
	}

	public static int getRemainingDaysInTodate(int month) {
		int[] num_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int sum = 0;
		for (int i = 0; i < month; i++) {
			sum = sum + num_days[i];
		}
		return sum;
	}
}
