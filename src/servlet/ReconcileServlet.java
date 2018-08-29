package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.AccountError;
import model.AccountTotal;
import service.ReconcileService;
import service.impl.ReconcileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reconcile")
public class ReconcileServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        Gson gson = new Gson();
        ReconcileService reconcileService = new ReconcileServiceImpl();
        String bankID = request.getParameter("bank_id");
        String dateIn = request.getParameter("date_in");
        List<AccountTotal> accountTotalList = null;
        List<AccountError> accountErrorList = null;
        try {
            reconcileService.reconcile(bankID, dateIn);
            accountTotalList = reconcileService.accountTotal(dateIn);
            accountErrorList = reconcileService.accountError(dateIn);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReconcileServlet: " + "对账请求异常");
        }

        try {
            JsonElement accountTotalJson = gson.toJsonTree(accountTotalList);
            JsonElement accountErrorJson = gson.toJsonTree(accountErrorList);
            JsonObject json = new JsonObject();
            json.add("accountTotalJson", accountTotalJson);
            json.add("accountErrorJson", accountErrorJson);
            response.setContentType("text/plain");
            response.getWriter().write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReconcileServlet: " + "对账信息返回异常");
        }
    }
}
