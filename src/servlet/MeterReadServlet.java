package servlet;

import service.MeterService;
import service.impl.MeterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/meterRead")
public class MeterReadServlet extends BaseServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        MeterService meterService = new MeterServiceImpl();
        try {
            String mrDate = request.getParameter("mrDate");
            String deviceID = request.getParameter("deviceID");
            String customerID = request.getParameter("customerID");
            String mtNumber = request.getParameter("mtNumber");
            String mrID = request.getParameter("mrID");
            if (meterService.meterRead(mrDate, deviceID, customerID, mtNumber, mrID)) {
                System.out.println("MeterReadServlet: 抄表请求成功");
                response.setContentType("text/plain");
                response.getWriter().write("/reader");
            } else {
                response.sendError(403);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MeterReadServlet: 抄表请求失败");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
