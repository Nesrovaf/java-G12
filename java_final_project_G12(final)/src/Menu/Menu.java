package Menu;

import Get_Update_data.Update;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState {

    int modechange;
    Image play;
    Image exit;

    public Menu(int state){
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        modechange=0;
        play = new Image("Menu/resource/play.png");
        exit = new Image("Menu/resource/exit.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        Image titlescreen = new Image("Menu/resource/title.jpg");
        graphics.drawImage(titlescreen,0,0);
        graphics.drawImage(play,50,420);
        graphics.drawImage(exit,50,520);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(modechange==1){
            Update update = new Update();
            try {
                update.ATK_update(10);
                update.Exp_update(0);
                update.Health_update(100);
                update.Lv_update(1);
                update.MaxHealth_update(100);
                update.Money_update(5000);
                update.Medicine_large_update(3);
                update.Medicine_small_update(5);
                update.Sowrd_update(1);
                update.Bow_update(0);
                update.Spear_update(0);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            stateBasedGame.enterState(1,new FadeOutTransition(),new FadeInTransition());
        }
        if(modechange==2){
            gameContainer.exit();
        }
    }

    public void mouseClicked(int button, int x, int y, int clickCount) {
        if(button == Input.MOUSE_LEFT_BUTTON){
            if(x>50 && 428>x && y>420 && 498>y){
                modechange = 1;
            }
            if(x>50 && 395>x && y>520 && 599>y){
                modechange = 2;
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}
