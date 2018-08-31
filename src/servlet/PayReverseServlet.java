package servlet;

import service.ChargeService;
import service.impl.ChargeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/payReverse")
public class PayReverseServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        ChargeService chargeService = new ChargeServiceImpl();
        try {
            String customerID = request.getParameter("customerID");
            String reverseID = request.getParameter("reverseID");
            String reverseType = request.getParameter("reverseType");
            if (reverseType.equals("bank")) {
                chargeService.payReverse(customerID, reverseID);
            } else if (reverseType.equals("balance")) {
                chargeService.payReverseBalance(customerID, reverseID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("PayReverseServlet: 冲正请求异常");
        }
    }
}
