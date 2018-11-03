import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;  

public class dWebController extends HttpServlet { 
	DBUtils dbu;
	public dWebController(){
		dbu = new DBUtils();
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {  
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String input = "";
        if(br != null){
            input = br.readLine();
        }
        response.setContentType("application/json");  
        response.setCharacterEncoding("UTF-8");
        
        //this.dbu.defaultTableData(); // Add Table data for test
        dWebDS returnedValue = dbu.dbConnetion(Integer.parseInt(input));   
        //System.out.println(" table dWebTable : " + returnedValue.getID()+" "+returnedValue.getMsg()+" "+returnedValue.getRemark()+" "+returnedValue.getMemo());
        /* response with JSON */
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(returnedValue != null){
	        try {
				json.put("id", returnedValue.getID());
				json.put("msg", returnedValue.getMsg());
				json.put("remark", returnedValue.getRemark());
				json.put("memo", returnedValue.getMemo());
			} catch (JSONException e) {
				e.printStackTrace();
			}
        }
        out.print(json.toString());
        out.flush();
    }  
    
    @Override  
    public void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  