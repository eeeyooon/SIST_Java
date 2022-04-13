package com.test.java.test;

import java.io.File;
import java.util.Random;

public class idDummy {

	public static void main(String[] args) {
	

        char[] id = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
 '0','1','2','3','4','5','6','7','8','9'};

        StringBuffer sb = new StringBuffer();

        Random rn = new Random();

        int idLength = rn.nextInt(13) + 4;
        for( int i = 0 ; i < idLength ; i++ ){

            sb.append( id[ rn.nextInt( id.length ) ] );

        }

        System.out.println(sb.toString());

    

	}
	
}//idDummy
