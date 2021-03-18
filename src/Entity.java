/**
 * Clase base para crear entidades en el ambiente
 * @author Efraín
 */

import edu.epromero.util.*;

abstract public class Entity {
    protected int iCX;
    protected int iCY;
    protected Imagen imgSprite;
    protected int iWidth;
    protected int iHeight;
    
    /**
     * Funcion para iniciar los valores de una entidad
     * @param myCX La coordenada en x
     * @param myCY La coordenada en y
     * @param mySprite El sprite de la imagen
     */
    protected void start (int myCX, int myCY, String mySprite){
        setiCX(myCX);
        setiCY(myCY);
        imgSprite = new Imagen(mySprite);
    }
    
    /**
     * Pinta una entidad en la pantalla
     */
    public void Paint(){
        LienzoStd.dibujo(iCX, iCY, imgSprite);
    }
 
    /**
     * Regresa un booleano verdadero si una clase "Player" colisiona
     * @param Hero Jugador con el que se quiere colisionar
     * @return Booleano verdadero cuando hay colision
     */
    public boolean Colission(Player Hero){
        if(Hero.isbGoesD() 
                && (this.iCX - this.imgSprite.ancho()/2 < Hero.iCX + Hero.imgSprite.ancho()/2 || this.iCX - this.imgSprite.ancho()/2 < Hero.iCX - Hero.imgSprite.ancho()/2)
                && (this.iCX + this.imgSprite.ancho()/2 > Hero.iCX + Hero.imgSprite.ancho()/2 || this.iCX + this.imgSprite.ancho()/2 > Hero.iCX - Hero.imgSprite.ancho()/2)
                && (Hero.iCY - Hero.imgSprite.alto()/2 <= this.iCY + this.imgSprite.alto()/2  && Hero.iCY - Hero.imgSprite.alto()/2 >= this.iCY - this.imgSprite.alto()/2)
                ){
            return true;
        } else {
            return false;
        }        
    }
    
    /**
     * Funcion para mover abajo una entidad y hacerla reaparecer arriba de la pantalla
     */
    public void MoveDown(){       
        this.iCY = this.iCY-5;
        if(this.iCY <= LienzoStd.pideLimiteYMin()){  
            this.iCY = (int)LienzoStd.pideLimiteYMax();
            this.iCX = (int)StdRandom.uniforme(LienzoStd.pideLimiteXMin(),LienzoStd.pideLimiteXMax());
        }
    
    }
    
    /**
     * Getter de la coordenada x
     * @return coordenada x
     */
    public int getiCX() {
        return iCX;
    }

    /**
     * Setter para la coordenada x
     * @param iCX coordenada x
     */
    public void setiCX(int iCX) {
        this.iCX = iCX;
    }

    /**
     * Getter para la coordenada y
     * @return coordenada y
     */
    public int getiCY() {
        return iCY;
    }

    /**
     * Setter para la coordenada y
     * @param iCY coordenada y
     */
    public void setiCY(int iCY) {
        this.iCY = iCY;
    }

    /**
     * Getter para el Sprite
     * @return Sprite
     */
    public Imagen getImgSprite() {
        return imgSprite;
    }

    /**
     * Setter para el Sprite
     * @param imgSprite Sprite
     */
    public void setImgSprite(Imagen imgSprite) {
        this.imgSprite = imgSprite;
    }    
}
