package com.vivo;

import java.util.ArrayList;
import java.util.List;

public class Code860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {

            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five <= 0) {
                        return false;
                    } else {
                        ten++;
                        five--;
                    }
                    break;
                case 20:
                    // 一个10 一个5  或者3个5
                    if (five <= 0 && ten <= 0) {
                        return false;
                    }
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                        break;
                    }
                    if (five >= 3) {
                        five = five - 3;
                        break;
                    }
                    return false;
            }


        }
        return true;
    }
}
