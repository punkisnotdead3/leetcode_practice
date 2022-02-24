package com.vivo;

import java.util.*;

public class Code874 {
    public int robotSim(int[] commands, int[][] obstacles) {


        Map<String, String> directMap = new HashMap<>();
        directMap.put("up_left", "left");
        directMap.put("up_right", "right");
        directMap.put("left_left", "down");
        directMap.put("left_right", "up");
        directMap.put("down_left", "left");
        directMap.put("down_right", "right");
        directMap.put("right_left", "up");
        directMap.put("right_right", "down");

        Set<String> obset = new HashSet<>();
        for (int[] obs : obstacles) {
            obset.add(obs[0] + "_" + obs[1]);
        }


        int dis = 0;
        // 原始坐标
        int[] s = new int[]{0, 0};
        String dir = "up";
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                dir = directMap.get(dir + "_left");
            } else if ((commands[i] == -1)) {
                dir = directMap.get(dir + "_right");
            } else {
                for (int j = 1; j <= commands[i]; j++) {
                    int nextx = s[0];
                    int nexty = s[1];
                    if (dir.equals("up")) {
                        nexty = nexty + 1;
                    } else if (dir.equals("left")) {
                        nextx = nextx - 1;
                    } else if (dir.equals("right")) {
                        nextx = nextx + 1;
                    } else if (dir.equals("down")) {
                        nexty = nexty - 1;
                    }
                    if (obset.contains(nextx + "_" + nexty)) {
                        break;
                    }
                    s[0] = nextx;
                    s[1] = nexty;
                    dis = Math.max(dis, s[0] * s[0] + s[1] * s[1]);
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        Code874 code874 = new Code874();
        System.out.println(code874.robotSim(new int[]{
                -2, -1, 8, 9, 6
        }, new int[][]{
                {-1, 3},
                {0, 1},
                {-1, 5},
                {-2, -4},
                {5, 4},
                {-2, -3},
                {5, -1},
                {1, -1},
                {5, 5},
                {5, 2},
        }));
    }
}
