package jp.ac.uryukyu.ie.e215753;
import java.util.*;

/**バトルクラス
 *  1.準備。初期の手札を決める
 * 2.ヒットかスタンドを選択
 * 3.バーストしていないかチェック
 *  4.点数を競う
 * の順に進めていく。
*/
public class Battle {
    int playerPoint;//あなたの点数
    int enemyPoint;//ディーラーの点数
    int[] playerCard = new int[50]; 
    int[] enemyCard = new int[50];
    int p_math;//あなたのカード数
    int e_math;//ディーラーのカード数
    String Result;//勝敗

    Win_lose ju = new Win_lose();

    /**準備クラス
     * プレイヤーにはランダムに2枚、ディーラーにはランダムに１枚のカードを配る
     * これで、最初の手札を決める。
     */
    void preparation(){
        
        Random random = new Random();

        for(int k = 0; k<2; k++){//プレイヤーの手札
            playerCard[k] = random.nextInt(9) +1;
            p_math += 1;
            if (playerCard[k] == 1) {
                playerCard[k] = 11;
            }
            playerPoint += playerCard[k];
        }

        for (int i = 0; i<1; i++){//ディーラーの手札
            enemyCard[i] = random.nextInt(9) +1;//ランダムでは０が出てくる可能性があるため＋１をする
            e_math += 1;
            if (enemyCard[i] == 1) {
                enemyCard[i] = 11;
            }
            enemyPoint += enemyCard[i];
        }
        System.out.println("あなたの最初の点数は"+ playerPoint);
        System.out.println("ディーラーの最初の点数は"+ enemyPoint);
    }

    /**プレイクラス
     * ヒットかスタンドを選び、半角の0か1で選択
     * ヒットを選んだ場合は、プレイヤーのカードが一枚増える
     * スタンドを選んだ場合は、プレイヤーの手札を確定し、ディーラーの点数が１７以上になるまでカードを引く。
     * その後、勝敗クラスによって、点数を競う。
    */
    void play(){
        Random random = new Random();
        System.out.println("あなた"+p_math+"枚　　　合計点＿"+playerPoint);
        System.out.println("ディーラー"+e_math+"枚　合計点＿"+enemyPoint);

        for (int k = 2 ; playerPoint < 22; k++){
            System.out.println("0:Hit？ or 1:Stand？");
            String judge = new Scanner(System.in).nextLine();
            if (judge.equals("0")) {//0＿ヒットを選択した場合
                playerCard[k] = random.nextInt(9) +1;
                p_math += 1;
                if (playerCard[k] == 1) {//1を11として扱う
                    playerCard[k] = 11;
                }
                playerPoint += playerCard[k];
                System.out.println("あなた"+p_math+"枚　　　合計点＿"+playerPoint);
                System.out.println("ディーラー"+e_math+"枚　合計点＿"+enemyPoint);    
                if(playerPoint >= 22){//プレイヤーが22を超えてしまいバーストした場合。即負けとなる。
                    System.out.println("バーストしました。あなたの負け！");
                    break;
                }
            }

            if (judge.equals("1")) {//1＿スタンドを選択した場合
                System.out.println("あなた"+p_math+"枚　　　合計点＿"+playerPoint);
                for (int i = 1; enemyPoint < 17; i++) {//ディーラーの点数が１７以上になるように引き続ける。
                    enemyCard[i] = random.nextInt(9) +1;
                    e_math += 1;
                    if (enemyCard[i] == 1) {
                        enemyCard[i] = 11;
                    }
                    enemyPoint += enemyCard[i];
                    System.out.println("ディーラー"+e_math+"枚　合計点＿"+enemyPoint);
                }
                if(enemyPoint >= 22){//ディーラーが22を超えてしまいバーストした場合。即勝利となる
                    System.out.println("ディーラーがバーストしました。あなたの勝ち！！");
                    break;
                }
            }
            if(enemyPoint < 22){
                if(enemyPoint >= 17){//ジャッジクラスによって点数を比べる。
                    System.out.println("両者の点数を確定します");
                    System.out.println("あなた"+p_math+"枚　　　合計点＿"+playerPoint);
                    System.out.println("ディーラー"+e_math+"枚　合計点＿"+enemyPoint);
                    Result = ju.judge(playerPoint,enemyPoint);
                    System.out.println(Result);
                    break;
                }
            }
        }
    }



}

