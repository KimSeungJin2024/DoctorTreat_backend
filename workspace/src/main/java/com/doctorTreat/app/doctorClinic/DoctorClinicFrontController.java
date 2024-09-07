package com.doctorTreat.app.doctorClinic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctorTreat.app.Result;
import com.doctorTreat.app.memberClinic.EarDoctorListController;

/**
 * Servlet implementation class ClinicFrontController
 */
public class DoctorClinicFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorClinicFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = new Result();

		switch (target) {
		case "/chatListDoctor.doccl":
			result = new ChatListDoctorController().execute(request, response);
			request.getRequestDispatcher(result.getPath()).forward(request, response);
			break;
		case "/clinicStartDoctor.doccl":
			request.getRequestDispatcher("/app/clinic/clinicStartDoctor.jsp").forward(request, response);
			break;
		}

//	      if (result != null) {
//	         if (result.isRedirect()) {
//	            response.sendRedirect(result.getPath());
//	         } else {
//	            request.getRequestDispatcher(result.getPath()).forward(request, response);
//	         }
//	      }
	}

}
