
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class Client extends HttpServlet {
    @EJB
    private TempConverter tempConverter;
//    private TempConverter tempConverter = new TempConverter();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/temp_conv.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String temp = request.getParameter("temp");


        if (type.equals("fahr2cel")) {
            System.out.println("Setting converted_temp to: " + tempConverter.fahr2Cel(Double.parseDouble(temp)));
            request.setAttribute("converted_temp", "" + tempConverter.fahr2Cel(Double.parseDouble(temp)));
        } else if(type.equals("cel2fahr")) {
            System.out.println("Setting converted_temp to: " + tempConverter.fahr2Cel(Double.parseDouble(temp)));
            request.setAttribute("converted_temp", "" + tempConverter.cel2Fahr(Double.parseDouble(temp)));
        }

        doGet(request, response);
    }

}
