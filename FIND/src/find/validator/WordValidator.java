package find.validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import find.util.WordValidatorUtil;

/**
 * 敏感词过滤,回调函数
 * @author MONEY
 *
 */
public class WordValidator implements Filter{

    
	private WordValidatorUtil wordValidatorUtil=new WordValidatorUtil(); 

	@Override
	public void destroy() {
		wordValidatorUtil=null;
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request= (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String txt=request.getParameter("txt");
		if(txt!=null)
		{
			Boolean bool = wordValidatorUtil.isContaintSensitiveWord(txt, 1);
			if(bool==true){
				System.out.println("有敏感词");
				PrintWriter writer=response.getWriter();
				writer.print(common.util.Status.SENSITIVE_WORD_TRUE);
				writer.flush();
				writer.close();
				}else {
					System.out.println("没有敏感词");
					arg2.doFilter(arg0, arg1);
					}
		}else {
			arg2.doFilter(arg0, arg1);
		}
		return;
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
