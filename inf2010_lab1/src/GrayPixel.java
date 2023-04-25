/**
 * Classe de pixel en tons de gris
 * @author : Son-Thang Pham(1856338) et Amal Metsahel(1853223)
 * @date : 24 septembre 2017
 */

public class GrayPixel  extends AbstractPixel 
{
	int pixel; // donnee du pixel
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	GrayPixel()
	{
		this.pixel = 255;
	}
	
	/**
	 * Constructeur par parametre
	 * @param pixel : valeur du pixel
	 */
	GrayPixel(int pixel)
	{
		// complet
		this.pixel = pixel;
	}
	
	/**
	 * Renvoie la valeur du pixel
	 */
	public int getPixel()
	{
		return pixel;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param pixel: valeur a assigner 
	 */
	public void setPixel(int pixel)
	{
		this.pixel = pixel;
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// complet
		if(this.pixel <= 127)
			return new BWPixel(false);
		else
			return new BWPixel(true);
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
		// complet
		return new GrayPixel(this.pixel);
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		// complet
		int[]rgb={this.pixel,this.pixel,this.pixel};
		return new ColorPixel(rgb);
	}
	
	public TransparentPixel toTransparentPixel()
	{
		// complet
		int[]rgba={this.pixel,this.pixel,this.pixel,255};
		return new TransparentPixel(rgba);
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public AbstractPixel Negative()
	{
		// complet
		return new GrayPixel(255-this.pixel);
	}
	
	public void setAlpha(int alpha)
	{
		//ne fait rien
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return ((Integer)(pixel)).toString() + " ";
	}
	
	public int compareTo(AbstractPixel p) {
		if (this.pixel < ((GrayPixel) p).pixel) {
			return -1;
		} else {
			if (this.pixel == ((GrayPixel) p).pixel) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}
}
