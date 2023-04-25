import java.awt.PageAttributes.ColorType;

/*
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : Son-Thang Pham(1856338) et Amal Metsahel(1853223)
 * @date : 24 septembre 2017
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/*
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/*
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color/Transparent)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/*
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color/Transparent)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/*
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color/Transparent)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/*
	 * Genere le negatif d'une image
	 */
	
	public void negate()
	{
		// complï¿½ter
		// AJOUT
		// Pour chaque pixel, on transforme sous la forme negative
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				imageData[i][j] = imageData[i][j].Negative();
		}
	}
	
	/*
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		// complï¿½ter
		// AJOUT
		// Pour chaque pixel, on transforme sous la forme noire et blanche
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				imageData[i][j] = imageData[i][j].toBWPixel();
		}
	}
	
	/*
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		// complï¿½ter
		// AJOUT
		// Pour chaque pixel, on transforme sous la forme grise
		for(int i=0; i<height; i++)
			{
				for(int j=0; j<width; j++)
					imageData[i][j] = imageData[i][j].toGrayPixel();
			}	
	}
	
	/*
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		// complï¿½ter
		// AJOUT
		// Pour chaque pixel, on transforme sous la forme couleur
		for(int i=0; i<height; i++)
			{
				for(int j=0; j<width; j++)
					imageData[i][j] = imageData[i][j].toColorPixel();
			}
	}
	
	public void convertToTransparentImage()
	{
		// complï¿½ter
		// AJOUT
		// Pour chaque pixel, on transforme sous la forme transparente
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				imageData[i][j] = imageData[i][j].toTransparentPixel();
		}
	}
	
	/*
	 * Fait pivoter l'image de 10 degres autour du pixel (i,j)=(0, 0)
	 * dans le sens des aiguilles d'une montre (clockWise == true)
	 * ou dans le sens inverse des aiguilles d'une montre (clockWise == false).
	 * Les pixels vides sont blancs.
	 * @param clockWise : Direction de la rotation 
	 */
	public void rotate(int x, int y, double angleRadian)
	{
		// complï¿½ter
		// AJOUT
		PixelMapPlus nouveau = new PixelMapPlus(this.getType(), height, width);
		
		// Afin d'avoir le meilleur effet possible, parcourez tous les
		// pixels de l'image cible et trouvez le pixel équivalent dans
		// l'image source (en utilisant la 2ème matrice).
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
			{
				double X = (Math.cos(angleRadian)*j) + (Math.sin(angleRadian)*i) + (-Math.cos(angleRadian)*x-Math.sin(angleRadian)*y+x);
				double Y = (-Math.sin(angleRadian)*j) + (Math.cos(angleRadian)*i) + (Math.sin(angleRadian)*x-Math.cos(angleRadian)*y+y);
				
				// on regarde si elle fait partie de l'image
				if(((int)X >= 0) && ((int)X < width) && 
						((int)Y >= 0) && ((int)Y < height)){
					nouveau.imageData[i][j] = this.getPixel((int)Y, (int)X);
				}
				// sinon on transforme en blanc 
				else {
					nouveau.imageData[i][j] = new BWPixel (true);
				}
			}
		}
		clearData();
		
		// nouvelle img
		this.imageData = nouveau.imageData;
	}
	
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		// complï¿½ter
		// AJOUT
		PixelMap newImage = new PixelMapPlus(imageType, h, w);

	    for (int i = 0; i < h; i++)
	    {
		  for (int j = 0; j < w; j++)
		  {
			// nouvelle/ancienne
			if (i < h && i < height && j < w && j < width)
			      newImage.imageData[i][j] = imageData[i][j];
		      // Sinon on ajoute des pixels blanc
			else
			      newImage.imageData[i][j] = new BWPixel(true);
		  }
	    }
	    height = h;
	    width = w;
	    clearData();
	    imageData = newImage.imageData;	
	}
	
	/*
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void inset(PixelMap pm, int row0, int col0)
	{
		// complï¿½ter
		// AJOUT
		for(int i=0; i <pm.height; i++) {
			for(int j=0; j < pm.width; j++) {
				if ((i + row0)< height && (j+col0 < width))
					imageData[i+row0][j+col0] = pm.imageData[i][j];
			}
		}
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		// complï¿½ter	
		// AJOUT
		if(h < 0 || w < 0)
			throw new IllegalArgumentException();
		else{
			// nouveau blanc
			PixelMapPlus nouveau = new PixelMapPlus(this.getType(), h, w);
			// La position (0, 0)
			nouveau.inset(this, 0, 0);
			// on change les donnees
			height = nouveau.height;
			width = nouveau.width;
			
			clearData();
			imageData = nouveau.imageData;
		}	
		
	}
	
	/*
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		// complï¿½ter		
		// AJOUT
		// nouveau blanc
		PixelMapPlus nouveau = new PixelMapPlus(this.getType(), height, width);
		
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width ; j++)
				nouveau.imageData[i][j] = new BWPixel(true);
		}
		
		for(int i=rowOffset; i<height; i++)
		{
			for(int j=colOffset; j<width; j++)
				nouveau.imageData[i][j]=getPixel(i, j);
		}
		
		// on change les donnees
		height = nouveau.height;
		width = nouveau.width;
		
		clearData();
		imageData = nouveau.imageData;
		
	}
	
	/**
	 * Effectue un zoom autour du pixel (x,y) d'un facteur zoomFactor 
	 * @param x : colonne autour de laquelle le zoom sera effectue
	 * @param y : rangee autour de laquelle le zoom sera effectue  
	 * @param zoomFactor : facteur du zoom a effectuer. Doit etre superieur a 1
	 */
	public void zoomIn(int x, int y, double zoomFactor) throws IllegalArgumentException
	{
		if(zoomFactor < 1.0)
			throw new IllegalArgumentException();
		
		// complï¿½ter
		// AJOUT
		int widthInit = width;
		int heightInit = height;
		
		double largeur = width/zoomFactor;
		double hauteur = height/zoomFactor;
		

		int xGaucheHaut = (int)(x - (largeur/2));
		int yGaucheHaut = (int)(y - (hauteur/2));
		int xDroiteHaut = xGaucheHaut + (int)largeur;
		int yGaucheBas = yGaucheHaut + (int)hauteur;
		
		// condition en haut a gauche et repositionnement
		if(xGaucheHaut < 0)
			xGaucheHaut = 0;
		
		// condition en haut a droite et repositionnement
		if(yGaucheHaut < 0)
			yGaucheHaut = 0;
		
		// deplacement de l'image en haut a gauche
		if(yGaucheBas > height){
			int espace = yGaucheBas - height;
			yGaucheHaut -= espace;
			yGaucheBas = height;	
		}
		
		// deplacement de l'image en haut a droite
		if(xDroiteHaut > width){
			int espace = xDroiteHaut - width;
			xGaucheHaut -= espace;
			xDroiteHaut = width;	
		}
		
		// nouvelle image
		PixelMapPlus nouveau = new PixelMapPlus(this.getType(),(int)hauteur, (int)largeur);
		int colN = xGaucheHaut - 1;		
		int rowN= yGaucheHaut;

		for(int i=0; i < nouveau.height ; i++)
		{
			for(int j=0; j < nouveau.width ; j++)
			{
				colN++;
				nouveau.imageData[i][j] = this.getPixel(rowN, colN);
			}
			rowN++;
			colN = xGaucheHaut - 1 ;
		}
		height = nouveau.height;
		width = nouveau.width;
		
		clearData();
		imageData = nouveau.imageData;
		resize(widthInit, heightInit);
	}

	/**
	 * Effectue un remplacement de tout les pixels dont la valeur est entre min et max 
	 * avec newPixel
	 * @param min : La valeur miniale d'un pixel
	 * @param max : La valeur maximale d'un pixel  
	 * @param newPixel : Le pixel qui remplacera l'ancienne couleur 
	 * (sa valeur est entre min et max)
	 */
	public void replaceColor(AbstractPixel min, AbstractPixel max,
			AbstractPixel newPixel) {
		
		// complï¿½ter
		// AJOUT
		for(int i=0; i < height; i++)
		{
			for(int j=0; j < width; j++)
			{
				if (imageData[i][j].compareTo(max) < 0 && imageData[i][j].compareTo(min) > 0)
					imageData[i][j] = newPixel;
			}
		}
		clearData();
	}

	public void inverser() {

		// complï¿½ter
		// AJOUT
		PixelMapPlus newPixelMapPlus = new PixelMapPlus(this.getType(), height, width);

		int hauteur = height - 1;
		for(int i=0; i < height; i++)
		{
			for(int j=0; j < width; j++)	
				 newPixelMapPlus.imageData[i][j] = this.getPixel(hauteur - i, j);
		}
		
		clearData();
		
		// nouvelle img
		this.imageData = newPixelMapPlus.imageData;
	}
}
