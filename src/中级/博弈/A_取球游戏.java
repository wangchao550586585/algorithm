package 中级.博弈;

/**
 * 盒子有n球，ab二人轮流取球，盒子取球数目必须为1,3,7,8个，ab交替取球，拿到最后一个球的是胜利方
 * @:			f(局面x) {
 * @:				边界条件处理(出口) 
 * @:				for(我能走的所有走法){ 
 * @:					试走一步:局面y 
 * @:					胜负t=f(y) 
 * @:					if(t==false)return true;
 * @:						恢复局面(x) 
 * @:				}
 * @:				return false;
 * 				}
 * @author Administrator
 * 
 */
public class A_取球游戏 {
	public static void main(String[] args) {
		System.out.println(f(10));
		System.out.println(f(1));
		System.out.println(f(4));
		System.out.println(f(10));
		//重复运算过多，优化方案，利用哈希表缓存已经计算的局面
	}

	private static boolean f(int i) {
		/*
		 * 如果球多余1，那么取出一个球，判断是否false，如果false，那么我胜利
		 */
		if(i>=1&&f(i-1)==false)return true;
		if(i>=3&&f(i-3)==false)return true;
		if(i>=7&&f(i-7)==false)return true;
		if(i>=8&&f(i-8)==false)return true;
		return false;
	}
}
