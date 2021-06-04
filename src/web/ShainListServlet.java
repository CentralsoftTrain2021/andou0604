package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ShainListBean;
import dao.EmployeesVo;
import jp.co.central_soft.train2021.DBUtil;

@WebServlet("/ShainListServlet")
public class ShainListServlet extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		//社員リストwoDBから取得　課題
		List<EmployeesVo>  shainList = getEmployeesVoList();

		ShainListBean bean = new ShainListBean();

		bean.setMsg(			"社員リストを表示します");
		bean.setShainList( 		shainList );

		//セッションからログインユーザーを取得
		HttpSession session = request.getSession();
	    EmployeesVo emp  = (EmployeesVo)session.getAttribute("EmployeesVo");

	    bean.setLoginShainName(	emp.getEmployeename() );

		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/shainlist.jsp");
		disp.forward(request, response);
	}

	//DBから従業員を取得する
	private static List<EmployeesVo> getEmployeesVoList()
	{
		List<EmployeesVo> empList = null;


		//ここにDBアクセス処理を作ってみましょう。　課題


		//仮実装　あとで消す
		empList = new ArrayList<EmployeesVo>();

		DBUtil dbu = new DBUtil();
		try( Connection c =dbu.getConnection() )
		{
			dao.EmployeesDao dao = new dao.EmployeesDao( c );
			empList = dao.getAllEmployees();

		}
		catch( ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}


		return empList;
	}


}
