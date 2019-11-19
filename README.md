# 2018310988
student
实验目的
掌握字符串String及其方法的使用
掌握异常处理结构
业务要求
内容：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能函数，并运行。达到如下功能：

1.	每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
2.	允许提供输入参数，统计古诗中某个字或词出现的次数
3.	考虑操作中可能出现的异常，在程序中设计异常处理程序

定义每7个字添加一个“，”，每14个字添加一个“。”，再将长恨歌输入。 ---------1
	public static void main(String[] args) {
		int i=1;
		char[] char_chg=chg.toCharArray();
		
		for(char hz:char_chg) {
			System.out.print(hz);
			if (i%7==0&&i%14!=0)
				System.out.println("，");
			if(i%14==0)
				System.out.println("。");
			i++;
		}
	}

字频统计       ------------------------------------------------------2
        public static void print(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c)?1:(map.get(c)+1));
        }
        for (Character c : map.keySet()) {
            System.out.println(c+":"+map.get(c));
