package find.action.fileaction;

import java.io.File;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import find.service.classservice.ClassService;
import find.util.BaseAction;

public class PhotoAction extends BaseAction{
	
	private File image; 
    private String imageFileName; 
    private String imageContentType; 
    private ClassService classservice;
    HttpServletRequest request;
    
    String s="F:"+"\\"+"workspace2"+"\\"+"FIND";
    
    public String execute() throws Exception {
    	
    	//String s= Class.class.getClass().getResource("/").getPath();
    	
    	//String p=ServletActionContext.getServletContext().getRealPath("");
    	//
    	/*String p=ServletActionContext.getServletContext().getRealPath("");
    	
    	System.out.println("p:"+p);*/
    	
    	/*String path2 = request.getSession().getServletContext().getRealPath("/");
    	System.err.println(path2);*/
    	String pathh=request.getContextPath();
    	
    	System.err.println(s);
    	String path=s+"\\"+"upload"+"\\";
        if (image != null) {
            File savefile = new File(new File(path), imageFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(image, savefile);
            String savepath="\\"+"upload"+"\\"+imageFileName;
            System.out.println("savepath:"+savepath);
        }
        String realpath=path+imageFileName;
        ActionContext.getContext().put("file", realpath);
        System.out.println("realpath: "+realpath);
        return "success";
    }
    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public ClassService getClassservice() {
		return classservice;
	}

	public void setClassservice(ClassService classservice) {
		this.classservice = classservice;
	}
	public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    

}
