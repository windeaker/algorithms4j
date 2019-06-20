package aim_offer;

import java.math.BigDecimal;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Q12 {
    public double Power(double base, int exponent) {
        if (exponent==0){
            return (double)1;
        }
        int expAbs=Math.abs(exponent);
        BigDecimal baseDec=BigDecimal.valueOf(base);
        BigDecimal result=baseDec;
        for(int i=1;i<expAbs;i++){
            result=result.multiply(baseDec);
        }
        if(exponent>0){
            return result.doubleValue();
        }else {
            BigDecimal one=new BigDecimal(1);
            return one.divide(result).doubleValue();
        }

    }

    public static void main(String[] args) {
        new Q12().Power(2,-3);
    }
}
