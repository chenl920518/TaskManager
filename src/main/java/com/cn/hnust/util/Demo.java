package com.cn.hnust.util;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Demo {

	public static void main(String args[]){
		String str = "abc,def;gh,ij;k;lm,no,p;qr,st";
        StringTokenizer st = new StringTokenizer(str,";");

            System.out.println(st);
     
	}
	
}
