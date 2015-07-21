/*
 * Copyright (C) 2003-2010 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */

import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import java.util.Properties;

import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.cms.scripts.CmsScript;
import org.exoplatform.services.jcr.core.ManageableRepository;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.mail.MailService;
import org.exoplatform.services.mail.Message;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;



public class SendMailScript implements CmsScript {

  private static Log log_ = ExoLogger.getLogger("ecm.SendMailScript");
  private static String DEFAULT_MAIL = "exosender@gmail.com";
  private static String DEFAULT_DESCRIPTION = "You have received a message from ";
  
  public SendMailScript() throws Exception {
  }
  
  public void execute(Object context) {               
    Map variables = (Map) context;                      
    String to = variables.get("exo:to").toString();     
    String from = variables.get("exo:from").toString();
    String nodePath = (String)variables.get("nodePath");
    String workspace = (String)variables.get("srcWorkspace");
    String srcPath = (String)variables.get("srcPath");
    System.out.println("nodePath: " + nodePath);
    System.out.println("workspace: " + workspace);
    System.out.println("srcPath: " + srcPath);
    Node contactNode = getNode(workspace, nodePath);
        
    Message message = new Message();
    message.setFrom(getFrom());
    message.setSubject(getSubject(contactNode));
    message.setMimeType("text/html");
    message.setBody(getMessage(contactNode));
    ExoContainer container = ExoContainerContext.getCurrentContainer();     
    MailService mailService = (MailService) container.getComponentInstanceOfType(MailService.class);
    
    String address = getAddress();
    message.setTo(address);
    try {
      mailService.sendMessage(message);
    } catch (Exception e) {
      if (log_.isDebugEnabled()) {
        log_.debug(String.format("Failed to send notification email to user: %s", address), e);
      }
    }
  }
  
  private Node getNode(String ws, String path) {
    Session session;
    Node node;
    try{
      session = WCMCoreUtils.getSystemSessionProvider().
                             getSession(ws, WCMCoreUtils.getRepository());
      node = (Node)session.getItem(path);
      return node;
    } catch(Exception e) {
      if (log_.isDebugEnabled()) {
        log_.debug("Can not get node", e);
      }
      return null;
    }
  }
  
  private String getFrom() {
    Properties props = new Properties(System.getProperties());
    String mailAddr = props.getProperty("gatein.email.smtp.from");
    if (mailAddr == null || mailAddr.length() == 0) mailAddr = props.getProperty("mail.from");
    if (mailAddr == null) mailAddr = DEFAULT_MAIL;
    try {
      InternetAddress addr = new InternetAddress("Contact");
      InternetAddress serMailAddr = new InternetAddress(mailAddr);
      addr.setAddress(serMailAddr.getAddress());
      return addr.toUnicodeString();
    } catch (AddressException e) {
      if (log_.isDebugEnabled()) { log_.debug("value of 'gatein.email.smtp.from' or 'mail.from' in configuration file is not in format of mail address", e); }
      return null;
    }
  }
  
  private String getSubject(Node contactNode) {
    try {
      String subject = "Contact of " + contactNode.getProperty("exo:userName").getString();
      return subject;
    } catch (RepositoryException e) {
      if (log_.isDebugEnabled()) { 
        log_.debug("Can not generate mail subject", e); 
      }
      return "Contact: ";
    }
  }
  
  private String getMessage(Node contactNode) {
    try {
      StringBuilder sbt = new StringBuilder();
      String userName = contactNode.getProperty("exo:userName").getString();
      String userEmail = contactNode.getProperty("exo:userEmail").getString();
      String userPhone = contactNode.getProperty("exo:userPhone").getString();
      String userMessage = contactNode.getProperty("exo:userMessage").getString();
      
      sbt.append("<html>")
         .append("  <head>")
         .append("  </head>")
         .append("  <body>")
         .append("    <table>")
         .append("      <tr><td>Name: </td><td>").append(userName).append("</td></tr>")
         .append("      <tr><td>Email: </td><td>").append(userEmail).append("</td></tr>")
         .append("      <tr><td>Phone: </td><td>").append(userPhone).append("</td></tr>")
         .append("      <tr><td>Message: </td><td>").append(userMessage).append("</td></tr>")
         .append("    </table>")
         .append("  </body>")
         .append("</html>");
      return sbt;
    } catch (RepositoryException e) {
      if (log_.isDebugEnabled()) { 
        log_.debug("Can not generate mail content", e);
      }
      return "";
    }
  }
  
  private String getAddress() {
    Properties props = new Properties(System.getProperties());
    String mailAddr = props.getProperty("dynamico.mail.to");
    if (mailAddr == null) { 
      mailAddr = "contact@yourcompany.com";
    }
    try {
      InternetAddress addr = new InternetAddress("Contact");
      InternetAddress serMailAddr = new InternetAddress(mailAddr);
      addr.setAddress(serMailAddr.getAddress());
      return addr.toUnicodeString();
    } catch (AddressException e) {
      if (log_.isDebugEnabled()) { log_.debug("value of 'gatein.email.smtp.from' or 'mail.from' in configuration file is not in format of mail address", e); }
      return null;
    }
  }

  public void setParams(String[] params) {}

}