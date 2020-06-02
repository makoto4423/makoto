package interview1To100;

// 单纯位运算，位运算抄网上的，最后用位移代替除法，否则timeout
public class a64sumNums {
    public int sumNums(int n) {
        return add(multiply(n,n),n)>>1;
    }

    public int add(int num1, int num2){
        if(num2 == 0)
            return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    public int subtract(int num1, int num2){
        int subtract = add(~num2, 1);// 先求减数的补码（取反加一）
        return add(num1, subtract);
    }

    public int multiply(int a, int b){
        // 取绝对值　　
        int multiplicand = a < 0 ? add(~a, 1) : a;
        int multiplier = b < 0 ? add(~b , 1) : b;// 如果为负则取反加一得其补码，即正数　　
        // 计算绝对值的乘积　　
        int product = 0;
        int count = 0;
        while(count < multiplier) {
            product = add(product, multiplicand);
            count = add(count, 1);// 这里可别用count++，都说了这里是位运算实现加法　　
        }
        // 确定乘积的符号　　
        if((a ^ b) < 0) {// 只考虑最高位，如果a,b异号，则异或后最高位为1；如果同号，则异或后最高位为0；　　　　
            product = add(~product, 1);
        }
        return product;
    }

    public int divide(int a, int b){
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : add(~a, 1);
        int divisor = b > 0 ? b : add(~b, 1);

        int quotient = 0;// 商
        // 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
        while(dividend >= divisor){// 直到商小于被除数
            quotient = add(quotient, 1);
            dividend = subtract(dividend, divisor);
        }
        // 确定商的符号
        if((a ^ b) < 0){// 如果除数和被除数异号，则商为负数
            quotient = add(~quotient, 1);
        }
        // 确定余数符号
        return quotient;// 返回商
    }
}
