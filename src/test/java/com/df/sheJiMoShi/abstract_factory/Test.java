package com.df.sheJiMoShi.abstract_factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author hanyli
 * @date 2020/11/25
 */
public class Test {
    public static void main(String[] args) throws Exception {
        AbstractFactory shape = FactoryProducer.createFactory("shape");
        Shape round = shape.getShape("round");
        round.drawing();
        AbstractFactory color = FactoryProducer.createFactory("color");
        Color red = color.getColor("red");
        red.spray();

        File file = new File("d:\\data.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder builder = new StringBuilder();
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            builder.append(s);
        }
        bufferedReader.close();
        String string = builder.toString();
        System.out.println(string);
    }
}
