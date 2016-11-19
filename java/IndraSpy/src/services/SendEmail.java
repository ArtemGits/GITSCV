package services;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@WebServlet(name = "SendEmail", urlPatterns = "/send_email")
public class SendEmail extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    

    private static Properties emailProperties;
    private static Session mailSession;
    private static MimeMessage emailMessage;

    private static String emailHost = "smtp.gmail.com";
    private static String emailPort = "587";// gmail's smtp port
    private static String fromUser = "agiths.salagaev@gmail.com";// your gmail id
    private static String fromUserEmailPassword = "gits2016";
    private static String[] toEmails = { "agiths.salagaev@gmail.com" };


     
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
         
       
        String message = null;
        String status = null;
        if (request.getParameter("submit") != null) {
            
            setMailServerProperties();
            String emailSubject = "Contact Form using Java JSP GMail";
            String emailBody = "";
            if (request.getParameter("name") != null) {
                emailBody = "Sender Name: " + request.getParameter("name")
                        + "<br>";
            }
            if (request.getParameter("email") != null) {
                emailBody = emailBody + "Sender Email: "
                        + request.getParameter("email") + "<br>";
            }
           
            if (request.getParameter("comments") != null) {
                emailBody = emailBody + "Message: " + request.getParameter("comments")
                        + "<br>";
            }
            try {
                createEmailMessage(emailSubject, emailBody);
            } catch (AddressException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                sendEmail();
                status = "success";
                message = "Email sent Successfully!";
            } catch (MessagingException me) {
                status = "error";
                message = "Error in Sending Email!";
            }
        }
        
        
        if (null != message) {
        	request.setAttribute("Message", message);
            request.getRequestDispatcher("ind_index.jsp").forward(request, response);
            System.out.println(message);
                    
        }   
         
   }
    
    public void sendEmail() throws AddressException, MessagingException {
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
    }
    
    
    
    public void createEmailMessage(String emailSubject, String emailBody)
            throws AddressException, MessagingException {
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);
        for (int i = 0; i < toEmails.length; i++) {
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email

    }

    public void setMailServerProperties() {
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
    }

    
}

