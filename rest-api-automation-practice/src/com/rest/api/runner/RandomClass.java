package com.rest.api.runner;

import java.util.Random;
import java.util.stream.LongStream;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomClass {

	public static void main(String[] args) {
		
		
		String a=RandomStringUtils.randomNumeric(10);
		System.out.println(a);
		
		long b=new Random().nextLong(5);
		System.out.println(b);
		
		
		

	}

}
