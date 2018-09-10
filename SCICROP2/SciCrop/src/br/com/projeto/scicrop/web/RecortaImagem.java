package br.com.projeto.scicrop.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;



public class RecortaImagem {

	
	
	public static void recortar(File caminhoImagemOriginal, File ondeSalvarImagemRecordata, int width, int height,String formatoImagem )throws Exception {
			BufferedImage original = ImageIO.read(caminhoImagemOriginal);
			BufferedImage imagemRecortada = new BufferedImage(width, height, original.getType());
			Graphics2D g2 = imagemRecortada.createGraphics();
			g2.drawImage(original, 0, 0, width, height, null);
			g2.dispose();
			ImageIO.write(imagemRecortada,formatoImagem, ondeSalvarImagemRecordata);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// fim teste
	
//			File imagemOriginal = new File("C:\\Users\\Fernando\\Desktop\\corinthians.png");
//			File imagemRecortada = new File("C:\\Users\\Fernando\\Desktop\\corinthians2.png");
	
//	public static void main(String[] args) {
//		File caminhoImagemOriginal = new File("C:\\Users\\Fernando\\Desktop\\corinthians.png");
//		File ondeSalvarImagem = new File("C:\\Users\\Fernando\\Desktop\\TesteFinal.png");
//		
//		RecortaImagem.recortar(caminhoImagemOriginal, ondeSalvarImagem, 100, 100, "png");
//		
//	}
//					
//		public static void recortar
//				(File caminhoImagemOriginal, File ondeSalvarImagem, int width, int height, String formatoImagem) {
//			if(caminhoImagemOriginal != null) {
//			
//				try {
//					BufferedImage imagemOriginal = ImageIO.read(caminhoImagemOriginal);
//					BufferedImage imagemRecortada = new BufferedImage(width, height, imagemOriginal.getType());
//					Graphics2D g2 = imagemOriginal.createGraphics();
//					g2.drawImage(imagemOriginal,0,0,width,height,null);
//					g2.dispose();
//					
//					ImageIO.write(imagemRecortada, formatoImagem, ondeSalvarImagem);
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}//fim condi��o
//		
//			
//		}
		
}
