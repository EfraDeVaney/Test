/**
 * Clase para una plataforma movil
 * @author Efraín
 */

import edu.epromero.util.*;

public class PlatformMobile extends PlatformBasic{
    
    private int iSpeed;
    private boolean bGoesR;
    
    /**
     * Funcion para iniciar los valores de una plataforma
     * @param cX La coordenada en x
     * @param cY La coordenada en y
     * @param mySprite El nombre del Sprite
     * @param mySpeed La velocidad con la que se mueve la plataforma
     */
    private void start(int cX, int cY, String mySprite, int mySpeed){
        super.start(cX, cY, mySprite);
        setbGoesR(true);
        setiSpeed(mySpeed);
    }
    
    /**
     * Constructor para crear una plataforma movil
     */
    PlatformMobile(){
        start(StdRandom.uniforme(0,(int)LienzoStd.pideLimiteXMax()),StdRandom.uniforme(0,(int)LienzoStd.pideLimiteYMax()/10)*10,"MobilePlatform.png", StdRandom.uniforme(1,3));
    }
    
    /**
     * Mueve la plataforma de izquierda a derecha
     */
    
    
    @Override
    void Move(){
        
        if (this.isbGoesR()){
            iCX = iCX + iSpeed;
            if (iCX + imgSprite.ancho() / 2 > LienzoStd.pideLimiteXMax())
                this.setbGoesR(false);
        } else {
            iCX = iCX - iSpeed;
            if (iCX - imgSprite.ancho() / 2 < LienzoStd.pideLimiteXMin())
                this.setbGoesR(true);
        }
    }

    /**
     * La plataforma va a la derecha?
     * @return direccion de la plataforma en el eje x
     */
    public boolean isbGoesR() {
        return bGoesR;
    }

    /**
     * Define si la ´plataforma se mueve a la derecha
     * @param bGoesR true = va a la derecha false = va a la izquierda
     */
    public void setbGoesR(boolean bGoesR) {
        this.bGoesR = bGoesR;
    }

    /**
     * Te da la velocidad de la plataforma
     * @return Velocidad de la plataforma
     */
    public int getiSpeed() {
        return iSpeed;
    }

    /**
     * Define la velocidad de la plataforma
     * @param iSpeed La velocidad que quieres tenga la plataforma
     */
    public void setiSpeed(int iSpeed) {
        this.iSpeed = iSpeed;
    }
    
}
    