package servlet;

import service.ChargeService;
import service.impl.ChargeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payPr")
public class PayPrServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        ChargeService chargeService = new ChargeServiceImpl();

        String prID = request.getParameter("prID");
        String payAmount = request.getParameter("payAmount");
        String bankID = request.getParameter("bankID");

        try {
            chargeService.payByPr(bankID, prID, payAmount);
            response.setContentType("text/plain");
            response.getWriter().write("/customer");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(403);
        }
    }
}
