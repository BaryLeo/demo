package multi_threading;

import java.util.concurrent.Phaser;

public class MarriagePhaser extends Phaser {
    /**
     *
     * @param phase 第几次触发
     * @param registeredParties 触发总人数
     * @return
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:{
                System.out.println("都到齐了 "+registeredParties);
                return false;
            }
            case 1:{
                System.out.println("都吃完了 "+registeredParties);
                return false;
            }
            case 2:{
                System.out.println("都离开了 "+registeredParties);
                return false;
            }
            case 3:{
                System.out.println("洞房了 "+registeredParties);
                return true;
            }
            default:return true;
        }
    }
}
