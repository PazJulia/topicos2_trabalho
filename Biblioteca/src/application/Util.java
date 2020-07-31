package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {
	// /images
	public static final String PATH_IMAGES = File.separator + "images";
	// /images/professor
	public static final String PATH_IMAGES_PROFESSOR = PATH_IMAGES + File.separator + "professor";
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.sha256Hex("asldkjfa;lskdjf;laksjdflaksjdflkjas;dlkfja;lskdjf;alksjdf;lkasjdf;lkasjd;flkjasd;lkfjas;dlkjfa;sldkjf;laksdjf;lkasjd;flkjasd;lkjf;lasdkjf;laksjdf;lkjasd;lkfjas;dlkj"));
	}
	
	public static String hashSHA256(String valor) {
		return DigestUtils.sha256Hex(valor);
	}

	public static void addMessageInfo(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

	public static void addMessageWarn(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
	}

	public static void addMessageError(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}
	
	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			addMessageError("Erro ao redirecionar a página.");
			e.printStackTrace();
		}
	}
	
	public static boolean saveImageProfessor(InputStream inputStream, String imageType, int idProfessor) {
		// Exemplo da maquina do janio: /home/janio/images/professor
		String diretorio = System.getProperty("user.home") + PATH_IMAGES_PROFESSOR;
		
		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exeista ele cria tambem)
		}
		
		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada 
			BufferedImage bImage = ImageIO.read(inputStream);
			
			// estrutura final do arquivo ex: /home/janio/images/professor/01.png
			File arquivoFinal = new File(diretorio + File.separator + idProfessor + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}