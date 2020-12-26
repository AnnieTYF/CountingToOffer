package leecode.Math;

import java.util.HashSet;

public class RectangleCover {

    /**
     * 所谓「完美矩形」，就是说rectangles中的小矩形拼成图形必须是一个大矩形，且大矩形中不能有重叠和空缺
     * 其实，想判断最终形成的图形是否是完美矩形，需要从「面积」和「顶点」两个角度来处理
     * 面积：
     * rectangles数组中每个元素都是一个四元组(x1, y1, x2, y2)，表示一个小矩形的左下角顶点坐标和右上角顶点坐标
     * 那么假设这些小矩形最终形成了一个「完美矩形」，这个完美矩形的左下角顶点(X1, Y1)就是rectangles中所有小矩形中最靠左下角的那个小矩形的左下角顶点；
     * 右上角顶点(X2, Y2)就是所有小矩形中最靠右上角的那个小矩形的右上角顶点
     * 计算出的 X1,Y1,X2,Y2 坐标是完美矩形的「理论坐标」，
     * 如果所有小矩形的面积之和不等于这个完美矩形的理论面积，那么说明最终形成的图形肯定存在空缺或者重叠，肯定不是完美矩形
     * 但即便面积相同，并不能完全保证不存在空缺或者重叠，所以我们需要从「顶点」的维度来辅助判断
     * 完美矩形一定只有四个顶点
     * 当某一个点同时是 2 个或者 4 个小矩形的顶点时，该点最终不是顶点；当某一个点同时是 1 个或者 3 个小矩形的顶点时，该点最终是一个顶点。
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE;
        int Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE;
        int Y2 = Integer.MIN_VALUE;
        //记录所有小矩形的面积之和
        int actualArea = 0;
        //哈希集合，记录最终图形的顶点
        HashSet<String> points = new HashSet<>();
        for(int[] rectangle : rectangles){
            int x1 = rectangle[0];
            int x2 = rectangle[2];
            int y1 = rectangle[1];
            int y2 = rectangle[3];
            X1 = Math.min(x1,X1);
            Y1 = Math.min(y1,Y1);
            X2 = Math.max(x2,X2);
            Y2 = Math.max(y2,Y2);
            actualArea += (x2 - x1) * (y2 - y1);
            // 判断顶点是否出现过
            String[] ps = {x1 + "" + y1, x1 + "" + y2, x2 + "" + y1, x2 + "" + y2};
            //如果某一个顶点p存在于集合points中，则将它删除；如果不存在于集合points中，则将它插入
            for(String point: ps){
                if(!points.contains(point)){
                    points.add(point);
                }else{
                    points.remove(point);
                }
            }
        }
        int expectedArea = (X2 - X1) * (Y2 - Y1);
        if(actualArea != expectedArea){
            return false;
        }
        if(points.size() != 4){
            return false;
        }
        String s1 = X1 + "" + Y1;
        String s2 = X1 + "" + Y2;
        String s3 = X2 + "" + Y1;
        String s4 = X2 + "" + Y2;
        //不仅要保证len(points) == 4,而且要保证points中最终剩下的点坐标就是完美矩形的四个理论坐标
        if(!points.contains(s1) || !points.contains(s2) || !points.contains(s3) || !points.contains(s4)){
            return false;
        }
        return true;
    }
}
