package com.df.sheJiMoShi.zhongjie;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class UnitedNationCil extends UnitedNations {
    private USA usa;
    private Iraq iraq;

    public void setUsa(USA usa) {
        this.usa = usa;
    }

    public void setIraq(Iraq iraq) {
        this.iraq = iraq;
    }

    @Override
    public void declare(String msg, Country country) {
        if (usa == country) {
            iraq.getmsg(msg);
        }
        if (iraq == country) {
            usa.getmsg(msg);
        }
    }
}
