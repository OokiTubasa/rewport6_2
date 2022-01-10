package jp.ac.uryukyu.ie.e215753;

public class Win_lose {
    String str;
    /**
     * 勝敗を決定するメソッド
     * 点数を比べ、高い方の勝ちとなる
     * バーストの際はこのメソッドを通すことなく、すぐに勝敗が決まる
     * @param playerPoint
     * @param enemyPoint
     * @return
     */
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
