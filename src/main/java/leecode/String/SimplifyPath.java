package leecode.String;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        /*
        使用split将字符分开后,分开后无非三种情况
        1. 为空或'.'，continue跳过
        2. 正常字符，就入栈
        3. ‘..’弹出栈中上一个元素
         */
        String[] pathEle = path.split("/");

        Stack<String> stack = new Stack<>();
        //2种情况，栈为空或者栈不为空
        for(int i = 0; i< pathEle.length ; i++){
            if(pathEle[i].length() == 0 || ".".equals(pathEle[i])){
                continue;
            }
            if(!stack.isEmpty()){
                if("..".equals(pathEle[i])){
                    stack.pop();
                }else{
                    stack.push(pathEle[i]);
                }
            }else{
                if(!"..".equals(pathEle[i])){
                    stack.push(pathEle[i]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        if(stack.isEmpty()){
            return res.append("/").toString();
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
            res.insert(0,"/");
        }
        return res.toString();
    }
}
