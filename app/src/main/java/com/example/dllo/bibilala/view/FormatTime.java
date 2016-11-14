package com.example.dllo.bibilala.view;
 /*
        quu..__
         $$$b  `---.__
          "$$b        `--.                          ___.---uuudP
           `$$b           `.__.------.__     __.---'      $$$$"              .
             "$b          -'            `-.-'            $$$"              .'|
               ".                                       d$"             _.'  |
                 `.   /                              ..."             .'     |
                   `./                           ..::-'            _.'       |
                    /                         .:::-'            .-'         .'
                   :                          ::''\          _.'            |
                  .' .-.             .-.           `.      .'               |
                  : /'$$|           .@"$\           `.   .'              _.-'
                 .'|$u$$|          |$$,$$|           |  <            _.-'
                 | `:$$:'          :$$$$$:           `.  `.       .-'
                 :                  `"--'             |    `-.     \
                :                |                |#'     `..'`..'          `                 \                                   xXX|     /    ./
                  \                                xXXX'|    /   ./
                  /`-.                                  `.  /   /
                 :    `-  ...........,                   | /  .'
                 |         ``:::::::'       .            |<    `.
                 |             ```          |           x| \ `.:``.
                 |                         .'    /'   xXX|  `:`M`M':.
                 |    |                    ;    /:' xXXX'|  -'MMMMM:'
                 `.  .'                   :    /:'       |-'MMMM.-'
                  |  |                   .'   /'        .'MMM.-'
                  `'`'                   :  ,'          |MMM<
                    |                     `'            |tbap\
                     \                                  :MM.-'
                      \                 |              .''
                       \.               `.            /
                        /     .:::::::.. :           /
                       |     .:::::::::::`.         /
                       |   .:::------------\       /
                      /   .''               >::'  /
                      `',:                 :    .'
                                           `:.:'

         
        */

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dllo on 16/11/12.
 */

public class FormatTime {
    private static long timeMillis;
    private static String returnTime;
    private static long subtractTime;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static String formatTime(long mTime) {
        timeMillis = Calendar.getInstance().getTimeInMillis();
        String nowTimeDay = format.format(timeMillis).substring(8, 10);
        String inTimeDay = format.format(mTime).substring(8, 10);
        String inTime = format.format(mTime);
        switch (Integer.parseInt(nowTimeDay) - Integer.parseInt(inTimeDay)) {
            case 0:
                // 今天的时间判断是否大于一小时

                subtractTime = (timeMillis - mTime) / 1000 / 60;
                if (subtractTime < 60) {
                    returnTime = subtractTime + "分钟前";
                } else {
                    returnTime = inTime.substring(11, 16);
                }
                break;
            case 1:
                returnTime = "昨天";
                break;
            case 2:
                returnTime = "前天";
                break;
            default:
                returnTime = inTime.substring(5, 10);
                break;
        }
        return returnTime;

    }


}
