package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData.TaxBehavior;
import com.stripe.Stripe;
import com.stripe.model.Price;

/**
 * Servlet implementation class paymentServlet
 */
@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STRIPE_API_KEY = "sk_test_51MTf6qGOzIM2uC94dvvVH4OiAI1soPvUkiU6DS3KlyoXMWOljYRJWQWdh8WnIq43V2ono23OlaAqF2WmYHco1soG00G1Oj3jEC";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String propertyName = request.getParameter("name");
		String propertyImageUrl = request.getParameter("image");
		System.out.println(propertyImageUrl);
		long propertyPrice = Long.parseLong(request.getParameter("price")) ;
		try {
			Stripe.apiKey = STRIPE_API_KEY;
			SessionCreateParams params =
			        SessionCreateParams.builder()
			          .setMode(SessionCreateParams.Mode.PAYMENT)
			          .setSuccessUrl("http://localhost:3030/success")
			          .setCancelUrl("http://localhost:3030/cancel")
			          .addLineItem(
			          SessionCreateParams.LineItem.builder()
			          	.addTaxRate("txr_1MTmF2GOzIM2uC94PVx6VqyQ")
			            .setQuantity(1L)
			            .setPriceData(
			              SessionCreateParams.LineItem.PriceData.builder()
			                .setCurrency("aud")
			                .setUnitAmount(propertyPrice)    
			                .setProductData(
			                  SessionCreateParams.LineItem.PriceData.ProductData.builder()
			                  	.setDescription("UrbanEasy booking payment")
			                  	.addImage(propertyImageUrl)
			                    .setName(propertyName)
			                    .build())
			                .build())
			            .build())
			          .build();
	      Session session = Session.create(params);
	      response.sendRedirect(session.getUrl());
		} catch (StripeException e) {
			e.printStackTrace();
		}
    
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
