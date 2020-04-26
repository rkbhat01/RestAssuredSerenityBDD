package com.studentapp.junit.studentidinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)
public class SerenityidinfoTest {

	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8085/student";
	}
	
	@Test
	public void getAllStudents() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
	
	@Test
	public void thisIsFailingTest() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
		
	}
	
	@Pending
	@Test
	public void thisIsPendingTest() {
				
	}
	
	@Ignore
	@Test
	public void thisIsIgnoreTest() {
				
	}
	
	@Test
	public void thisIsErrorTest() {
		System.out.println("This is error test"+(5/0));
				
	}
	
	@Test
	public void filedoestnotExist() throws FileNotFoundException {
		File file = new File("E://file.txt");
		@SuppressWarnings("unused")
		FileReader fr = new FileReader(file);
				
	}
	
	@Manual
	@Test
	public void thisIsManualTest() {
				
	}
}
