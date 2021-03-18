/**
 *
 * @author Efraín
 */
import edu.epromero.util.*;

public class DoodleJump {
    
    public static void main(String[] args) throws InterruptedException {
        
        //Tamaño de la ventana
        int xMax = 255;
        int yMax = 511;
        
        LienzoStd.ponTamanioLienzo(xMax, yMax);
        LienzoStd.ponEscalaX(0, xMax);
        LienzoStd.ponEscalaY(0, yMax);
        Imagen fondo = new Imagen("Background.png");
        PlatformBasic[] BaP = new PlatformBasic[15];
        
        
        
                
        while(true){
            
            //Generadores del personaje y el monstruo
            Player Doo = new Player();
            Monster Mo = new Monster();
            int counter = 00;
            
            //Generador aleatorio de plataformas
            for(int i = 0; i < BaP.length; i++){
                int chance = StdRandom.uniforme(1,100);
                if (chance >= 1 && chance <= 60)
                    BaP[i] = new PlatformBasic();
                if (chance >= 61 && chance <= 85)
                    BaP[i] = new PlatformMobile();
                if (chance >= 86 && chance <= 100)
                    BaP[i] = new PlatformBreaking();
            }
            
            
            //Condicion para que el juego empieze
            while(Doo.getiCY() > LienzoStd.pideLimiteYMin()){
                
                //Actualizacion de frames en pantalla
                LienzoStd.mostrar(0);
                LienzoStd.limpia();
                LienzoStd.dibujo(LienzoStd.pideLimiteXMax()/2, LienzoStd.pideLimiteYMax()/2, fondo);
                LienzoStd.texto(xMax-15, yMax-15, String.valueOf(counter));
                //Movimiento del personaje
                Doo.Paint();
                Doo.Move(); 
                Mo.Paint();
            
                for(int j=0; j<BaP.length; j++){                    
                    
                    BaP[j].Paint();
                    
                    if(BaP[j].getClass() == PlatformMobile.class)
                        BaP[j].Move();
                    
                    if(BaP[j].getClass() == PlatformBreaking.class && BaP[j].iCY >= LienzoStd.pideLimiteYMax()-LienzoStd.pideLimiteYMax()/4)
                        BaP[j].Reapear();                   
                    
                    if(BaP[j].Colission(Doo)){  
                        
                        //Colision plataformas mobiles y basicas para bajar las plataformas y el monstruo
                        if((BaP[j].getClass() == PlatformBasic.class || BaP[j].getClass() == PlatformMobile.class) && BaP[j].iCY> LienzoStd.pideLimiteYMax()/5 ){
                            counter = counter + 10;
                            
                            for(int l=0; l < Doo.getiCY()/5 ; l++){
                                Mo.MoveDown();
                                LienzoStd.mostrar(0);
                                LienzoStd.limpia();
                                LienzoStd.dibujo(LienzoStd.pideLimiteXMax()/2, LienzoStd.pideLimiteYMax()/2, fondo);
                                LienzoStd.texto(xMax-15, yMax-15, String.valueOf(counter));
                                //Movimiento del personaje
                                Doo.Paint();
                                Doo.Move(); 
                                Mo.Paint();                                
                                for (PlatformBasic BaP1 : BaP) {
                                    BaP1.MoveDown();
                                    BaP1.Paint();
                                    BaP1.Move();
                                    
                                }
                                if(Mo.Colission(Doo)){
                                    Doo.setiCY(-20);
                                    Doo.setbGoesD(true);
                                }
                                Thread.sleep(10);
                            }
                            Doo.setbGoesD(false);
                        }
                        
                        //Colision plataformas mobiles y basicas sin bajar plataformas
                        if((BaP[j].getClass() == PlatformBasic.class || BaP[j].getClass() == PlatformMobile.class)){
                            Doo.setbGoesD(false);
                        }
                        
                        //Colision para romper las plataformas rompibles
                        if(BaP[j].getClass() == PlatformBreaking.class){
                            BaP[j].Break();                            
                        }  
                    }
                    
                    if(Mo.Colission(Doo)){
                        Doo.setiCY(-20);
                        Doo.setbGoesD(true);
                    }
                }            
                Thread.sleep(10);            
            }
            
            //Condicion para que el juego termine
            while(Doo.getiCY() < LienzoStd.pideLimiteYMin() ){
                LienzoStd.mostrar(0);
                LienzoStd.limpia();
                LienzoStd.texto(xMax/2, yMax/2, "Espacio para continuar");
                //Condicion para reiniciar el juego
                if(LienzoStd.fuePulsadaTecla(32)){
                    Doo.setiCY(5);
                    Doo.setbGoesD(false);  
                }   
            }
        }            
    }    
}
