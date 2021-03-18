/**
 * Clase para crear un jugador
 * @author Efraín
 */

import edu.epromero.util.*;

public class Player extends Entity {
    
    protected boolean bGoesD;
    
    /**
     * Constructor para un jugador
     */
    Player(){
        start(0, 0, "Player.png");
    }
    
    void Move(){
        MoveLR();
        MoveUD();
    }
    
    void MoveLR(){
        
        if(LienzoStd.fuePulsadaTecla(37)){
            iCX = iCX - 3;
            imgSprite = new Imagen("Player2.png");
            this.setImgSprite(imgSprite);
        }
        
        if(LienzoStd.fuePulsadaTecla(39)){
            iCX = iCX + 3;
            imgSprite = new Imagen("Player.png");
            this.setImgSprite(imgSprite);
        }
        
    }
    
    /**
     * Mueve al personaje
     */
    void MoveUD(){
        
        if (iCX >= LienzoStd.pideLimiteXMax()){
            iCX = (int)LienzoStd.pideLimiteXMin();
            LienzoStd.dibujo(iCX, iCY, imgSprite);   
        }
        
        if (iCX <= LienzoStd.pideLimiteXMin()){
            iCX = (int)LienzoStd.pideLimiteXMax();
            LienzoStd.dibujo(iCX, iCY, imgSprite);   
        }
        
        if(this.isbGoesD()){
            iCY = iCY - 3;    
        } else {
            iCY = iCY + 3;
            if (iCY + imgSprite.alto() / 2 > LienzoStd.pideLimiteYMax()-LienzoStd.pideLimiteYMax()/3)
                setbGoesD(true);
        }
        
    }

    /**
     * El jugador va hacia abajo?
     * @return true = el jugador va hacia abajo, false = el jugador va hacia arriba
     */
    public boolean isbGoesD() {
        return bGoesD;
    }

    /**
     * Define la direccion del jugador
     * @param bGoesD true = va hacia abajo, false = va havcia arriba
     */
    public void setbGoesD(boolean bGoesD) {
        this.bGoesD = bGoesD;
    }
                
}
