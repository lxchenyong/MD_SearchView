package bz.sunlight.store.myserachview;

import java.io.Serializable;

/**
 *
 * Created by Administrator on 2016/11/10.
 */
public class Bean implements Serializable {
    private String name;
    private String number;
    private String storName;

    public Bean(String name, String number, String storName) {
        this.name = name;
        this.number = number;
        this.storName = storName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStorName() {
        return storName;
    }

    public void setStorName(String storName) {
        this.storName = storName;
    }
}
