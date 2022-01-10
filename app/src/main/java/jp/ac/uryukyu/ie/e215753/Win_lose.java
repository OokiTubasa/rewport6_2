package jp.ac.uryukyu.ie.e215753;

public class Win_lose {
    String str;

    public String judge(int playerPoint, int enemyPoint){
        if (playerPoint > enemyPoint){
            str = "あなたの勝ち！！";
        }
        else if (playerPoint == enemyPoint){
            str = "引き分け";
        }
        else if (playerPoint < enemyPoint){
            str = "あなたの負け、、、。";
        }
        return str;
    }
}
