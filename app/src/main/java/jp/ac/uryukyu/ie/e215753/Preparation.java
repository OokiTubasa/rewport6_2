package jp.ac.uryukyu.ie.e215753;
import java.util.Random;

public class Preparation {
    int playerPoint;
    int enemyPoint;
    int[] playerCard = new int[50]; 
    int[] enemyCard = new int[50];
    int p_math;
    int e_math;

    void hand(){
        Random random = new Random();

        for (int i = 0; i<2; i++){
            enemyCard[i] = random.nextInt(10) + 1;
            enemyPoint += enemyCard[i];
            e_math += 1;
        }
        for(int k = 0; k<2; k++){
            playerCard[k] = random.nextInt(10) + 1;
            playerPoint += playerCard[k];
            p_math += 1;
        }
        System.out.println("ディーラー"+e_math+"枚　合計点＿"+enemyPoint);
        System.out.println("あなた"+p_math+"枚　合計点＿"+playerPoint);
    }
}