/**
 *
 * @author Efraín
 */
import edu.epromero.util.*;

public class Monster extends Entity{
    
    Monster(){
        start(StdRandom.uniforme(0,(int)LienzoStd.pideLimiteXMax()),StdRandom.uniforme(0,(int)LienzoStd.pideLimiteYMax()), "Monster.png");
    }
    
    
    
    /**
     * Regresa un booleano verdadero si una clase "Player" colisiona con el mounstro
     * @param Hero Jugador con el que se quiere colisionar
     * @return Booleano verdadero cuando hay colision
     */
    @Override
    public boolean Colission(Player Hero){
        if(        (this.getiCX()-this.getImgSprite().ancho()/2 < Hero.getiCX()+Hero.getImgSprite().ancho()/2 || this.getiCX()-this.getImgSprite().ancho()/2 < Hero.getiCX()-Hero.getImgSprite().ancho()/2)
                && (this.getiCX()+this.getImgSprite().ancho()/2 > Hero.getiCX()+Hero.getImgSprite().ancho()/2 || this.getiCX()+this.getImgSprite().ancho()/2 > Hero.getiCX()-Hero.getImgSprite().ancho()/2)
                && (Hero.getiCY()-Hero.getImgSprite().alto()/2 <= this.getiCY()+this.getImgSprite().alto()/2  && Hero.getiCY()-Hero.getImgSprite().alto()/2 >= this.getiCY()-this.getImgSprite().alto()/2)
                ){
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
