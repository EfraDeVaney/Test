/**
 * Clase para una plataforma rompible
 * @author Efraín
 */

import edu.epromero.util.*;

public class PlatformBreaking extends PlatformBasic {
    
    /**
     * Constructor para una plataforma rompible
     */
    PlatformBreaking(){
        start(StdRandom.uniforme(0,(int)LienzoStd.pideLimiteXMax()),StdRandom.uniforme(0,(int)LienzoStd.pideLimiteYMax()/10)*10,"BreakingPlatform.png");
    }
    
    /**
     * Cambia el sprite para que parezca rota la plataforma
     */
    @Override
    void Break(){
        imgSprite = new Imagen("BreakingPlatform2.png");
        this.setImgSprite(imgSprite);            
    }
         
    /**
     * Cambia el sprite para que la plataforma se vea rompible
     */
    @Override
    void Reapear(){
        imgSprite = new Imagen("BreakingPlatform.png");
        this.setImgSprite(imgSprite);
    }
    
}
