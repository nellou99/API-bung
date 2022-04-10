package Service.Email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);

    @Autowired
    private JavaMailSender javaMailSender;
    private static final String senderEmailWkDev = "hardilamachine@gmail.com";

    public void sendEmail(String toEmail, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(senderEmailWkDev);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        javaMailSender.send(simpleMailMessage);
    }

    public void sendTestEmail(String toEmail) {
        sendEmail(toEmail, "Email for Test", "User was save");
        log.info("Test Email was sent");
    }
}
