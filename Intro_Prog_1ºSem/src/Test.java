public class Test {
	
/********************************************************** Semana 8 **********************************************************/
	
	@SuppressWarnings("unused")
	static void main(){
		//Imagem Original
		ColorImage img = new ColorImage("coffee.jpg");
		
		
		//Copiar
		ColorImage copy = img.copy();
		
		
		//Inverter
		img.invertColors();
		
		
		//Preto e Branco
		img.grayScale();	
		
		
		//Alterar Brilho
		img.brightness(-100);
		
		
		//Espelhar
		img.mirror();
		
		return;
	}
	
	/*Desenvolva uma função estática que dada uma imagem, produza uma nova com o seguinte efeito. 
	*Será útil desenvolver um procedimento extra, para além dos realizados anteriormente.*/
	
	static ColorImage extraProcedure(String s){
		ColorImage img=new ColorImage(s);
		img.extraProcedure();
		img.invertColors();
		img.grayScale();
		return img;
	}
	
	/*Problema: produzir a seguinte imagem (a partir da foto original). 
	 A solução será baseada apenas numa integração de funções e procedimentos realizados anteriormente.*/
	
	static ColorImage problem(String s){
		
		//Declarações
		ColorImage imgStart = new ColorImage(s);
		ColorImage imgEnd = new ColorImage (imgStart.getWidth()*2, imgStart.getHeight()*2);
		ColorImage img1 = new ColorImage(s);
		img1.mirror();
		img1.grayScale();
		ColorImage img2 = new ColorImage(s);
		ColorImage img3 = new ColorImage(s);
		img3.mirror();
		img3.invertColors();
		ColorImage img4 = new ColorImage(s);
		img4.grayScale();
		
		//Procedimentos
		imgEnd.paste(img1,0,0);
		imgEnd.paste(img2,imgEnd.getWidth()/2,0);
		imgEnd.paste(img3,0,imgEnd.getHeight()/2);
		imgEnd.paste(img4,imgEnd.getWidth()/2,imgEnd.getHeight()/2);
		
		//Retorno
		return imgEnd;
	}
	
/******************************************************** Exercícios Extra ********************************************************/
	
	static ColorImage[] test(String s){
		
		//Declarações
		ColorImage img=new ColorImage(s);
		ColorImage img1=img.selection(0,0,img.getWidth()/2,img.getHeight()/2);
		ColorImage img2=img.selection(img.getWidth()/2,0,img.getWidth(),img.getHeight()/2);
		ColorImage img3=img.selection(0,img.getHeight()/2,img.getWidth()/2,img.getHeight());
		ColorImage img4=img.selection(img.getWidth()/2,img.getHeight()/2,img.getWidth(),img.getHeight());
		ColorImage[] imgarray=new ColorImage[4];
		
		//Desenvolvimento
		imgarray[0]=img1;
		imgarray[1]=img2;
		imgarray[2]=img3;
		imgarray[3]=img4;
		
		//Retorno
		return imgarray;
	}
	
}