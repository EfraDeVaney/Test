/**
 * Clase para una plataforma basica
 * @author Efraín
 */

import edu.epromero.util.LienzoStd;
import edu.epromero.util.StdRandom;

public class PlatformBasic extends Entity{
    
    /**
     * Constructor para una plataforma basica
     */
    PlatformBasic(){
        start(StdRandom.uniforme(0,(int)LienzoStd.pideLimiteXMax()),StdRandom.uniforme(0,(int)LienzoStd.pideLimiteYMax()/10)*10,"BasicPlatform.png");
    }
 
    void Move(){}
    
    void Break(){}
    
    void Reapear(){}
            
}
