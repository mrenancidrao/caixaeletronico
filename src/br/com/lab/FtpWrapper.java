package br.com.lab;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class FtpWrapper {
	
    private static FtpWrapper instance;
    private FTPClient ftp;
     
    private FtpWrapper(){
              this.ftp = new FTPClient();
    }
     
    public static FtpWrapper getInstance(){
              if (instance == null){
                       instance = new FtpWrapper();
              }
              return instance;
    }
     
    public String currentDirectory(){
              try {
                       checkIfConected();
                       return ftp.printWorkingDirectory();
              } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                       return null;
              }
    }
     
    private void checkIfConected(){
              if (!ftp.isConnected()){
                       throw new RuntimeException("Não está conectado ao FTP");
              }
    }
     
    public void connect(String hostname){
              try {
                       if (ftp.isConnected()){
                                 throw new RuntimeException("Já conectado");
                       }
                       ftp.connect(hostname);
              } catch (SocketException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
              } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
              }
    }
     
    public void login(String username, String password){
              try {
                       ftp.login(username, password);
              } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
              }
    }
     
    public void changeWorkingDirectory(String targetDir){
              try {
                       checkIfConected();
                       ftp.changeWorkingDirectory(targetDir);
              } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
              }
    }
     
    public String[] listNames(){
              try {
                       checkIfConected();
                       return ftp.listNames();
              } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                       return null;
              }
    }

}
