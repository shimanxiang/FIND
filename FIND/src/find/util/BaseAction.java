package find.util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ezmorph.object.AbstractObjectMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONTokener;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import common.util.ConstantField;
import common.util.Status;

public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, SessionAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0; 
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Map getSession() {
		return session;
	}

	public abstract String execute() throws Exception;
	

	public void responseClient(JSONObject json) {
		responseClient(json.toString());
	}

	/**
	 * ��Json��ʽ���ַ�ת����Json����
	 * 
	 * @param jsonString
	 * @return
	 */
	protected JSONObject strToJson(String jsonString) {
		JSONObject js = JSONObject.fromObject(jsonString);
		return js;
	}

	/**
	 * ��ÿͻ����ϴ��ĵ������Ե�ֵ
	 * 
	 * @param key
	 * @return
	 */
	protected Object getParas(String key) {
		JSONObject js = (JSONObject) getRequestParamsObject(JSONObject.class);
		return js == null ? null : js.get(key);
	}

	/**
	 * ��ͻ��˷��ص�����ֵ
	 * 
	 * @param key
	 * @param value
	 */
	protected void responseClient(String key, Object value) {
		JSONObject json = new JSONObject();
		json.put(key, value);
		responseClient(json.toString());
	}

	protected void responseClient(Status status) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put(ConstantField.STATUS, status);
		responseClient(json);
	}

	public void responseClient(JSONObject json, Status status) {
		json.put(ConstantField.STATUS, status);
		responseClient(json.toString());
	}

	public void responseClient(String str) {
		try {
			PrintWriter writer = this.getResponse().getWriter();
			writer.print(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 
	 * 
	 * 
	 *
	 */
	public Object getRequestParamsObject(Class c) {
		try {

			this.getRequest().setCharacterEncoding("UTF-8");
			String jsonstring = this.getRequest().getParameter(
					ConstantField.PARAMS);
			JSONTokener jsonParser = new JSONTokener(jsonstring);
			//���json����
			JSONObject jsonObject = (JSONObject) jsonParser.nextValue();
			JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher());
			return JSONObject.toBean(jsonObject, c);
		} catch (Exception e) {
			return null;
		}
	}

	public Object getRequestParamsObject(Class c, Map<String, Class> field) {

		try {
			this.getRequest().setCharacterEncoding("UTF-8");
			String jsonstring = this.getRequest().getParameter(
					ConstantField.PARAMS);
			JSONTokener jsonParser = new JSONTokener(jsonstring);
			JSONObject jsonObject = (JSONObject) jsonParser.nextValue();
			JSONUtils.getMorpherRegistry().registerMorpher(
					new TimestampMorpher());

			return JSONObject.toBean(jsonObject, c, field);
		} catch (Exception e) {
			return null;
		}
	}

	public JSONObject getRequestParamsJSON() {

		try {
			this.getRequest().setCharacterEncoding("UTF-8");
			String jsonstring = this.getRequest().getParameter(
					ConstantField.PARAMS);
			JSONTokener jsonParser = new JSONTokener(jsonstring);
			return (JSONObject) jsonParser.nextValue();
		} catch (Exception e) {
			return null;
		}
	}

	public String getRequestParamsString() {
		return this.getRequest().getParameter(ConstantField.PARAMS);
	}

	/*** ��json���е������ַ�ת��Ϊbean�е�Timestamp */
	public class TimestampMorpher extends AbstractObjectMorpher {
		public TimestampMorpher() {
		}

		String[] formats = { "yyyy-MM-dd HH:mm:ss" };

		public Object morph(Object value) {
			if (value == null) {
				return null;
			}
			if (Timestamp.class.isAssignableFrom(value.getClass())) {
				return (Timestamp) value;
			}
			if (value instanceof Long) {
				return new Timestamp((Long) value);
			}
			String strValue = (String) value;
			SimpleDateFormat dateParser = null;
			for (int i = 0; i < formats.length; i++) {
				if (null == dateParser) {
					dateParser = new SimpleDateFormat(formats[i]);
				} else {
					dateParser.applyPattern(formats[i]);
				}
				try {
					return new Timestamp(dateParser.parse(
							strValue.toLowerCase()).getTime());
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
			}

			return null;
		}

		@Override
		public Class morphsTo() {
			// TODO Auto-generated method stub
			return Timestamp.class;
		}
	}

	public Class morphsTo() {
		return Timestamp.class;
	}
	//struts2��ȡsession�����ַ�ʽ 1.��ActionContext�л�ȡ 2.ʵ��SessionAware
}
