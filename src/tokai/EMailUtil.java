/*
    Bases de Datos Distribuidas 5751
    Ramírez Torres Iñaki Sebastián
*/
package tokai;

import java.io.UnsupportedEncodingException;
import java.util.Date;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author hinse
 */
public class EMailUtil {
    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@gmail.com", "Protocolo NoReplicar"));
            msg.setReplyTo(InternetAddress.parse("no_reply@gmail.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Mensaje enviado");
            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Correo Electrónico Enviado con Exito");
            System.out.println("Correo Electrónico Enviado con Exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}