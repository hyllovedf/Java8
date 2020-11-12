package com.df.sheJiMoShi.zhuang_shi;

/**
 * 装饰模式
 *动态的给一个对象增加功能  避免继承方式的体系臃肿
 * 不需要添加代码到旧类中  只是把要装饰的功能放到单独的类中  并让这个类包装他需要装饰的对象
 * 可以简化装饰的类
 * 各个装饰类相互独立 可以有选择的按照顺序使用装饰类
 * https://www.cnblogs.com/santry/archive/2011/06/19/2084679.html
 * @author hanyli
 * @date 2020/11/12
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("df");
        Trousers trousers = new Trousers();
        Shoe shoe = new Shoe();
        trousers.decorate(person);
        shoe.decorate(trousers);
        shoe.show();

    }
}
