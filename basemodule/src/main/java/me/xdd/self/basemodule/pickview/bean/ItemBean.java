package me.xdd.self.basemodule.pickview.bean;


import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class ItemBean implements IPickerViewData {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
