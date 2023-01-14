package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Utility {
	Scanner scan;
	Random rand;
	public Utility() {
		this.scan = new Scanner(System.in);
		this.rand = new Random();
	}
	public void cls() {
		for (int i = 0; i < 64; i++) {
			System.out.println();
		}
	}
	public void enter() {
		System.out.print("Press Enter to Continue");
		scan.nextLine();
		cls();
	}
	public int Int(int a, int b, String msg) {
		int temp = 0;
		while (true) {
			System.out.print(msg);
			try {
				temp = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				
			}
			if(temp >= a && temp <= b) {
				break;
			}
		}
		return temp;
	}
	
	public String randType() {
		String temp;
		int range = rand.nextInt(10);
		if(range <= 4) {
			temp = "Rare";
		}else {
			temp = "Common";
		}
		return temp;
	}
	public int randLevel() {
		int temp = rand.nextInt(40)+1;
		return temp;
	}
	public int randRange(int start, int end) {
		return rand.nextInt(end)+start;
	}
	public int randSize(int temp) {
		return rand.nextInt(temp);
	}
	public void sleep(int temp) {
		try {
			Thread.sleep(temp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printDynamicMsg(String name, int time) {
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
			sleep(time);
		}
		System.out.println(); 
	}
}
