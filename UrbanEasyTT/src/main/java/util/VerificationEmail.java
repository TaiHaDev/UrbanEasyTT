package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import dao.AuthenticationDAO;

public class VerificationEmail {
	public static int generateVerificationCode() {
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}

	public static int sendVerificationEmail(String emailID) {
		String body = """
				                {
				                "personalizations": [
				{
				    "to": [
				    {
				            "email": "verification-email"
				    }
				    ],
				    "subject": "Verify Your Email"
				}
				],
				"from": {
				"email": "no-reply@urbaneasy.com"
				},
				    "content": [
				{
				    "type": "text/html",
				    "value": "<h1>UrbanEasy</h1> <p>This is your verification number: verification-code </p> <p>The code will expire after 30 minutes</p>"
				}
				]
				}""";
		int generatedCode = generateVerificationCode();
		body = body.replace("verification-email", emailID);
		body = body.replace("verification-code", "" + generatedCode);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://rapidprod-sendgrid-v1.p.rapidapi.com/mail/send"))
				.header("content-type", "application/json")
				.header("X-RapidAPI-Key", "7c352dcfb2msh75ced58cd8d9a5cp168631jsn410e99164d5e")
				.header("X-RapidAPI-Host", "rapidprod-sendgrid-v1.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(body)).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return generatedCode;

	}

	public static void ScheduleVerificationRowDeletion(int id) {
		TimerTask task = new TimerTask() {
			public void run() {
				AuthenticationDAO authenticationDAO = new AuthenticationDAO();
				authenticationDAO.deleteVerificationRow(id);
			}
		};
		Timer timer = new Timer("Timer");
		long delay = 1000 * 60 * 30;
		timer.schedule(task, delay);
	}

}
