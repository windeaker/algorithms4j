package common;

import com.sun.istack.internal.NotNull;

public class CommonUtil {
    private static final StringBuilder builder=new StringBuilder();

    private synchronized static void builderClear(){
        builder.delete(0,builder.length());
    }

    public synchronized static String convertArrayToString(@NotNull Object[] params){
        builderClear();
        builder.append('{');
        for(Object temp:params){
            builder.append(temp);
            builder.append(',');
        }
        builder.replace(builder.length()-1,builder.length(),"}");
        return builder.toString();
    }

    public synchronized static String convertArrayToString(@NotNull int[] params){
        builderClear();
        builder.append('{');
        for(int temp:params){
            builder.append(temp);
            builder.append(',');
        }
        builder.replace(builder.length()-1,builder.length(),"}");
        return builder.toString();
    }



}
