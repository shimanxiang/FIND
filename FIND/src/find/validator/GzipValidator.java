package find.validator;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import find.util.CachedResponseWrapper;
import find.util.GzipUtil;
/**Gzip压缩
 * @author MONEY
 *
 */
public class GzipValidator implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request=  (HttpServletRequest) arg0 ;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		CachedResponseWrapper responseWrapper = null ;
		responseWrapper = new CachedResponseWrapper(response);
		
		filterChain.doFilter(request, responseWrapper);
		byte[] responseData = responseWrapper.getResponseData();
		System.out.println(responseData.length);
		
		//压缩数据
		responseData=compress(request, responseWrapper, responseData);
		System.out.println(responseData.length);
		//发送数据
		response.setContentLength(responseData.length);
		response.setHeader("Content-Encoding", "gzip");
		ServletOutputStream output = response.getOutputStream();
		//因为是包装过后的所以要重新输出
		output.write(responseData);
		output.flush();
		output.close();
	}
	public byte[] compress(HttpServletRequest request,
			HttpServletResponse response, byte[] responseData){
		
		String acceptEncoding = request.getHeader("Accept-Encoding");
		if ( acceptEncoding == null
				||!acceptEncoding.contains("gzip")) {
			return responseData;
		}
		response.setHeader("Content-Encoding", "gzip");
		return GzipUtil.gzip(responseData);		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
