package find.service.mailservice;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailService {
	
	private JavaMailSender mailSender;  
	
    public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

    public String send(String user_mail) { 
    	try {
    		Random random = new Random(); 
    	    String result="";
    	    for(int i=0;i<6;i++){
    	        result+=random.nextInt(10);    
    	    }
            SimpleMailMessage msg = new SimpleMailMessage();//SimpleMailMessage
            msg.setFrom("13990101637@163.com");
            msg.setTo(user_mail);
            msg.setSubject("FIND�˺�--���������֤");  
            msg.setText("�𾴵��û����,�����������֤��Ϊ:"+result);
            mailSender.send(msg);//�����ʼ�  
            return result;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}
