package com.studentapp.junit.studentinfo;

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
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	
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
	
	@Title("This test will get the info of all the students from student app")
	@Test
	public void test01() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
}
