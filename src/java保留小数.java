

public class java保留小数 {
	/*方式一：
	四舍五入  
	double   f   =   111231.5585;  
	BigDecimal   b   =   new   BigDecimal(f);  
	double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
	保留两位小数  
	--------------------------------------------------------------- 
	System.out.printf("%.4f", arr[n][x]);
	方式二：
	Java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
	df.format(你要格式化的数字);
	例：new java.text.DecimalFormat("#.00").format(3.1415926)
	#.00 表示两位小数 #.0000四位小数 以此类推...
	方式三：
	double d = 3.1415926;
	String result = String .format("%.2f",d);
	%.2f %. 表示 小数点前任意位数   2 表示两位小数 格式后的结果为f 表示浮点型
	方式四：
	NumberFormat ddf1=NumberFormat.getNumberInstance() ;
	void setMaximumFractionDigits(int digits) 
	digits 显示的数字位数 
	为格式化对象设定小数点后的显示的最多位,显示的最后位是舍入的
	import java.text.* ; 
	import java.math.* ; 
	class TT 
	{ 
	public static void main(String args[]) 
	{ double x=23.5455; 
	NumberFormat ddf1=NumberFormat.getNumberInstance() ;

	ddf1.setMaximumFractionDigits(2); 
	String s= ddf1.format(x) ; 
	System.out.print(s); 
	} 
	}*/
}
