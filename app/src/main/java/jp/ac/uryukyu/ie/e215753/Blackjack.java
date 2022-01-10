package jp.ac.uryukyu.ie.e215753;

public class Blackjack {
    public void gameSt(){// 実際にブラックジャックを動かすメソッド
        Battle St = new Battle();
        St.preparation();
        St.natural();
        St.play();
    }
}
