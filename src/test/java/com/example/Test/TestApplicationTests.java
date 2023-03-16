package com.example.Test;

import com.example.Test.controllers.TestController;
import com.example.Test.models.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class TestControllerTest {

	private TestController testController;

	@BeforeEach
	public void setUp() {
		testController = new TestController();
	}

	@Test
	public void testPlayPierre() {
		String response = testController.play("pierre");
		assertThat(response, containsString("You"));
	}

	@Test
	public void testPlayPapier() {
		String response = testController.play("papier");
		assertThat(response, containsString("You"));
	}

	@Test
	public void testPlayCiseaux() {
		String response = testController.play("ciseaux");
		assertThat(response, containsString("You"));
	}

	@Test
	public void testPlayInvalidAction() {
		String response = testController.play("invalid");
		assertThat(response, containsString("Invalid"));
	}

	@Test
	public void testRestart() {
		testController.setScore(2, 3, 1);
		testController.restart();
		assertThat(testController.getWins(), equalTo(0));
		assertThat(testController.getLosses(), equalTo(0));
		assertThat(testController.getTies(), equalTo(0));
	}

	@Test
	public void testGetScore() {
		testController.setScore(2, 3, 1);
		Score score = testController.getScore();
		assertThat(score.getWins(), equalTo(2));
		assertThat(score.getLosses(), equalTo(3));
		assertThat(score.getTies(), equalTo(1));
	}

	@Test
	public void testSetScore() {
		testController.setScore(2, 3, 1);
		assertThat(testController.getWins(), equalTo(2));
		assertThat(testController.getLosses(), equalTo(3));
		assertThat(testController.getTies(), equalTo(1));
	}
}
