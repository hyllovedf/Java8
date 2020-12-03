package com.df.sheJiMoShi.zhongjie;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Test {
    public static void main(String[] args) {
        UnitedNationCil unitedNationCil = new UnitedNationCil();
        USA usa = new USA(unitedNationCil);
        Iraq iraq = new Iraq(unitedNationCil);
        unitedNationCil.setIraq(iraq);
        unitedNationCil.setUsa(usa);

        usa.declare("禁止核武器");
        iraq.declare("没有");

    }
}
