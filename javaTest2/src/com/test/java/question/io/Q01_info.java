package com.test.java.question.io; //04.04과제

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;



public class Q01_info {
		
		//Q01. 파일의 경로를 입력받아 파일 정보를 출력하시오.
		//-조건 : 파일 크기 단위 변환 출력(소수 이하 1자리까지) : B, KB, MB, GB, TB
		
		//입력
		//- 파일 경로 : D:\\class\\java\\file\\test.txt
		//- 파일 경로 : C:\\class\\movie\\SpiderMan.mp4
		
		public static void main(String[] args) throws IOException {		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("파일 경로 : ");
			File file = new File(br.readLine());
			getFileInfo(file);
			
			
		}
		public static void getFileInfo(File file) {
			if(file.isFile()) {
				String name = file.getName();
				String format = getFileFormat(name);
				String size = getFileSize(file.length());
				
				System.out.printf("파일명:%s\n"
								+ "종류:%s 파일\n"
								+ "파일 크기:%s\n"
								, name, format, size);
			} else {
				System.out.println("경로가 잘못됐거나, 파일의 형식이 아닙니다.");
			}
		}
		public static String getFileSize(long size) {
			int maxByte = 1024;
			int maxKB = maxByte*1024;
			long maxMB = maxKB*1024;
			long maxGB = maxMB*1024;
			long maxTB = maxGB*1024;

			if(size < maxByte) {
				return size + "Byte";
			} else if(size < maxKB) {
				return size/maxByte + "KB";
			} else if(size < maxMB) {
				return size/maxKB + "MB";
			} else if(size < maxGB) {
				return size/maxMB + "GB";
			} else if(size < maxTB) {
				return size/maxGB + "TB";
			} else {
				return "PB 이상의 파일크기입니다.";			
			}
			

		}
		public static String getFileFormat(String name) {
			int index = name.lastIndexOf(".");
			String format = name.substring(index+1, name.length());
			
			return format;
		}
}
		
