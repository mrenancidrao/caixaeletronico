package br.com.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ftpManager")
@ViewScoped
public class FtpManager {
	 private String hostName, username, password, newDir;
     private List<String> arquivos;

     private void showMessage(String message) {
               FacesContext fc = FacesContext.getCurrentInstance();
               fc.addMessage(null, new FacesMessage(message));
     }

     public void conectar() {
               try {
                        FtpWrapper.getInstance().connect(hostName);
                        FtpWrapper.getInstance().login(username, password);
                        newDir = FtpWrapper.getInstance().currentDirectory();
                        showMessage("Conectado com sucesso em " + hostName);
               } catch (Exception e) {
                        showMessage(e.getMessage());
              }
     }

     public void mudarDiretorio() {
               try {
                        FtpWrapper.getInstance().changeWorkingDirectory(newDir);
                        showMessage("Diretório alterado para "+newDir);
               } catch (Exception e) {
                        showMessage(e.getMessage());
               }
     }

     public void listarArquivos() {
               try {
                        arquivos = new ArrayList<String>(Arrays.asList(FtpWrapper
                                           .getInstance().listNames()));
                        showMessage("Arquivos carregados com sucesso");
               } catch (Exception e) {
                        showMessage(e.getMessage());
               }
     }

     public String getHostName() {
               return hostName;
     }

     public void setHostName(String hostName) {
               this.hostName = hostName;
     }

     public String getUsername() {
               return username;
     }

     public void setUsername(String username) {
               this.username = username;
     }

     public String getPassword() {
               return password;
     }

     public void setPassword(String password) {
               this.password = password;
     }

     public String getNewDir() {
               return newDir;
     }

     public void setNewDir(String newDir) {
               this.newDir = newDir;
     }

     public List<String> getArquivos() {
               return arquivos;
     }

     public void setArquivos(List<String> arquivos) {
               this.arquivos = arquivos;
     }
}
